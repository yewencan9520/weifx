package com.abc.Business.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultOv {

    private WxbGood wxbGood;
    private List<WxbGoodSku2> sku2List;

}
