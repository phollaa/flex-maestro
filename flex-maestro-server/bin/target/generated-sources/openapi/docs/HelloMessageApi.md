# HelloMessageApi

All URIs are relative to *http://localhost:9876/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createMessage**](HelloMessageApi.md#createMessage) | **POST** /{sid} | Create a new message |
| [**deleteMessage**](HelloMessageApi.md#deleteMessage) | **DELETE** /{sid} | Deletes a message |
| [**getMessage**](HelloMessageApi.md#getMessage) | **GET** /{sid} | Fetch a message |
| [**listMessages**](HelloMessageApi.md#listMessages) | **GET**  | Retrieves messages |
| [**updateMessage**](HelloMessageApi.md#updateMessage) | **PUT** /{sid} | Update a message |




## createMessage

> HelloMessageContainer createMessage(sid, etag, helloMessage, apiAuthContext, requestContext, asyncResponse)

Create a new message

### Example

```java
import com.twilio.core.request.context.RequestContext;
import com.twilio.core.security.contexts.ApiAuthContext;
import com.twilio.sids.SmsSid;
import jakarta.ws.rs.container.AsyncResponse;
// Import classes:
import com.twilio.flexmaestro.server.ApiClient;
import com.twilio.flexmaestro.server.ApiException;
import com.twilio.flexmaestro.server.Configuration;
import com.twilio.flexmaestro.server.auth.*;
import com.twilio.flexmaestro.server.model.*;
import com.twilio.flexmaestro.server.api.hello.message.HelloMessageApi;

public class Example {
    public static void main(String[] args) {
        final var client = new HelloMessageApi.Builder()
            .baseUrl(URI.create("http://localhost:9876/v1))
            .objectMapper(mapper)
            .requestTimeout(Duration.ofSeconds(5)).build();
final var responseHeaders = CreateMessageResponseHeaders();

        final com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        final String etag = "etag_example"; // String | 
        final HelloMessage helloMessage = new HelloMessage(); // HelloMessage | 
        final com.twilio.core.request.context.RequestContext requestContext = ; // com.twilio.core.request.context.RequestContext | the request context
        final var request = client.createMessage(sid, etag, helloMessage, requestContext);
        try {
            request.call(responseHeaders)
                .thenApply(response -> response.fold(e -> e.printStackTrace(), v -> System.out.println("Response: " + v)))
                .toCompletableFuture()
                .get(10, TimeUnit.SECONDS);
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageApi#createMessage");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sid** | [**String**](String.md)| A unique message SID identifier | |
| **etag** | **String**|  | |
| **helloMessage** | [**HelloMessage**](HelloMessage.md)|  | |
| **requestContext** | **RequestContext**| the request context | |

### Return type

[**HelloMessageContainer**](HelloMessageContainer.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Message created |  * etag -  <br>  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **422** | Invalid HelloMessage |  -  |
| **500** | Internal server error |  -  |
| **429** | Rate Limit Exceeded |  * X-Rate-Limit-Config - The rate limit configuration used for this request. <br>  * X-Rate-Limit-Limit - The maximum number of requests that can be made in the current time window. <br>  * X-Rate-Limit-Remaining - The number of requests left for the time window. <br>  |



## deleteMessage

> deleteMessage(sid, apiAuthContext, requestContext, asyncResponse)

Deletes a message

### Example

```java
import com.twilio.core.request.context.RequestContext;
import com.twilio.core.security.contexts.ApiAuthContext;
import com.twilio.sids.SmsSid;
import jakarta.ws.rs.container.AsyncResponse;
// Import classes:
import com.twilio.flexmaestro.server.ApiClient;
import com.twilio.flexmaestro.server.ApiException;
import com.twilio.flexmaestro.server.Configuration;
import com.twilio.flexmaestro.server.auth.*;
import com.twilio.flexmaestro.server.model.*;
import com.twilio.flexmaestro.server.api.hello.message.HelloMessageApi;

public class Example {
    public static void main(String[] args) {
        final var client = new HelloMessageApi.Builder()
            .baseUrl(URI.create("http://localhost:9876/v1))
            .objectMapper(mapper)
            .requestTimeout(Duration.ofSeconds(5)).build();
final var responseHeaders = DeleteMessageResponseHeaders();

        final com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        final com.twilio.core.request.context.RequestContext requestContext = ; // com.twilio.core.request.context.RequestContext | the request context
        final var request = client.deleteMessage(sid, requestContext);
        try {
            request.call(responseHeaders)
                .thenApply(response -> response.fold(e -> e.printStackTrace(), v -> System.out.println("Response: " + v)))
                .toCompletableFuture()
                .get(10, TimeUnit.SECONDS);
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageApi#deleteMessage");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sid** | [**String**](String.md)| A unique message SID identifier | |
| **requestContext** | **RequestContext**| the request context | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Message deleted |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |
| **429** | Rate Limit Exceeded |  * X-Rate-Limit-Config - The rate limit configuration used for this request. <br>  * X-Rate-Limit-Limit - The maximum number of requests that can be made in the current time window. <br>  * X-Rate-Limit-Remaining - The number of requests left for the time window. <br>  |



## getMessage

> HelloMessageContainer getMessage(sid, ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange, apiAuthContext, requestContext, asyncResponse)

Fetch a message

### Example

```java
import com.twilio.core.request.context.RequestContext;
import com.twilio.core.security.contexts.ApiAuthContext;
import com.twilio.sids.SmsSid;
import jakarta.ws.rs.container.AsyncResponse;
// Import classes:
import com.twilio.flexmaestro.server.ApiClient;
import com.twilio.flexmaestro.server.ApiException;
import com.twilio.flexmaestro.server.Configuration;
import com.twilio.flexmaestro.server.auth.*;
import com.twilio.flexmaestro.server.model.*;
import com.twilio.flexmaestro.server.api.hello.message.HelloMessageApi;

public class Example {
    public static void main(String[] args) {
        final var client = new HelloMessageApi.Builder()
            .baseUrl(URI.create("http://localhost:9876/v1))
            .objectMapper(mapper)
            .requestTimeout(Duration.ofSeconds(5)).build();
final var responseHeaders = GetMessageResponseHeaders();

        final com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        final com.twilio.core.request.context.RequestContext requestContext = ; // com.twilio.core.request.context.RequestContext | the request context
        final var request = client.getMessage(sid, requestContext);
        try {
            request.call(responseHeaders)
                .thenApply(response -> response.fold(e -> e.printStackTrace(), v -> System.out.println("Response: " + v)))
                .toCompletableFuture()
                .get(10, TimeUnit.SECONDS);
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageApi#getMessage");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sid** | [**String**](String.md)| A unique message SID identifier | |
| **requestContext** | **RequestContext**| the request context | |

### Return type

[**HelloMessageContainer**](HelloMessageContainer.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Message returned |  * etag -  <br>  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Message not found |  -  |
| **500** | Internal server error |  -  |
| **429** | Rate Limit Exceeded |  * X-Rate-Limit-Config - The rate limit configuration used for this request. <br>  * X-Rate-Limit-Limit - The maximum number of requests that can be made in the current time window. <br>  * X-Rate-Limit-Remaining - The number of requests left for the time window. <br>  |
| **304** | Not Modified |  * ETag - An opaque validator for
 differentiating between multiple representations of the same resource, regardless of whether those multiple representations are due to resource state changes over time, content negotiation resulting in multiple representations being valid at the same time, or both <br>  * Cache-Control - The &quot;Cache-Control&quot; header field is used to specify directives for caches along the request/response chain.  Such cache directives are unidirectional in that the presence of a directive in a request does not imply that the same directive is to be given in the response. <br>  * Content-Location - The &quot;Content-Location&quot; header field references a URI that can be used as an identifier for a specific resource corresponding to the representation in this message&#39;s payload <br>  * DATE - The &quot;Date&quot; header field represents the date and time at which the message was originated, having the same semantics as the Origination Date Field (orig-date) defined in Section 3.6.1 of [RFC5322].  The field value is an HTTP-date <br>  * Expires - The &quot;Expires&quot; header field gives the date/time after which the response is considered stale.  See Section 4.2 for further discussion of the freshness model <br>  * Vary - The &quot;Vary&quot; header field in a response describes what parts of a request message, aside from the method, Host header field, and request target, might influence the origin server&#39;s process for selecting and representing this response.  The value consists of either a single asterisk (&quot;*&quot;) or a list of header field names (case-insensitive) <br>  * Last-Modified - The last modified date for the requested object (in RFC 2822 format). <br>  |



## listMessages

> HelloMessageList listMessages(from, to, pageSize, pageToken, apiAuthContext, requestContext, asyncResponse)

Retrieves messages

### Example

```java
import com.twilio.core.request.context.RequestContext;
import com.twilio.core.security.contexts.ApiAuthContext;
import jakarta.ws.rs.container.AsyncResponse;
// Import classes:
import com.twilio.flexmaestro.server.ApiClient;
import com.twilio.flexmaestro.server.ApiException;
import com.twilio.flexmaestro.server.Configuration;
import com.twilio.flexmaestro.server.auth.*;
import com.twilio.flexmaestro.server.model.*;
import com.twilio.flexmaestro.server.api.hello.message.HelloMessageApi;

public class Example {
    public static void main(String[] args) {
        final var client = new HelloMessageApi.Builder()
            .baseUrl(URI.create("http://localhost:9876/v1))
            .objectMapper(mapper)
            .requestTimeout(Duration.ofSeconds(5)).build();
final var responseHeaders = ListMessagesResponseHeaders();

        final String from = "from_example"; // String | A sender name
        final String to = "to_example"; // String | A recipient name
        final Integer pageSize = 56; // Integer | Number of results to return at once
        final String pageToken = "pageToken_example"; // String | Opaque token describing which page of results to return
        final com.twilio.core.request.context.RequestContext requestContext = ; // com.twilio.core.request.context.RequestContext | the request context
        final var request = client.listMessages(from, to, pageSize, pageToken, requestContext);
        try {
            request.call(responseHeaders)
                .thenApply(response -> response.fold(e -> e.printStackTrace(), v -> System.out.println("Response: " + v)))
                .toCompletableFuture()
                .get(10, TimeUnit.SECONDS);
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageApi#listMessages");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **from** | **String**| A sender name | [optional] |
| **to** | **String**| A recipient name | [optional] |
| **pageSize** | **Integer**| Number of results to return at once | [optional] |
| **pageToken** | **String**| Opaque token describing which page of results to return | [optional] |
| **requestContext** | **RequestContext**| the request context | |

### Return type

[**HelloMessageList**](HelloMessageList.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned message list |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |
| **429** | Rate Limit Exceeded |  * X-Rate-Limit-Config - The rate limit configuration used for this request. <br>  * X-Rate-Limit-Limit - The maximum number of requests that can be made in the current time window. <br>  * X-Rate-Limit-Remaining - The number of requests left for the time window. <br>  |



## updateMessage

> HelloMessageContainer updateMessage(sid, from, to, message, ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange, apiAuthContext, requestContext, asyncResponse)

Update a message

### Example

```java
import com.twilio.core.request.context.RequestContext;
import com.twilio.core.security.contexts.ApiAuthContext;
import com.twilio.sids.SmsSid;
import jakarta.ws.rs.container.AsyncResponse;
// Import classes:
import com.twilio.flexmaestro.server.ApiClient;
import com.twilio.flexmaestro.server.ApiException;
import com.twilio.flexmaestro.server.Configuration;
import com.twilio.flexmaestro.server.auth.*;
import com.twilio.flexmaestro.server.model.*;
import com.twilio.flexmaestro.server.api.hello.message.HelloMessageApi;

public class Example {
    public static void main(String[] args) {
        final var client = new HelloMessageApi.Builder()
            .baseUrl(URI.create("http://localhost:9876/v1))
            .objectMapper(mapper)
            .requestTimeout(Duration.ofSeconds(5)).build();
final var responseHeaders = UpdateMessageResponseHeaders();

        final com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        final String from = "from_example"; // String | Sender address
        final String to = "to_example"; // String | Recipient address
        final String message = "message_example"; // String | Message body
        final com.twilio.core.request.context.RequestContext requestContext = ; // com.twilio.core.request.context.RequestContext | the request context
        final var request = client.updateMessage(sid, from, to, message, requestContext);
        try {
            request.call(responseHeaders)
                .thenApply(response -> response.fold(e -> e.printStackTrace(), v -> System.out.println("Response: " + v)))
                .toCompletableFuture()
                .get(10, TimeUnit.SECONDS);
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageApi#updateMessage");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sid** | [**String**](String.md)| A unique message SID identifier | |
| **from** | **String**| Sender address | [optional] |
| **to** | **String**| Recipient address | [optional] |
| **message** | **String**| Message body | [optional] |
| **requestContext** | **RequestContext**| the request context | |

### Return type

[**HelloMessageContainer**](HelloMessageContainer.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Message updated |  -  |
| **400** | Invalid parameters |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **404** | Message not found |  -  |
| **500** | Internal server error |  -  |
| **429** | Rate Limit Exceeded |  * X-Rate-Limit-Config - The rate limit configuration used for this request. <br>  * X-Rate-Limit-Limit - The maximum number of requests that can be made in the current time window. <br>  * X-Rate-Limit-Remaining - The number of requests left for the time window. <br>  |
| **412** | Precondition Failed |  * ETag - An opaque validator for
 differentiating between multiple representations of the same resource, regardless of whether those multiple representations are due to resource state changes over time, content negotiation resulting in multiple representations being valid at the same time, or both <br>  * Last-Modified - The last modified date for the requested object (in RFC 2822 format). <br>  |


