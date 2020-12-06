package com.shortrent.serviceImpl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.shortrent.config.AliPayConfig;
import com.shortrent.service.AliPayService;
import com.shortrent.service.OrderListService;
import com.shortrent.utils.AliPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author zhengLiang
 * @description
 * @date 2020/1/11 13:58
 */
@Service
public class AliPayServiceImpl implements AliPayService {

    @Autowired
    private OrderListService orderService;

	public String webPay(String price,String orderId) throws AlipayApiException {
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.GATEWAYURL, AliPayConfig.app_id,
                AliPayConfig.merchant_private_key, "json", AliPayConfig.CHARSET,
                AliPayConfig.alipay_public_key, AliPayConfig.SIGN_TYPE);
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        //同步通知，支付完成后，支付成功页面
        aliPayRequest.setReturnUrl(AliPayConfig.return_url);
        //异步通知，支付完成后，需要进行的异步处理
        aliPayRequest.setNotifyUrl(AliPayConfig.notify_url);
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + orderId + "\","
                + "\"total_amount\":\"" + price+ "\","
                + "\"subject\":\"" + "项目" + "\","
                + "\"body\":\"" + "描述" + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String result= alipayClient.pageExecute(aliPayRequest).getBody();
        return result;
	}

    public String returnDeal(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        Map<String, String> params = AliPayUtil.getParams(request);
        System.err.println(params);
        //商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        //支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
        //付款金额
        String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AliPayConfig.alipay_public_key, AliPayConfig.CHARSET,  AliPayConfig.SIGN_TYPE);

        orderService.updateOrderPay(Integer.valueOf(out_trade_no));
        if (signVerified) {
            request.setAttribute("info","支付成功");
            request.setAttribute("out_trade_no",out_trade_no);
            request.setAttribute("trade_no",trade_no);
            request.setAttribute("total_amount",total_amount);
            return "system/paysuccess";
        } else {
            request.setAttribute("info","安全验证有误");
            return "system/paysuccess";
        }
    }
    
}
