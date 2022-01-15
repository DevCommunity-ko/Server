package com.devko.magnet.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AdditionalInfo {
    private String job;
    private String field;
    private int career;
}
