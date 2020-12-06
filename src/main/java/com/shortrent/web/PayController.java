package com.shortrent.web;

import com.alipay.api.AlipayApiException;
import com.shortrent.service.AliPayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author zhengLiang
 * @description 支付管理
 * @date 2020/1/11 13:55
 */
@Controller
public class PayController {

    //实现支付宝沙箱环境开发  买家账号：njsqay3274@sandbox.com

    @Resource
    private AliPayService aliPayService;

    @GetMapping("/pay")
    @ResponseBody
    public String webPay(@RequestParam("price") String price,@RequestParam("orderId") String orderId) throws AlipayApiException {
        return  aliPayService.webPay(price, orderId);
    }
    @GetMapping("/returnDeal")
    public String returnDeal(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException, AlipayApiException {
        return aliPayService.returnDeal( httpServletRequest);
    }
}
