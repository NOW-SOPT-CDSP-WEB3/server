package org.sopt.hyundai.culture.dto;

import org.sopt.hyundai.culture.domain.Culture;

public record CultureDto(
        Long id,
        String description,
        String image,
        String name,
        String summary,
        String period
) {
    public static CultureDto of(Culture culture){
        return new CultureDto(culture.getId(), culture.getDescription(), culture.getImage(), culture.getName(), culture.getSummary(), culture.getPeriod());
    }
}
