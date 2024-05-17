package org.sopt.hyundai.culture.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public enum Category {
    SPACE("space"),
    CULTURE("culture");
    private final String content;

    public static List<Category> getAll(){
        return Arrays.stream(
                Category.values()
        ).toList();
    }
}
