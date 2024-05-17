package org.sopt.hyundai.bookmark.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.hyundai.card.domain.Card;
import org.sopt.hyundai.member.domain.Member;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)  // 매핑되는 열 이름 지정
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)  // 매핑되는 열 이름 지정
    private Card card;

    public static Bookmark create(Member member, Card card) {
        return Bookmark.builder()
                .member(member)
                .card(card)
                .build();
    }

    @Builder
    public Bookmark(Member member, Card card) {
        this.member = member;
        this.card = card;
    }
}
