package com.shortrent.service;

import java.util.Collection;

import com.shortrent.pojo.House;

public interface HouseService {
	public Collection<House> getAllHouses();
	public Collection<House> getAllSimpleHouses();
	Collection<House> vagueHouse(String inputParam);
	Collection<House> userScreenHouse(String locate,Integer price1,Integer price2,Integer size1,Integer size2,String type,String descorasc);
	House getHouseById(int house_id);	
	Collection<House> getHousesByLocate(String locate);
	Collection<House> getHousesByName(String name);
	Collection<House> getHousesByType(String type);
	Collection<House> getHousesBySize(int size1,int size2);
	Collection<House> getHousesByPrice(int price1,int price2);
	void addHouse(House house);
	void releaseHouse(int house_id);
	void offTheShelfHouse(Integer house_id);//下架房屋
	void deleteHouse(int house_id);
	void updateHouse(House house);
	void rentHouse(int house_id);
	void notRentHouse(int house_id);
	void orderHouse(int house_id);
	void notOrderHouse(int house_id);
	Collection<House> getAllNotReleaseHouses(int start,int end);
	int getCount();	
	//查询所有未发布的房屋信息
	Collection<House> getAllHouses2(int start,int end);
	//查询未发布的房屋数量
	int getCount2();	
	//得到该用户所创建的所有房屋列表根据用户id（包括出租的与已出租的）
	Collection<House> getAllUserCreateHousesByUserId(String user_id,int start,int end);			
	//得到该用户所创建的所有未出租房屋列表根据用户id
	Collection<House> getAllUserRentHousesByUserId(String user_id,int start,int end);
	//得到该用户所创建的已经发布的房屋信息
	Collection<House> getAllUserReleaseHousesByUserId(String user_id,int start,int end);	
	int getCount3(String user_id);
	//根据该用户查看所有创建的存在数据库没有被删除的数量
	int getCount4(String user_id);
	//根据该用户查看该用户已经发布的房屋数量
	int getCount5(String user_id);
	
}

