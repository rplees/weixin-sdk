package com.riversoft.weixin.pay.payment.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.riversoft.weixin.common.util.DateDeserializer;
import com.riversoft.weixin.pay.base.BaseResponse;

/**
 * @borball on 5/15/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MicroPayResponse extends BaseResponse {
	@JsonProperty("openid")
	private String openid;

	@JsonProperty("is_subscribe")
	private String isSubscribe;

	@JsonProperty("trade_type")
	private String tradeType;

	@JsonProperty("bank_type")
	private String bankType;

	@JsonProperty("fee_type")
	private String feeType;

	@JsonProperty("total_fee")
	private Integer totalFee;

	@JsonProperty("settlement_total_fee")
	private Integer settlementTotalFee;

	@JsonProperty("coupon_fee")
	private Integer couponFee;

	@JsonProperty("cash_fee_type")
	private String cashFeeType;

	@JsonProperty("cash_fee")
	private Integer cashFee;

	@JsonProperty("transaction_id")
	private String transactionId;

	@JsonProperty("out_trade_no")
	private String tradeNumber;

	@JsonProperty("attach")
	private String attach;

	@JsonProperty("time_end")
	@JsonDeserialize(using = DateDeserializer.class)
	private Date timeEnd;

	@JsonProperty("promotion_detail")
	public String promotionDetail;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	
	public Integer getSettlementTotalFee() {
		return settlementTotalFee;
	}

	public void setSettlementTotalFee(Integer settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	public Integer getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Integer couponFee) {
		this.couponFee = couponFee;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

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

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getPromotionDetail() {
		return promotionDetail;
	}

	public void setPromotionDetail(String promotionDetail) {
		this.promotionDetail = promotionDetail;
	}
}
