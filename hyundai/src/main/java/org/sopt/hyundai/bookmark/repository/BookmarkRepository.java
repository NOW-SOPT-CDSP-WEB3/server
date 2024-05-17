package org.sopt.hyundai.bookmark.repository;

import jakarta.transaction.Transactional;
import org.sopt.hyundai.bookmark.domain.Bookmark;
import org.sopt.hyundai.card.domain.Card;
import org.sopt.hyundai.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Transactional
    void deleteByMemberAndCard(Member member, Card card);

    boolean existsByMemberAndCard(Member member, Card card);
}
