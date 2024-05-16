package org.sopt.hyundai.member.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.common.dto.ApiResponse;
import org.sopt.hyundai.common.dto.SuccessCode;
import org.sopt.hyundai.member.service.MemberService;
import org.sopt.hyundai.member.service.dto.MemberCreateRequest;
import org.sopt.hyundai.member.service.dto.MemberCreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<ApiResponse> createMember(
            @RequestBody MemberCreateRequest memberCreateRequest) {
        MemberCreateResponse response = memberService.createMember(memberCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.of(SuccessCode.MEMBER_CREATE_SUCCESS, response));
    }
}
