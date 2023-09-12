package com.example.smilekarina.event.vo;

import com.example.smilekarina.event.domain.EventType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventParticipateIn {
    Long eventId;
    Boolean prizeBool;
}
