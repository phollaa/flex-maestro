package com.twilio.flexmaestro.server.handlers;

import static java.util.Objects.requireNonNullElse;
import static java.util.concurrent.CompletableFuture.completedFuture;

import com.twilio.core.request.context.RequestContext;
import com.twilio.core.security.contexts.RemoteHostContext;
import com.twilio.flexmaestro.server.api.admin.AdminApi;
import com.twilio.flexmaestro.server.definitions.HelloMessageList;
import com.twilio.flexmaestro.server.services.ServiceRepository;
import com.twilio.rest.TwilioServiceErrorResponse;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminHandlerImpl implements AdminApi {
    private static final int DEFAULT_PAGE_SIZE = 50;

    private final ServiceRepository serviceRepository;

    @Inject
    public AdminHandlerImpl(final ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public long getTimeoutMs(final String operation) {
        return 5000L;
    }

    @Override
    public CompletionStage<Either<TwilioServiceErrorResponse, HelloMessageList>> readMessages(
            final Integer pageSize,
            final String pageToken,
            final RemoteHostContext remoteHostContext,
            final RequestContext requestContext,
            final AdminApi.ReadMessagesResponseHeaders responseHeaders) {
        log.info("readMessages setting etag");
        responseHeaders.setEtag("Hello World");

        return remoteHostContext
                .getAuthenticatedHost()
                .map(
                        authenticatedHost -> {
                            log.info("Host {} is retrieving all messages", authenticatedHost.getSid());
                            return this.serviceRepository
                                    .retrieveAllMessages(requireNonNullElse(pageSize, DEFAULT_PAGE_SIZE), pageToken)
                                    .thenApply(Either::<TwilioServiceErrorResponse, HelloMessageList>right);
                        })
                .orElseGet(this::unauthenticated);
    }

    private <T> CompletionStage<Either<TwilioServiceErrorResponse, T>> unauthenticated() {
        return completedFuture(
                Either.left(
                        TwilioServiceErrorResponse.create(
                                "Unauthenticated", Response.Status.UNAUTHORIZED.getStatusCode())));
    }
}
