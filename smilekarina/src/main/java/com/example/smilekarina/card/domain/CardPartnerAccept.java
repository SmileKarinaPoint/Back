package com.example.smilekarina.card.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 제휴 포인트카드 적립
@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CardPartnerAccept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "point_id")
    private Long pointId;

}
