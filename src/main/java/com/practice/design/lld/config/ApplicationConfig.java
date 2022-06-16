package com.practice.design.lld.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.practice.design.lld")
@Getter
@Setter
public class ApplicationConfig {

    @Value("${com.practice.design.lld.envVariableString:Arshu}")
    private String envVariableString;

    @Value("#{new Integer('${com.practice.design.lld.envVariableInteger:123}')}")
    private Integer envVariableInteger;

    @Value("#{new Boolean('${com.practice.design.lld.envVariableBoolean:true}')}")
    private Boolean envVariableBoolean;

    private String envVariableStringSecond = "Second";
}
