package com.riversoft.weixin.pay;

import java.util.concurrent.ConcurrentHashMap;

import com.riversoft.weixin.common.WxSslClient;
import com.riversoft.weixin.pay.base.IPaySetting;
import com.riversoft.weixin.pay.base.IPayWxClient;

/**
 * Created by exizhai on 11/12/2015.
 */
public class PayWxClientFactory implements IPayWxClient {

    private static PayWxClientFactory instance = null;
    private static ConcurrentHashMap<String, WxSslClient> wxClients = new ConcurrentHashMap<>();

    public static PayWxClientFactory getInstance() {
        if (instance == null) {
            instance = new PayWxClientFactory();
        }
        return instance;
    }

	@Override
	public WxSslClient load(IPaySetting paySetting) {
		if (!wxClients.containsKey(key(paySetting))) {
			WxSslClient wxClient = new WxSslClient(paySetting.getCertContent(), paySetting.getCertPassword());
			wxClients.putIfAbsent(key(paySetting), wxClient);
		}

		return wxClients.get(key(paySetting));
	}
    
//    public WxSslClient defaultWxSslClient() {
//        return with(XMLPaySetting.defaultSetting());
//    }

    private String key(IPaySetting paySetting) {
        return paySetting.getAppId() + ":" + paySetting.getMchId();
    }
}

