package com.riversoft.weixin.pay.base;

import com.riversoft.weixin.common.WxSslClient;

public interface IPayWxClient {
	WxSslClient load(IPaySetting paySetting);
}
