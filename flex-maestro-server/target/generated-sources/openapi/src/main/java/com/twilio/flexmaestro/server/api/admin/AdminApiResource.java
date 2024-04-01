package com.twilio.flexmaestro.server.api.admin;

import com.twilio.core.jersey3.auth.annotations.HostAuth;
import com.twilio.flexmaestro.server.definitions.HelloMessageList;
import com.twilio.core.security.contexts.RemoteHostContext;
import com.twilio.rest.TwilioServiceErrorResponse;
import com.twilio.concurrency.limit.annotations.AIMDConcurrencyLimited;
import io.vavr.control.Either;
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
import com.twilio.flexmaestro.server.api.admin.AdminApi;

/**
 * The AdminApiResources exposes REST endpoints to the servlet container.
 * It offers delegation to the specified {@link AdminApiResource#handler} which can be
 * either injected or passed to the constructor.
 * Second thing it offers is the ability to map an error, exception or a timeout to a {@link TwilioServiceErrorResponse}.
 */

@jakarta.annotation.Generated(value = "com.twilio.codegen.TwilioGenerator", date = "2024-04-01T17:46:14.982174+05:30[Asia/Kolkata]")
@Tag(description = "The Admin API", name = "")
@Path("/v1/Admin/ReadMessages")public class AdminApiResource {  
    public static enum AdminApiResourceKey implements ResourceKey { 
      ReadMessages("read_messages" , 1);
      private final String key;
      private final int defaultRateLimit;

      AdminApiResourceKey(final String key, final int defaultRateLimit) {
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
    public static @interface AdminApiRateLimited {

      /**
       * Key to be used for resource limits.
       */
      AdminApiResourceKey resourceKey();
    }

    /**
     * A filter factory that registers a resource key for rate limiting.
     * <p>
     * Remember to register AdminApiFilterFactory in your application:
     * <code>environment.jersey().register(
     *   new AdminApiApiResource.AdminApiFilterFactory());</code>
     * </p>
     * Otherwise rate limits will not be enforced.
     */
    @Provider
    public static class AdminApiFilterFactory extends AbstractFilterFactory {

      @Override
      public void configure(final ResourceInfo resourceInfo, final FeatureContext context) {
        final var annotation =
            resourceInfo.getResourceMethod().getAnnotation(AdminApiRateLimited.class);
        if (isNull(annotation)) {
          return;
        }
        registerResourceKey(annotation.resourceKey(), context);
      }
    }
    private static final Logger log = LoggerFactory.getLogger(AdminApi.class);

    /**
     * The delegate which contains all the business logic (implementation), implement AdminApiDelegate and
     * and annotate it with the Service annotation.
     */
    private final AdminApi handler;

   /**
    * Create a new AdminApi resource.
    *
    * @param handler a {@link AdminApi } that implements the handling of invocations
    */
   @Inject
   public AdminApiResource(final AdminApi handler) {
     this.handler = handler;
   }

   // --- REST Operations ---


   /**
    * GET : Reads all the messages
    * 
    * @param pageSize Number of results to return at once  a {@link Integer}
    * @param pageToken Opaque token describing which page of results to return  a {@link String}
    * @param remoteHostContext the authentication context  a {@link RemoteHostContext}
    * @param requestContext the request context  a {@link com.twilio.core.request.context.RequestContext}
    * @param asyncResponse assign asyncResponse a {@link AsyncResponse}
    */
   @Operation(operationId = "readMessages", summary = "Reads all the messages",
        responses = { 
            @ApiResponse(responseCode = "200", description = "Full message list",
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
            @Parameter(name = "pageSize", required=false, in=ParameterIn.QUERY, description = "Number of results to return at once",
                content = @Content(schema = @Schema(implementation=Integer.class))), 
            @Parameter(name = "pageToken", required=false, in=ParameterIn.QUERY, description = "Opaque token describing which page of results to return",
                content = @Content(schema = @Schema(implementation=String.class))), 
            @Parameter(name = "remoteHostContext", required=true, in=ParameterIn.DEFAULT, description = "the authentication context",
                content = @Content(schema = @Schema(implementation=RemoteHostContext.class)))
        },
        security = { 
        }
   )
   @AsyncTimed(name = "read_messages")
   @GET
   @Produces({ "application/json" })
   @AdminApiRateLimited(resourceKey = AdminApiResourceKey.ReadMessages)
   @AIMDConcurrencyLimited(name = "read_messages", timeout = 500, backOffRatio = 0.700000,  maxLimit = 1024, initialLimit = 200, minLimit = 2)
   public void readMessages(@Schema(description = "Number of results to return at once", required = false) @QueryParam(value = "PageSize") @Parameter(description="PageSize", in = ParameterIn.QUERY)   Integer pageSize,
                @Schema(description = "Opaque token describing which page of results to return", required = false) @QueryParam(value = "PageToken") @Parameter(description="PageToken", in = ParameterIn.QUERY)   String pageToken,
                @HostAuth(views = { "admin" } , require = true) final RemoteHostContext remoteHostContext,
                @Context final com.twilio.core.request.context.RequestContext requestContext,
                @Suspended final AsyncResponse asyncResponse) {
        
     // create container for response headers
     final var responseHeaders = handler.createReadMessagesResponseHeaders();
     final var _reqTimeout = handler.getTimeoutMs("read_messages");

     AsyncJerseyHelper.setAsyncResponse(
        handler.readMessages(pageSize,
                pageToken,
                remoteHostContext,
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
            log.error("Executing response for '{}' threw an exception: {}", "readMessages", err.getMessage(), err);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(
                  new TwilioServiceErrorResponse("Request encountered an unexpected error",
                    Status.INTERNAL_SERVER_ERROR.getStatusCode(), false, null))
                  .build();
          },
          () -> {
            log.warn("Executing response for '{}' timed out after {} milliseconds", "readMessages", _reqTimeout);
            return Response.status(Status.SERVICE_UNAVAILABLE).entity(
                new TwilioServiceErrorResponse("Request timed out", Status.SERVICE_UNAVAILABLE.getStatusCode(), false, null))
            .build();
          },
        _reqTimeout);
      }
    
}
