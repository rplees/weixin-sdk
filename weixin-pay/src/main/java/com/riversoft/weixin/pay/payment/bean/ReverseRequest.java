package com.riversoft.weixin.pay.payment.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.riversoft.weixin.pay.base.BaseRequest;

/**
 * 
 * title: MicroPayRequest.java 
 * 提交刷卡支付
 *
 * @author rplees
 * @email rplees.i.ly@gmail.com
 * @version 1.0  
 * @created May 24, 2018 5:56:42 PM
 */
@JacksonXmlRootElement(localName = "xml")
public class ReverseRequest extends BaseRequest {


    @JsonProperty("transaction_id")
    private String transactionId;
    @JsonProperty("out_trade_no")
    private String tradeNumber;
    
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
}
