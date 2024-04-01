package com.twilio.flexmaestro.client.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.net.URI;
import java.util.Arrays;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.isNull;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;


import java.io.Serializable;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;



/**
 * ListMeta.
 */

@jakarta.annotation.Generated(value = "com.twilio.codegen.TwilioGenerator", date = "2024-04-01T15:05:48.196693+05:30[Asia/Kolkata]")
@JsonPropertyOrder({ 
  ListMeta.JSON_PROPERTY_KEY, 
  ListMeta.JSON_PROPERTY_PAGE_SIZE, 
  ListMeta.JSON_PROPERTY_URL, 
  ListMeta.JSON_PROPERTY_PREVIOUS_PAGE_URL, 
  ListMeta.JSON_PROPERTY_NEXT_PAGE_URL
})
@Schema(name="ListMeta")
public class ListMeta  { 


  /**
   * A constant for the json attribute &quot;key&quot;.
   */
  public static final String JSON_PROPERTY_KEY = "key";

  @JsonProperty(value = JSON_PROPERTY_KEY, required = true)
  @NotNull
  private String key;

  /**
   * A constant for the json attribute &quot;page_size&quot;.
   */
  public static final String JSON_PROPERTY_PAGE_SIZE = "page_size";

  @JsonProperty(value = JSON_PROPERTY_PAGE_SIZE, required = true)
  @NotNull
  private Integer pageSize;

  /**
   * A constant for the json attribute &quot;url&quot;.
   */
  public static final String JSON_PROPERTY_URL = "url";

  @JsonProperty(value = JSON_PROPERTY_URL, required = true)
  @NotNull
  private URI url;

  /**
   * A constant for the json attribute &quot;previous_page_url&quot;.
   */
  public static final String JSON_PROPERTY_PREVIOUS_PAGE_URL = "previous_page_url";

  @JsonProperty(value = JSON_PROPERTY_PREVIOUS_PAGE_URL, required = false)
  private URI previousPageUrl;

  /**
   * A constant for the json attribute &quot;next_page_url&quot;.
   */
  public static final String JSON_PROPERTY_NEXT_PAGE_URL = "next_page_url";

  @JsonProperty(value = JSON_PROPERTY_NEXT_PAGE_URL, required = false)
  private URI nextPageUrl;
  /**
   * Default constructor for ListMeta.
   */
  public ListMeta() {
  
  }

  /**
   * Deserializing/Complete constructor of a ListMeta.
   * 
   * @param key assign key a {@link String} 
   * @param pageSize assign pageSize a {@link Integer} 
   * @param url assign url a {@link java.net.URI} 
   * @param previousPageUrl assign previousPageUrl a {@link java.net.URI} 
   * @param nextPageUrl assign nextPageUrl a {@link java.net.URI} 
   */
  @JsonCreator
  public ListMeta(final @JsonProperty(value = JSON_PROPERTY_KEY, required = true) String key,
        final @JsonProperty(value = JSON_PROPERTY_PAGE_SIZE, required = true) Integer pageSize,
        final @JsonProperty(value = JSON_PROPERTY_URL, required = true) URI url,
        final @JsonProperty(value = JSON_PROPERTY_PREVIOUS_PAGE_URL, required = false) URI previousPageUrl,
        final @JsonProperty(value = JSON_PROPERTY_NEXT_PAGE_URL, required = false) URI nextPageUrl) { 
    this.key = key;
    this.pageSize = pageSize;
    this.url = url;
    this.previousPageUrl = previousPageUrl;
    this.nextPageUrl = nextPageUrl;
  }
  
  /**
    * Set the key.
    * @param key assign key a {@link String}
    * @return {@link ListMeta self}
    */
   public ListMeta key(final String key) {
     this.key = key;
     return this;
  }

