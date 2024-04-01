/*
 * FlexMaestro Service
 * This is a basic FlexMaestro service, showcasing many features of a standard Twilio Service
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: your-team-name@twilio.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.twilio.flexmaestro.client;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import com.twilio.sids.Sid;

import java.util.Map;
import java.io.IOException;

/**
 * ParamSerializer helps in converting types into their String representation.
 */

@jakarta.annotation.Generated(value = "com.twilio.codegen.TwilioGenerator", date = "2024-04-01T15:05:48.196693+05:30[Asia/Kolkata]")
public final class ParamSerializer {

    private final ObjectMapper mapper;

    /** Exception to be thrown if the specified type has no string representation. */
    @SuppressWarnings("serial")
    public static class UnshowableInstanceException extends RuntimeException {
        /**
         * Create a new UnshowableInstanceException.
         *
         * @param instance that couldn't be shown
         */
        public UnshowableInstanceException(final Object instance) {
            super("Instance of type " + instance.getClass().getName() + " can't be converted to a String");
        }

        /**
         * Create a new UnshowableInstanceException.
         *
         * @param instance that couldn't be shown
         * @param cause the cause of this exception
         */
        public UnshowableInstanceException(final Object instance, final Throwable cause) {
            super("Instance of type " + instance.getClass().getName() + " can't be converted to a String", cause);
        }
    }

    /**
     * An interface to convert values into strings.
     *
     * @param <T> the reference type to convert to a String
     */
    public interface StringConverter<T> {
        /**
         * Converts the specified <code>value</code> into a String.
         *
         * @param value the value to convert to a string
         * @return a String
         */
        String convert(T value);
    }

    /**
     * Get the singleton instance.
     *
     * @param mapper the {@link ObjectMapper} to use
     * @return the {@link ParamSerializer}
     */
    public static ParamSerializer getInstance(final ObjectMapper mapper) {
        return new ParamSerializer(mapper);
    }

    private ParamSerializer(final ObjectMapper mapper) {
        this.mapper = mapper;
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    /**
     * Register a new type with its corresponding {@link StringConverter}.
     *
     * @param <T> the type of <code>converter</code>
     * @param cls the {@link Class type}
     * @param converter the {@link StringConverter}
     */
    public <T> void register(
            final Class<? extends T> cls, final StringConverter<T> converter) {
        mapper.registerModule(createModule(cls, converter));
    }

    private <V> Module createModule(
            final Class<? extends V> type, final StringConverter<V> converter) {
        return new SimpleModule() {
            @Override
            public <T> SimpleModule addSerializer(
                    final Class<? extends T> type, final JsonSerializer<T> ser) {
                return super.addSerializer(
                        type,
                        new JsonSerializer<T>() {
                            @Override
                            public void serialize(
                                    final T t,
                                    final JsonGenerator jsonGenerator,
                                    final SerializerProvider serializerProvider)
                                    throws IOException {
                                jsonGenerator.writeString(converter.convert((V) t));
                            }
                        });
            }
        };
    }
   /**
     * Serializes the <code>value</code> to a String.
     *
     * @param value to {@link Object instance} to show
     * @return the value converted to a String
     */
    public String serialize(final Object value) {
        try {
            return mapper.writeValueAsString(value).replaceAll("^\"|\"$", "");
        } catch (final JsonProcessingException exception) {
            throw new UnshowableInstanceException(value, exception);
        }
    }

    /**
     * Deserializes the <code>value</code> to the suggested <code>type</code>..
     *
     * @param <T> the type of the class to deserialize
     * @param type {@link Class} deserialize
     * @param value to {@link String} to deserialize
     * @return the value converted to the instance
     */
    public <T> T deserialize(final String value, final Class<T> type) {
        if (value == null) {
            return null;
        }
        // corner case, Strings do not need to be converted, (so well) return the value
        if (type.equals(String.class)) {
            return (T) value;
        }

        try {
            return mapper.readValue(value, type);
        } catch (final IOException exception) {
            throw new UnshowableInstanceException(value, exception);
        }
    }

    /**
     * Deserializes the <code>value</code> to the suggested <code>type</code>..
     *
     * @param <T> the type of the class to deserialize
     * @param type {@link TypeReference} deserialized type
     * @param value to {@link String} to deserialize
     * @return the value converted to the instance
     */
    public <T> T deserialize(final String value, final TypeReference<T> type) {
        if (value == null) {
            return null;
        }
        return deserialize(value.getBytes(java.nio.charset.StandardCharsets.UTF_8), type);
    }

    /**
     * Deserializes the <code>value</code> to the suggested <code>type</code>..
     *
     * @param <T> the type of the class to deserialize
     * @param value byte array to deserialize
     * @param type {@link TypeReference} deserialized type
     * @return the value converted to the instance
     */
    public <T> T deserialize(final byte[] value, final TypeReference<T> type) {
        if (value == null) {
            return null;
        }

        try {
            return mapper.readValue(value, type);
        } catch (final IOException exception) {
            throw new UnshowableInstanceException(value, exception);
        }
    }

    /**
     * Deserializes the <code>value</code> to the suggested <code>type</code>..
     *
     * @param <T> the type of the class to deserialize
     * @param value {@link InputStream} to deserialize
     * @param type {@link TypeReference} deserialized type
     * @return the value converted to the instance
     */
    public <T> T deserialize(final InputStream value, final TypeReference<T> type) {
        if (value == null) {
            return null;
        }

        try {
            return mapper.readValue(value, type);
        } catch (final IOException exception) {
            throw new UnshowableInstanceException(value, exception);
        }
    }

    /**
     * Checks if this ParamConverter have the capability to convert the specified <code>cls</code>
     * into a String.
     *
     * @param cls the {@link Class type} to check
     * @return <code>true</code> if the specified type can be shown
     */
    public boolean canConvert(final Class<?> cls) {
        return mapper.canSerialize(cls);
    }
}
