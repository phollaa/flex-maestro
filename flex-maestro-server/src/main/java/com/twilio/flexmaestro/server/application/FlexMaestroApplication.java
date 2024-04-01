package com.twilio.flexmaestro.server.application;

import static com.twilio.flexmaestro.server.application.ServiceLocatorUtils.getApplicationInstance;

import com.twilio.concurrency.limit.jakarta.bundle.ConcurrencyLimitBundle;
import com.twilio.core.bundles.healthcheck.HealthCheckBundle;
import com.twilio.core.bundles.jakarta.auth.AuthBundle;
import com.twilio.core.bundles.jakarta.exceptions.ExceptionsBundle;
import com.twilio.core.bundles.jakarta.request.context.RequestContextBundle;
import com.twilio.core.bundles.jakarta.servlets.RequestIdMDCBundle;
import com.twilio.core.bundles.mapper.ObjectMapperBundle;
import com.twilio.core.bundles.metrics.datadog.DataDogMetricsBundle;
import com.twilio.coreutil.service.api.healthcheck.caching.CachingHealthCheck;
import com.twilio.coreutil.service.configuration.EnvironmentVariableSubstitutor;
import com.twilio.coreutil.service.configuration.FileContentSubstitutor;
import com.twilio.coreutil.service.configuration.MultiSubstitutingSourceProvider;
import com.twilio.coreutil.service.dw40.application.DW40ApplicationAdapter;
import com.twilio.coreutil.service.jakarta.api.application.Application;
import com.twilio.coreutil.service.jakarta.api.application.Bootstrap;
import com.twilio.coreutil.service.jakarta.api.application.Environment;
import com.twilio.jersey3.metrics.AsyncTimedMethodSupportBundle;
import com.twilio.flexmaestro.server.api.ResourceBundle;
import com.twilio.flexmaestro.server.configuration.FlexMaestroConfiguration;
import com.twilio.flexmaestro.server.health.ServerUpHealthCheck;
import com.twilio.platform.metrics.TwilioTaggedMetricsRegistry;
import com.twilio.ratelimit.jakarta.AccountSidRateLimitBundle;
import com.twilio.rollbar.core.RollbarConfiguration;
import com.twilio.rollbar.service.bundle.RollbarBundle;
import com.twilio.util.ServiceRegistry;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the main application class for the Dropwizard 4.0 Example service.
 *
 * <p>This is where configuration gets read and subsystems start.
 */
public class FlexMaestroApplication implements Application<FlexMaestroConfiguration> {

    private static final Logger LOG = LoggerFactory.getLogger(FlexMaestroApplication.class);

    // This is the default health check interval for the "CachingHealthCheck".
    // It caches the health check result for this many MS.
    private static final int HEALTH_CHECK_INTERVAL_MS = 10000;

    // This is the default timeout for checking the health using the HealthCheck
    // provided to the CachingHealthCheck
    private static final int HEALTH_CHECK_TIMEOUT_MS = 5000;
    private final ResourceBundle<FlexMaestroConfiguration> resourceBundle;

    @Inject
    public FlexMaestroApplication(
            final ResourceBundle<FlexMaestroConfiguration> resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void initialize(final Bootstrap<FlexMaestroConfiguration> bootstrap) {

        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new MultiSubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false),
                        new FileContentSubstitutor(true)));

        // The Swagger bundle enables the Swagger UI
        //
        // The Swagger UI is available on the admin port /swagger

        // The DataDogMetricsBundle registers a Datadog Reporter and
        // MetricsRegistries that you can fetch from ServiceRegistry
        // like this: ServiceRegistry.get(TwilioMetricRegistry.class)
        bootstrap.addBundle(new DataDogMetricsBundle<>());

        // In order to support the AsyncTimed annotations, we need to register the
        // {@linkAsyncTimedMethodSupportBundle}.
        bootstrap.addBundle(
                new AsyncTimedMethodSupportBundle<>(
                        ServiceRegistry.get(TwilioTaggedMetricsRegistry.class)));

        // Adds a filter that extracts request context and exposes it injectable in Jersey methods
        bootstrap.addBundle(new RequestContextBundle<>());

        // Adds a filter that extracts request.sid and adds it to the MDC for logging purposes
        bootstrap.addBundle(new RequestIdMDCBundle<>());

        // The Rollbar bundle adds Rollbar publishing for errors
        bootstrap.addBundle(
                new RollbarBundle<>() {

                    // Required to get the lb status in rollbar
                    // See https://code.hq.twilio.com/twilio/twilio-rollbar-java#load-balancer-status
                    @Override
                    protected String getRole(final FlexMaestroConfiguration configuration) {
                        return configuration.getBaseAppConfiguration().getRole();
                    }

                    @Override
                    public RollbarConfiguration getRollbarConfiguration(
                            final FlexMaestroConfiguration configuration) {
                        return configuration.getRollbarConfiguration();
                    }
                });
        bootstrap.addBundle(new ExceptionsBundle<>());

        // This configuring the ObjectMapper in a standard Twilio way (Sid serialization and
        // deserialization etc.)
        bootstrap.addBundle(new ObjectMapperBundle<>());

        // This adds support for the @ApiAuth, @HostAuth, and @CloudAuth resource annotations
        bootstrap.addBundle(new AuthBundle<>());

        // Add the concurrency limiting framework to support @AIMDConcurrencyLimit annotations
        bootstrap.addBundle(
                new ConcurrencyLimitBundle<>(ServiceRegistry.get(TwilioTaggedMetricsRegistry.class)));

        // This adds the Rate-Limiting Framework to your application
        bootstrap.addBundle(new AccountSidRateLimitBundle<>());

        bootstrap.addBundle(resourceBundle);

        // And an example of a health check - you should customize the health check to something
        // meaningful
        // for your server. Typically, any datasource created through the JDBI Bundle also has an
        // associated Health Check.
        //
        // Using CachingHealthCheck is important in order not to overwhelm the downstream if you get
        // a rapid storm of health check requests (HA proxy reload can trigger this for example)

        bootstrap.addBundle(
                new HealthCheckBundle<>(
                        "server-up-healthcheck",
                        CachingHealthCheck.from(
                                new ServerUpHealthCheck(), HEALTH_CHECK_INTERVAL_MS, HEALTH_CHECK_TIMEOUT_MS)));
    }

    @Override
    public void run(
            final FlexMaestroConfiguration dropwizardExampleConfiguration,
            final Environment environment) {
        LOG.info("Running FlexMaestroApplication");
    }

    /**
     * This is the main server startup. This is what allows you to run the jar as is...
     *
     * @param args the arguments to the application
     * @throws Exception if the server fails to start
     */
    public static void main(final String... args) throws Exception {
        final var app =
                new DW40ApplicationAdapter<>(
                        getApplicationInstance(), FlexMaestroConfiguration.class);
        app.run(args);
    }
}
