package com.shortrent.service;

import java.util.Collection;

import com.shortrent.pojo.Announcement;

public interface AnnouncementService {

	//查询所有公告信息
	Collection<Announcement> getAllAnnouncements(int start,int end);
		
	//得到所有公告数量
	int getCount();
	    
	//发布公告
	void addAnnouncement(Announcement announcement);
}
