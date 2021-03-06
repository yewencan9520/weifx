package com.abc.Client.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxbGood {

    private long goodsId;
    private String goodsName;
    private String customerId;
    private String customerName;
    private String goodsPic1;
    private String goodsPic2;
    private String goodsPic3;
    private String promoteDesc;
    private String qq;
    private String skuId;
    private String skuTitle;
    private String skuCost;
    private String skuPrice;
    private String skuPmoney;
    private String copyIds;
    private String copyDesc;
    private String forwardLink;
    private Integer orderNo;
    private String typeId;
    private String tags;
    private Integer state;
    private java.sql.Timestamp createTime;
    private Integer toped;
    private Integer recomed;
    private Integer level;
    private java.sql.Timestamp topedTime;
    private java.sql.Timestamp recomedTime;
    private String spcId;
    private String zonId;
    private Integer sellNum;
    private String website;
    private Integer iswxpay;
    private Integer isfdfk;
    private Integer leixingId;
    private String kfqq;


}
