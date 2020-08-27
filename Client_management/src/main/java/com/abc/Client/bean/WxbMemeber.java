package com.abc.Client.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxbMemeber {

    private String memeberId;
    private String account;
    private String qqNum;
    private String email;
    private String phone;
    private String recomUser;
    private java.sql.Timestamp registerTime;
    private String payAccount;
    private String name;
    private String password;
    private String visitCode;
    private Integer useRecom;
    private String levelCode;
    private Integer mid;
    private java.sql.Timestamp updateTime;


}
