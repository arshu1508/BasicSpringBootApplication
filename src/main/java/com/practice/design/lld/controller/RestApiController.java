package com.practice.design.lld.controller;

import com.practice.design.lld.handlers.InputRequestResponseConvertor;
import com.practice.design.lld.model.InputRequest;
import com.practice.design.lld.model.OutputResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    private InputRequestResponseConvertor inputRequestResponseConvertor;

    @PostMapping("/testInputPost")
    public OutputResponse testInputPost(@RequestBody InputRequest inputRequest)
    {
        LOGGER.info("Input Name {} ", inputRequest.getName());
        LOGGER.info("Input value is {} ", inputRequest.getValue());
        return inputRequestResponseConvertor.convert(inputRequest);
    }

    @GetMapping("/testInputGet/{id}")
    public String testInputGet(@PathVariable("id") Integer id, @RequestParam("name") String name)
    {
        LOGGER.info("ID {} Name {} ", id, name);
        return id + " , " + name + "-> received";
    }
}