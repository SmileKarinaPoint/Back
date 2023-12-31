package com.example.smilekarina.card.application;

import com.example.smilekarina.card.dto.AffiliateCardDto;
import com.example.smilekarina.card.dto.PointCardDto;
import com.example.smilekarina.card.vo.CreditCardOut;
import com.example.smilekarina.card.vo.OfflinePointCardOut;
import com.example.smilekarina.card.vo.OnlinePointCardOut;

import java.util.List;

public interface CardService {

    // 신규 포인트 카드 등록
    void registerPointCard(PointCardDto pointCardDto);


    // 제휴 멤버십 카드 등록
    void registerAffiliateCard(AffiliateCardDto affiliateCardDto);

    // 온라인 카드 조회
    List<OnlinePointCardOut> getOnlinePointCardList(String token);

    // 제휴 신용카드 조회
    List<CreditCardOut> getCreditCardList(String token);

    // 오프라인 카드 조회
    List<OfflinePointCardOut> getOfflinePointCardList(String token);

    // 포인트카드 번호 조회(바코드 보기 위함)
    String getPointCardNumber(String token);

    // 회원가입시 온라인포인트카드 등록
    void registerOnlinePointCard(Long userId);

}
