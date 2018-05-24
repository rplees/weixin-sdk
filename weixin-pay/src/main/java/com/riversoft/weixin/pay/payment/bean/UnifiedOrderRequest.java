package com.riversoft.weixin.pay.payment.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.riversoft.weixin.pay.base.BaseRequest;

/**
 * @borball on 5/15/2016.
 */
@JacksonXmlRootElement(localName = "xml")
public class UnifiedOrderRequest extends BaseRequest {

    /**
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     */
    @JsonProperty("device_info")
    private String deviceInfo;

    private String body;
    private String detail;
    private String attach;

    @JsonProperty("out_trade_no")
    private String tradeNumber;

    @JsonProperty("fee_type")
    private String feeType;

    @JsonProperty("total_fee")
    private int totalFee;

    /**
     * APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP
     */
    @JsonProperty("spbill_create_ip")
    private String billCreatedIp;

    @JsonProperty("time_start")
    private String timeStart;

    @JsonProperty("time_expire")
    private String timeExpire;

    @JsonProperty("goods_tag")
    private String goodsTag;

    @JsonProperty("notify_url")
    private String notifyUrl;

    @JsonProperty("trade_type")
    private String tradeType;

    /**
     * trade_type=NATIVE时（即扫码支付），此参数必传。此参数为二维码中包含的商品ID，商户自行定义
     */
    @JsonProperty("product_id")
    private String productId;

    @JsonProperty("limit_pay")
    private String limitPay;

    /**
     * trade_type=JSAPI时（即公众号支付或者小程序支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。
     */
    @JsonProperty("openid")
    private String openId;

    @JsonProperty("sub_openid")
    private String subOpenId;
    
    @JsonProperty("scene_info")
    private String sceneInfo;
    
    public String getSubOpenId() {
		return subOpenId;
	}

	public void setSubOpenId(String subOpenId) {
		this.subOpenId = subOpenId;
	}

	public String getSceneInfo() {
		return sceneInfo;
	}

	public void setSceneInfo(String sceneInfo) {
		this.sceneInfo = sceneInfo;
	}

	public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

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

	public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getBillCreatedIp() {
        return billCreatedIp;
    }

    public void setBillCreatedIp(String billCreatedIp) {
        this.billCreatedIp = billCreatedIp;
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

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
