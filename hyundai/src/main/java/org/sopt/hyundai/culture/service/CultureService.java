package org.sopt.hyundai.culture.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.culture.dto.Category;
import org.sopt.hyundai.culture.dto.CategoryDto;
import org.sopt.hyundai.culture.dto.CategoryListDto;
import org.sopt.hyundai.culture.dto.CultureDto;
import org.sopt.hyundai.culture.repository.CultureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CultureService {
    private final CultureRepository cultureRepository;

    public CategoryDto findAllCultureByCategory(String category){
        List<CultureDto> cultures = cultureRepository.findByCategory(category).stream().map(
                CultureDto::of
        ).toList();
        return CategoryDto.of(category, cultures);
    }
    public CategoryListDto findAllCulture(){
        List<CategoryDto> categories = Category.getAll().stream().map(
                category -> findAllCultureByCategory(category.getContent())
        ).toList();
        return CategoryListDto.of(categories);
    }
}
