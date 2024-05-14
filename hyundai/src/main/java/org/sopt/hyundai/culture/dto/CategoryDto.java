package org.sopt.hyundai.culture.dto;

import java.util.List;

public record CategoryDto(
        String name,
        List<CultureDto> cultures
) {
    public static CategoryDto of(String name, List<CultureDto> cultures){
        return new CategoryDto(name, cultures);
    }
}
