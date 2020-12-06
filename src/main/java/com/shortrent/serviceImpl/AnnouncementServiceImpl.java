package com.shortrent.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shortrent.dao.AnnouncementDao;
import com.shortrent.pojo.Announcement;
import com.shortrent.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	
	@Autowired
	private AnnouncementDao announcementDao;
	
	public Collection<Announcement> getAllAnnouncements(int start, int end) {
		return announcementDao.getAllAnnouncements(start, end);
	}

	public int getCount() {
		return announcementDao.getCount();
	}

	public void addAnnouncement(Announcement announcement) {
		announcementDao.addAnnouncement(announcement);
	}

}
