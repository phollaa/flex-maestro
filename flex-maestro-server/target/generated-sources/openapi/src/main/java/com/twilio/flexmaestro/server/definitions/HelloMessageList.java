package com.twilio.flexmaestro.server.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.twilio.flexmaestro.server.definitions.HelloMessageContainer;
import com.twilio.flexmaestro.server.definitions.ListMeta;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * HelloMessageList.
 */

@jakarta.annotation.Generated(value = "com.twilio.codegen.TwilioGenerator", date = "2024-04-01T17:46:14.982174+05:30[Asia/Kolkata]")
@JsonPropertyOrder({ 
  HelloMessageList.JSON_PROPERTY_HELLO_MESSAGES, 
  HelloMessageList.JSON_PROPERTY_META
})
@Schema(name="HelloMessageList")
public class HelloMessageList  { 


  /**
   * A constant for the json attribute &quot;hello_messages&quot;.
   */
  public static final String JSON_PROPERTY_HELLO_MESSAGES = "hello_messages";

  @JsonProperty(value = JSON_PROPERTY_HELLO_MESSAGES, required = true)
  @NotNull
  @Valid
  private List<HelloMessageContainer> helloMessages = new ArrayList<HelloMessageContainer>();
    

  /**
   * A constant for the json attribute &quot;meta&quot;.
   */
  public static final String JSON_PROPERTY_META = "meta";

  @JsonProperty(value = JSON_PROPERTY_META, required = true)
  @NotNull
  private ListMeta meta;
  /**
   * Default constructor for HelloMessageList.
   */
  public HelloMessageList() {
  
  }

  /**
   * Deserializing/Complete constructor of a HelloMessageList.
   * 
   * @param helloMessages A list of messages {@link List} of type {@link HelloMessageContainer},
  *      defaults to new ArrayList&lt;HelloMessageContainer&gt;() 
   * @param meta assign meta a {@link ListMeta} 
   */
  @JsonCreator
  public HelloMessageList(final @JsonProperty(value = JSON_PROPERTY_HELLO_MESSAGES, required = true) List<HelloMessageContainer> helloMessages,
        final @JsonProperty(value = JSON_PROPERTY_META, required = true) ListMeta meta) { 
    this.helloMessages = isNull(helloMessages) ? new ArrayList<HelloMessageContainer>() : new ArrayList<>(helloMessages);
    this.meta = meta;
  }
  
  /**
   * A list of messages.
   *
    * @param helloMessages A list of messages {@link List} of type {@link HelloMessageContainer},
  *      defaults to new ArrayList&lt;HelloMessageContainer&gt;()
    * @return {@link HelloMessageList self}
    */
   public HelloMessageList helloMessages(final List<HelloMessageContainer> helloMessages) {
     this.helloMessages = isNull(helloMessages) ? new ArrayList<HelloMessageContainer>() : new ArrayList<>(helloMessages);
     return this;
  }
  /**
   * Append helloMessagesitem to helloMessages. A list of messages. 
   *
   * @param helloMessagesItem A list of messages, {@link List} of type {@link HelloMessageContainer }, 
   *       default to new ArrayList&lt;HelloMessageContainer&gt;()
   *
   * @return {@link HelloMessageList self}
   */
   public HelloMessageList addHelloMessagesItem(final HelloMessageContainer helloMessagesItem) {   
  this.helloMessages.add(helloMessagesItem);
     return this;
   }

  /**
   * A list of messages.
   *
   * @param helloMessages A list of messages {@link List} of type {@link HelloMessageContainer},
  *      defaults to new ArrayList&lt;HelloMessageContainer&gt;()
   */
  @SchemaProperty(name = "helloMessages", array = @ArraySchema(uniqueItems = false,
    items = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "A list of messages")))
  public void setHelloMessages(@NotNull @Valid final List<HelloMessageContainer> helloMessages) { 
    this.helloMessages = isNull(helloMessages) ? new ArrayList<HelloMessageContainer>() : new ArrayList<>(helloMessages);
  }

    /**
   * A list of messages.
   *
   * @return  {@link List } of {@link HelloMessageContainer }
   */
  @SchemaProperty(name = "helloMessages", array = @ArraySchema(uniqueItems = false,
    items = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "A list of messages")))
  @NotNull 
  @Valid 
  public List<HelloMessageContainer> getHelloMessages() {
    return helloMessages;
  }
  
  /**
    * Set the meta.
    * @param meta assign meta a {@link ListMeta}
    * @return {@link HelloMessageList self}
    */
   public HelloMessageList meta(final ListMeta meta) {
     this.meta = meta;
     return this;
  }

  /**
   * Set the meta.
   * @param meta assign meta a {@link ListMeta}
   */
  @SchemaProperty(name = "meta", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE))
  public void setMeta(@NotNull @Valid final ListMeta meta) { 
    this.meta = meta;
  }

    /**
   * Get the meta.
   * @return {@link ListMeta }
   */
  @SchemaProperty(name = "meta", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE))
  @NotNull 
  @Valid 
  public ListMeta getMeta() {
    return meta;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (isNull(o) || getClass() != o.getClass()) {
            return false;
        }
    HelloMessageList helloMessageList = (HelloMessageList) o;
        return Objects.equals(this.helloMessages, helloMessageList.helloMessages)
            && Objects.equals(this.meta, helloMessageList.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(helloMessages,meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HelloMessageList {\n");
        
        sb.append("    helloMessages: ").append(helloMessages).append("\n");
        sb.append("    meta: ").append(meta).append("\n");
        sb.append("}");
        return sb.toString();
    }
  /**
   * A builder for HelloMessageList.
   */
  public static class HelloMessageListBuilder { 
    private List<HelloMessageContainer> helloMessages = new ArrayList<HelloMessageContainer>();
    private ListMeta meta;

    /**
    
     * A list of messages.
     *
     * @param helloMessages A list of messages {@link List} of type {@link HelloMessageContainer},
  *      defaults to new ArrayList&lt;HelloMessageContainer&gt;()
     * @return {@link HelloMessageListBuilder builder}
     */
    public HelloMessageListBuilder helloMessages(final List<HelloMessageContainer> helloMessages) {
      this.helloMessages = helloMessages;
      return this;
    }

    /**
    
     * Set &quot;meta&quot;.
     *
     * @param meta assign meta a {@link ListMeta}
     * @return {@link HelloMessageListBuilder builder}
     */
    public HelloMessageListBuilder meta(final ListMeta meta) {
      this.meta = meta;
      return this;
    }
    /**
     * Builder constructor.
     */
    public HelloMessageListBuilder() {}

    /**
     * Builds a HelloMessageList.
     *
     * @return the created {@link HelloMessageList }
     */
    public HelloMessageList build() {
      return new HelloMessageList(this.helloMessages,
        this.meta);}
  }
}