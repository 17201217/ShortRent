package com.shortrent.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shortrent.dao.ReserveDao;
import com.shortrent.pojo.Reserve;
import com.shortrent.service.ReserveService;

@Service
public class ReserveServiceImpl implements ReserveService{
	
	@Autowired  
    private ReserveDao reserveDao;  
	
	@Override
	public int getCountbyid(String user_id) {
		return reserveDao.getCountbyid(user_id);
	}

	@Override
	public List<Reserve> getAllReserve(String user_id, int start, int end) {
		return reserveDao.getAllReserve(user_id, start, end);
	}

	@Override
	public void addReservice(Reserve reserve) {		
		reserveDao.addReserve(reserve);
		
	}

	@Override
	public List<Reserve> getReserve(String user_id, int start, int end) {		
		return reserveDao.getReserve(user_id, start, end);
	}

	@Override
	public int getCountReserve(String user_id) {		
		return reserveDao.getCountReserve(user_id);
	}

	@Override
	public void passReserve(int reserve_id) {
		 reserveDao.passReserve(reserve_id);		
	}

	@Override
	public void noPassReserve(int reserve_id) {
		reserveDao.noPassReserve(reserve_id);		
	}

	@Override
	public void deleteReserve(int reserve_id) {
		reserveDao.deleteReserve(reserve_id);
	}
	
}
