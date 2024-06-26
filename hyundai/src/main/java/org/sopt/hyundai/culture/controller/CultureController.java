package org.sopt.hyundai.culture.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.common.dto.ApiResponse;
import org.sopt.hyundai.common.dto.SuccessCode;
import org.sopt.hyundai.culture.service.CultureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cultures")
public class CultureController {
    private final CultureService cultureService;

    @Operation(summary = "문화 리스트 조회 API", description = "모든 문화를 조회합니다.")
    @GetMapping
    public ResponseEntity<ApiResponse> getAllCultures(){
        return ResponseEntity.ok(ApiResponse.of(SuccessCode.GET_CULTURE_LIST_SUCCESS, cultureService.findAllCulture()));
    }
}
