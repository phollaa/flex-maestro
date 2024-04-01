package com.twilio.flexmaestro.server.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.twilio.flexmaestro.server.definitions.HelloMessage;
import com.twilio.sids.AccountSid;
import com.twilio.sids.SmsSid;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
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
 * HelloMessageContainer.
 */

@jakarta.annotation.Generated(value = "com.twilio.codegen.TwilioGenerator", date = "2024-04-01T17:46:14.982174+05:30[Asia/Kolkata]")
@JsonPropertyOrder({ 
  HelloMessageContainer.JSON_PROPERTY_SID, 
  HelloMessageContainer.JSON_PROPERTY_ACCOUNT_SID, 
  HelloMessageContainer.JSON_PROPERTY_HELLO_MESSAGE, 
  HelloMessageContainer.JSON_PROPERTY_DATE_CREATED, 
  HelloMessageContainer.JSON_PROPERTY_DATE_UPDATED
})
@Schema(name="HelloMessageContainer")
public class HelloMessageContainer  { 


  /**
   * A constant for the json attribute &quot;sid&quot;.
   */
  public static final String JSON_PROPERTY_SID = "sid";

  @JsonProperty(value = JSON_PROPERTY_SID, required = true)
  @NotNull
  private SmsSid sid;

  /**
   * A constant for the json attribute &quot;account_sid&quot;.
   */
  public static final String JSON_PROPERTY_ACCOUNT_SID = "account_sid";

  @JsonProperty(value = JSON_PROPERTY_ACCOUNT_SID, required = true)
  @NotNull
  private AccountSid accountSid;

  /**
   * A constant for the json attribute &quot;hello_message&quot;.
   */
  public static final String JSON_PROPERTY_HELLO_MESSAGE = "hello_message";

  @JsonProperty(value = JSON_PROPERTY_HELLO_MESSAGE, required = true)
  @NotNull
  private HelloMessage helloMessage;

  /**
   * A constant for the json attribute &quot;date_created&quot;.
   */
  public static final String JSON_PROPERTY_DATE_CREATED = "date_created";

  @JsonProperty(value = JSON_PROPERTY_DATE_CREATED, required = true)
  @NotNull
  private OffsetDateTime dateCreated;

  /**
   * A constant for the json attribute &quot;date_updated&quot;.
   */
  public static final String JSON_PROPERTY_DATE_UPDATED = "date_updated";

  @JsonProperty(value = JSON_PROPERTY_DATE_UPDATED, required = true)
  @NotNull
  private OffsetDateTime dateUpdated;
  /**
   * Default constructor for HelloMessageContainer.
   */
  public HelloMessageContainer() {
  
  }

  /**
   * Deserializing/Complete constructor of a HelloMessageContainer.
   * 
   * @param sid The string ID reference for the message  a {@link com.twilio.sids.SmsSid} 
   * @param accountSid The account owning the message  a {@link com.twilio.sids.AccountSid} 
   * @param helloMessage assign helloMessage a {@link HelloMessage} 
   * @param dateCreated Timestamp of when the message was created  a {@link OffsetDateTime} 
   * @param dateUpdated Timestamp of when the message was last updated  a {@link OffsetDateTime} 
   */
  @JsonCreator
  public HelloMessageContainer(final @JsonProperty(value = JSON_PROPERTY_SID, required = true) SmsSid sid,
        final @JsonProperty(value = JSON_PROPERTY_ACCOUNT_SID, required = true) AccountSid accountSid,
        final @JsonProperty(value = JSON_PROPERTY_HELLO_MESSAGE, required = true) HelloMessage helloMessage,
        final @JsonProperty(value = JSON_PROPERTY_DATE_CREATED, required = true) OffsetDateTime dateCreated,
        final @JsonProperty(value = JSON_PROPERTY_DATE_UPDATED, required = true) OffsetDateTime dateUpdated) { 
    this.sid = sid;
    this.accountSid = accountSid;
    this.helloMessage = helloMessage;
    this.dateCreated = dateCreated;
    this.dateUpdated = dateUpdated;
  }
  
