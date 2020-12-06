package com.shortrent.pojo;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Announcement {

	private int anno_id;//公告编号，自增
	
	@NotBlank(message = "公告内容不能为空")
	private String message;//公告内容
	
	@JsonFormat(locale="zh", pattern="yyyy-MM-dd HH:mm:ss")
	private Date anno_time;//公告时间
	
	public int getAnno_id() {
		return anno_id;
	}
	public void setAnno_id(int anno_id) {
		this.anno_id = anno_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getAnno_date() {
		return anno_time;
	}
	public void setAnno_date(Date anno_time) {
		this.anno_time = anno_time;
	}
	
	
}
