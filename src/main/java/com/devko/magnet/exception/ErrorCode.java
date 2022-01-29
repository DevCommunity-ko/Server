package com.devko.magnet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // common
    INVALID_INPUT_VALUE(400, "C001", "Invalid Input Value")

    ;

    private int status;
    private String code;
    private String message;
}
