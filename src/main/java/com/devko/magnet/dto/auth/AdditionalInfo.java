package com.devko.magnet.dto.auth;

import com.devko.magnet.exception.annotation.CheckField;
import com.devko.magnet.exception.annotation.CheckJob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class AdditionalInfo {
    @NotBlank
    @CheckJob
    private String job;

    @NotBlank
    @CheckField
    private String field;

    private int career;
}
