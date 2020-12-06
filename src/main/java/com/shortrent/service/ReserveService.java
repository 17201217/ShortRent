package com.shortrent.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shortrent.pojo.House;
import com.shortrent.pojo.Reserve;

public interface ReserveService {
	
    int getCountbyid(String user_id);
    
    List<Reserve> getAllReserve(String user_id, int start, int end);
    
    void addReservice(Reserve reserve);
    
    int getCountReserve(String user_id);//得到数量
    
    List<Reserve> getReserve(String user_id, int start, int end);
    
    void passReserve(int reserve_id);
    
    void noPassReserve(int reserve_id);
    
    void deleteReserve(int reserve_id);
    
}
