package com.shortrent.rest;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.shortrent.error.ShortRentErrorMessage;
import com.shortrent.error.ShortRentException;
import com.shortrent.pojo.Announcement;
import com.shortrent.service.AnnouncementService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/announcement")
public class AnnouncementRestController {
	
	@Autowired
	private AnnouncementService announcementService;
	
	@RequestMapping(value="/announcements",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<Announcement>> findAllAnnouncements(
						@RequestParam(value="start",defaultValue="0",required=false) Integer s,
						@RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<Announcement> announcements = this.announcementService.getAllAnnouncements(s, e);
		return new ResponseEntity<Collection<Announcement>>(announcements,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getcount",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCount(){
		int count = announcementService.getCount();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Announcement> announcementAdd(@Valid @RequestBody Announcement announcement,BindingResult result) throws ShortRentException {
		if(result.hasErrors()) {
			throw new ShortRentException(new ShortRentErrorMessage(101,result.getFieldErrors().get(0).getDefaultMessage()));
		}
		announcementService.addAnnouncement(announcement);;
		return new ResponseEntity<Announcement>(HttpStatus.CREATED);
	}
}
