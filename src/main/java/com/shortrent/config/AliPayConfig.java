package com.shortrent.config;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zhengLiang
 * @description 支付宝支付配置
 * @date 2020/1/11 13:56
 */
@Configuration
public class AliPayConfig {
	/**
	 * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	 */

	public static String app_id = "2021000119688182";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCi8GKzD/Et58/VBfnHsvH4upXlKcasC+00KWFDZ2dd2phLA5X5AMvjJhi/f/XGVEOT/TwoAqIG3R131SXgOkClMk1MNJ/039/WvQx7Ll4m8yFSaKNCHVP3g7TY5iCy+Nv50FbKXcWD5TCVHwYV870N0sOAsNI9zLhA/ce/cmMeKROq48vIULHexif+R/S10fl2KxJNlpxC5z7oKP2Imu93erRxPj//4IObLIOnoapNsf22w1LAi931JNUXgHtiIDbDJNHORPgFYLs8PKxT4XNPO0IAFmtuMf2BV1zlsjpXnIDjuCQgzvN9VYoJMh1DjjMxppc6ELHeVpur+A8NVVaHAgMBAAECggEAMDH8b8yiYRq1TeRjmp8ilZjTJ6KwwkkQ06H9xAs89vTmoSGhZbLHnBuzrEk0MILSLl70QT1uIaubwMtKVcXFQ1fap1TVj3/83K60l2cCsHCwBYkv6Sl1obvSbWm8eFPF9WGbmmYcO0Q6l5FCopGi9QjHjTRAK8l3IrouMEGsccnpi7N8jRCYUtW1bdyVZHoL2lNM17/yh8LCS5B5K+n+FZKPX+6QV/Krk7Ad11OJCs5iM+oViEZvotvP4W7V14+gD8FGl+3EfNVLhatZ84jtTWOkzksV8dycohFRx5otWhb9DaxzGNrmnuu4qNow/afWMt8UL2t4bhwhbz9AiIlwIQKBgQDa3g1n9dCnQrjuclu1rnYaVcZCkHmbLWy9RU0SYDZ4xL+JjaHVf1oLoM53vFvWNsunCqsxxIlwRJQeiJW0nmKp4lW9C9Xu/HpyaAoz45Fu3s8WyTJV0eQhT2Sbn6Eu4nR/va9FwCd8GzUbGaq2c5uquYbRyS7vt74cVFp5iITWsQKBgQC+lTnoXU6yyI5FbK1UPKcg9DeoW4Xo4YkBhQeRdPjtMF2GHDnvQY73aXlnD8T4yN9g+3WEMm6j7FfkCWump8bnuyQEnnShEYoJB9/OLJSE+6evofejtXDxMnAA5tMpYQ1W6dJKeoL/gDSk6iEs5HVvCcU3Y8Jy4VKGPnmt+rE+twKBgQCD/o7PN6xScybchxNQCpsnXrtmwYLVVxvROc41Wtj/FIj/B++ltlwzzxM1mt833WwMnZ6JMSJCFtnNYEoI18xg8CMNE+o9av7dqGkeyguXdcAm2cgFgcO3Yw4l3Kt0fxYLQ/ZEdpJZgn8QjPYreqVS3Pi15ELuRz3cD/NQgEi8wQKBgDMYyUzOb4IpmVNtvs798AU61Q1TdISqq1P3+b568R6OwBRrzvCh0BXvdng2VyYonRNgd/J4nwdeH3ZpPC6TfxW0LAT9AuIIVMz1CoE5nJxG6H+DWmTPCbfxQOxM9sJ6Xdw2loYXcLXWBsdMapahrgaWRQUDvyeT189cQr1toEXjAoGAKE4PUE8RBwnviAECVboFlb1FKCw8FLSJSRCx7s7sMGLK8YI7BUWiE1awLmBdv7NWoHuTMzjjPeFwVbPEQMhxJ4BgOuRqD3WE77X3T6ZdPEx97rxV73F76Yjw98sP4T8znEIrjWc2uhn09E0fJWDt1fs4li+TvnURMLfBLgj3OXo=";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAovBisw/xLefP1QX5x7Lx+LqV5SnGrAvtNClhQ2dnXdqYSwOV+QDL4yYYv3/1xlRDk/08KAKiBt0dd9Ul4DpApTJNTDSf9N/f1r0Mey5eJvMhUmijQh1T94O02OYgsvjb+dBWyl3Fg+UwlR8GFfO9DdLDgLDSPcy4QP3Hv3JjHikTquPLyFCx3sYn/kf0tdH5disSTZacQuc+6Cj9iJrvd3q0cT4//+CDmyyDp6GqTbH9tsNSwIvd9STVF4B7YiA2wyTRzkT4BWC7PDysU+FzTztCABZrbjH9gVdc5bI6V5yA47gkIM7zfVWKCTIdQ44zMaaXOhCx3labq/gPDVVWhwIDAQAB";
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问

	public static String notify_url = "https://localhost:8080/notify";
	/**
	 * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	 */

	public static String return_url = "https://localhost:8080/returnDeal";

	/**
	 * 签名方式
	 */
	public static String SIGN_TYPE = "RSA2";

	/**
	 * 字符编码格式
	 */
	public static String CHARSET = "UTF-8";
	/**
	 * 支付宝网关
	 */
	public static String GATEWAYURL = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String LOG_PATH = "D:\\";

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord 要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(LOG_PATH + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
