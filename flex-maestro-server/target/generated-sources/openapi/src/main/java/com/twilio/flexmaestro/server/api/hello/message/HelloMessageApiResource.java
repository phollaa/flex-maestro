package com.twilio.flexmaestro.server.api.hello.message;

import com.twilio.core.jersey3.auth.annotations.ApiAuth;
import com.twilio.core.security.contexts.ApiAuthContext;
import com.twilio.flexmaestro.server.definitions.HelloMessage;
import com.twilio.flexmaestro.server.definitions.HelloMessageContainer;
import com.twilio.flexmaestro.server.definitions.HelloMessageList;
import com.twilio.rest.TwilioServiceErrorResponse;
import com.twilio.concurrency.limit.annotations.AIMDConcurrencyLimited;
import io.vavr.control.Either;
import com.twilio.sids.SmsSid;
import jakarta.ws.rs.container.AsyncResponse;
import com.twilio.core.request.context.RequestContext;

import com.twilio.jersey3.vavr.AsyncJerseyHelper;
import com.twilio.jersey3.metrics.annotation.AsyncTimed;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.Context;

import java.util.Map;
import java.util.List;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;

import jakarta.validation.constraints.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.isNull;
import com.twilio.ratelimit.framework.protocol.ResourceKey;

import com.twilio.ratelimit.jakarta.AbstractFilterFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.ext.Provider;


import jakarta.inject.Inject;
import org.jvnet.hk2.annotations.Service;
import com.twilio.flexmaestro.server.api.hello.message.HelloMessageApi;

/**
 * The HelloMessageApiResources exposes REST endpoints to the servlet container.
 * It offers delegation to the specified {@link HelloMessageApiResource#handler} which can be
 * either injected or passed to the constructor.
 * Second thing it offers is the ability to map an error, exception or a timeout to a {@link TwilioServiceErrorResponse}.
 */

