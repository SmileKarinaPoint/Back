package com.example.smilekarina.user.vo;

import lombok.Getter;

@Getter
public class ChangePasswordNewIn {
    private String loginId;
    private String oldPwd;
    private String newPwd;
}
