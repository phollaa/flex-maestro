package com.twilio.flexmaestro.server.services;

import com.twilio.flexmaestro.server.definitions.HelloMessage;
import com.twilio.flexmaestro.server.definitions.HelloMessageContainer;
import com.twilio.flexmaestro.server.definitions.HelloMessageList;
import com.twilio.sids.AccountSid;
import com.twilio.sids.SmsSid;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

/** The {@link ServiceRepository} is an interface to the main business logic of the service. */
public interface ServiceRepository {
    CompletionStage<HelloMessageList> retrieveAllMessages(int pageSize, String pageToken);

    CompletionStage<HelloMessageList> retrieveMessages(
            AccountSid accountSid, String from, String to, int pageSize, String pageToken);

    CompletionStage<Optional<HelloMessageContainer>> retrieveMessage(
            SmsSid sid, AccountSid accountSid);

    CompletionStage<HelloMessageContainer> createMessage(
            SmsSid sid, AccountSid accountSid, HelloMessage helloMessage);

    CompletionStage<HelloMessageContainer> updateMessage(
            SmsSid sid, AccountSid accountSid, String from, String to, String message);

    CompletionStage<Void> deleteMessage(SmsSid sid, AccountSid accountSid);
}
