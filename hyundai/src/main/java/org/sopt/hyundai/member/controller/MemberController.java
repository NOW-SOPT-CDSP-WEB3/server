package org.sopt.hyundai.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.common.dto.ApiResponse;
import org.sopt.hyundai.common.dto.SuccessCode;
import org.sopt.hyundai.member.service.MemberService;
import org.sopt.hyundai.member.service.dto.MemberCreateRequest;
import org.sopt.hyundai.member.service.dto.MemberCreateResponse;
import org.sopt.hyundai.member.service.dto.MemberLoginRequest;
import org.sopt.hyundai.member.service.dto.MemberLoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원가입 API", description = "회원가입을 처리합니다.")
    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponse> createMember(
            @Valid @RequestBody MemberCreateRequest memberCreateRequest) {
        MemberCreateResponse response = memberService.createMember(memberCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.of(SuccessCode.MEMBER_CREATE_SUCCESS, response));
    }

    @Operation(summary = "로그인 API", description = "로그인을 처리합니다.")
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginMember(
            @RequestHeader
            @Valid @RequestBody MemberLoginRequest memberLoginRequest) {
        MemberLoginResponse response = memberService.loginMember(memberLoginRequest);
        return ResponseEntity.ok(ApiResponse.of(SuccessCode.MEMBER_LOGIN_SUCCESS, response));
    }
}