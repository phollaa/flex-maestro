/*
 * FlexMaestro Service
 * This is a basic FlexMaestro service, showcasing many features of a standard Twilio Service
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: your-team-name@twilio.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.twilio.flexmaestro.client;

import com.twilio.core.client.base.handlers.RequestHandler;
import com.twilio.core.client.base.payload.PayloadSource;
import com.twilio.core.client.base.request.DefaultEncodedRequest;
import com.twilio.core.client.base.request.EncodedRequest;
import com.twilio.core.client.base.request.Request;
import com.twilio.core.util.transcoding.Transcoder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Optional;

/**
 * A {@link RequestHandler} that uses the specified {@link Transcoder transcoder} to encode the request.
 */
public class EndpointRequestHandler implements RequestHandler {
  private final Transcoder transcoder;

  /**
   * Create a new EndpointRequestHandler using the specified {@link Transcoder}.
   *
   * @param transcoder the {@link Transcoder that will be used to encode requests with}
   */
  public EndpointRequestHandler(final Transcoder transcoder) {
    this.transcoder = transcoder;
  }

  @Override
  public <T> EncodedRequest<T> handle(Request<T> request, Transcoder ignored) {
    PayloadSource source = (PayloadSource)request.getPayload().map((p) -> {
        return this.createPayloadSource(this.transcoder.encode(p));
      })
      .orElse(null);
    return new DefaultEncodedRequest(request, source);
  }

  /**
   * Provide a {@link PayloadSource} from the specified byte array.
   *
   * @param bytes the payload encoded as a byte array
   * @return a {@link PayloadSource}
   */
  protected PayloadSource createPayloadSource(final byte[] bytes) {
    return new PayloadSource() {
      @Override
      public Optional<Integer> getSize() {
        return Optional.of(bytes.length);
      }

      @Override
      public byte[] copyBytes() {
        return Arrays.copyOf(bytes, bytes.length);
      }

      @Override
      public InputStream createStream() {
        return new ByteArrayInputStream(bytes);
      }
    };
  }
}
