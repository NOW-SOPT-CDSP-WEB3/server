package org.sopt.hyundai.culture.repository;

import org.sopt.hyundai.culture.domain.Culture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CultureRepository extends JpaRepository<Culture, Long> {
    List<Culture> findByCategory(String category);
}
