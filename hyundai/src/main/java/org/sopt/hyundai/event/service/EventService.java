package org.sopt.hyundai.event.service;

import lombok.RequiredArgsConstructor;
import org.sopt.hyundai.event.dto.EventDto;
import org.sopt.hyundai.event.dto.EventListDto;
import org.sopt.hyundai.event.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventListDto findAllEvent(String content){
        List<EventDto> events = eventRepository.findAllByContent(content).stream()
                .map(
                        EventDto::of
                ).toList();
        return EventListDto.of(events);
    }
}
