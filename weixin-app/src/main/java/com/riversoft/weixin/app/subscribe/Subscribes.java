package com.riversoft.weixin.app.subscribe;

import com.riversoft.weixin.app.AppWxClientFactory;
import com.riversoft.weixin.app.base.AppSetting;
import com.riversoft.weixin.app.base.WxEndpoint;
import com.riversoft.weixin.common.WxClient;
import com.riversoft.weixin.common.util.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * title: Subscribe.java 
 * 小程序消息订阅
 * https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.send.html
 *
 * @author rplees
 * @email rplees.i.ly@gmail.com
 * @version 1.0  
 * @created Mar 19, 2020 6:18:27 PM
 */
public class Subscribes {

    private static Logger logger = LoggerFactory.getLogger(Subscribes.class);

    private WxClient wxClient;

    public static Subscribes defaultSubscribes() {
        return with(AppSetting.defaultSettings());
    }

    public static Subscribes with(AppSetting appSetting) {
        Subscribes templates = new Subscribes();
        templates.setWxClient(AppWxClientFactory.getInstance().with(appSetting));
        return templates;
    }

    public void setWxClient(WxClient wxClient) {
        this.wxClient = wxClient;
    }

    /**
     * 发送模板消息
     *
     * @param message
     */
    public void send(Subscribe subscribe) {
        String sendUrl = WxEndpoint.get("url.subscribe.send");
        String json = JsonMapper.defaultMapper().toJson(subscribe);

        logger.debug("template message, send message: {}", json);
        String response = wxClient.post(sendUrl, json);
        JsonMapper.defaultMapper().json2Map(response);
    }

}
