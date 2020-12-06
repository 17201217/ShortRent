package com.shortrent.service;

import java.util.List;

import com.shortrent.pojo.Collect;
import com.shortrent.pojo.House;
	
public interface CollectService {
	
	public List<Collect> getAllCollect();
	
	List<Collect> getCollectByid(String user_id, int start, int end);
	
	public int getCountbyid(String user_id);
	
	public int delcollect(String user_id, int house_id);
	
	public void addCollect(Collect collect);
}
