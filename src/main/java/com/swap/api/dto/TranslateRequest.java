package com.swap.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TranslateRequest {
    private final String text;
    private final String lang;
}
