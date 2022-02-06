package com.devko.magnet.dto.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginParamDto {
    private String code;
    private String state;
}
