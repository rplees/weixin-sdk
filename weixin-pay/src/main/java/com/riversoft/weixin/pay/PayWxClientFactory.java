package com.riversoft.weixin.pay;

import java.util.concurrent.ConcurrentMap;

import com.google.common.cache.CacheBuilder;
import com.riversoft.weixin.common.WxSslClient;
import com.riversoft.weixin.pay.base.IPaySetting;
import com.riversoft.weixin.pay.base.IPayWxClient;
import com.riversoft.weixin.pay.base.XMLPaySetting;

/**
 * Created by exizhai on 11/12/2015.
 */
public class PayWxClientFactory implements IPayWxClient {

    private static PayWxClientFactory instance = null;
    private static ConcurrentMap<String, WxSslClient> wxClients = CacheBuilder.newBuilder().initialCapacity(8)
            .maximumSize(128).<String, WxSslClient>build().asMap();

    public static PayWxClientFactory getInstance() {
        if (instance == null) {
            instance = new PayWxClientFactory();
        }
        return instance;
    }

    public WxSslClient defaultWxSslClient() {
        return with(XMLPaySetting.defaultSetting());
    }

    public WxSslClient with(IPaySetting paySetting) {
        if (!wxClients.containsKey(key(paySetting))) {
            WxSslClient wxClient = new WxSslClient(paySetting.getCertContent(), paySetting.getCertPassword());
            wxClients.putIfAbsent(key(paySetting), wxClient);
        }

        return wxClients.get(key(paySetting));
    }


    private String key(IPaySetting paySetting) {
        return paySetting.getAppId() + ":" + paySetting.getMchId();
    }

	@Override
	public WxSslClient load(IPaySetting paySetting) {
		return with(paySetting);
	}
}

