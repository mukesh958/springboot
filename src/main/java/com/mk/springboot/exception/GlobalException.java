package com.mk.springboot.exception;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class GlobalException {
    @JsonProperty("status")
    public HashMap<String, Object> status;

    @JsonProperty("data")
    public HashMap<String, Object> data;
}

