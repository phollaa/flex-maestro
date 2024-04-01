package com.twilio.flexmaestro.server.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
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
 * HelloMessage.
 */

@jakarta.annotation.Generated(value = "com.twilio.codegen.TwilioGenerator", date = "2024-04-01T17:46:14.982174+05:30[Asia/Kolkata]")
@JsonPropertyOrder({ 
  HelloMessage.JSON_PROPERTY_FROM, 
  HelloMessage.JSON_PROPERTY_TO, 
  HelloMessage.JSON_PROPERTY_MESSAGE
})
@Schema(name="HelloMessage")
public class HelloMessage  { 


  /**
   * A constant for the json attribute &quot;from&quot;.
   */
  public static final String JSON_PROPERTY_FROM = "from";

  @JsonProperty(value = JSON_PROPERTY_FROM, required = true)
  @NotNull
  private String from;

  /**
   * A constant for the json attribute &quot;to&quot;.
   */
  public static final String JSON_PROPERTY_TO = "to";

  @JsonProperty(value = JSON_PROPERTY_TO, required = true)
  @NotNull
  private String to;

  /**
   * A constant for the json attribute &quot;message&quot;.
   */
  public static final String JSON_PROPERTY_MESSAGE = "message";

  @JsonProperty(value = JSON_PROPERTY_MESSAGE, required = true)
  @NotNull
  private String message;
  /**
   * Default constructor for HelloMessage.
   */
  public HelloMessage() {
  
  }

  /**
   * Deserializing/Complete constructor of a HelloMessage.
   * 
   * @param from The name of the sender of the message  a {@link String} 
   * @param to The name of the recipient of the message  a {@link String} 
   * @param message The actual message  a {@link String} 
   */
  @JsonCreator
  public HelloMessage(final @JsonProperty(value = JSON_PROPERTY_FROM, required = true) String from,
        final @JsonProperty(value = JSON_PROPERTY_TO, required = true) String to,
        final @JsonProperty(value = JSON_PROPERTY_MESSAGE, required = true) String message) { 
    this.from = from;
    this.to = to;
    this.message = message;
  }
  
  /**
   * The name of the sender of the message.
   *
    * @param from The name of the sender of the message  a {@link String}
    * @return {@link HelloMessage self}
    */
   public HelloMessage from(final String from) {
     this.from = from;
     return this;
  }

  /**
   * The name of the sender of the message.
   *
   * @param from The name of the sender of the message  a {@link String}
   */
  @SchemaProperty(name = "from", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "The name of the sender of the message"))
  public void setFrom(@NotNull final String from) { 
    this.from = from;
  }

    /**
   * The name of the sender of the message.
   *
   * @return {@link String }
   */
  @SchemaProperty(name = "from", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "The name of the sender of the message"))
  @NotNull 
  public String getFrom() {
    return from;
  }
  
  /**
   * The name of the recipient of the message.
   *
    * @param to The name of the recipient of the message  a {@link String}
    * @return {@link HelloMessage self}
    */
   public HelloMessage to(final String to) {
     this.to = to;
     return this;
  }

  /**
   * The name of the recipient of the message.
   *
   * @param to The name of the recipient of the message  a {@link String}
   */
  @SchemaProperty(name = "to", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "The name of the recipient of the message"))
  public void setTo(@NotNull final String to) { 
    this.to = to;
  }

    /**
   * The name of the recipient of the message.
   *
   * @return {@link String }
   */
  @SchemaProperty(name = "to", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "The name of the recipient of the message"))
  @NotNull 
  public String getTo() {
    return to;
  }
  
  /**
   * The actual message.
   *
    * @param message The actual message  a {@link String}
    * @return {@link HelloMessage self}
    */
   public HelloMessage message(final String message) {
     this.message = message;
     return this;
  }

  /**
   * The actual message.
   *
   * @param message The actual message  a {@link String}
   */
  @SchemaProperty(name = "message", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "The actual message"))
  public void setMessage(@NotNull final String message) { 
    this.message = message;
  }

    /**
   * The actual message.
   *
   * @return {@link String }
   */
  @SchemaProperty(name = "message", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "The actual message"))
  @NotNull 
  public String getMessage() {
    return message;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (isNull(o) || getClass() != o.getClass()) {
            return false;
        }
    HelloMessage helloMessage = (HelloMessage) o;
        return Objects.equals(this.from, helloMessage.from)
            && Objects.equals(this.to, helloMessage.to)
            && Objects.equals(this.message, helloMessage.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from,to,message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HelloMessage {\n");
        
        sb.append("    from: ").append(from).append("\n");
        sb.append("    to: ").append(to).append("\n");
        sb.append("    message: ").append(message).append("\n");
        sb.append("}");
        return sb.toString();
    }
  /**
   * A builder for HelloMessage.
   */
  public static class HelloMessageBuilder { 
    private String from;
    private String to;
    private String message;

    /**
    
     * The name of the sender of the message.
     *
     * @param from The name of the sender of the message  a {@link String}
     * @return {@link HelloMessageBuilder builder}
     */
    public HelloMessageBuilder from(final String from) {
      this.from = from;
      return this;
    }

    /**
    
     * The name of the recipient of the message.
     *
     * @param to The name of the recipient of the message  a {@link String}
     * @return {@link HelloMessageBuilder builder}
     */
    public HelloMessageBuilder to(final String to) {
      this.to = to;
      return this;
    }

    /**
    
     * The actual message.
     *
     * @param message The actual message  a {@link String}
     * @return {@link HelloMessageBuilder builder}
     */
    public HelloMessageBuilder message(final String message) {
      this.message = message;
      return this;
    }
    /**
     * Builder constructor.
     */
    public HelloMessageBuilder() {}

    /**
     * Builds a HelloMessage.
     *
     * @return the created {@link HelloMessage }
     */
    public HelloMessage build() {
      return new HelloMessage(this.from,
        this.to,
        this.message);}
  }
}