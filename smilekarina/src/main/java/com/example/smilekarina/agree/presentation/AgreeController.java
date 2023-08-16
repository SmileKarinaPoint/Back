package com.example.smilekarina.agree.presentation;

import com.example.smilekarina.agree.domain.AgreeList;
import com.example.smilekarina.agree.infrastructure.AgreeListRepository;
import com.example.smilekarina.agree.infrastructure.AgreeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class AgreeController {
    private final AgreeRepository agreeRepository;
    private final AgreeListRepository agreeListRepository;


}
