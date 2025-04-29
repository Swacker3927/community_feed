package org.fastcampus.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fastcampus.common.ui.*;

public class ResponseObjectMapper {
    private ResponseObjectMapper() {
        throw new IllegalStateException("Utility class");
    }

    private static final ObjectMapper objMapper = new ObjectMapper();

    public static Response toResponseObject(String response) {
        try {
            return objMapper.readValue(response, Response.class);
        } catch (Exception e) {
            return null;
        }
    }

    public static String toStringResponse(Response<?> response) {
        try {
            return objMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
