# HelloMessageClient

All URIs are relative to *http://localhost:9876/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMessage**](HelloMessageClient.md#createMessage) | **POST** /{sid} | Create a new message
[**createMessageWithHttpInfo**](HelloMessageClient.md#createMessageWithHttpInfo) | **POST** /{sid} | Create a new message
[**deleteMessage**](HelloMessageClient.md#deleteMessage) | **DELETE** /{sid} | Deletes a message
[**deleteMessageWithHttpInfo**](HelloMessageClient.md#deleteMessageWithHttpInfo) | **DELETE** /{sid} | Deletes a message
[**getMessage**](HelloMessageClient.md#getMessage) | **GET** /{sid} | Fetch a message
[**getMessageWithHttpInfo**](HelloMessageClient.md#getMessageWithHttpInfo) | **GET** /{sid} | Fetch a message
[**listMessages**](HelloMessageClient.md#listMessages) | **GET**  | Retrieves messages
[**listMessagesWithHttpInfo**](HelloMessageClient.md#listMessagesWithHttpInfo) | **GET**  | Retrieves messages
[**updateMessage**](HelloMessageClient.md#updateMessage) | **PUT** /{sid} | Update a message
[**updateMessageWithHttpInfo**](HelloMessageClient.md#updateMessageWithHttpInfo) | **PUT** /{sid} | Update a message




## createMessage

> CompletionStage<HelloMessageContainer> createMessage(sid, etag, helloMessage, apiAuthContext, requestContext, asyncResponse)

Create a new message

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        HelloMessageClient apiInstance = new HelloMessageClient(defaultClient);
        com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        String etag = "etag_example"; // String | 
        HelloMessage helloMessage = new HelloMessage(); // HelloMessage | 
        ApiAuthContext apiAuthContext = ; // ApiAuthContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<HelloMessageContainer> result = apiInstance.createMessage(sid, etag, helloMessage, apiAuthContext, requestContext, asyncResponse);
            System.out.println(result.get());
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageClient#createMessage");
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
 **sid** | **com.twilio.sids.SmsSid**| A unique message SID identifier |
 **etag** | **String**|  |
 **helloMessage** | [**HelloMessage**](HelloMessage.md)|  |
 **apiAuthContext** | [**ApiAuthContext**](ApiAuthContext.md)| the authentication context |
 **requestContext** | [**RequestContext**](RequestContext.md)| the request context |
 **asyncResponse** | [**AsyncResponse**](AsyncResponse.md)|  | [optional]

### Return type

CompletionStage<[**HelloMessageContainer**](HelloMessageContainer.md)foo >


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

## createMessageWithHttpInfo

> CompletionStage<ApiResponse<HelloMessageContainer>> createMessage createMessageWithHttpInfo(sid, etag, helloMessage, apiAuthContext, requestContext, asyncResponse)

Create a new message

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.ApiResponse;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        HelloMessageClient apiInstance = new HelloMessageClient(defaultClient);
        com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        String etag = "etag_example"; // String | 
        HelloMessage helloMessage = new HelloMessage(); // HelloMessage | 
        ApiAuthContext apiAuthContext = ; // ApiAuthContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<ApiResponse<HelloMessageContainer>> response = apiInstance.createMessageWithHttpInfo(sid, etag, helloMessage, apiAuthContext, requestContext, asyncResponse);
            System.out.println("Status code: " + response.get().getStatusCode());
            System.out.println("Response headers: " + response.get().getHeaders());
            System.out.println("Response body: " + response.get().getData());
        } catch (InterruptedException | ExecutionException e) {
            ApiException apiException = (ApiException)e.getCause();
            System.err.println("Exception when calling HelloMessageClient#createMessage");
            System.err.println("Status code: " + apiException.getCode());
            System.err.println("Response headers: " + apiException.getResponseHeaders());
            System.err.println("Reason: " + apiException.getResponseBody());
            e.printStackTrace();
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageClient#createMessage");
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
 **sid** | **com.twilio.sids.SmsSid**| A unique message SID identifier |
 **etag** | **String**|  |
 **helloMessage** | [**HelloMessage**](HelloMessage.md)|  |
 **apiAuthContext** | [**ApiAuthContext**](ApiAuthContext.md)| the authentication context |
 **requestContext** | [**RequestContext**](RequestContext.md)| the request context |
 **asyncResponse** | [**AsyncResponse**](AsyncResponse.md)|  | [optional]

### Return type

CompletionStage<ApiResponse<[**HelloMessageContainer**](HelloMessageContainer.md)>>


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

> CompletionStage<Void> deleteMessage(sid, apiAuthContext, requestContext, asyncResponse)

Deletes a message

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        HelloMessageClient apiInstance = new HelloMessageClient(defaultClient);
        com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        ApiAuthContext apiAuthContext = ; // ApiAuthContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<Void> result =apiInstance.deleteMessage(sid, apiAuthContext, requestContext, asyncResponse);
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageClient#deleteMessage");
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
 **sid** | **com.twilio.sids.SmsSid**| A unique message SID identifier |
 **apiAuthContext** | [**ApiAuthContext**](ApiAuthContext.md)| the authentication context |
 **requestContext** | [**RequestContext**](RequestContext.md)| the request context |
 **asyncResponse** | [**AsyncResponse**](AsyncResponse.md)|  | [optional]

### Return type


CompletionStage<void>null (empty response body)

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

## deleteMessageWithHttpInfo

> CompletionStage<ApiResponse<Void>> deleteMessage deleteMessageWithHttpInfo(sid, apiAuthContext, requestContext, asyncResponse)

Deletes a message

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.ApiResponse;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        HelloMessageClient apiInstance = new HelloMessageClient(defaultClient);
        com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        ApiAuthContext apiAuthContext = ; // ApiAuthContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<ApiResponse<Void>> response = apiInstance.deleteMessageWithHttpInfo(sid, apiAuthContext, requestContext, asyncResponse);
            System.out.println("Status code: " + response.get().getStatusCode());
            System.out.println("Response headers: " + response.get().getHeaders());
        } catch (InterruptedException | ExecutionException e) {
            ApiException apiException = (ApiException)e.getCause();
            System.err.println("Exception when calling HelloMessageClient#deleteMessage");
            System.err.println("Status code: " + apiException.getCode());
            System.err.println("Response headers: " + apiException.getResponseHeaders());
            System.err.println("Reason: " + apiException.getResponseBody());
            e.printStackTrace();
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageClient#deleteMessage");
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
 **sid** | **com.twilio.sids.SmsSid**| A unique message SID identifier |
 **apiAuthContext** | [**ApiAuthContext**](ApiAuthContext.md)| the authentication context |
 **requestContext** | [**RequestContext**](RequestContext.md)| the request context |
 **asyncResponse** | [**AsyncResponse**](AsyncResponse.md)|  | [optional]

### Return type


CompletionStage<ApiResponse<Void>>

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

> CompletionStage<HelloMessageContainer> getMessage(sid, ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange, apiAuthContext, requestContext, asyncResponse)

Fetch a message

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        HelloMessageClient apiInstance = new HelloMessageClient(defaultClient);
        com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        String ifMatch = ; // String | Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value.
        String ifModifiedSince = ; // String | Makes the request method conditional on the selected representation's last modification date being earlier than or equal to the date provided in the field-value.
        String ifNoneMatch = ; // String | Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value.
        String ifUnmodifiedSince = ; // String | Makes the request method conditional on the selected representation's last modification date being later than the date provided in the field-value.
        String ifRange = ; // String | Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn't match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response.
        ApiAuthContext apiAuthContext = ; // ApiAuthContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<HelloMessageContainer> result = apiInstance.getMessage(sid, ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange, apiAuthContext, requestContext, asyncResponse);
            System.out.println(result.get());
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageClient#getMessage");
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
 **sid** | **com.twilio.sids.SmsSid**| A unique message SID identifier |
 **ifMatch** | **String**| Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value. |
 **ifModifiedSince** | **String**| Makes the request method conditional on the selected representation&#39;s last modification date being earlier than or equal to the date provided in the field-value. |
 **ifNoneMatch** | **String**| Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value. |
 **ifUnmodifiedSince** | **String**| Makes the request method conditional on the selected representation&#39;s last modification date being later than the date provided in the field-value. |
 **ifRange** | **String**| Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn&#39;t match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response. |
 **apiAuthContext** | [**ApiAuthContext**](ApiAuthContext.md)| the authentication context |
 **requestContext** | [**RequestContext**](RequestContext.md)| the request context |
 **asyncResponse** | [**AsyncResponse**](AsyncResponse.md)|  | [optional]

### Return type

CompletionStage<[**HelloMessageContainer**](HelloMessageContainer.md)foo >


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

## getMessageWithHttpInfo

> CompletionStage<ApiResponse<HelloMessageContainer>> getMessage getMessageWithHttpInfo(sid, ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange, apiAuthContext, requestContext, asyncResponse)

Fetch a message

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.ApiResponse;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        HelloMessageClient apiInstance = new HelloMessageClient(defaultClient);
        com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        String ifMatch = ; // String | Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value.
        String ifModifiedSince = ; // String | Makes the request method conditional on the selected representation's last modification date being earlier than or equal to the date provided in the field-value.
        String ifNoneMatch = ; // String | Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value.
        String ifUnmodifiedSince = ; // String | Makes the request method conditional on the selected representation's last modification date being later than the date provided in the field-value.
        String ifRange = ; // String | Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn't match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response.
        ApiAuthContext apiAuthContext = ; // ApiAuthContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<ApiResponse<HelloMessageContainer>> response = apiInstance.getMessageWithHttpInfo(sid, ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange, apiAuthContext, requestContext, asyncResponse);
            System.out.println("Status code: " + response.get().getStatusCode());
            System.out.println("Response headers: " + response.get().getHeaders());
            System.out.println("Response body: " + response.get().getData());
        } catch (InterruptedException | ExecutionException e) {
            ApiException apiException = (ApiException)e.getCause();
            System.err.println("Exception when calling HelloMessageClient#getMessage");
            System.err.println("Status code: " + apiException.getCode());
            System.err.println("Response headers: " + apiException.getResponseHeaders());
            System.err.println("Reason: " + apiException.getResponseBody());
            e.printStackTrace();
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageClient#getMessage");
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
 **sid** | **com.twilio.sids.SmsSid**| A unique message SID identifier |
 **ifMatch** | **String**| Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value. |
 **ifModifiedSince** | **String**| Makes the request method conditional on the selected representation&#39;s last modification date being earlier than or equal to the date provided in the field-value. |
 **ifNoneMatch** | **String**| Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value. |
 **ifUnmodifiedSince** | **String**| Makes the request method conditional on the selected representation&#39;s last modification date being later than the date provided in the field-value. |
 **ifRange** | **String**| Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn&#39;t match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response. |
 **apiAuthContext** | [**ApiAuthContext**](ApiAuthContext.md)| the authentication context |
 **requestContext** | [**RequestContext**](RequestContext.md)| the request context |
 **asyncResponse** | [**AsyncResponse**](AsyncResponse.md)|  | [optional]

### Return type

CompletionStage<ApiResponse<[**HelloMessageContainer**](HelloMessageContainer.md)>>


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

> CompletionStage<HelloMessageList> listMessages(from, to, pageSize, pageToken, apiAuthContext, requestContext, asyncResponse)

Retrieves messages

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        HelloMessageClient apiInstance = new HelloMessageClient(defaultClient);
        String from = "from_example"; // String | A sender name
        String to = "to_example"; // String | A recipient name
        Integer pageSize = 56; // Integer | Number of results to return at once
        String pageToken = "pageToken_example"; // String | Opaque token describing which page of results to return
        ApiAuthContext apiAuthContext = ; // ApiAuthContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<HelloMessageList> result = apiInstance.listMessages(from, to, pageSize, pageToken, apiAuthContext, requestContext, asyncResponse);
            System.out.println(result.get());
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageClient#listMessages");
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
 **from** | **String**| A sender name | [optional]
 **to** | **String**| A recipient name | [optional]
 **pageSize** | **Integer**| Number of results to return at once | [optional]
 **pageToken** | **String**| Opaque token describing which page of results to return | [optional]
 **apiAuthContext** | [**ApiAuthContext**](ApiAuthContext.md)| the authentication context |
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
| **200** | Returned message list |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |
| **429** | Rate Limit Exceeded |  * X-Rate-Limit-Config - The rate limit configuration used for this request. <br>  * X-Rate-Limit-Limit - The maximum number of requests that can be made in the current time window. <br>  * X-Rate-Limit-Remaining - The number of requests left for the time window. <br>  |

## listMessagesWithHttpInfo

> CompletionStage<ApiResponse<HelloMessageList>> listMessages listMessagesWithHttpInfo(from, to, pageSize, pageToken, apiAuthContext, requestContext, asyncResponse)

Retrieves messages

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.ApiResponse;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        HelloMessageClient apiInstance = new HelloMessageClient(defaultClient);
        String from = "from_example"; // String | A sender name
        String to = "to_example"; // String | A recipient name
        Integer pageSize = 56; // Integer | Number of results to return at once
        String pageToken = "pageToken_example"; // String | Opaque token describing which page of results to return
        ApiAuthContext apiAuthContext = ; // ApiAuthContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<ApiResponse<HelloMessageList>> response = apiInstance.listMessagesWithHttpInfo(from, to, pageSize, pageToken, apiAuthContext, requestContext, asyncResponse);
            System.out.println("Status code: " + response.get().getStatusCode());
            System.out.println("Response headers: " + response.get().getHeaders());
            System.out.println("Response body: " + response.get().getData());
        } catch (InterruptedException | ExecutionException e) {
            ApiException apiException = (ApiException)e.getCause();
            System.err.println("Exception when calling HelloMessageClient#listMessages");
            System.err.println("Status code: " + apiException.getCode());
            System.err.println("Response headers: " + apiException.getResponseHeaders());
            System.err.println("Reason: " + apiException.getResponseBody());
            e.printStackTrace();
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageClient#listMessages");
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
 **from** | **String**| A sender name | [optional]
 **to** | **String**| A recipient name | [optional]
 **pageSize** | **Integer**| Number of results to return at once | [optional]
 **pageToken** | **String**| Opaque token describing which page of results to return | [optional]
 **apiAuthContext** | [**ApiAuthContext**](ApiAuthContext.md)| the authentication context |
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
| **200** | Returned message list |  -  |
| **401** | Unauthorized |  -  |
| **403** | Forbidden |  -  |
| **500** | Internal server error |  -  |
| **429** | Rate Limit Exceeded |  * X-Rate-Limit-Config - The rate limit configuration used for this request. <br>  * X-Rate-Limit-Limit - The maximum number of requests that can be made in the current time window. <br>  * X-Rate-Limit-Remaining - The number of requests left for the time window. <br>  |



## updateMessage

> CompletionStage<HelloMessageContainer> updateMessage(sid, from, to, message, ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange, apiAuthContext, requestContext, asyncResponse)

Update a message

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        HelloMessageClient apiInstance = new HelloMessageClient(defaultClient);
        com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        String from = "from_example"; // String | Sender address
        String to = "to_example"; // String | Recipient address
        String message = "message_example"; // String | Message body
        String ifMatch = ; // String | Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value.
        String ifModifiedSince = ; // String | Makes the request method conditional on the selected representation's last modification date being earlier than or equal to the date provided in the field-value.
        String ifNoneMatch = ; // String | Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value.
        String ifUnmodifiedSince = ; // String | Makes the request method conditional on the selected representation's last modification date being later than the date provided in the field-value.
        String ifRange = ; // String | Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn't match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response.
        ApiAuthContext apiAuthContext = ; // ApiAuthContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<HelloMessageContainer> result = apiInstance.updateMessage(sid, from, to, message, ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange, apiAuthContext, requestContext, asyncResponse);
            System.out.println(result.get());
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageClient#updateMessage");
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
 **sid** | **com.twilio.sids.SmsSid**| A unique message SID identifier |
 **from** | **String**| Sender address | [optional]
 **to** | **String**| Recipient address | [optional]
 **message** | **String**| Message body | [optional]
 **ifMatch** | **String**| Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value. |
 **ifModifiedSince** | **String**| Makes the request method conditional on the selected representation&#39;s last modification date being earlier than or equal to the date provided in the field-value. |
 **ifNoneMatch** | **String**| Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value. |
 **ifUnmodifiedSince** | **String**| Makes the request method conditional on the selected representation&#39;s last modification date being later than the date provided in the field-value. |
 **ifRange** | **String**| Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn&#39;t match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response. |
 **apiAuthContext** | [**ApiAuthContext**](ApiAuthContext.md)| the authentication context |
 **requestContext** | [**RequestContext**](RequestContext.md)| the request context |
 **asyncResponse** | [**AsyncResponse**](AsyncResponse.md)|  | [optional]

### Return type

CompletionStage<[**HelloMessageContainer**](HelloMessageContainer.md)foo >


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

## updateMessageWithHttpInfo

> CompletionStage<ApiResponse<HelloMessageContainer>> updateMessage updateMessageWithHttpInfo(sid, from, to, message, ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange, apiAuthContext, requestContext, asyncResponse)

Update a message

### Example

```java
// Import classes:
import com.twilio.flexmaestro.client.ApiClient;
import com.twilio.flexmaestro.client.ApiException;
import com.twilio.flexmaestro.client.ApiResponse;
import com.twilio.flexmaestro.client.Configuration;
import com.twilio.flexmaestro.client.auth.*;
import com.twilio.flexmaestro.client.models.*;
import com.twilio.flexmaestro.client.api.hello.message.HelloMessageClient;
import java.util.concurrent.CompletionStage;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:9876/v1");
        
        HelloMessageClient apiInstance = new HelloMessageClient(defaultClient);
        com.twilio.sids.SmsSid sid = "sid_example"; // com.twilio.sids.SmsSid | A unique message SID identifier
        String from = "from_example"; // String | Sender address
        String to = "to_example"; // String | Recipient address
        String message = "message_example"; // String | Message body
        String ifMatch = ; // String | Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value.
        String ifModifiedSince = ; // String | Makes the request method conditional on the selected representation's last modification date being earlier than or equal to the date provided in the field-value.
        String ifNoneMatch = ; // String | Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value.
        String ifUnmodifiedSince = ; // String | Makes the request method conditional on the selected representation's last modification date being later than the date provided in the field-value.
        String ifRange = ; // String | Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn't match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response.
        ApiAuthContext apiAuthContext = ; // ApiAuthContext | the authentication context
        RequestContext requestContext = ; // RequestContext | the request context
        AsyncResponse asyncResponse = ; // AsyncResponse | 
        try {
            CompletionStage<ApiResponse<HelloMessageContainer>> response = apiInstance.updateMessageWithHttpInfo(sid, from, to, message, ifMatch, ifModifiedSince, ifNoneMatch, ifUnmodifiedSince, ifRange, apiAuthContext, requestContext, asyncResponse);
            System.out.println("Status code: " + response.get().getStatusCode());
            System.out.println("Response headers: " + response.get().getHeaders());
            System.out.println("Response body: " + response.get().getData());
        } catch (InterruptedException | ExecutionException e) {
            ApiException apiException = (ApiException)e.getCause();
            System.err.println("Exception when calling HelloMessageClient#updateMessage");
            System.err.println("Status code: " + apiException.getCode());
            System.err.println("Response headers: " + apiException.getResponseHeaders());
            System.err.println("Reason: " + apiException.getResponseBody());
            e.printStackTrace();
        } catch (ApiException e) {
            System.err.println("Exception when calling HelloMessageClient#updateMessage");
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
 **sid** | **com.twilio.sids.SmsSid**| A unique message SID identifier |
 **from** | **String**| Sender address | [optional]
 **to** | **String**| Recipient address | [optional]
 **message** | **String**| Message body | [optional]
 **ifMatch** | **String**| Makes the request method conditional on the recipient origin server either having at least one current representation of the target resource, when the field-value is *, or having a current representation of the target resource that has an entity-tag matching a member of the list of entity-tags provided in the field-value. |
 **ifModifiedSince** | **String**| Makes the request method conditional on the selected representation&#39;s last modification date being earlier than or equal to the date provided in the field-value. |
 **ifNoneMatch** | **String**| Makes the request method conditional on the selected representation not having an entity-tag matching any of the entity-tags provided in the field-value. |
 **ifUnmodifiedSince** | **String**| Makes the request method conditional on the selected representation&#39;s last modification date being later than the date provided in the field-value. |
 **ifRange** | **String**| Header field provides a special conditional request mechanism that is similar to the If-Match and If-Unmodified-Since header fields but that instructs the recipient to ignore the Range header field if the validator doesn&#39;t match, resulting in transfer of the new selected representation instead of a 412 (Precondition Failed) response. |
 **apiAuthContext** | [**ApiAuthContext**](ApiAuthContext.md)| the authentication context |
 **requestContext** | [**RequestContext**](RequestContext.md)| the request context |
 **asyncResponse** | [**AsyncResponse**](AsyncResponse.md)|  | [optional]

### Return type

CompletionStage<ApiResponse<[**HelloMessageContainer**](HelloMessageContainer.md)>>


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

