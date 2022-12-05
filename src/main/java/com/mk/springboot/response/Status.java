package com.mk.springboot.response;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private String httpCode;
    private Boolean success;
    private List<HashMap<String, String>> messages;

    public Status(HttpStatus httpStatus) {
        this.httpCode = httpStatus.name();
        this.success = !httpStatus.isError();
    }
}