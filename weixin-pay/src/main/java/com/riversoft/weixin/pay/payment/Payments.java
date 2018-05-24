package com.riversoft.weixin.pay.payment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SortedMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.riversoft.weixin.common.WxSslClient;
import com.riversoft.weixin.common.exception.WxRuntimeException;
import com.riversoft.weixin.common.util.JsonMapper;
import com.riversoft.weixin.common.util.RandomStringGenerator;
import com.riversoft.weixin.common.util.XmlObjectMapper;
import com.riversoft.weixin.pay.PayWxClientFactory;
import com.riversoft.weixin.pay.base.BaseRequest;
import com.riversoft.weixin.pay.base.BaseResponse;
import com.riversoft.weixin.pay.base.IOnSettingBaseRequest;
import com.riversoft.weixin.pay.base.IPaySetting;
import com.riversoft.weixin.pay.base.IPayWxClient;
import com.riversoft.weixin.pay.base.WxEndpoint;
import com.riversoft.weixin.pay.base.XMLPaySetting;
import com.riversoft.weixin.pay.payment.bean.BillRequest;
import com.riversoft.weixin.pay.payment.bean.MicroPayRequest;
import com.riversoft.weixin.pay.payment.bean.MicroPayResponse;
import com.riversoft.weixin.pay.payment.bean.OrderCloseRequest;
import com.riversoft.weixin.pay.payment.bean.OrderCloseResponse;
import com.riversoft.weixin.pay.payment.bean.OrderQueryRequest;
import com.riversoft.weixin.pay.payment.bean.OrderQueryResponse;
import com.riversoft.weixin.pay.payment.bean.PaymentNotification;
import com.riversoft.weixin.pay.payment.bean.RefundQueryRequest;
import com.riversoft.weixin.pay.payment.bean.RefundQueryResponse;
import com.riversoft.weixin.pay.payment.bean.RefundRequest;
import com.riversoft.weixin.pay.payment.bean.RefundResponse;
import com.riversoft.weixin.pay.payment.bean.ReverseRequest;
import com.riversoft.weixin.pay.payment.bean.ReverseResponse;
import com.riversoft.weixin.pay.payment.bean.UnifiedOrderRequest;
import com.riversoft.weixin.pay.payment.bean.UnifiedOrderResponse;
import com.riversoft.weixin.pay.util.SignatureUtil;

/**
 * 支付相关: 小程序或者公众号
 * @borball on 5/15/2016.
 */
public class Payments {
    private static Logger logger = LoggerFactory.getLogger(Payments.class);
    private IPaySetting paySetting;
    private IOnSettingBaseRequest onSettingBaseRequest;
    
    public void setPaySetting(IPaySetting paySetting) {
        this.paySetting = paySetting;
    }

    private WxSslClient wxSslClient;

    public static Payments defaultPayments() {
        return with(XMLPaySetting.defaultSetting(), PayWxClientFactory.getInstance(), null);
    }

    public static Payments with(IPaySetting paySetting, IPayWxClient payWxClient, IOnSettingBaseRequest onSettingBaseRequest) {
        Payments payments = new Payments();
        payments.setPaySetting(paySetting);
        payments.setWxSslClient(payWxClient.load(paySetting));
        payments.onSettingBaseRequest = onSettingBaseRequest;
        return payments;
    }

    public void setWxSslClient(WxSslClient wxSslClient) {
        this.wxSslClient = wxSslClient;
    }
    
    /**
     * 统一下单
     *
     * @param unifiedOrderRequest
     * @return
     */
    @SuppressWarnings("unchecked")
	public UnifiedOrderResponse unifiedOrder(UnifiedOrderRequest request) {
    		setBaseRequest(request);
        SortedMap<String, Object> unifiedOrderRequestMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(request, SortedMap.class);
        sign(request, unifiedOrderRequestMap);

        String url = WxEndpoint.get("url.pay.payment.order.unified");
        try {
            String xml = XmlObjectMapper.nonEmptyMapper().toXml(request);
            logger.info("支付 unified order request: {}", xml);
            String responseXML = wxSslClient.post(url, xml);
            logger.info("支付 unified order response: {}", responseXML);

            UnifiedOrderResponse response = XmlObjectMapper.defaultMapper().fromXml(responseXML, UnifiedOrderResponse.class);
            return response;
        } catch (Exception e) {
            throw new WxRuntimeException(999, "pre order failed:" + e.getMessage());
        }

    }

