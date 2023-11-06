package com.example.reportingapi.util;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Optional;

/**
 * @Author Erdem Ozer
 * Date: 06/11/2023
 */
public class JsonWriter {
    public static void addToJsonIfNotNull(ObjectNode json, String key, Object value) {
        Optional.ofNullable(value).ifPresent(val -> json.put(key, val.toString()));
    }
}
