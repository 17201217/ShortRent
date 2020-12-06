package com.shortrent.pojo;

public class OrderList {
	
	private Integer order_id;//订单编号
	private String rent_id;//租房者用户名
	private Integer house_id;//房屋编号
	private String order_time;//订单生成日期
	private Integer totalcost;//总费用
	private String starttime;//入住日期



	private String endtime;//退房日期
	private int flag;//订单是否审核

	private int ispay;//订单是否支付
	
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getRent_id() {
		return rent_id;
	}
	public void setRent_id(String rent_id) {
		this.rent_id = rent_id;
	}
	public Integer getHouse_id() {
		return house_id;
	}
	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public Integer getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Integer totalcost) {
		this.totalcost = totalcost;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getIspay() {
		return ispay;
	}
	public void setIspay(int ispay) {
		this.ispay = ispay;
	}
	
	
}