    /**
     * 查询订单状态
     * @param orderQueryRequest
     * @return
     */
    public OrderQueryResponse query(OrderQueryRequest request) {
    		setBaseRequest(request);
        @SuppressWarnings("unchecked")
		SortedMap<String, Object> queryRequestMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(request, SortedMap.class);
        sign(request, queryRequestMap);

        String url = WxEndpoint.get("url.pay.payment.order.query");
        try {
            String xml = XmlObjectMapper.nonEmptyMapper().toXml(request);
            logger.info("支付 query order request: {}", xml);
            String responseXML = wxSslClient.post(url, xml);
            logger.info("支付 query order response: {}", responseXML);

            OrderQueryResponse response = XmlObjectMapper.defaultMapper().fromXml(responseXML, OrderQueryResponse.class);
            return response;
        } catch (Exception e) {
            throw new WxRuntimeException(999, "query order failed:" + e.getMessage());
        }

    }

    /**
     * 关闭订单
     * @param tradeNumber
     * @return
     */
    public BaseResponse close(OrderCloseRequest request) {
        setBaseRequest(request);

        @SuppressWarnings("unchecked")
		SortedMap<String, Object> closeOrderRequestMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(request, SortedMap.class);
        sign(request, closeOrderRequestMap);

        String url = WxEndpoint.get("url.pay.payment.order.close");
        try {
            String xml = XmlObjectMapper.nonEmptyMapper().toXml(request);
            logger.info("支付 close order request: {}", xml);
            String responseXML = wxSslClient.post(url, xml);
            logger.info("支付 close order response: {}", responseXML);

            OrderCloseResponse response = XmlObjectMapper.defaultMapper().fromXml(responseXML, OrderCloseResponse.class);
            return response;
        } catch (Exception e) {
            throw new WxRuntimeException(999, "close order failed:" + e.getMessage());
        }

    }
    /**
     * 撤销订单
     * @param tradeNumber
     * @return
     */
	public ReverseResponse reverse(ReverseRequest request) {
		setBaseRequest(request);

		@SuppressWarnings("unchecked")
		SortedMap<String, Object> closeOrderRequestMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(request,SortedMap.class);
		sign(request, closeOrderRequestMap);

		String url = "https://api.mch.weixin.qq.com/secapi/pay/reverse";
		try {
			String xml = XmlObjectMapper.nonEmptyMapper().toXml(request);
			logger.info("撤销 close order request: {}", xml);
			String responseXML = wxSslClient.post(url, xml);
			logger.info("撤销 close order response: {}", responseXML);

			ReverseResponse response = XmlObjectMapper.defaultMapper().fromXml(responseXML, ReverseResponse.class);
			return response;
		} catch (Exception e) {
			throw new WxRuntimeException(999, "撤销 order failed:" + e.getMessage());
		}

	}

    /**
     * check if sign is valid
     * @param notification
     * @return
     */
    public boolean checkSignature(PaymentNotification notification) {
        @SuppressWarnings("unchecked")
		SortedMap<String, Object> notificationMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(notification, SortedMap.class);
        notificationMap.putAll(notification.getOthers());
        notificationMap.remove("sign");
        notificationMap.remove("others");
        return notification.getSign().equals(SignatureUtil.sign(notificationMap, paySetting.getKey()));
    }

    /**
     * 申请退款
     * @param refundRequest
     * @return
     */
    public MicroPayResponse microPay(MicroPayRequest request) {
        setBaseRequest(request);

        @SuppressWarnings("unchecked")
		SortedMap<String, Object> refundRequestMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(request, SortedMap.class);
        sign(request, refundRequestMap);
        String url = "https://api.mch.weixin.qq.com/pay/micropay";
        try {
            String xml = XmlObjectMapper.nonEmptyMapper().toXml(request);
            logger.info("支付 refund request: {}", xml);
            String responseXML = wxSslClient.post(url, xml);
            logger.info("支付 refund response: {}", responseXML);

            MicroPayResponse response = XmlObjectMapper.defaultMapper().fromXml(responseXML, MicroPayResponse.class);
            return response;
        } catch (Exception e) {
            throw new WxRuntimeException(999, "refund failed:" + e.getMessage());
        }
    }
    
