package org.sopt.hyundai.event.dto;

import java.util.List;

public record EventListDto(
        List<EventDto> events
) {
    public static EventListDto of(List<EventDto> events){
        return new EventListDto(events);
    }
}
