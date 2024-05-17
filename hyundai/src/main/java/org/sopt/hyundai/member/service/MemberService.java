package org.sopt.hyundai.member.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.common.dto.ErrorCode;
import org.sopt.hyundai.exception.BusinessException;
import org.sopt.hyundai.member.domain.Member;
import org.sopt.hyundai.member.repository.MemberRepository;
import org.sopt.hyundai.member.service.dto.MemberCreateRequest;
import org.sopt.hyundai.member.service.dto.MemberCreateResponse;
import org.sopt.hyundai.member.service.dto.MemberLoginRequest;
import org.sopt.hyundai.member.service.dto.MemberLoginResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberCreateResponse createMember(MemberCreateRequest memberCreateRequest) {
        if (memberRepository.existsByEmail(memberCreateRequest.email())) { // 이메일 중복을 잡아줌
            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);
        }

        Member member = memberRepository.save(Member.create(memberCreateRequest.email(), memberCreateRequest.password()));
        return new MemberCreateResponse(member.getId(), member.getEmail());
    }

    public MemberLoginResponse loginMember(MemberLoginRequest memberLoginRequest) {
        Member member = memberRepository.findByEmail(memberLoginRequest.email()).orElseThrow(
                () -> new BusinessException(ErrorCode.LOGIN_FAILED)
        );

        if (!memberLoginRequest.password().equals(member.getPassword())) {
            throw new BusinessException(ErrorCode.LOGIN_FAILED);
        }

        return new MemberLoginResponse(member.getId(), member.getEmail());
    }
}