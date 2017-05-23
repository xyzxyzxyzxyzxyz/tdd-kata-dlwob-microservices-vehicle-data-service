package com.tdd.katas.dlwob.microservices.vehicledataservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

abstract class AbstractMockServiceImpl<DATA> {

    public AbstractMockServiceImpl(Class<DATA> dataClass) {
        readJsonFile(dataClass);
    }

    public AbstractMockServiceImpl(TypeReference<DATA> typeReference) {
        readJsonFile(typeReference);
    }

    protected DATA dataObject;

    protected void readJsonFile(Object dataClass) {
        ObjectMapper objectMapper = new ObjectMapper();

        String resourceName = getClass().getSimpleName() + ".json";

        InputStream resourceInputStream = null;
        try {
            resourceInputStream = getClass().getResourceAsStream(resourceName);

            if (dataClass instanceof Class) {
                dataObject = (DATA) objectMapper.readValue(resourceInputStream, (Class) dataClass);
            }
            else if (dataClass instanceof TypeReference) {
                dataObject = objectMapper.readValue(resourceInputStream, (TypeReference) dataClass);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Unexpected error reading from JSON file", e);
        } finally {
            if (resourceInputStream!=null) {
                try {
                    resourceInputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
