# AdminClient

All URIs are relative to *http://localhost:9876/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**readMessages**](AdminClient.md#readMessages) | **GET**  | Reads all the messages
[**readMessagesWithHttpInfo**](AdminClient.md#readMessagesWithHttpInfo) | **GET**  | Reads all the messages




## readMessages

> CompletionStage<HelloMessageList> readMessages(pageSize, pageToken, remoteHostContext, requestContext, asyncResponse)

Reads all the messages

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.admin.AdminClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        AdminClient apiInstance = new AdminClient(defaultClient);
        Integer pageSize = 56; // Integer | Number of results to return at once
        String pageToken = "pageToken_example"; // String | Opaque token describing which page of results to return
        RemoteHostContext remoteHostContext = ; // RemoteHostContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<HelloMessageList> result = apiInstance.readMessages(pageSize, pageToken, remoteHostContext, requestContext, asyncResponse);
            System.out.println(result.get());
        } catch (ApiException e) {
            System.err.println("Exception when calling AdminClient#readMessages");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageSize** | **Integer**| Number of results to return at once | [optional]
 **pageToken** | **String**| Opaque token describing which page of results to return | [optional]
 **remoteHostContext** | [**RemoteHostContext**](RemoteHostContext.md)| the authentication context |
 **requestContext** | [**RequestContext**](RequestContext.md)| the request context |
 **asyncResponse** | [**AsyncResponse**](AsyncResponse.md)|  | [optional]

### Return type

CompletionStage<[**HelloMessageList**](HelloMessageList.md)foo >


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

## readMessagesWithHttpInfo

> CompletionStage<ApiResponse<HelloMessageList>> readMessages readMessagesWithHttpInfo(pageSize, pageToken, remoteHostContext, requestContext, asyncResponse)

Reads all the messages

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.ApiResponse;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.admin.AdminClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        AdminClient apiInstance = new AdminClient(defaultClient);
        Integer pageSize = 56; // Integer | Number of results to return at once
        String pageToken = "pageToken_example"; // String | Opaque token describing which page of results to return
        RemoteHostContext remoteHostContext = ; // RemoteHostContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<ApiResponse<HelloMessageList>> response = apiInstance.readMessagesWithHttpInfo(pageSize, pageToken, remoteHostContext, requestContext, asyncResponse);
            System.out.println("Status code: " + response.get().getStatusCode());
            System.out.println("Response headers: " + response.get().getHeaders());
            System.out.println("Response body: " + response.get().getData());
        } catch (InterruptedException | ExecutionException e) {
            ApiException apiException = (ApiException)e.getCause();
            System.err.println("Exception when calling AdminClient#readMessages");
            System.err.println("Status code: " + apiException.getCode());
            System.err.println("Response headers: " + apiException.getResponseHeaders());
            System.err.println("Reason: " + apiException.getResponseBody());
            e.printStackTrace();
        } catch (ApiException e) {
            System.err.println("Exception when calling AdminClient#readMessages");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageSize** | **Integer**| Number of results to return at once | [optional]
 **pageToken** | **String**| Opaque token describing which page of results to return | [optional]
 **remoteHostContext** | [**RemoteHostContext**](RemoteHostContext.md)| the authentication context |
 **requestContext** | [**RequestContext**](RequestContext.md)| the request context |
 **asyncResponse** | [**AsyncResponse**](AsyncResponse.md)|  | [optional]

### Return type

CompletionStage<ApiResponse<[**HelloMessageList**](HelloMessageList.md)>>


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

