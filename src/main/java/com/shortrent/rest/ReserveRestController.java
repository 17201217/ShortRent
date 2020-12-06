package com.shortrent.rest;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shortrent.pojo.House;
import com.shortrent.pojo.OrderList;
import com.shortrent.pojo.Reserve;
import com.shortrent.service.ReserveService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/reserve")
public class ReserveRestController {

	@Autowired
	private ReserveService reserveService;

	@RequestMapping(value = "/{userid}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<Reserve>> findall(@PathVariable String userid,
			@RequestParam(value = "start", defaultValue = "0", required = false) Integer s,
			@RequestParam(value = "end", defaultValue = "10", required = false) Integer e) {
		Collection<Reserve> reserves = this.reserveService.getAllReserve(userid, s, e);
		return new ResponseEntity<Collection<Reserve>>(reserves, HttpStatus.OK);
	}

	@RequestMapping(value = "/getcount/{userid}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Integer> getCountbyid(@PathVariable String userid) {
		int count = reserveService.getCountbyid(userid);
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Integer> add(@RequestBody Reserve reserve) {

		this.reserveService.addReservice(reserve);
		return new ResponseEntity<Integer>(1, HttpStatus.CREATED);
	}

	@RequestMapping(value = "res/{userid}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Collection<Reserve>> findall1(@PathVariable String userid,
			@RequestParam(value = "start", defaultValue = "0", required = false) Integer s,
			@RequestParam(value = "end", defaultValue = "10", required = false) Integer e) {
		Collection<Reserve> reserves = this.reserveService.getReserve(userid, s, e);
		return new ResponseEntity<Collection<Reserve>>(reserves, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getcount1/{userid}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Integer> getCountReserve(@PathVariable String userid) {
		int count = reserveService.getCountReserve(userid);
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/check/{reserve_id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<House> reserveUpdateStatus(@PathVariable int reserve_id) {
		reserveService.passReserve(reserve_id);
		return new ResponseEntity<House>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/check2/{reserve_id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<House> reserveUpdateStatus2(@PathVariable int reserve_id) {
		reserveService.noPassReserve(reserve_id);
		return new ResponseEntity<House>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{reserve_id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Reserve> reserveDelete(@PathVariable int reserve_id) {
		reserveService.deleteReserve(reserve_id);
		return new ResponseEntity<Reserve>(HttpStatus.OK);
	}
	
	
}
