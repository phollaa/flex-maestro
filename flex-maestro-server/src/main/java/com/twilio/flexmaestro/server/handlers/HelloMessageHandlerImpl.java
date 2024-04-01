package com.twilio.flexmaestro.server.handlers;

import static java.util.Objects.requireNonNullElse;
import static java.util.concurrent.CompletableFuture.completedFuture;

import com.twilio.core.request.context.RequestContext;
import com.twilio.core.security.contexts.ApiAuthContext;
import com.twilio.flexmaestro.server.api.hello.message.HelloMessageApi;
import com.twilio.flexmaestro.server.definitions.HelloMessage;
import com.twilio.flexmaestro.server.definitions.HelloMessageContainer;
import com.twilio.flexmaestro.server.definitions.HelloMessageList;
import com.twilio.flexmaestro.server.services.ServiceRepository;
import com.twilio.rest.TwilioServiceErrorResponse;
import com.twilio.sids.SmsSid;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import java.util.concurrent.CompletionStage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloMessageHandlerImpl implements HelloMessageApi {
    private static final TwilioServiceErrorResponse NO_ACCOUNT_SID_SPECIFIED =
            TwilioServiceErrorResponse.create("No account SID specified", 401);
    private static final Integer DEFAULT_PAGE_SIZE = 50;

    private final ServiceRepository serviceRepository;

    @Inject
    public HelloMessageHandlerImpl(final ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public CompletionStage<Either<TwilioServiceErrorResponse, HelloMessageList>> listMessages(
            final String from,
            final String to,
            final Integer pageSize,
            final String pageToken,
            final ApiAuthContext apiAuthContext,
            final RequestContext requestContext,
            final HelloMessageApi.ListMessagesResponseHeaders headers) {
        return apiAuthContext
                .getAuthenticatedAccount()
                .map(
                        authenticatedAccount ->
                                serviceRepository
                                        .retrieveMessages(
                                                authenticatedAccount.getSid(),
                                                from,
                                                to,
                                                requireNonNullElse(pageSize, DEFAULT_PAGE_SIZE),
                                                pageToken)
                                        .thenApply(Either::<TwilioServiceErrorResponse, HelloMessageList>right)
                                        .exceptionally(
                                                e -> Either.left(TwilioServiceErrorResponse.create(e.getMessage(), 500))))
                .orElseGet(this::unauthenticated);
    }

    @Override
    public CompletionStage<Either<TwilioServiceErrorResponse, HelloMessageContainer>> getMessage(
            final SmsSid sid,
            final ApiAuthContext apiAuthContext,
            final RequestContext requestContext,
            final ConditionalRequest conditionalRequest,
            final GetMessageResponseHeaders responseHeaders) {
        responseHeaders.setEtag("Hello World");

        return apiAuthContext
                .getAuthenticatedAccount()
                .map(
                        authenticatedAccount ->
                                serviceRepository
                                        .retrieveMessage(sid, authenticatedAccount.getSid())
                                        .thenApply(
                                                o ->
                                                        o.map(Either::<TwilioServiceErrorResponse, HelloMessageContainer>right)
                                                                .orElse(
                                                                        Either.left(
                                                                                TwilioServiceErrorResponse.create("Not Found", 404)))))
                .orElseGet(this::unauthenticated);
    }

    @Override
    public CompletionStage<Either<TwilioServiceErrorResponse, HelloMessageContainer>> createMessage(
            final SmsSid sid,
            final String etag,
            final HelloMessage body,
            final ApiAuthContext apiAuthContext,
            final RequestContext requestContext,
            final HelloMessageApi.CreateMessageResponseHeaders responseHeaders) {
        log.info("Creating new Message etag {} : {}", etag, body);
        responseHeaders.setEtag("Hello World: " + etag);
        return apiAuthContext
                .getAuthenticatedAccount()
                .map(
                        authenticatedAccount ->
                                this.serviceRepository
                                        .createMessage(sid, authenticatedAccount.getSid(), body)
                                        .thenApply(Either::<TwilioServiceErrorResponse, HelloMessageContainer>right))
                .orElseGet(this::unauthenticated);
    }

    @Override
    public CompletionStage<Either<TwilioServiceErrorResponse, HelloMessageContainer>> updateMessage(
            final SmsSid sid,
            final String from,
            final String to,
            final String message,
            final ApiAuthContext apiAuthContext,
            final RequestContext requestContext,
            final ConditionalRequest conditionalRequest,
            final UpdateMessageResponseHeaders responseHeaders) {
        return apiAuthContext
                .getAuthenticatedAccount()
                .map(
                        authenticatedAccount ->
                                this.serviceRepository
                                        .updateMessage(sid, authenticatedAccount.getSid(), from, to, message)
                                        .thenApply(Either::<TwilioServiceErrorResponse, HelloMessageContainer>right))
                .orElseGet(this::unauthenticated);
    }

    @Override
    public CompletionStage<Either<TwilioServiceErrorResponse, Void>> deleteMessage(
            final SmsSid sid,
            final ApiAuthContext apiAuthContext,
            final RequestContext requestContext,
            final HelloMessageApi.DeleteMessageResponseHeaders responseHeaders) {
        return apiAuthContext
                .getAuthenticatedAccount()
                .map(
                        authenticatedAccount ->
                                this.serviceRepository
                                        .deleteMessage(sid, authenticatedAccount.getSid())
                                        .thenApply(Either::<TwilioServiceErrorResponse, Void>right))
                .orElseGet(this::unauthenticated);
    }

    private <T> CompletionStage<Either<TwilioServiceErrorResponse, T>> unauthenticated() {
        return completedFuture(
                Either.left(
                        TwilioServiceErrorResponse.create(
                                "Unauthenticated", NO_ACCOUNT_SID_SPECIFIED.getHttpStatusCode())));
    }
}
