package com.practice.design.lld.handlers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.design.lld.config.ApplicationConfig;
import com.practice.design.lld.model.InputRequest;
import com.practice.design.lld.model.OutputResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InputRequestResponseConvertor {
    private static final Logger LOGGER = LoggerFactory.getLogger(InputRequestResponseConvertor.class);
    private static ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature
            .FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Autowired
    private ApplicationConfig applicationConfig;

    public OutputResponse convert(InputRequest input) {
        printApplicationConfig();
        LOGGER.info("Input is {}", input);
        OutputResponse response = objectMapper.convertValue(input, OutputResponse.class);
        LOGGER.info("Output is {}", response);
        return response;
    }

    private void printApplicationConfig() {
        LOGGER.info("env variable string is {}", applicationConfig.getEnvVariableString());
        LOGGER.info("env variable string second is {}",applicationConfig.getEnvVariableStringSecond());
        LOGGER.info("env variable boolean is {}", applicationConfig.getEnvVariableBoolean());
        LOGGER.info("env variable integer is {}",applicationConfig.getEnvVariableInteger());
    }
}
