package com.shortrent.rest;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shortrent.error.ShortRentErrorMessage;
import com.shortrent.error.ShortRentException;
import com.shortrent.pojo.House;
import com.shortrent.service.HouseService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/house")
public class HouseRestController {

	@Autowired
	private HouseService houseService;

	@RequestMapping(value = "/houseList", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<House>> getAllHouses() {
		Collection<House> houses = houseService.getAllHouses();

		return new ResponseEntity<Collection<House>>(houses, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/simpleHouseList", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<House>> getAllSimpleHouses() {
		Collection<House> houses = houseService.getAllSimpleHouses();
		return new ResponseEntity<Collection<House>>(houses, HttpStatus.OK);
	}

	@RequestMapping(value = "/houseList0", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<House>> getHousesByPrice(int price1,int price2) {
		Collection<House> houses = houseService.getHousesByPrice(price1, price2);
		return new ResponseEntity<Collection<House>>(houses, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/houseList1", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<House>> getHousesBySize(int size1,int size2) {
		Collection<House> houses = houseService.getHousesBySize(size1, size2);
		
		return new ResponseEntity<Collection<House>>(houses, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/houseList2", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<House>> getHousesByName(String name) {
		Collection<House> houses = houseService.getHousesByName(name);	
		return new ResponseEntity<Collection<House>>(houses, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/houseList3", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<House>> getHousesByType(String type) {
		Collection<House> houses = houseService.getHousesByType(type);	
		return new ResponseEntity<Collection<House>>(houses, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/houseList4", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<House>> getHousesByLocate(String locate) {
		Collection<House> houses = houseService.getHousesByLocate(locate);	
		return new ResponseEntity<Collection<House>>(houses, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value = "/houseList5", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<House>> userScreenHouse(String locate,Integer price1,Integer price2,Integer size1,Integer size2,String type,String descorasc) {
		Collection<House> houses = houseService.userScreenHouse(locate, price1, price2, size1, size2, type,descorasc);
		return new ResponseEntity<Collection<House>>(houses, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/houseList6", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<House>> vagueHouse(String inputParam) {
		Collection<House> houses = houseService.vagueHouse(inputParam);
		return new ResponseEntity<Collection<House>>(houses, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value = "/onehouse", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<House> getHousesById(int house_id) {
		House house = houseService.getHouseById(house_id);
		
		return new ResponseEntity<House>(house, HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<House> housesAdd(@Valid @RequestBody House house,BindingResult result) throws ShortRentException {
		if(result.hasErrors()) {
			throw new ShortRentException(new ShortRentErrorMessage(101,result.getFieldErrors().get(0).getDefaultMessage()));
		}
		houseService.addHouse(house);
		return new ResponseEntity<House>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<House> houseUpdate(@Valid @RequestBody House house,BindingResult result) throws ShortRentException {
		if(result.hasErrors()) {
			throw new ShortRentException(new ShortRentErrorMessage(101,result.getFieldErrors().get(0).getDefaultMessage()));
		}
		houseService.updateHouse(house);
		return new ResponseEntity<House>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{house_id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<House> houseDelete(@PathVariable int house_id) {
		houseService.deleteHouse(house_id);
		return new ResponseEntity<House>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/release/{house_id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<House> houseUpdateOnline(@PathVariable int house_id) {
		houseService.releaseHouse(house_id);
		return new ResponseEntity<House>(HttpStatus.OK);
	}
	

	@RequestMapping(value = "/offshelfhouse/{house_id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<House> houseUpdateXiajia(@PathVariable Integer house_id) {
		houseService.offTheShelfHouse(house_id);
		return new ResponseEntity<House>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rent/{house_id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<House> houseUpdateRent(@PathVariable int house_id) {
		houseService.rentHouse(house_id);
		return new ResponseEntity<House>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/notrent/{house_id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<House> houseUpdateNotRent(@PathVariable int house_id) {
		houseService.notRentHouse(house_id);
		return new ResponseEntity<House>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order/{house_id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<House> houseUpdateOrder(@PathVariable int house_id) {
		houseService.orderHouse(house_id);
		return new ResponseEntity<House>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/notorder/{house_id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<House> houseUpdateNotOrder(@PathVariable int house_id) {
		houseService.notOrderHouse(house_id);
		return new ResponseEntity<House>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{house_id}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<House> getPatient(@PathVariable int house_id){
		House house = houseService.getHouseById(house_id);
		if(house == null)
			return new ResponseEntity<House>(house,HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<House>(house,HttpStatus.OK);
	}
	
	@RequestMapping(value="/allnotrelease",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<House>> findAllNotReleaseHouse(
						@RequestParam(value="start",defaultValue="0",required=false) Integer s,
						@RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<House> houses = this.houseService.getAllNotReleaseHouses(s, e);
		return new ResponseEntity<Collection<House>>(houses,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getcount",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCount(){
		int count = houseService.getCount();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@RequestMapping(value="/allhouse2",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<House>> findAllHouse2(
						@RequestParam(value="start",defaultValue="0",required=false) Integer s,
						@RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<House> houses = this.houseService.getAllHouses2(s, e);
		return new ResponseEntity<Collection<House>>(houses,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getcount2",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCount2(){
		int count = houseService.getCount2();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@RequestMapping(value="/allhouseuserid",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<House>> getAllUserCreateHousesByUserId(@RequestParam(value="user_id",required=false) String user_id,
						@RequestParam(value="start",defaultValue="0",required=false) Integer s,
						@RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<House> houses = this.houseService.getAllUserCreateHousesByUserId(user_id, s, e);
		return new ResponseEntity<Collection<House>>(houses,HttpStatus.OK);
	}
	
	

	@RequestMapping(value="/allhouserentuserid",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<House>> getAllUserRentHousesByUserId(@RequestParam(value="user_id",required=false) String user_id,
						@RequestParam(value="start",defaultValue="0",required=false) Integer s,
						@RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<House> houses = this.houseService.getAllUserRentHousesByUserId(user_id,s, e);
		return new ResponseEntity<Collection<House>>(houses,HttpStatus.OK);
	}
	
	@RequestMapping(value="/allhousereleaseid",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<House>> getAllUserReleaseHousesByUserId(@RequestParam(value="user_id",required=false) String user_id,
						@RequestParam(value="start",defaultValue="0",required=false) Integer s,
						@RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<House> houses = this.houseService.getAllUserReleaseHousesByUserId(user_id, s, e);
		return new ResponseEntity<Collection<House>>(houses,HttpStatus.OK);
	}

	@RequestMapping(value="/getcount3",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCount1(String user_id){
		int count = houseService.getCount3(user_id);
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getcount4",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCount2(String user_id){
		int count = houseService.getCount4(user_id);
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getcount5",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCount3(String user_id){
		int count = houseService.getCount5(user_id);
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
}
