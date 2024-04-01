package com.twilio.flexmaestro.containers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.core.request.context.impl.DefaultRequestContext;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient.CreateMessageResponseHeaders;
import com.twilio.flexmaestro.client.definitions.HelloMessage.HelloMessageBuilder;
import com.twilio.platform.metrics.noop.NoopTwilioMetricRegistry;
import com.twilio.rest.TwilioHeaders;
import com.twilio.sids.AccountSid;
import com.twilio.sids.SmsSid;
import com.twilio.test.containers.ContainerComposeHelper;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

@EnabledIf(
        value = "com.twilio.test.containers.ContainerComposeHelper#composeFileExists",
        disabledReason = "docker-compose.yml file not found")
@EnabledIfSystemProperty(named = "container.test", matches = "true")
class ContainerTestIT {

    private static final ContainerComposeHelper CONTAINER_HELPER = new ContainerComposeHelper();

    private HelloMessageClient client;

    @BeforeEach
    void setup() throws IOException, InterruptedException {
        CONTAINER_HELPER.start("containers/compose.properties");
        client =
                new HelloMessageClient.Builder(
                                CONTAINER_HELPER.readClientConfiguration("client-configuration.yaml"))
                        .metricsRegistry(new NoopTwilioMetricRegistry())
                        .baseUrl(URI.create(CONTAINER_HELPER.getBaseURL("v1")))
                        .objectMapper(new ObjectMapper())
                        .build();
    }

    @AfterEach
    void tearDown() {
        CONTAINER_HELPER.stop();
    }

    @Test
    void simpleRequest() throws ExecutionException, InterruptedException, TimeoutException {
        final var sid = SmsSid.parse("SM12345678901234567890123456789012");
        final var accountSid = AccountSid.parse("ACdeadbeefdeadbeefdeadbeefdeadbeef");

        // Send a message from Bob to Jeff
        final var helloMessage =
                new HelloMessageBuilder().from("Bob").to("Jeff").message("Hi Jeff").build();

        final var responseHeaders = new CreateMessageResponseHeaders();
        final var res =
                client
                        .createMessage(
                                helloMessage,
                                sid,
                                "One",
                                responseHeaders,
                                new DefaultRequestContext.Builder().build())
                        .header(TwilioHeaders.AUTH_ACCOUNT_HEADER_KEY, accountSid.getValue());

        // Check that the result is a MessageContainer with the same sid
        assertTrue(
                res.call()
                        .thenApply(hc -> hc.getSid().equals(sid))
                        // in a normal application, you would not block the thread like this,
                        // but for the purposes of this test, we need to wait for the result
                        .toCompletableFuture()
                        .get(3, TimeUnit.SECONDS));
        assertEquals("Hello World: One", responseHeaders.getEtag().orElse(null));
    }
}
