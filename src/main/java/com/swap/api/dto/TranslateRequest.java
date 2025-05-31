package com.swap.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@AllArgsConstructor
public class TranslateRequest {
    @NotBlank
    @NotNull
    private final String text;
    @NotBlank
    @NotNull
    private final String lang;
}
