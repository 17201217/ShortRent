package com.shortrent.serviceImpl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shortrent.dao.OrderListDao;
import com.shortrent.pojo.OrderList;
import com.shortrent.service.OrderListService;

@Service
public class OrderListServiceImpl implements OrderListService{
	
	@Autowired  
    private OrderListDao orderDao;  

	public int getCount() {
		return orderDao.getCount();
	}

	public int getCountbyid(String user_id) {
		return orderDao.getCountbyid(user_id);
	}

	@Override
	public void updateOrderPay(int order_id) {
		orderDao.updateOrderPay(order_id);
	}

	@Override
	public int getCount2(String user_id) {
		return orderDao.getCount2(user_id);
	}


	@Override
	public List<OrderList> getOrderListByid2(String user_id, int start, int end) {
		return orderDao.getOrderListByid2(user_id, start, end);
	}

	@Override
	public int getCount3(String user_id) {
		return orderDao.getCount3(user_id);
	}


	@Override
	public List<OrderList> getOrderListByid3(String user_id, int start, int end) {
		return orderDao.getOrderListByid3(user_id, start, end);
	}

	public List<OrderList> getOrderListByid(String user_id, int start, int end) {
		return orderDao.getOrderListByid(user_id, start, end);
	}

	public void addOrder(OrderList order) {
		orderDao.addOrder(order);
	}

	public void deleteOrder(int order_id) {
		orderDao.deleteOrder(order_id);
	}

	public void auditOrder(int order_id) {
		orderDao.auditOrder(order_id);
	}

	public Collection<OrderList> getAllOrders2(int start, int end) {
		return orderDao.getAllOrders2(start, end);
	}

	

}
