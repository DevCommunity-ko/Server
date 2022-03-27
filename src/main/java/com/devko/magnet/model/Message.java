package com.devko.magnet.model;

import com.devko.magnet.exception.StatusCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class Message {
    private final StatusCode statusCode;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Object result;

    public Message(StatusCode statusCode, String message, Object result) {
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
    }

    public Message(StatusCode statusCode, Object result) {
        this.statusCode = statusCode;
        this.message = statusCode.getMessage();
        this.result = result;
    }

    public Message(StatusCode statusCode){
        this.statusCode = statusCode;
        this.message = statusCode.getMessage();
        this.result = null;
    }

    public ResponseEntity<Message> toResponseEntity(){
        return new ResponseEntity<>(this, statusCode.getHttpStatus());
    }
}