  /**
   * The string ID reference for the message.
   *
    * @param sid The string ID reference for the message  a {@link com.twilio.sids.SmsSid}
    * @return {@link HelloMessageContainer self}
    */
   public HelloMessageContainer sid(final SmsSid sid) {
     this.sid = sid;
     return this;
  }

  /**
   * The string ID reference for the message.
   *
   * @param sid The string ID reference for the message  a {@link com.twilio.sids.SmsSid}
   */
  @SchemaProperty(name = "sid", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "The string ID reference for the message"))
  public void setSid(@NotNull final SmsSid sid) { 
    this.sid = sid;
  }

    /**
   * The string ID reference for the message.
   *
   * @return {@link com.twilio.sids.SmsSid }
   */
  @SchemaProperty(name = "sid", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "The string ID reference for the message"))
  @NotNull 
  public SmsSid getSid() {
    return sid;
  }
  
  /**
   * The account owning the message.
   *
    * @param accountSid The account owning the message  a {@link com.twilio.sids.AccountSid}
    * @return {@link HelloMessageContainer self}
    */
   public HelloMessageContainer accountSid(final AccountSid accountSid) {
     this.accountSid = accountSid;
     return this;
  }

  /**
   * The account owning the message.
   *
   * @param accountSid The account owning the message  a {@link com.twilio.sids.AccountSid}
   */
  @SchemaProperty(name = "accountSid", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "The account owning the message"))
  public void setAccountSid(@NotNull final AccountSid accountSid) { 
    this.accountSid = accountSid;
  }

    /**
   * The account owning the message.
   *
   * @return {@link com.twilio.sids.AccountSid }
   */
  @SchemaProperty(name = "accountSid", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "The account owning the message"))
  @NotNull 
  public AccountSid getAccountSid() {
    return accountSid;
  }
  
  /**
    * Set the helloMessage.
    * @param helloMessage assign helloMessage a {@link HelloMessage}
    * @return {@link HelloMessageContainer self}
    */
   public HelloMessageContainer helloMessage(final HelloMessage helloMessage) {
     this.helloMessage = helloMessage;
     return this;
  }

  /**
   * Set the helloMessage.
   * @param helloMessage assign helloMessage a {@link HelloMessage}
   */
  @SchemaProperty(name = "helloMessage", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE))
  public void setHelloMessage(@NotNull @Valid final HelloMessage helloMessage) { 
    this.helloMessage = helloMessage;
  }

    /**
   * Get the helloMessage.
   * @return {@link HelloMessage }
   */
  @SchemaProperty(name = "helloMessage", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE))
  @NotNull 
  @Valid 
  public HelloMessage getHelloMessage() {
    return helloMessage;
  }
  
  /**
   * Timestamp of when the message was created.
   *
    * @param dateCreated Timestamp of when the message was created  a {@link OffsetDateTime}
    * @return {@link HelloMessageContainer self}
    */
   public HelloMessageContainer dateCreated(final OffsetDateTime dateCreated) {
     this.dateCreated = dateCreated;
     return this;
  }

  /**
   * Timestamp of when the message was created.
   *
   * @param dateCreated Timestamp of when the message was created  a {@link OffsetDateTime}
   */
  @SchemaProperty(name = "dateCreated", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "Timestamp of when the message was created"))
  public void setDateCreated(@NotNull @Valid final OffsetDateTime dateCreated) { 
    this.dateCreated = dateCreated;
  }

    /**
   * Timestamp of when the message was created.
   *
   * @return {@link OffsetDateTime }
   */
  @SchemaProperty(name = "dateCreated", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "Timestamp of when the message was created"))
  @NotNull 
  @Valid 
  public OffsetDateTime getDateCreated() {
    return dateCreated;
  }
  
  /**
   * Timestamp of when the message was last updated.
   *
    * @param dateUpdated Timestamp of when the message was last updated  a {@link OffsetDateTime}
    * @return {@link HelloMessageContainer self}
    */
   public HelloMessageContainer dateUpdated(final OffsetDateTime dateUpdated) {
     this.dateUpdated = dateUpdated;
     return this;
  }

  /**
   * Timestamp of when the message was last updated.
   *
   * @param dateUpdated Timestamp of when the message was last updated  a {@link OffsetDateTime}
   */
  @SchemaProperty(name = "dateUpdated", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "Timestamp of when the message was last updated"))
  public void setDateUpdated(@NotNull @Valid final OffsetDateTime dateUpdated) { 
    this.dateUpdated = dateUpdated;
  }

    /**
   * Timestamp of when the message was last updated.
   *
   * @return {@link OffsetDateTime }
   */
  @SchemaProperty(name = "dateUpdated", schema = @Schema(requiredMode = RequiredMode.REQUIRED, accessMode = AccessMode.READ_WRITE, description = "Timestamp of when the message was last updated"))
  @NotNull 
  @Valid 
  public OffsetDateTime getDateUpdated() {
    return dateUpdated;
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (isNull(o) || getClass() != o.getClass()) {
            return false;
        }
    HelloMessageContainer helloMessageContainer = (HelloMessageContainer) o;
        return Objects.equals(this.sid, helloMessageContainer.sid)
            && Objects.equals(this.accountSid, helloMessageContainer.accountSid)
            && Objects.equals(this.helloMessage, helloMessageContainer.helloMessage)
            && Objects.equals(this.dateCreated, helloMessageContainer.dateCreated)
            && Objects.equals(this.dateUpdated, helloMessageContainer.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,accountSid,helloMessage,dateCreated,dateUpdated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HelloMessageContainer {\n");
        
        sb.append("    sid: ").append(sid).append("\n");
        sb.append("    accountSid: ").append(accountSid).append("\n");
        sb.append("    helloMessage: ").append(helloMessage).append("\n");
        sb.append("    dateCreated: ").append(dateCreated).append("\n");
        sb.append("    dateUpdated: ").append(dateUpdated).append("\n");
        sb.append("}");
        return sb.toString();
    }
  /**
   * A builder for HelloMessageContainer.
   */
  public static class HelloMessageContainerBuilder { 
    private SmsSid sid;
    private AccountSid accountSid;
    private HelloMessage helloMessage;
    private OffsetDateTime dateCreated;
    private OffsetDateTime dateUpdated;

    /**
    
     * The string ID reference for the message.
     *
     * @param sid The string ID reference for the message  a {@link com.twilio.sids.SmsSid}
     * @return {@link HelloMessageContainerBuilder builder}
     */
    public HelloMessageContainerBuilder sid(final SmsSid sid) {
      this.sid = sid;
      return this;
    }

    /**
    
     * The account owning the message.
     *
     * @param accountSid The account owning the message  a {@link com.twilio.sids.AccountSid}
     * @return {@link HelloMessageContainerBuilder builder}
     */
    public HelloMessageContainerBuilder accountSid(final AccountSid accountSid) {
      this.accountSid = accountSid;
      return this;
    }

    /**
    
     * Set &quot;helloMessage&quot;.
     *
     * @param helloMessage assign helloMessage a {@link HelloMessage}
     * @return {@link HelloMessageContainerBuilder builder}
     */
    public HelloMessageContainerBuilder helloMessage(final HelloMessage helloMessage) {
      this.helloMessage = helloMessage;
      return this;
    }

    /**
    
     * Timestamp of when the message was created.
     *
     * @param dateCreated Timestamp of when the message was created  a {@link OffsetDateTime}
     * @return {@link HelloMessageContainerBuilder builder}
     */
    public HelloMessageContainerBuilder dateCreated(final OffsetDateTime dateCreated) {
      this.dateCreated = dateCreated;
      return this;
    }

    /**
    
     * Timestamp of when the message was last updated.
     *
     * @param dateUpdated Timestamp of when the message was last updated  a {@link OffsetDateTime}
     * @return {@link HelloMessageContainerBuilder builder}
     */
    public HelloMessageContainerBuilder dateUpdated(final OffsetDateTime dateUpdated) {
      this.dateUpdated = dateUpdated;
      return this;
    }
    /**
     * Builder constructor.
     */
    public HelloMessageContainerBuilder() {}

    /**
     * Builds a HelloMessageContainer.
     *
     * @return the created {@link HelloMessageContainer }
     */
    public HelloMessageContainer build() {
      return new HelloMessageContainer(this.sid,
        this.accountSid,
        this.helloMessage,
        this.dateCreated,
        this.dateUpdated);}
  }
}