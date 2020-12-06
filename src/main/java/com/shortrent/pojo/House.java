package com.shortrent.pojo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class House {

	private int house_id;// 房屋编号
	private String user_id;// 房东编号
	
	@NotBlank(message = "房屋名不能为空")
	@Length(message = "房屋名最长为{max}个字符", max = 40)
	private String house_name;// 房屋名
	
	@NotBlank(message = "房屋类型不能为空")
	@Length(message = "房屋类型最长为{max}个字符", max = 20)
	private String type;// 房屋类型
	
	@DecimalMin(value = "10",message = "房屋大小最低为10m²")
	private int size;// 房屋大小
	
	@DecimalMin(value = "1",message = "房屋价格最低为1元")
	private int house_price;// 房屋价格
	
	@NotBlank(message = "房屋图片不能为空")
	@Length(message = "房屋图片名字最长为{max}个字符", max = 40)
	private String photo;// 房子图片
	
	private int online;// 房屋是否发布 0未发布，1发布
	private int status;// 房屋是否出租 0未出租，1已出租
	
	@NotBlank(message = "房屋位置不能为空")
	@Length(message = "房屋位置最长为{max}个字符", max = 40)
	private String locate;// 房屋位置
	
	private int flag;// 房屋是否被预约 0未预约，1已预约
	
	@NotBlank(message = "房屋描述不能为空")
	@Length(message = "房屋描述最长为{max}个字符", max = 100)
	private String description;// 房屋描述
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getHouse_name() {
		return house_name;
	}
	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getHouse_price() {
		return house_price;
	}
	public void setHouse_price(int house_price) {
		this.house_price = house_price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
