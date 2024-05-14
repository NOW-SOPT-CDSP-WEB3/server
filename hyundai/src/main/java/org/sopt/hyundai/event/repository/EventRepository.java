package org.sopt.hyundai.event.repository;

import org.sopt.hyundai.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select e from Event e where e.description like concat('%', :content, '%') or e.name like concat('%', :content, '%')")
    List<Event> findAllByContent(@Param("content") String content);
}
