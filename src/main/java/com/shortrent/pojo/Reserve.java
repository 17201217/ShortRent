package com.shortrent.pojo;

public class Reserve {
	
	private Integer reserve_id;//预约编号	，自动生成
	private String user_id;//用户编号
	private Integer house_id;//房屋编号
	private String reserve_time;//预约时间
	private Integer status;
	
	public Integer getReserve_id() {
		return reserve_id;
	}
	
	public void setReserve_id(Integer reserve_id) {
		this.reserve_id = reserve_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getHouse_id() {
		return house_id;
	}
	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}
	public String getReserve_time() {
		return reserve_time;
	}
	public void setReserve_time(String reserve_time) {
		this.reserve_time = reserve_time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
