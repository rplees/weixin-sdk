package com.riversoft.weixin.pay.payment.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.riversoft.weixin.pay.base.BaseRequest;

/**
 * @borball on 1/13/2017.
 */
public class BillRequest extends BaseRequest {

    @JsonProperty("bill_date")
    private String date;

    @JsonProperty("bill_type")
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
