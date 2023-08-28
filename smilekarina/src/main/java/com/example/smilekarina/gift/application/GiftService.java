package com.example.smilekarina.gift.application;

import com.example.smilekarina.gift.dto.GiftLastDto;
import com.example.smilekarina.gift.vo.GiftIn;

public interface GiftService {

    // 포인트 선물하기
    void registerGift(Long userId, GiftIn giftIn);

    // 포인트 선물 받기 내역 조회(가장최근 것만)
    GiftLastDto getLastGift(String token);

}