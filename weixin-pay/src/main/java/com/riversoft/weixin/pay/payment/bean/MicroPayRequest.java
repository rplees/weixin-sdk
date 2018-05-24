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
public class MicroPayRequest extends BaseRequest {

    @JsonProperty("body")
    private String body;

    @JsonProperty("detail")
    private String detail;
    
    @JsonProperty("attach")
    private String attach;
    
    @JsonProperty("out_trade_no")
    private String tradeNumber;
    
    @JsonProperty("total_fee")
    private Integer totalFee;
    
    @JsonProperty("fee_type")
    private String feeType;
    
    @JsonProperty("spbill_create_ip")
    private String spbillCreateIp;
    
    @JsonProperty("goods_tag")
    private String goodsTag;
    
    @JsonProperty("limit_pay")
    private String limitPay;
    
    @JsonProperty("time_start")
    private String timeStart;
    
    @JsonProperty("time_expire")
    private String timeExpire;
    
    @JsonProperty("auth_code")
    private String authCode;
    
    @JsonProperty("scene_info")
    private String sceneInfo;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTradeNumber() {
		return tradeNumber;
	}

	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getSpbillCreateIp() {
		return spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getLimitPay() {
		return limitPay;
	}

	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeExpire() {
		return timeExpire;
	}

	public void setTimeExpire(String timeExpire) {
		this.timeExpire = timeExpire;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getSceneInfo() {
		return sceneInfo;
	}

	public void setSceneInfo(String sceneInfo) {
		this.sceneInfo = sceneInfo;
	}
}
