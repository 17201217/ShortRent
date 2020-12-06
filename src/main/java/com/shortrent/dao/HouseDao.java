package com.shortrent.dao;

import java.util.Collection;

import com.shortrent.vo.HouseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shortrent.pojo.House;

@Mapper
public interface HouseDao {
	
	Collection<House> getAllHouses();//查询出所有的房屋信息
	Collection<House> getAllSimpleHouses();////筛选房屋信息，已经发布没有被出租的房子
	House getHouseById(@Param("house_id") Integer house_id);//根据房屋编号找到房屋信息
	Collection<House> getHousesByLocate(@Param("locate") String locate);//根据位置找出所有房屋集合
	Collection<House> getHousesByName(@Param("name") String name);//根据房屋名称查找房屋
	Collection<House> getHousesByType(@Param("type") String type);//根据类型查找房屋
	Collection<House> getHousesBySize(@Param("size1") Integer size1,@Param("size2") Integer size2);//根据大小区间查找房屋
	Collection<House> getHousesByPrice(@Param("price1") Integer price1, @Param("price2") Integer price2);//根据价格区间查找房屋
	void addHouse(House house);//创建房屋
	void releaseHouse(@Param("house_id") Integer house_id);//发布房屋
	void offTheShelfHouse(@Param("house_id") Integer house_id);//下架房屋
	void deleteHouse(@Param("house_id") Integer house_id);//删除房屋
	void updateHouse(House house);//修改房屋信息
	void rentHouse(@Param("house_id") Integer house_id);//出租房屋
	void notRentHouse(@Param("house_id") Integer house_id);//退租房屋
	void orderHouse(@Param("house_id") Integer house_id);//预约房屋
	void notOrderHouse(@Param("house_id") Integer house_id);//取消预约房屋
	
	//查询所有用户提供筛选信息的房屋,分别为位置，价格区间，大小区间以及房屋类型
	Collection<House> userScreenHouse(@Param("locate") String locate,@Param("price1") Integer price1, @Param("price2") Integer price2,@Param("size1") Integer size1,@Param("size2") Integer size2,@Param("type") String type,@Param("descorasc") String descorasc);
	
	//输入框模糊查询，不管输入什么模糊查询出所有东西
	Collection<House> vagueHouse(@Param("inputParam") String inputParam);
	
	//查询所有未发布的房屋信息
	Collection<House> getAllNotReleaseHouses(@Param("start") int start, @Param("end")int end);
	
	//得到所有未发布的房屋数量
    int getCount();
    
    //查询所有未被出租且未被预约的房屋信息
     Collection<House> getAllHouses2(@Param("start") int start, @Param("end")int end);
     
    //得到所有未被出租且未被预约的房屋数量
     int getCount2();
     
   //得到该用户所有创建的房屋信息
 	Collection<House> getAllUserCreateHousesByUserId(@Param("user_id") String user_id,@Param("start") int start, @Param("end")int end);
 	//得到该用户所有创建房屋的数量
 	int getCount3(@Param("user_id") String user_id);
     
    //得到该用户所创造的没有出租的房屋信息，查询出来便于修改
    Collection<House> getAllUserRentHousesByUserId(@Param("user_id") String user_id,@Param("start") int start, @Param("end")int end);
    int getCount4(@Param("user_id") String user_id);
     
    //得到该用户已经发布的房屋信息
    Collection<House> getAllUserReleaseHousesByUserId(@Param("user_id") String user_id,@Param("start") int start, @Param("end")int end);
    int getCount5(@Param("user_id") String user_id);//得到数量
     



}
