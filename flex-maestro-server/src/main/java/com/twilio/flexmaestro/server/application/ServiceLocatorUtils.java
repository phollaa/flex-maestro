package com.twilio.flexmaestro.server.application;

import com.twilio.coreutil.service.jakarta.api.application.Application;
import com.twilio.flexmaestro.server.api.ResourceBundle;
import com.twilio.flexmaestro.server.api.admin.AdminApi;
import com.twilio.flexmaestro.server.api.hello.message.HelloMessageApi;
import com.twilio.flexmaestro.server.configuration.FlexMaestroConfiguration;
import com.twilio.flexmaestro.server.handlers.AdminHandlerImpl;
import com.twilio.flexmaestro.server.handlers.HelloMessageHandlerImpl;
import com.twilio.flexmaestro.server.services.ServiceRepository;
import com.twilio.flexmaestro.server.services.ServiceRepositoryImpl;
import io.dropwizard.core.Configuration;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 * Dropwizard comes with a CDI implementation, HK2. Although this can be swapped out with another
 * CDI implementation dagger, guice, sisu etc. We provide this utility as inspiration but also a way
 * to get the service locator without introducing any new dependencies.
 */
public class ServiceLocatorUtils {
    private static final ServiceLocator SERVICE_LOCATOR = ensureServiceLocator();

    /**
     * Get the {@link ServiceLocator} for the current application context.
     *
     * @return the ServiceLocator
     */
    public static ServiceLocator ensureServiceLocator() {
        if (SERVICE_LOCATOR != null) {
            return SERVICE_LOCATOR;
        }

        final var serviceLocator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
        ServiceLocatorUtilities.bind(
                serviceLocator,
                new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(FlexMaestroConfiguration.class).to(Configuration.class);
                        bind(FlexMaestroApplication.class)
                                .to(new TypeLiteral<Application<FlexMaestroConfiguration>>() {})
                                .to(FlexMaestroApplication.class);
                        bind(ResourceBundle.class)
                                .to(new TypeLiteral<ResourceBundle<FlexMaestroConfiguration>>() {});
                        bind(AdminHandlerImpl.class).to(AdminApi.class);
                        bind(HelloMessageHandlerImpl.class).to(HelloMessageApi.class);
                        bind(ServiceRepositoryImpl.class).to(ServiceRepository.class);

                        /*
                        example of binding a named value, this will map to an injected argument with
                        @Named("defaultTimeout")
                        e.g
                        @Inject public MyService(@Named("defaultTimeout") int timeout) {}
                        bind(10).to(Integer.class).named("defaultTimeout");
                        example of binding a contract to an implementation qualified by an annotation
                        e.g.
                        @Inject public MyConsumer(@MyAnnotation MyContract myService) {}
                        bind(MyService.class).to(MyContract.class).qualifiedBy(MyAnnotation.class);
                        */
                    }
                });
        return serviceLocator;
    }

    /**
     * Get the FlexMaestroApplication instance.
     *
     * @return the FlexMaestroApplication instance
     */
    public static FlexMaestroApplication getApplicationInstance() {
        return ensureServiceLocator().getService(FlexMaestroApplication.class);
    }
}
