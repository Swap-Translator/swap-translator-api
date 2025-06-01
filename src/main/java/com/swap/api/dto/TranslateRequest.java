package com.swap.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TranslateRequest {
    @NotBlank
    @NotNull
    private final String text;
    @NotBlank
    @NotNull
    private final String lang;
}