  /**
   * Set the key.
   * @param key assign key a {@link String}
   */
  @SchemaProperty(name = "key", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE))
  public void setKey(@NotNull final String key) { 
    this.key = key;
  }

    /**
   * Get the key.
   * @return {@link String }
   */
  @SchemaProperty(name = "key", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE))
  @NotNull 
  public String getKey() {
    return key;
  }
  
  /**
    * Set the pageSize.
    * @param pageSize assign pageSize a {@link Integer}
    * @return {@link ListMeta self}
    */
   public ListMeta pageSize(final Integer pageSize) {
     this.pageSize = pageSize;
     return this;
  }

  /**
   * Set the pageSize.
   * @param pageSize assign pageSize a {@link Integer}
   */
  @SchemaProperty(name = "pageSize", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE))
  public void setPageSize(@NotNull final Integer pageSize) { 
    this.pageSize = pageSize;
  }

    /**
   * Get the pageSize.
   * @return {@link Integer }
   */
  @SchemaProperty(name = "pageSize", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE))
  @NotNull 
  public Integer getPageSize() {
    return pageSize;
  }
  
  /**
    * Set the url.
    * @param url assign url a {@link java.net.URI}
    * @return {@link ListMeta self}
    */
   public ListMeta url(final URI url) {
     this.url = url;
     return this;
  }

  /**
   * Set the url.
   * @param url assign url a {@link java.net.URI}
   */
  @SchemaProperty(name = "url", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE))
  public void setUrl(@NotNull final URI url) { 
    this.url = url;
  }

    /**
   * Get the url.
   * @return {@link java.net.URI }
   */
  @SchemaProperty(name = "url", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE))
  @NotNull 
  public URI getUrl() {
    return url;
  }
  
  /**
    * Set the previousPageUrl.
    * @param previousPageUrl assign previousPageUrl a {@link java.net.URI}
    * @return {@link ListMeta self}
    */
   public ListMeta previousPageUrl(final URI previousPageUrl) {
     this.previousPageUrl = previousPageUrl;
     return this;
  }

  /**
   * Set the previousPageUrl.
   * @param previousPageUrl assign previousPageUrl a {@link java.net.URI}
   */
  @SchemaProperty(name = "previousPageUrl", schema = @Schema(requiredMode = RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_WRITE))
  public void setPreviousPageUrl(final URI previousPageUrl) { 
    this.previousPageUrl = previousPageUrl;
  }

    /**
   * Get the previousPageUrl.
   * @return {@link java.net.URI }
   */
  @SchemaProperty(name = "previousPageUrl", schema = @Schema(requiredMode = RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_WRITE))
  
  public URI getPreviousPageUrl() {
    return previousPageUrl;
  }
  
  /**
    * Set the nextPageUrl.
    * @param nextPageUrl assign nextPageUrl a {@link java.net.URI}
    * @return {@link ListMeta self}
    */
   public ListMeta nextPageUrl(final URI nextPageUrl) {
     this.nextPageUrl = nextPageUrl;
     return this;
  }

  /**
   * Set the nextPageUrl.
   * @param nextPageUrl assign nextPageUrl a {@link java.net.URI}
   */
  @SchemaProperty(name = "nextPageUrl", schema = @Schema(requiredMode = RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_WRITE))
  public void setNextPageUrl(final URI nextPageUrl) { 
    this.nextPageUrl = nextPageUrl;
  }

    /**
   * Get the nextPageUrl.
   * @return {@link java.net.URI }
   */
  @SchemaProperty(name = "nextPageUrl", schema = @Schema(requiredMode = RequiredMode.NOT_REQUIRED, accessMode = AccessMode.READ_WRITE))
  
  public URI getNextPageUrl() {
    return nextPageUrl;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (isNull(o) || getClass() != o.getClass()) {
            return false;
        }
    ListMeta listMeta = (ListMeta) o;
        return Objects.equals(this.key, listMeta.key)
            && Objects.equals(this.pageSize, listMeta.pageSize)
            && Objects.equals(this.url, listMeta.url)
            && Objects.equals(this.previousPageUrl, listMeta.previousPageUrl)
            && Objects.equals(this.nextPageUrl, listMeta.nextPageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key,pageSize,url,previousPageUrl,nextPageUrl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ListMeta {\n");
        
        sb.append("    key: ").append(key).append("\n");
        sb.append("    pageSize: ").append(pageSize).append("\n");
        sb.append("    url: ").append(url).append("\n");
        sb.append("    previousPageUrl: ").append(previousPageUrl).append("\n");
        sb.append("    nextPageUrl: ").append(nextPageUrl).append("\n");
        sb.append("}");
        return sb.toString();
    }
  /**
   * A builder for ListMeta.
   */
  public static class ListMetaBuilder { 
    private String key;
    private Integer pageSize;
    private URI url;
    private URI previousPageUrl;
    private URI nextPageUrl;

    /**
    
     * Set &quot;key&quot;.
     *
     * @param key assign key a {@link String}
     * @return {@link ListMetaBuilder builder}
     */
    public ListMetaBuilder key(final String key) {
      this.key = key;
      return this;
    }

    /**
    
     * Set &quot;pageSize&quot;.
     *
     * @param pageSize assign pageSize a {@link Integer}
     * @return {@link ListMetaBuilder builder}
     */
    public ListMetaBuilder pageSize(final Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    /**
    
     * Set &quot;url&quot;.
     *
     * @param url assign url a {@link java.net.URI}
     * @return {@link ListMetaBuilder builder}
     */
    public ListMetaBuilder url(final URI url) {
      this.url = url;
      return this;
    }

    /**
    
     * Set &quot;previousPageUrl&quot;.
     *
     * @param previousPageUrl assign previousPageUrl a {@link java.net.URI}
     * @return {@link ListMetaBuilder builder}
     */
    public ListMetaBuilder previousPageUrl(final URI previousPageUrl) {
      this.previousPageUrl = previousPageUrl;
      return this;
    }

    /**
    
     * Set &quot;nextPageUrl&quot;.
     *
     * @param nextPageUrl assign nextPageUrl a {@link java.net.URI}
     * @return {@link ListMetaBuilder builder}
     */
    public ListMetaBuilder nextPageUrl(final URI nextPageUrl) {
      this.nextPageUrl = nextPageUrl;
      return this;
    }
    /**
     * Builder constructor.
     */
    public ListMetaBuilder() {}

    /**
     * Builds a ListMeta.
     *
     * @return the created {@link ListMeta }
     */
    public ListMeta build() {
      return new ListMeta(this.key,
        this.pageSize,
        this.url,
        this.previousPageUrl,
        this.nextPageUrl);}
  }
}