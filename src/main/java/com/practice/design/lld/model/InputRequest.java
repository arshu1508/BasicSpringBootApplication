package com.practice.design.lld.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class InputRequest {
    @JsonProperty("name1")
    private String name;

    @JsonProperty("value")
    private JsonNode value;
}
