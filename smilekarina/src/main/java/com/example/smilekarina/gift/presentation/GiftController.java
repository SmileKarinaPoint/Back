package com.example.smilekarina.gift.presentation;

import com.example.smilekarina.gift.application.GiftService;
import com.example.smilekarina.gift.dto.GiftLastDto;
import com.example.smilekarina.gift.vo.GiftIn;
import com.example.smilekarina.gift.vo.GiftLastOut;
import com.example.smilekarina.global.vo.ResponseOut;
import com.example.smilekarina.point.application.PointService;
import com.example.smilekarina.point.dto.PointPasswordCheckDto;
import com.example.smilekarina.user.application.UserService;
import com.example.smilekarina.user.vo.UserGetOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class GiftController {

    private final ModelMapper modelMapper;
    private final GiftService giftService;
    private final PointService pointService;
    private final UserService userService;

    /*
        포인트 선물하기
     */
    @PostMapping("/point/gift")
    public ResponseEntity<?> createGift(@RequestHeader("Authorization") String token, @RequestBody GiftIn giftIn) {

        // 보낸사람 포인트비밀번호 체크
        Long userId = userService.getUserIdFromToken(token);

        PointPasswordCheckDto pointPasswordCheckDto = PointPasswordCheckDto.builder()
                .userId(userId)
                .pointPassword(giftIn.getPointPassword())
                .build();

        Boolean checkResult = pointService.checkPointPassword(pointPasswordCheckDto);

        if(!checkResult) {
            // TODO 실패시 메시지, 코드 리턴값은 프론트와 상의 후 확정 예정 일단은 인증실패로 리턴
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // 선물하기 처리
        giftService.registerGift(userId, giftIn);
        ResponseOut<?> responseOut = ResponseOut.success();

        return ResponseEntity.ok(responseOut);
    }

    /*
        포인트 선물 받기 내역 조회(가장 최근 것만)
     */
    @GetMapping("/gift/getlast")
    public ResponseEntity<ResponseOut<?>> getLastGift(@RequestHeader("Authorization") String token) {

        GiftLastDto giftLastDto = giftService.getLastGift(token);

        if(giftLastDto == null) {
            ResponseOut<?> responseOut = ResponseOut.success();
            return ResponseEntity.ok(responseOut);
        } else {
            ResponseOut<?> responseOut = ResponseOut.success(modelMapper.map(giftLastDto, GiftLastOut.class));
            return ResponseEntity.ok(responseOut);
        }
    }

    //******************************************************

    /*
        포인트 선물 수락
     */

    // 1) 포인트 테이블에 받는 사람의 적립 포인트 데이터 추가

    // 2) 선물 테이블의 선물 타입, 받는사람 포인트id를 갱신


    //******************************************************


    /*
        포인트 선물 거절
     */

    // 1) 포인트 테이블에 받는 사람 선물취소(적립) 포인트 데이터 추가
    // 2) 선물 테이블의 선물 타입을 취소로 갱신


    //******************************************************

    /*
        포인트 선물 리스트 조회
     */


    // 고민해보기

    //******************************************************


}