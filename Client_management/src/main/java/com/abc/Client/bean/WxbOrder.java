package com.abc.Client.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxbOrder {

  private Integer oid;
  private String orderId;
  private String goodsId;
  private String skuId;
  private String userId;
  private String province;
  private String city;
  private String area;
  private String address;
  private String buyerName;
  private String buyerPhone;
  private java.sql.Timestamp orderTime;
  private String buyerReamrk;
  private Integer buyNum;
  private Integer state;
  private Integer payType;
  private String alipayState;
  private Integer orderType;
  private String channelId;
  private String courierId;
  private String orderRemark;
  private String senderType;
  private String adminRemark;
  private String operator;
  private java.sql.Timestamp checkTime;
  private String orderIp;
  private java.sql.Timestamp updateTime;
  private Integer isfk;
  private Integer kdzt;
  private String miaoshu;



}
