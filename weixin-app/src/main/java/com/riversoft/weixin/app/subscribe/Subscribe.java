package com.riversoft.weixin.app.subscribe;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

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
public class Subscribe {

    @JsonProperty("touser")
    private String toUser;

    @JsonProperty("template_id")
    private String templateId;

    private String page;
    
    @JsonProperty("miniprogram_state")
    private String miniprogramState;

    private String lang;

    private Map<String, Data> data;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Map<String, Data> getData() {
        return data;
    }

    public void setData(Map<String, Data> data) {
        this.data = data;
    }

    
    public String getMiniprogramState() {
		return miniprogramState;
	}

	public void setMiniprogramState(String miniprogramState) {
		this.miniprogramState = miniprogramState;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}


	/**
     * Created by exizhai on 12/16/2015.
     */
    public static class Data {

        private String value;
        private String color;

        public Data() {
        }

        public Data(String value, String color) {
            this.value = value;
            this.color = color;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
