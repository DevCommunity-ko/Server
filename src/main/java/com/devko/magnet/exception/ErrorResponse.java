package com.devko.magnet.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final int status;
    private final String error;
    private final String code;
    private final String message;

    public static ResponseEntity<ErrorResponse> toResponseEntity(StatusCode statusCode){
        return ResponseEntity.status(statusCode.getHttpStatus())
                                    .body(ErrorResponse.builder()
                                            .status(statusCode.getHttpStatus().value())
                                            .error(statusCode.getHttpStatus().name())
                                            .code(statusCode.name())
                                            .message(statusCode.getMessage())
                                            .build()
                                    );
    }
}
