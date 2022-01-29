package com.devko.magnet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private String message;
    private int status;
    private String code;

    public ErrorResponse(String message, int status, String code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }

    public ErrorResponse(ErrorCode code){
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
        this.code = code.getCode();
    }
}
