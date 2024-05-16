package org.sopt.hyundai.member.service.dto;

public record MemberCreateRequest(
        String email,
        String password
) {
}
