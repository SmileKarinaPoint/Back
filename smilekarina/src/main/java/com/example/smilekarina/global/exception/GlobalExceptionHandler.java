package com.example.smilekarina.global.exception;

import com.example.smilekarina.global.vo.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
    만료된 토큰
     */
    @ExceptionHandler(TokenInvalidException.class)
    protected ResponseEntity<ErrorResponse> handleExpiredToken(TokenInvalidException ex) {
        log.error("tokenInvalidException", ex);
        ErrorResponse errorResponse = new ErrorResponse(ErrorStateCode.TOKEN_INVALID);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }
    /**
    같은 날짜 출석
    */
    @ExceptionHandler(SameDayCheckException.class)
    protected ResponseEntity<ErrorResponse> handlerSameDayCheck(SameDayCheckException ex) {
        log.error("sameDayException", ex);
        ErrorResponse errorResponse = new ErrorResponse(ErrorStateCode.SAMEDAYCHECK);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /*
        포인트 비밀번호 불일치
     */
    @ExceptionHandler(PointPasswordIncorrectException.class)
    protected ResponseEntity<ErrorResponse> handlerPointPasswordCheck(PointPasswordIncorrectException ex) {
        log.error("PointPasswordIncorrectException", ex);
        ErrorResponse errorResponse = new ErrorResponse(ErrorStateCode.INCORRECTPOINTPASSWORD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
