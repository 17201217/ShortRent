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

import com.shortrent.pojo.OrderList;
import com.shortrent.service.OrderListService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/orderlist")
public class OrderListRestController {
	
	@Autowired
    private OrderListService orderService;
	
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<OrderList> orderAdd(@RequestBody OrderList order) {
		orderService.addOrder(order);
		return new ResponseEntity<OrderList>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{order_id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<OrderList> orderDelete(@PathVariable int order_id) {
		orderService.deleteOrder(order_id);
		return new ResponseEntity<OrderList>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/audit/{order_id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<OrderList> orderAudit(@PathVariable int order_id) {
		orderService.auditOrder(order_id);
		return new ResponseEntity<OrderList>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/orders2",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<OrderList>> findAllHouse2(
						@RequestParam(value="start",defaultValue="0",required=false) Integer s,
						@RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<OrderList> orders = this.orderService.getAllOrders2(s, e);
		return new ResponseEntity<Collection<OrderList>>(orders,HttpStatus.OK);
	}
	
	@RequestMapping(value="/{userid}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<OrderList>> findorderbyid(@PathVariable String userid,
								@RequestParam(value="start",defaultValue="0",required=false) Integer s,
								@RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<OrderList> orders = this.orderService.getOrderListByid(userid, s, e);
		return new ResponseEntity<Collection<OrderList>>(orders,HttpStatus.OK);
	}

	@RequestMapping(value="/notpay/{userid}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<OrderList>> findorderbyid2(@PathVariable String userid,
																@RequestParam(value="start",defaultValue="0",required=false) Integer s,
																@RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<OrderList> orders = this.orderService.getOrderListByid2(userid, s, e);
		return new ResponseEntity<Collection<OrderList>>(orders,HttpStatus.OK);
	}

	@RequestMapping(value="/pay/{userid}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Collection<OrderList>> findorderbyid3(@PathVariable String userid,
															   @RequestParam(value="start",defaultValue="0",required=false) Integer s,
															   @RequestParam(value="end",defaultValue="10",required=false) Integer e){
		Collection<OrderList> orders = this.orderService.getOrderListByid3(userid, s, e);
		return new ResponseEntity<Collection<OrderList>>(orders,HttpStatus.OK);
	}

	
	@RequestMapping(value="/getcount",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCount(){
		int count = orderService.getCount();
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getcount/{userid}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCountbyid(@PathVariable String userid){
		int count = orderService.getCountbyid(userid);
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}

	@RequestMapping(value="/getcount2/{userid}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCountbyid2(@PathVariable String userid){
		int count = orderService.getCount2(userid);
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}

	@RequestMapping(value="/getcount3/{userid}",method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Integer> getCountbyid3(@PathVariable String userid){
		int count = orderService.getCount3(userid);
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}


	@RequestMapping(value = "/audit2/{order_id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<OrderList> orderAudit2(@PathVariable int order_id) {
		orderService.updateOrderPay(order_id);
		return new ResponseEntity<OrderList>(HttpStatus.OK);
	}
}
