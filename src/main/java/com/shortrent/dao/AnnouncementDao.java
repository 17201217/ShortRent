package com.shortrent.dao;

import java.util.Collection;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shortrent.pojo.Announcement;

@Mapper
public interface AnnouncementDao {

	//查询所有公告信息
	Collection<Announcement> getAllAnnouncements(@Param("start") int start, @Param("end")int end);
	
	//得到所有公告数量
    int getCount();
    
    //发布公告
    void addAnnouncement(Announcement announcement);
}