    /**
     * 申请退款
     * @param refundRequest
     * @return
     */
    public RefundResponse refund(RefundRequest request) {
        setBaseRequest(request);

        @SuppressWarnings("unchecked")
		SortedMap<String, Object> refundRequestMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(request, SortedMap.class);
        sign(request, refundRequestMap);

        String url = WxEndpoint.get("url.pay.payment.refund.refund");
        try {
            String xml = XmlObjectMapper.nonEmptyMapper().toXml(request);
            logger.info("支付 refund request: {}", xml);
            String responseXML = wxSslClient.post(url, xml);
            logger.info("支付 refund response: {}", responseXML);

            RefundResponse response = XmlObjectMapper.defaultMapper().fromXml(responseXML, RefundResponse.class);
            return response;
        } catch (Exception e) {
            throw new WxRuntimeException(999, "refund failed:" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
	public RefundQueryResponse refundQuery(RefundQueryRequest request) {
        setBaseRequest(request);

        SortedMap<String, Object> refundQueryRequestMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(request, SortedMap.class);
        sign(request, refundQueryRequestMap);

        String url = WxEndpoint.get("url.pay.payment.refund.query");
        try {
            String xml = XmlObjectMapper.nonEmptyMapper().toXml(request);
            logger.info("支付 refund query request: {}", xml);
            String responseXML = wxSslClient.post(url, xml);
            logger.info("支付 refund query response: {}", responseXML);

            RefundQueryResponse response = XmlObjectMapper.defaultMapper().fromXml(responseXML, RefundQueryResponse.class);
            return response;
        } catch (Exception e) {
            throw new WxRuntimeException(999, "refund query failed:" + e.getMessage());
        }
    }

    /**
     * 获取所有订单
     * @param date
     * @return
     */
    public String downloadAllBill(Date date){
        return downloadBill(date, "ALL");
    }

    /**
     * 获取所有退款订单
     * @param date
     * @return
     */
    public String downloadRefundBill(Date date){
        return downloadBill(date, "REFUND");
    }

    /**
     * 获取所有退款订单
     * @param date
     * @return
     */
    public String downloadSuccessBill(Date date){
        return downloadBill(date, "SUCCESS");
    }

    @SuppressWarnings("unchecked")
	private String downloadBill(Date date, String type){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        BillRequest request = new BillRequest();
        request.setDate(dateFormat.format(date));
        request.setType(type);
        setBaseRequest(request);
        SortedMap<String, Object> billRequestMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(request, SortedMap.class);
        sign(request, billRequestMap);

        String url = WxEndpoint.get("url.pay.payment.bill.download");
        try {
            String xml = XmlObjectMapper.nonEmptyMapper().toXml(request);
            logger.info("支付 bill download request: {}", xml);
            String responseXML = wxSslClient.post(url, xml);
            logger.info("支付 bill download response: {}", responseXML);
            return responseXML;
        } catch (Exception e) {
            throw new WxRuntimeException(999, "bill download failed:" + e.getMessage());
        }
    }
    
	private void setBaseRequest(BaseRequest baseRequest) {
		baseRequest.setAppId(paySetting.getAppId());
		baseRequest.setMchId(paySetting.getMchId());
		
		if(onSettingBaseRequest != null) {
			onSettingBaseRequest.setting(baseRequest);
		}
	}

	private void sign(BaseRequest baseRequest, SortedMap<String, Object> generals) {
		String nonce = RandomStringGenerator.getRandomStringByLength(32);
		generals.put("nonce_str", nonce);
		generals.put("mch_id", paySetting.getMchId());

		baseRequest.setNonce(nonce);
		baseRequest.setSign(SignatureUtil.sign(generals, paySetting.getKey()));
	}
}
