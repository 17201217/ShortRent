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
import com.shortrent.pojo.User;
import com.shortrent.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserRestController {
    
	@Autowired 
    private UserService userService;
    
	@RequestMapping(value = "/{userid}",method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<User> findById(@PathVariable String userid){
        User user = userService.findUserById(userid);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
	
	@RequestMapping(value="",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<User>> findAll(
							@RequestParam(value="start",defaultValue="0",required=false) Integer s,
							@RequestParam(value="end",defaultValue="10",required=false) Integer e){		
		Collection<User> users = this.userService.getAllUsers(s, e);
		return new ResponseEntity<Collection<User>>(users,HttpStatus.OK);
	}
	
	@RequestMapping(value="/like",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<User>> findbyidlike(@RequestParam("str") String str){		
		Collection<User> users = this.userService.findUserByIdlike(str);
		return new ResponseEntity<Collection<User>>(users,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getcount",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCount(){
		int count = userService.getCount();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST,produces="application/json")
	public ResponseEntity<Integer> update(@RequestBody User user){
		userService.update(user);
		return new ResponseEntity<Integer>(1, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/updpassword",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> updpassword(@RequestParam("user_id") String user_id){
		userService.updpassword(user_id);
		return new ResponseEntity<Integer>(1, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/block",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> block(@RequestParam("user_id") String user_id){
		User user = userService.findUserById(user_id);
		if(user.getIslock() == 1){
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_FOUND);
		}
		userService.block(user_id);
		return new ResponseEntity<Integer>(1, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/unblock",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> unblock(@RequestParam("user_id") String user_id){
		User user = userService.findUserById(user_id);
		if(user.getIslock() == 0){
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_FOUND);
		}
		userService.unblock(user_id);
		return new ResponseEntity<Integer>(1, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/phone/{user_tel}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<User> findByphone(@PathVariable String user_tel){
		User user = userService.findUserByPhone(user_tel);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@RequestMapping(value = "/email/{user_email}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<User> findByemail(@PathVariable String user_email){
		User user = userService.findUserByEmail(user_email);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
}