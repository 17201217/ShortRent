package com.shortrent.web;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shortrent.config.WebConfig;

@Controller
public class ShortRentController {

	
	//private String filePath="./src/main/resources/static/img/rent-img/";
	
	 //注解获取配置文件本地存储的绝对地址
    @Value("${filePath}")
    private String filePath;
	
	@RequestMapping("/upload")
	@ResponseBody
	public void uploading(MultipartFile file, Model model) {
		String url = WebConfig.Path + file.getOriginalFilename();

		System.out.println(file.getOriginalFilename());
		try {
			uploadFile(file.getBytes(), file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("url", url);
	}

	private void uploadFile(byte[] filebyte, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(filebyte);
		out.flush();
		out.close();
	}

	//system=======================
	//主页
	@GetMapping("/")
	public String welcome(@RequestParam(value = "user_id", required = false) String user_id,
			HttpServletRequest request) {
		request.getSession().setAttribute("user_id", user_id);
		return "system/welcome";
	}

	//登陆
	@GetMapping("/login")
	public String login() {
		return "system/login";
	}

	//注册
	@GetMapping("/registered")
	public String registered() {
		return "system/registered";
	}

	//房屋详情
	@GetMapping("/houseDetail")
	public String houseDetail(@RequestParam(value = "house_id", required = false) String house_id,
							  HttpServletRequest request) {
		return "system/houseDetail";
	}

	//改密
	@GetMapping("/changepwd")
	public String changepwd() {
		return "system/changepwd";
	}

	//支付成功
	@GetMapping("/paysuc")
	public String paysuc() {
		return "system/paysuccess";
	}

	//用户==============================
	//主页-个人中心
	@RequestMapping("/user")
	public String user(HttpServletRequest request) {
		if(request.getSession().getAttribute("user_id") == null){
			return "system/login";
		}
		return "user/index";
	}

	//修改信息
	@GetMapping("/update")
	public String update() {
		return "user/myinfo";
	}

	//我的订单--未支付订单
	@GetMapping("/myorder")
	public String myorder() {
		return "user/myorder";
	}

	//我的订单--已支付订单
	@GetMapping("/myorder2")
	public String myorder2() {
		return "user/myorder2";
	}

	//我的收藏
	@GetMapping("/mycollect")
	public String mycollect() {
		return "user/mycollect";
	}

	//我的预约
	@GetMapping("/myreserve")
	public String myreserve() {
		return "user/myreserve";
	}

	//我的通知
	@GetMapping("/myanno")
	public String myanno() {
		return "user/myanno";
	}


	//租户===================================
	//主页
	@RequestMapping("/landlord")
	public String llindex(@RequestParam("ll_id") String ll_id, HttpServletRequest request) {
		request.getSession().setAttribute("ll_id", ll_id);
		return "landlord/index";
	}

	//房屋列表-landlordhouselist
	@GetMapping("/llhl")
	public String landlordhouselist() {
		return "landlord/llhouselist";
	}

	//创建房屋-landlordhouseadd
	@GetMapping("/llha")
	public String landlordhouseadd() {
		return "landlord/llhouseadd";
	}

	//修改房屋列表页面-landlordhouseupdatelist
	@GetMapping("/llhul")
	public String landlordhouseupdatelist() {
		return "landlord/llhouseupdlist";
	}

	//房屋下架-landlordhouseoffshelf
	@GetMapping("/llhos")
	public String landlordhouseoffshelf() {
		return "landlord/llhouseoffshelf";
	}

	//预约审核页面-landlordreservecheck
	@GetMapping("/llrc")
	public String landlordreservecheck() {
		return "landlord/llreservecheck";
	}

	//修改房屋信息
	@GetMapping("/llupdate")
	public String llupdate() {
		return "landlord/llhouseupdate";
	}

	//查看图片
	@GetMapping("/photobyid")
	public String photobyid(@RequestParam("src") String src, Model model) {
		model.addAttribute("src", src);
		return "landlord/photo";
	}

	//管理员=============================
	//主页
	@RequestMapping("/admin")
	public String admin() {
		return "ad/index";
	}

	//用户管理
	@RequestMapping("/aduserm")
	public String aduserm() {
		return "ad/aduserm";
	}

	//公告
	@RequestMapping("/adannom")
	public String adannom() {
		return "ad/adannom";
	}

	//订单审核
	@RequestMapping("/adoc")
	public String adoc() {
		return "ad/adordercheck";
	}

	//房屋发布
	@RequestMapping("/adhp")
	String adhp() {
		return "ad/adhousepub";
	}

	//房屋删除
	@RequestMapping("/adhd")
	public String adhd() {
		return "ad/adhousedel";
	}

	//管理员查询
	@RequestMapping("/aduf")
	public String aduf() {
		return "ad/aduserfind";
	}

	//柱状图
	@GetMapping("/sumtype")
	public String sumType() {
		return "ad/bar";
	}

	//饼状图
	@GetMapping("/sumtype2")
	public String sumType2() {
		return "ad/pie";
	}
}
