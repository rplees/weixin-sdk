package com.riversoft.weixin.pay.payment.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.riversoft.weixin.pay.base.BaseRequest;

/**
 * @borball on 1/13/2017.
 */
public class OrderCloseRequest extends BaseRequest {

    @JsonProperty("out_trade_no")
    private String tradeNumber;

    public String getTradeNumber() {
        return tradeNumber;
    }

    public void setTradeNumber(String tradeNumber) {
        this.tradeNumber = tradeNumber;
    }
}
