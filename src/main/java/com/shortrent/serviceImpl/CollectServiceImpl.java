package com.shortrent.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shortrent.dao.CollectDao;
import com.shortrent.pojo.Collect;
import com.shortrent.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService{
	
	@Autowired  
    private CollectDao collectDao;  
	
	public List<Collect> getAllCollect() {
		return collectDao.getAllCollect();
	}

	public int getCountbyid(String user_id) {
		return collectDao.getCountbyid(user_id);
	}

	public List<Collect> getCollectByid(String user_id, int start, int end) {
		return collectDao.getCollectByid(user_id, start, end);
	}

	public int delcollect(String user_id, int house_id) {
		return collectDao.delcollect(user_id, house_id);
	}

	@Override
	public void addCollect(Collect collect) {
		collectDao.addCollect(collect);
	}

}
