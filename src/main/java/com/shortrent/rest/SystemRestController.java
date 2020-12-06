package com.shortrent.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shortrent.pojo.User;
import com.shortrent.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/system")
public class SystemRestController {
    
	@Autowired 
    private UserService userService;
    
	@RequestMapping(value="/registered",method = RequestMethod.POST,produces="application/json")
	public ResponseEntity<Integer> add(@RequestBody User user){
		User u = userService.findUserById(user.getUser_id());
		User u2 = userService.findUserByEmail(user.getUser_email());
		User u3 = userService.findUserByPhone(user.getUser_tel());
		if(u != null || u2 != null || u3 != null){
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_FOUND);
		}
		
		this.userService.add(user);
		return new ResponseEntity<Integer>(1, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST,produces="application/json")
	public ResponseEntity<Integer> login(@RequestParam("user_id") String user_id,
										 @RequestParam("user_password") String user_password){
		User user = userService.findUserById(user_id);
		if(user == null || user.getIslock() == 1 || !user_password.equals(user.getUser_password())){			
			return new ResponseEntity<Integer>(0,HttpStatus.NOT_FOUND);
		}
		int flag = user.getCategory();
			
		return new ResponseEntity<Integer>(flag,HttpStatus.OK);
	}
	
	@RequestMapping(value="/changepwd",method = RequestMethod.POST,produces="application/json")
	public ResponseEntity<Integer> changepwd(@RequestParam("user_id") String user_id,
										 	 @RequestParam("user_password") String user_password){
		User user = userService.findUserById(user_id);
		if(user == null || user.getIslock() == 1){
			return new ResponseEntity<Integer>(0,HttpStatus.NOT_FOUND);
		}
		
		User u = new User();
		u.setUser_id(user_id);
		u.setUser_password(user_password);
		userService.update(u);
		return new ResponseEntity<Integer>(1,HttpStatus.OK);
	}
	
	
}