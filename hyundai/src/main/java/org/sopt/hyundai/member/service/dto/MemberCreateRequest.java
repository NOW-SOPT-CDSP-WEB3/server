package org.sopt.hyundai.member.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MemberCreateRequest(
        @NotBlank
        @Email // 이메일 형식인 지 잡아줌
        String email,

        @NotBlank
        String password
) {
}