@jakarta.annotation.Generated(value = "com.twilio.codegen.TwilioGenerator", date = "2024-04-01T17:46:14.982174+05:30[Asia/Kolkata]")
@Tag(description = "The HelloMessage API", name = "")
@Path("/v1/Service/Messages")public class HelloMessageApiResource {  
    public static enum HelloMessageApiResourceKey implements ResourceKey { 
      CreateMessage("create_message" , 1),
      DeleteMessage("delete_message" , 20),
      GetMessage("get_message" , 10),
      ListMessages("list_messages" , 10),
      UpdateMessage("update_message" , 1);
      private final String key;
      private final int defaultRateLimit;

      HelloMessageApiResourceKey(final String key, final int defaultRateLimit) {
        this.key = key;
        this.defaultRateLimit = defaultRateLimit;
      }

      @Override
      public String asString() {
        return key;
      }

      @Override
      public int getDefaultRateLimit() {
        return defaultRateLimit;
      }
    }

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface HelloMessageApiRateLimited {

      /**
       * Key to be used for resource limits.
       */
      HelloMessageApiResourceKey resourceKey();
    }

    /**
     * A filter factory that registers a resource key for rate limiting.
     * <p>
     * Remember to register HelloMessageApiFilterFactory in your application:
     * <code>environment.jersey().register(
     *   new HelloMessageApiApiResource.HelloMessageApiFilterFactory());</code>
     * </p>
     * Otherwise rate limits will not be enforced.
     */
    @Provider
    public static class HelloMessageApiFilterFactory extends AbstractFilterFactory {

      @Override
      public void configure(final ResourceInfo resourceInfo, final FeatureContext context) {
        final var annotation =
            resourceInfo.getResourceMethod().getAnnotation(HelloMessageApiRateLimited.class);
        if (isNull(annotation)) {
          return;
        }
        registerResourceKey(annotation.resourceKey(), context);
      }
    }
    private static final Logger log = LoggerFactory.getLogger(HelloMessageApi.class);

    /**
     * The delegate which contains all the business logic (implementation), implement HelloMessageApiDelegate and
     * and annotate it with the Service annotation.
     */
    private final HelloMessageApi handler;

   /**
    * Create a new HelloMessageApi resource.
    *
    * @param handler a {@link HelloMessageApi } that implements the handling of invocations
    */
   @Inject
   public HelloMessageApiResource(final HelloMessageApi handler) {
     this.handler = handler;
   }

   // --- REST Operations ---


   /**
    * POST /{sid}: Create a new message
    * 
    * @param sid A unique message SID identifier  a {@link com.twilio.sids.SmsSid}
    * @param etag assign etag a {@link String}
    * @param helloMessage assign helloMessage a {@link HelloMessage}
    * @param apiAuthContext the authentication context  a {@link ApiAuthContext}
    * @param requestContext the request context  a {@link com.twilio.core.request.context.RequestContext}
    * @param asyncResponse assign asyncResponse a {@link AsyncResponse}
    */
   @Operation(operationId = "createMessage", summary = "Create a new message",
        responses = { 
            @ApiResponse(responseCode = "201", description = "Message created",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = HelloMessageContainer.class)) 
                    }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "422", description = "Invalid HelloMessage",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "429", description = "Rate Limit Exceeded",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = com.twilio.rest.TwilioServiceErrorResponse.class)) 
                    })
        },
        parameters = { 
            @Parameter(name = "sid", required=true, in=ParameterIn.PATH, description = "A unique message SID identifier",
                content = @Content(schema = @Schema(implementation=com.twilio.sids.SmsSid.class))), 
            @Parameter(name = "etag", required=true, in=ParameterIn.HEADER,
                content = @Content(schema = @Schema(implementation=String.class))), 
            @Parameter(name = "helloMessage", required=true, in=ParameterIn.DEFAULT,
                content = @Content(schema = @Schema(implementation=HelloMessage.class))), 
            @Parameter(name = "apiAuthContext", required=true, in=ParameterIn.DEFAULT, description = "the authentication context",
                content = @Content(schema = @Schema(implementation=ApiAuthContext.class)))
        },
        security = { 
        }
   )
   @AsyncTimed(name = "create_message")
   @POST
   @Path("/{sid}")
   @Produces({ "application/json" })
   @Consumes({ "application/json" })
   @HelloMessageApiRateLimited(resourceKey = HelloMessageApiResourceKey.CreateMessage)
   @AIMDConcurrencyLimited(name = "create_message", timeout = 500, backOffRatio = 0.700000,  maxLimit = 1024, initialLimit = 200, minLimit = 2)
   public void createMessage(@Schema(description= "A unique message SID identifier", required = true) @Parameter(description="sid", in = ParameterIn.PATH) @PathParam("sid") com.twilio.sids.SmsSid sid,
                @Schema(description = "", required=true ) @Parameter(description="etag", in = ParameterIn.HEADER) @HeaderParam("etag") String etag,
                @Schema(description = "", required = true ) @NotNull 
  @Valid  HelloMessage helloMessage,
                @ApiAuth final ApiAuthContext apiAuthContext,
                @Context final com.twilio.core.request.context.RequestContext requestContext,
                @Suspended final AsyncResponse asyncResponse) {
        
     // create container for response headers
     final var responseHeaders = handler.createCreateMessageResponseHeaders();
     final var _reqTimeout = handler.getTimeoutMs("create_message");

     AsyncJerseyHelper.setAsyncResponse(
        handler.createMessage(sid,
                etag,
                helloMessage,
                apiAuthContext,
                requestContext, responseHeaders), asyncResponse,
            res -> {
              return res.fold(
                e -> {
                  final var builder = Response.status(e.getHttpStatusCode());
                  responseHeaders.addHeaders(builder);
                  builder.entity(e);
                  return builder.build();
                },
                v -> { 
                  final var builder = Response.status(201);
                  responseHeaders.addHeaders(builder);
                  builder.entity(v);
                  return builder.build();
                }
              ); // end of fold()
          },
          err -> { 
            log.error("Executing response for '{}' threw an exception: {}", "createMessage", err.getMessage(), err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(
                  new TwilioServiceErrorResponse("Request encountered an unexpected error",
                    Status.INTERNAL_SERVER_ERROR.getStatusCode(), false, null))
                  .build();
          },
          () -> {
            log.warn("Executing response for '{}' timed out after {} milliseconds", "createMessage", _reqTimeout);
            return Response.status(Status.SERVICE_UNAVAILABLE).entity(
                new TwilioServiceErrorResponse("Request timed out", Status.SERVICE_UNAVAILABLE.getStatusCode(), false, null))
            .build();
          },
        _reqTimeout);
      }
    
   /**
    * DELETE /{sid}: Deletes a message
    * 
    * @param sid A unique message SID identifier  a {@link com.twilio.sids.SmsSid}
    * @param apiAuthContext the authentication context  a {@link ApiAuthContext}
    * @param requestContext the request context  a {@link com.twilio.core.request.context.RequestContext}
    * @param asyncResponse assign asyncResponse a {@link AsyncResponse}
    */
   @Operation(operationId = "deleteMessage", summary = "Deletes a message",
        responses = { 
            @ApiResponse(responseCode = "204", description = "Message deleted",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)) 
                    }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "429", description = "Rate Limit Exceeded",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = com.twilio.rest.TwilioServiceErrorResponse.class)) 
                    })
        },
        parameters = { 
            @Parameter(name = "sid", required=true, in=ParameterIn.PATH, description = "A unique message SID identifier",
                content = @Content(schema = @Schema(implementation=com.twilio.sids.SmsSid.class))), 
            @Parameter(name = "apiAuthContext", required=true, in=ParameterIn.DEFAULT, description = "the authentication context",
                content = @Content(schema = @Schema(implementation=ApiAuthContext.class)))
        },
        security = { 
        }
   )
   @AsyncTimed(name = "delete_message")
   @DELETE
   @Path("/{sid}")
   @Produces({ "application/json" })
   @HelloMessageApiRateLimited(resourceKey = HelloMessageApiResourceKey.DeleteMessage)
   @AIMDConcurrencyLimited(name = "delete_message", timeout = 500, backOffRatio = 0.700000,  maxLimit = 1024, initialLimit = 200, minLimit = 2)
   public void deleteMessage(@Schema(description= "A unique message SID identifier", required = true) @Parameter(description="sid", in = ParameterIn.PATH) @PathParam("sid") com.twilio.sids.SmsSid sid,
                @ApiAuth final ApiAuthContext apiAuthContext,
                @Context final com.twilio.core.request.context.RequestContext requestContext,
                @Suspended final AsyncResponse asyncResponse) {
        
     // create container for response headers
     final var responseHeaders = handler.createDeleteMessageResponseHeaders();
     final var _reqTimeout = handler.getTimeoutMs("delete_message");

     AsyncJerseyHelper.setAsyncResponse(
        handler.deleteMessage(sid,
                apiAuthContext,
                requestContext, responseHeaders), asyncResponse,
            res -> {
              return res.fold(
                e -> {
                  final var builder = Response.status(e.getHttpStatusCode());
                  responseHeaders.addHeaders(builder);
                  builder.entity(e);
                  return builder.build();
                },
                v -> { 
                  final var builder = Response.status(204);
                  responseHeaders.addHeaders(builder);
                  builder.entity(v);
                  return builder.build();
                }
              ); // end of fold()
          },
          err -> { 
            log.error("Executing response for '{}' threw an exception: {}", "deleteMessage", err.getMessage(), err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(
                  new TwilioServiceErrorResponse("Request encountered an unexpected error",
                    Status.INTERNAL_SERVER_ERROR.getStatusCode(), false, null))
                  .build();
          },
          () -> {
            log.warn("Executing response for '{}' timed out after {} milliseconds", "deleteMessage", _reqTimeout);
            return Response.status(Status.SERVICE_UNAVAILABLE).entity(
                new TwilioServiceErrorResponse("Request timed out", Status.SERVICE_UNAVAILABLE.getStatusCode(), false, null))
            .build();
          },
        _reqTimeout);
      }
    
   /**
    * GET /{sid}: Fetch a message
    * 
    * @param sid A unique message SID identifier  a {@link com.twilio.sids.SmsSid}
    * @param ifMatch Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value.  a {@link String}
    * @param ifModifiedSince Makes the request method conditional on the selected representation's last modification date being earlier than or equal to the date provided in the field-value.  a {@link String}
    * @param ifNoneMatch Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value.  a {@link String}
    * @param ifUnmodifiedSince Makes the request method conditional on the selected representation's last modification date being later than the date provided in the field-value.  a {@link String}
    * @param ifRange Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn't match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response.  a {@link String}
    * @param apiAuthContext the authentication context  a {@link ApiAuthContext}
    * @param requestContext the request context  a {@link com.twilio.core.request.context.RequestContext}
    * @param asyncResponse assign asyncResponse a {@link AsyncResponse}
    */
   @Operation(operationId = "getMessage", summary = "Fetch a message",
        responses = { 
            @ApiResponse(responseCode = "200", description = "Message returned",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = HelloMessageContainer.class)) 
                    }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "404", description = "Message not found",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "429", description = "Rate Limit Exceeded",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = com.twilio.rest.TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "304", description = "Not Modified",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = com.twilio.rest.TwilioServiceErrorResponse.class)) 
                    })
        },
        parameters = { 
            @Parameter(name = "sid", required=true, in=ParameterIn.PATH, description = "A unique message SID identifier",
                content = @Content(schema = @Schema(implementation=com.twilio.sids.SmsSid.class))), 
            @Parameter(name = "apiAuthContext", required=true, in=ParameterIn.DEFAULT, description = "the authentication context",
                content = @Content(schema = @Schema(implementation=ApiAuthContext.class)))
        },
        security = { 
        }
   )
   @AsyncTimed(name = "get_message")
   @GET
   @Path("/{sid}")
   @Produces({ "application/json" })
   @HelloMessageApiRateLimited(resourceKey = HelloMessageApiResourceKey.GetMessage)
   @AIMDConcurrencyLimited(name = "get_message", timeout = 500, backOffRatio = 0.700000,  maxLimit = 1024, initialLimit = 200, minLimit = 2)
   public void getMessage(@Schema(description= "A unique message SID identifier", required = true) @Parameter(description="sid", in = ParameterIn.PATH) @PathParam("sid") com.twilio.sids.SmsSid sid,
                @Schema(description = "Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value.", required=true ) @Parameter(description="If-Match", in = ParameterIn.HEADER) @HeaderParam("If-Match") String ifMatch,
                @Schema(description = "Makes the request method conditional on the selected representation's last modification date being earlier than or equal to the date provided in the field-value.", required=true ) @Parameter(description="If-Modified-Since", in = ParameterIn.HEADER) @HeaderParam("If-Modified-Since") String ifModifiedSince,
                @Schema(description = "Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value.", required=true ) @Parameter(description="If-None-Match", in = ParameterIn.HEADER) @HeaderParam("If-None-Match") String ifNoneMatch,
                @Schema(description = "Makes the request method conditional on the selected representation's last modification date being later than the date provided in the field-value.", required=true ) @Parameter(description="If-Unmodified-Since", in = ParameterIn.HEADER) @HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince,
                @Schema(description = "Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn't match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response.", required=true ) @Parameter(description="If-Range", in = ParameterIn.HEADER) @HeaderParam("If-Range") String ifRange,
                @ApiAuth final ApiAuthContext apiAuthContext,
                @Context final com.twilio.core.request.context.RequestContext requestContext,
                @Suspended final AsyncResponse asyncResponse) {
        
     // create container for response headers
     final var responseHeaders = handler.createGetMessageResponseHeaders();
     final var conditional = handler.createConditional(ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange);
     final var _reqTimeout = handler.getTimeoutMs("get_message");

     AsyncJerseyHelper.setAsyncResponse(
        handler.getMessage(sid,
                apiAuthContext,
                requestContext, 
                conditional, responseHeaders), asyncResponse,
            res -> {
              return res.fold(
                e -> {
                  final var builder = Response.status(e.getHttpStatusCode());
                  responseHeaders.addHeaders(builder);
                  builder.entity(e);
                  return builder.build();
                },
                v -> { 
                  final var builder = Response.status(200);
                  responseHeaders.addHeaders(builder);
                  builder.entity(v);
                  return builder.build();
                }
              ); // end of fold()
          },
          err -> { 
            log.error("Executing response for '{}' threw an exception: {}", "getMessage", err.getMessage(), err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(
                  new TwilioServiceErrorResponse("Request encountered an unexpected error",
                    Status.INTERNAL_SERVER_ERROR.getStatusCode(), false, null))
                  .build();
          },
          () -> {
            log.warn("Executing response for '{}' timed out after {} milliseconds", "getMessage", _reqTimeout);
            return Response.status(Status.SERVICE_UNAVAILABLE).entity(
                new TwilioServiceErrorResponse("Request timed out", Status.SERVICE_UNAVAILABLE.getStatusCode(), false, null))
            .build();
          },
        _reqTimeout);
      }
    
   /**
    * GET : Retrieves messages
    * 
    * @param from A sender name  a {@link String}
    * @param to A recipient name  a {@link String}
    * @param pageSize Number of results to return at once  a {@link Integer}
    * @param pageToken Opaque token describing which page of results to return  a {@link String}
    * @param apiAuthContext the authentication context  a {@link ApiAuthContext}
    * @param requestContext the request context  a {@link com.twilio.core.request.context.RequestContext}
    * @param asyncResponse assign asyncResponse a {@link AsyncResponse}
    */
   @Operation(operationId = "listMessages", summary = "Retrieves messages",
        responses = { 
            @ApiResponse(responseCode = "200", description = "Returned message list",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = HelloMessageList.class)) 
                    }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "429", description = "Rate Limit Exceeded",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = com.twilio.rest.TwilioServiceErrorResponse.class)) 
                    })
        },
        parameters = { 
            @Parameter(name = "from", required=false, in=ParameterIn.QUERY, description = "A sender name",
                content = @Content(schema = @Schema(implementation=String.class))), 
            @Parameter(name = "to", required=false, in=ParameterIn.QUERY, description = "A recipient name",
                content = @Content(schema = @Schema(implementation=String.class))), 
            @Parameter(name = "pageSize", required=false, in=ParameterIn.QUERY, description = "Number of results to return at once",
                content = @Content(schema = @Schema(implementation=Integer.class))), 
            @Parameter(name = "pageToken", required=false, in=ParameterIn.QUERY, description = "Opaque token describing which page of results to return",
                content = @Content(schema = @Schema(implementation=String.class))), 
            @Parameter(name = "apiAuthContext", required=true, in=ParameterIn.DEFAULT, description = "the authentication context",
                content = @Content(schema = @Schema(implementation=ApiAuthContext.class)))
        },
        security = { 
        }
   )
   @AsyncTimed(name = "list_messages")
   @GET
   @Produces({ "application/json" })
   @HelloMessageApiRateLimited(resourceKey = HelloMessageApiResourceKey.ListMessages)
   @AIMDConcurrencyLimited(name = "list_messages", timeout = 1500, backOffRatio = 0.700000,  maxLimit = 1024, initialLimit = 200, minLimit = 2)
   public void listMessages(@Schema(description = "A sender name", required = false) @QueryParam(value = "From") @Parameter(description="From", in = ParameterIn.QUERY)   String from,
                @Schema(description = "A recipient name", required = false) @QueryParam(value = "To") @Parameter(description="To", in = ParameterIn.QUERY)   String to,
                @Schema(description = "Number of results to return at once", required = false) @QueryParam(value = "PageSize") @Parameter(description="PageSize", in = ParameterIn.QUERY)   Integer pageSize,
                @Schema(description = "Opaque token describing which page of results to return", required = false) @QueryParam(value = "PageToken") @Parameter(description="PageToken", in = ParameterIn.QUERY)   String pageToken,
                @ApiAuth final ApiAuthContext apiAuthContext,
                @Context final com.twilio.core.request.context.RequestContext requestContext,
                @Suspended final AsyncResponse asyncResponse) {
        
     // create container for response headers
     final var responseHeaders = handler.createListMessagesResponseHeaders();
     final var _reqTimeout = handler.getTimeoutMs("list_messages");

     AsyncJerseyHelper.setAsyncResponse(
        handler.listMessages(from,
                to,
                pageSize,
                pageToken,
                apiAuthContext,
                requestContext, responseHeaders), asyncResponse,
            res -> {
              return res.fold(
                e -> {
                  final var builder = Response.status(e.getHttpStatusCode());
                  responseHeaders.addHeaders(builder);
                  builder.entity(e);
                  return builder.build();
                },
                v -> { 
                  final var builder = Response.status(200);
                  responseHeaders.addHeaders(builder);
                  builder.entity(v);
                  return builder.build();
                }
              ); // end of fold()
          },
          err -> { 
            log.error("Executing response for '{}' threw an exception: {}", "listMessages", err.getMessage(), err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(
                  new TwilioServiceErrorResponse("Request encountered an unexpected error",
                    Status.INTERNAL_SERVER_ERROR.getStatusCode(), false, null))
                  .build();
          },
          () -> {
            log.warn("Executing response for '{}' timed out after {} milliseconds", "listMessages", _reqTimeout);
            return Response.status(Status.SERVICE_UNAVAILABLE).entity(
                new TwilioServiceErrorResponse("Request timed out", Status.SERVICE_UNAVAILABLE.getStatusCode(), false, null))
            .build();
          },
        _reqTimeout);
      }
    
   /**
    * PUT /{sid}: Update a message
    * 
    * @param sid A unique message SID identifier  a {@link com.twilio.sids.SmsSid}
    * @param from Sender address  a {@link String}
    * @param to Recipient address  a {@link String}
    * @param message Message body  a {@link String}
    * @param ifMatch Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value.  a {@link String}
    * @param ifModifiedSince Makes the request method conditional on the selected representation's last modification date being earlier than or equal to the date provided in the field-value.  a {@link String}
    * @param ifNoneMatch Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value.  a {@link String}
    * @param ifUnmodifiedSince Makes the request method conditional on the selected representation's last modification date being later than the date provided in the field-value.  a {@link String}
    * @param ifRange Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn't match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response.  a {@link String}
    * @param apiAuthContext the authentication context  a {@link ApiAuthContext}
    * @param requestContext the request context  a {@link com.twilio.core.request.context.RequestContext}
    * @param asyncResponse assign asyncResponse a {@link AsyncResponse}
    */
   @Operation(operationId = "updateMessage", summary = "Update a message",
        responses = { 
            @ApiResponse(responseCode = "200", description = "Message updated",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = HelloMessageContainer.class)) 
                    }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "404", description = "Message not found",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "429", description = "Rate Limit Exceeded",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = com.twilio.rest.TwilioServiceErrorResponse.class)) 
                    }),
            @ApiResponse(responseCode = "412", description = "Precondition Failed",
                    content = { 
                        @Content(mediaType = "application/json", schema = @Schema(implementation = com.twilio.rest.TwilioServiceErrorResponse.class)) 
                    })
        },
        parameters = { 
            @Parameter(name = "sid", required=true, in=ParameterIn.PATH, description = "A unique message SID identifier",
                content = @Content(schema = @Schema(implementation=com.twilio.sids.SmsSid.class))), 
            @Parameter(name = "from", required=false, in=ParameterIn.DEFAULT, description = "Sender address",
                content = @Content(schema = @Schema(implementation=String.class))), 
            @Parameter(name = "to", required=false, in=ParameterIn.DEFAULT, description = "Recipient address",
                content = @Content(schema = @Schema(implementation=String.class))), 
            @Parameter(name = "message", required=false, in=ParameterIn.DEFAULT, description = "Message body",
                content = @Content(schema = @Schema(implementation=String.class))), 
            @Parameter(name = "apiAuthContext", required=true, in=ParameterIn.DEFAULT, description = "the authentication context",
                content = @Content(schema = @Schema(implementation=ApiAuthContext.class)))
        },
        security = { 
        }
   )
   @AsyncTimed(name = "update_message")
   @PUT
   @Path("/{sid}")
   @Produces({ "application/json" })
   @Consumes({ "application/x-www-form-urlencoded" })
   @HelloMessageApiRateLimited(resourceKey = HelloMessageApiResourceKey.UpdateMessage)
   @AIMDConcurrencyLimited(name = "update_message", timeout = 500, backOffRatio = 0.700000,  maxLimit = 1024, initialLimit = 200, minLimit = 2)
   public void updateMessage(@Schema(description= "A unique message SID identifier", required = true) @Parameter(description="sid", in = ParameterIn.PATH) @PathParam("sid") com.twilio.sids.SmsSid sid,
                @Schema(description = "Sender address", required = false) @Parameter(description="From") @FormParam("From")final String from,
                @Schema(description = "Recipient address", required = false) @Parameter(description="To") @FormParam("To")final String to,
                @Schema(description = "Message body", required = false) @Parameter(description="Message") @FormParam("Message")final String message,
                @Schema(description = "Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value.", required=true ) @Parameter(description="If-Match", in = ParameterIn.HEADER) @HeaderParam("If-Match") String ifMatch,
                @Schema(description = "Makes the request method conditional on the selected representation's last modification date being earlier than or equal to the date provided in the field-value.", required=true ) @Parameter(description="If-Modified-Since", in = ParameterIn.HEADER) @HeaderParam("If-Modified-Since") String ifModifiedSince,
                @Schema(description = "Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value.", required=true ) @Parameter(description="If-None-Match", in = ParameterIn.HEADER) @HeaderParam("If-None-Match") String ifNoneMatch,
                @Schema(description = "Makes the request method conditional on the selected representation's last modification date being later than the date provided in the field-value.", required=true ) @Parameter(description="If-Unmodified-Since", in = ParameterIn.HEADER) @HeaderParam("If-Unmodified-Since") String ifUnmodifiedSince,
                @Schema(description = "Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn't match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response.", required=true ) @Parameter(description="If-Range", in = ParameterIn.HEADER) @HeaderParam("If-Range") String ifRange,
                @ApiAuth final ApiAuthContext apiAuthContext,
                @Context final com.twilio.core.request.context.RequestContext requestContext,
                @Suspended final AsyncResponse asyncResponse) {
        
     // create container for response headers
     final var responseHeaders = handler.createUpdateMessageResponseHeaders();
     final var conditional = handler.createConditional(ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange);
     final var _reqTimeout = handler.getTimeoutMs("update_message");

     AsyncJerseyHelper.setAsyncResponse(
        handler.updateMessage(sid,
                from,
                to,
                message,
                apiAuthContext,
                requestContext, 
                conditional, responseHeaders), asyncResponse,
            res -> {
              return res.fold(
                e -> {
                  final var builder = Response.status(e.getHttpStatusCode());
                  responseHeaders.addHeaders(builder);
                  builder.entity(e);
                  return builder.build();
                },
                v -> { 
                  final var builder = Response.status(200);
                  responseHeaders.addHeaders(builder);
                  builder.entity(v);
                  return builder.build();
                }
              ); // end of fold()
          },
          err -> { 
            log.error("Executing response for '{}' threw an exception: {}", "updateMessage", err.getMessage(), err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(
                  new TwilioServiceErrorResponse("Request encountered an unexpected error",
                    Status.INTERNAL_SERVER_ERROR.getStatusCode(), false, null))
                  .build();
          },
          () -> {
            log.warn("Executing response for '{}' timed out after {} milliseconds", "updateMessage", _reqTimeout);
            return Response.status(Status.SERVICE_UNAVAILABLE).entity(
                new TwilioServiceErrorResponse("Request timed out", Status.SERVICE_UNAVAILABLE.getStatusCode(), false, null))
            .build();
          },
        _reqTimeout);
      }
    
}
