package com.riversoft.weixin.pay.payment.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.riversoft.weixin.pay.base.BaseResponse;

/**
 * @borball on 5/17/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReverseResponse extends BaseResponse {

    @JsonProperty("recall")
    private String recall;

	public String getRecall() {
		return recall;
	}

	public void setRecall(String recall) {
		this.recall = recall;
	}
}
