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
import com.shortrent.pojo.Collect;
import com.shortrent.pojo.House;
import com.shortrent.service.CollectService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/collect")
public class CollectRestController {
	
	@Autowired
    private CollectService collectService;
	
	@RequestMapping(value="",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<Collect>> findAllcollect(){
		Collection<Collect> collects = this.collectService.getAllCollect();
		return new ResponseEntity<Collection<Collect>>(collects,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{userid}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<Collect>> findorderbyid(@PathVariable String userid,
								@RequestParam(value="start",defaultValue="0",required=false) Integer s,
								@RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<Collect> collects = this.collectService.getCollectByid(userid, s, e);
		return new ResponseEntity<Collection<Collect>>(collects,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getcount/{userid}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCountbyid(@PathVariable String userid){
		int count = collectService.getCountbyid(userid);
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete",method = RequestMethod.DELETE,produces="application/json")
	public ResponseEntity<Integer> delcollect(@RequestParam("user_id") String user_id,
											@RequestParam("house_id") int house_id){

		int count = collectService.delcollect(user_id, house_id);
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Collect> housesAdd(@RequestBody Collect collect)  {
		
		collectService.addCollect(collect);
		return new ResponseEntity<Collect>(HttpStatus.CREATED);
	}
}
