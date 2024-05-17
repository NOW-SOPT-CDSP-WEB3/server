package org.sopt.hyundai.culture.dto;

import java.util.List;

public record CategoryListDto(
        List<CategoryDto> categories
) {
    public static CategoryListDto of(List<CategoryDto> categories){
        return new CategoryListDto(categories);
    }
}
