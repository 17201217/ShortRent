package com.shortrent.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shortrent.dao.HouseDao;
import com.shortrent.pojo.House;
import com.shortrent.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDao houseDao;
	public Collection<House> getAllHouses() {
		return houseDao.getAllHouses();
	}
	public House getHouseById(int house_id) {
		return houseDao.getHouseById(house_id);
	}
	public Collection<House> getHousesByLocate(String locate) {
		return houseDao.getHousesByLocate(locate);
	}
	public Collection<House> getHousesByName(String name) {
		return houseDao.getHousesByName(name);
	}
	public Collection<House> getHousesByType(String type) {
		return houseDao.getHousesByType(type);
	}
	public Collection<House> getHousesBySize(int size1, int size2) {
		return houseDao.getHousesBySize(size1, size2);
	}
	public Collection<House> getHousesByPrice(int price1, int price2) {
		return houseDao.getHousesByPrice(price1, price2);
	}
	public void addHouse(House house) {
		houseDao.addHouse(house);
	}
	public void releaseHouse(int house_id) {
		houseDao.releaseHouse(house_id);
	}
	
	public void deleteHouse(int house_id) {
		houseDao.deleteHouse(house_id);		
	}
	public void updateHouse(House house) {
		houseDao.updateHouse(house);
	}
	public void rentHouse(int house_id) {
		houseDao.rentHouse(house_id);
	}
	public void notRentHouse(int house_id) {
		houseDao.notRentHouse(house_id);
	}
	public void orderHouse(int house_id) {
		houseDao.orderHouse(house_id);
	}
	public void notOrderHouse(int house_id) {
		houseDao.notOrderHouse(house_id);
	}
	public Collection<House> getAllSimpleHouses() {
		// TODO Auto-generated method stub
		return houseDao.getAllSimpleHouses();
	}
	public Collection<House> userScreenHouse(String locate, Integer price1, Integer price2, Integer size1, Integer size2, String type,String descorasc) {
		// TODO Auto-generated method stub
		return houseDao.userScreenHouse(locate, price1, price2, size1, size2, type,descorasc);
	}
	public Collection<House> vagueHouse(String inputParam) {
		// TODO Auto-generated method stub
		return houseDao.vagueHouse(inputParam);
	}
	
	public Collection<House> getAllNotReleaseHouses(int start, int end) {
		return houseDao.getAllNotReleaseHouses(start, end);
	}
	
	public int getCount() {
		return houseDao.getCount();
	}
	
	public Collection<House> getAllHouses2(int start, int end) {
		return houseDao.getAllHouses2(start, end);
	}
	public int getCount2() {
		return houseDao.getCount2();
	}
	@Override
	public void offTheShelfHouse(Integer house_id) {
		houseDao.offTheShelfHouse(house_id);
		
	}
	@Override
	public Collection<House> getAllUserCreateHousesByUserId(String user_id, int start, int end) {
		// TODO Auto-generated method stub
		return houseDao.getAllUserCreateHousesByUserId(user_id, start, end);
	}
	@Override
	public Collection<House> getAllUserRentHousesByUserId(String user_id, int start, int end) {
		// TODO Auto-generated method stub
		return houseDao.getAllUserRentHousesByUserId(user_id, start, end);
	}
	@Override
	public Collection<House> getAllUserReleaseHousesByUserId(String user_id, int start, int end) {
		// TODO Auto-generated method stub
		return houseDao.getAllUserReleaseHousesByUserId(user_id, start, end);
	}
	@Override
	public int getCount3(String user_id) {
		// TODO Auto-generated method stub
		return houseDao.getCount3(user_id);
	}
	@Override
	public int getCount4(String user_id) {
		// TODO Auto-generated method stub
		return houseDao.getCount4(user_id);
	}
	@Override
	public int getCount5(String user_id) {
		// TODO Auto-generated method stub
		return houseDao.getCount5(user_id);
	}
}

