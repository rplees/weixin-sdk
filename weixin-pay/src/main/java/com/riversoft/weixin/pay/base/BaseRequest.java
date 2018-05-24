package com.riversoft.weixin.pay.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @borball on 1/13/2017.
 */
public class BaseRequest {

    @JsonProperty("appid")
    private String appId;

    @JsonProperty("mch_id")
    private String mchId;
    
    @JsonProperty("sub_appid")
    private String subAppId; //微信分配的子商户公众账号ID
    
    @JsonProperty("sub_mch_id")
    private String subMchId; //微信支付分配的子商户号

    @JsonProperty("nonce_str")
    private String nonce;

    private String sign;
    
    @JsonProperty("sign_type")
    private String signType;

    
    /**
     * 设置子商户信息 
     * @param subAppId
     * @param subMchId
     * @return
     */
    public BaseRequest subMInfo(String subAppId, String subMchId) {
    		this.subAppId = subAppId;
    		this.subMchId = subMchId;
    		return this;
    }
    
    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

	public String getSubAppId() {
		return subAppId;
	}

	public void setSubAppId(String subAppId) {
		this.subAppId = subAppId;
	}

	public String getSubMchId() {
		return subMchId;
	}

	public void setSubMchId(String subMchId) {
		this.subMchId = subMchId;
	}
}
