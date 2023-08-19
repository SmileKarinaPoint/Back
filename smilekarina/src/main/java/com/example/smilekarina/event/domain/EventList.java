package com.example.smilekarina.event.domain;


import com.example.smilekarina.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//이벤트 참여한 리스트
public class EventList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //event_list_id
    @Column(nullable = false, name = "event_id")
    private Long eventId;   //event_id :해당하는 이벤트 id값
    @Column(nullable = false, name="prize_bool")
    private Boolean prizeBool;  //이벤트 당첨여부

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;  //user_id
}
