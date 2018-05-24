package com.riversoft.weixin.pay.base;

import com.riversoft.weixin.common.cert.CertContent;

/**
 * 商户信息
 *
 * Created by exizhai on 11/22/2015.
 */
public interface IPaySetting {
	
	String getMchId();

	String getAppId();

	String getKey();

	String getCertPassword();
	
	CertContent getCertContent();
}
