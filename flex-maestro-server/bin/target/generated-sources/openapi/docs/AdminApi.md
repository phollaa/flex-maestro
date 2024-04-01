# AdminApi

All URIs are relative to *http://localhost:9876/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**readMessages**](AdminApi.md#readMessages) | **GET**  | Reads all the messages |




## readMessages

> HelloMessageList readMessages(pageSize, pageToken, remoteHostContext, requestContext, asyncResponse)

Reads all the messages

### Example

```java
import com.twilio.core.request.context.RequestContext;
import com.twilio.core.security.contexts.RemoteHostContext;
import jakarta.ws.rs.container.AsyncResponse;
// Import classes:
import com.twilio.flexmaestro.server.ApiClient;
import com.twilio.flexmaestro.server.ApiException;
import com.twilio.flexmaestro.server.Configuration;
import com.twilio.flexmaestro.server.auth.*;
import com.twilio.flexmaestro.server.model.*;
import com.twilio.flexmaestro.server.api.admin.AdminApi;

public class Example {
    public static void main(String[] args) {
        final var client = new AdminApi.Builder()
            .baseUrl(URI.create("http://localhost:9876/v1))
            .objectMapper(mapper)
            .requestTimeout(Duration.ofSeconds(5)).build();
final var responseHeaders = ReadMessagesResponseHeaders();

        final Integer pageSize = 56; // Integer | Number of results to return at once
        final String pageToken = "pageToken_example"; // String | Opaque token describing which page of results to return
        final com.twilio.core.request.context.RequestContext requestContext = ; // com.twilio.core.request.context.RequestContext | the request context
        final var request = client.readMessages(pageSize, pageToken, requestContext);
        try {
            request.call(responseHeaders)
                .thenApply(response -> response.fold(e -> e.printStackTrace(), v -> System.out.println("Response: " + v)))
                .toCompletableFuture()
                .get(10, TimeUnit.SECONDS);
        } catch (ApiException e) {
            System.err.println("Exception when calling AdminApi#readMessages");
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
| **200** | Full message list |  * etag -  <br>  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |
| **429** | Rate Limit Exceeded |  * X-Rate-Limit-Config - The rate limit configuration used for this request. <br>  * X-Rate-Limit-Limit - The maximum number of requests that can be made in the current time window. <br>  * X-Rate-Limit-Remaining - The number of requests left for the time window. <br>  |


