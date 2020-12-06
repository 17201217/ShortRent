package com.shortrent.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shortrent.pojo.House;
import com.shortrent.pojo.Reserve;

@Mapper
public interface ReserveDao {
	
	//根据用户id得到预约数量
    int getCountbyid(String user_id);
    //根据用户id得到所有预约记录
    List<Reserve> getAllReserve(@Param("user_id") String user_id,@Param("start") int start, @Param("end")int end);
	  
    void addReserve(Reserve reserve);//增加一条预约记录
    
    
    int getCountReserve(String user_id);//得到数量
    
    //商户查询预约订单，进行审核
    List<Reserve> getReserve(@Param("user_id") String user_id,@Param("start") int start, @Param("end")int end);
    
    //预约审核通过
    void passReserve(@Param("reserve_id") Integer reserve_id);//发布房屋
    
    //预约审核不通过
    void noPassReserve(@Param("reserve_id") Integer reserve_id);//发布房屋
    
  //删除订单
  	void deleteReserve(@Param("reserve_id") Integer reserve_id);
  	
  	
}
