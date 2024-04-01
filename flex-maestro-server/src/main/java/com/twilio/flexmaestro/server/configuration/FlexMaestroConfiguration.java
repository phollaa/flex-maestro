package com.twilio.flexmaestro.server.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.twilio.concurrency.limit.core.ConcurrencyLimitConfiguration;
import com.twilio.concurrency.limit.core.bundle.configuration.ConcurrencyLimitConfigurationStrategy;
import com.twilio.core.bundles.configuration.BaseAppConfiguration;
import com.twilio.core.bundles.configuration.SettableHostConfiguration;
import com.twilio.core.bundles.jakarta.auth.configuration.AuthConfiguration;
import com.twilio.core.bundles.jakarta.auth.configuration.AuthConfigurationStrategy;
import com.twilio.core.bundles.jakarta.exceptions.ExceptionsConfiguration;
import com.twilio.core.bundles.jakarta.exceptions.ExceptionsConfigurationStrategy;
import com.twilio.core.bundles.mapper.ObjectMapperConfiguration;
import com.twilio.core.bundles.mapper.ObjectMapperConfigurationStrategy;
import com.twilio.core.bundles.metrics.MetricsConfigurationStrategy;
import com.twilio.core.bundles.metrics.datadog.DataDogMetricsConfiguration;
import com.twilio.core.bundles.metrics.datadog.DataDogMetricsConfigurationStrategy;
import com.twilio.coreutil.configuration.client.ClientConfigurations;
import com.twilio.platform.config.HostConfiguration;
import com.twilio.ratelimit.bundle.config.RateLimitConfiguration;
import com.twilio.ratelimit.bundle.config.RateLimitConfigurationStrategy;
import com.twilio.rollbar.core.RollbarConfiguration;
import io.dropwizard.core.Configuration;
import io.dropwizard.core.server.AbstractServerFactory;
import lombok.Getter;

/**
 * The {@link FlexMaestroConfiguration} is the "POJO" for the yaml file in
 * conf/default-service.yaml
 *
 * <p>This class uses a Lombok Getter annotation. Learn more about using Lombok at
 *
 * @see <a href="https://projectlombok.org/">Lombok</a>.
 */
@Getter
public class FlexMaestroConfiguration extends Configuration
        implements MetricsConfigurationStrategy,
                DataDogMetricsConfigurationStrategy,
                ExceptionsConfigurationStrategy,
                ObjectMapperConfigurationStrategy,
                AuthConfigurationStrategy,
                RateLimitConfigurationStrategy,
                ConcurrencyLimitConfigurationStrategy {

    private RateLimitConfiguration rateLimitConfiguration;

    private RollbarConfiguration rollbarConfiguration;

    private DataDogMetricsConfiguration dataDogMetricsConfiguration;

    @JsonDeserialize(as = SettableHostConfiguration.class)
    private HostConfiguration hostConfiguration;

    private boolean localTest;

    private BaseAppConfiguration baseAppConfiguration;

    private ExceptionsConfiguration exceptionMapperConfiguration;

    private ObjectMapperConfiguration objectMapperConfiguration = new ObjectMapperConfiguration();

    private AuthConfiguration authConfiguration;

    private ClientConfigurations clients;

    private ConcurrencyLimitConfiguration concurrencyLimit;

    @Override
    @JsonIgnore
    public boolean isRegisterDefaultExceptionMappers() {
        return ((AbstractServerFactory) getServerFactory()).getRegisterDefaultExceptionMappers();
    }

    @Override
    public ConcurrencyLimitConfiguration getConcurrencyLimitConfiguration() {
        return concurrencyLimit;
    }

    @Override
    public String toString() {
        return "FlexMaestroConfiguration{"
                + "rateLimitConfiguration="
                + rateLimitConfiguration
                + ", rollbarConfiguration="
                + rollbarConfiguration
                + ", dataDogMetricsConfiguration="
                + dataDogMetricsConfiguration
                + ", hostConfiguration="
                + hostConfiguration
                + ", localTest="
                + localTest
                + ", baseAppConfiguration="
                + baseAppConfiguration
                + ", exceptionMapperConfiguration="
                + exceptionMapperConfiguration
                + ", objectMapperConfiguration="
                + objectMapperConfiguration
                + ", authConfiguration="
                + authConfiguration
                + ", clients="
                + clients
                + ", concurrencyLimit="
                + concurrencyLimit
                + '}';
    }
}
