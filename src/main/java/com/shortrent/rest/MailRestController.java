package com.shortrent.rest;

import com.zhenzi.sms.ZhenziSmsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import com.shortrent.pojo.User;
import com.shortrent.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/mail")
public class MailRestController {
	private static Logger LOG=LoggerFactory.getLogger(MailRestController.class);

	@Value("${spring.mail.username}")
	private String username;

	@Value("${sms.apiUrl}")
	private String apiUrl;

	@Value("${sms.appId}")
	private String appId;

	@Value("${sms.appSecret}")
	private String appSecret;


	@Autowired
	private JavaMailSender mailSender;
    
	@Autowired 
    private UserService userService;
	
    @RequestMapping(value="/sendMail/{receiver}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<Integer> sendMail(@PathVariable String receiver) {
    	int code = (int)(Math.random()*9000 + 1000);
    	
    	User user = userService.findUserById(receiver);
    	if(user == null || user.getIslock() == 1){
    		return new ResponseEntity<Integer>(code, HttpStatus.NOT_FOUND);
    	}
    	
    	SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(username);
		message.setTo(user.getUser_email());
		message.setSubject("这是一封来自短租网的邮件");
		message.setText("您的验证码为 " + code + "（10分钟内有效），请勿泄露给他人。");
		mailSender.send(message);
		LOG.info("发送成功!");
		
		return new ResponseEntity<Integer>(code, HttpStatus.OK);
    }

    //邮箱
	@RequestMapping(value="/sendEmail/{user_email}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> email(@PathVariable String user_email) {
		int code = (int)(Math.random()*9000 + 1000);

		User user = userService.findUserByEmail(user_email);
		if(user == null || user.getIslock() == 1){
			return new ResponseEntity<Integer>(code, HttpStatus.NOT_FOUND);
		}

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(username);
		message.setTo(user.getUser_email());
		message.setSubject("这是一封来自短租网的邮件");
		message.setText("您的验证码为 " + code + "（10分钟内有效），请勿泄露给他人。");
		mailSender.send(message);
		LOG.info("发送成功!");

		return new ResponseEntity<Integer>(code, HttpStatus.OK);
	}

	//短信
	@RequestMapping(value="/sendPhone/{user_tel}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> sendphone(@PathVariable String user_tel) throws Exception {
		int code = (int)(Math.random()*9000 + 1000);

		User user = userService.findUserByPhone(user_tel);
		if(user == null || user.getIslock() == 1){
			return new ResponseEntity<Integer>(code, HttpStatus.NOT_FOUND);
		}

		ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("number", user_tel);
		params.put("templateId", "2316");
		String[] templateParams = new String[2];
		templateParams[0] = code+"";
		templateParams[1] = "5分钟";
		params.put("templateParams", templateParams);
		String result = client.send(params);
		return new ResponseEntity<Integer>(code, HttpStatus.OK);
	}
}
