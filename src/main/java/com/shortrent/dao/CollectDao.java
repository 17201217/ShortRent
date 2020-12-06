package com.shortrent.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.shortrent.pojo.Collect;
import com.shortrent.pojo.House;

@Mapper
public interface CollectDao {

	List<Collect> getAllCollect();

    List<Collect> getCollectByid(@Param("user_id") String user_id,@Param("start") int start, @Param("end")int end);
    
    //用户的到他收藏的房源数量
    int getCountbyid(String user_id);
	
    //此用户取消房源信息
	int delcollect(@Param("user_id") String user_id,@Param("house_id") int house_id);
	
	
	void addCollect(Collect collect);//收藏房屋 
}
