package com.shortrent.service;

import java.util.Collection;
import java.util.List;

import com.shortrent.pojo.OrderList;
import org.apache.ibatis.annotations.Param;

public interface OrderListService {
			
	void addOrder(OrderList order);//生成订单（增加）
	
	void deleteOrder(int order_id);//删除订单
	
	//审核订单
	void auditOrder(int order_id);
	
	//查询所有未审核的订单信息
	Collection<OrderList> getAllOrders2(int start,int end);
		
	//得到所有未审核的订单数量
	int getCount();
	
	public List<OrderList> getOrderListByid(String user_id, int start, int end);
	
	int getCountbyid(String user_id);

	void updateOrderPay(int order_id);

	//得到所有用户id所有的订单数量没有被支付的
	int getCount2(String user_id);
	//根据用户id查看所有没有支付的订单
	List<OrderList> getOrderListByid2(String user_id,int start,int end);

	int getCount3(String user_id);
	//根据用户id查看所有已经支付的订单
	List<OrderList> getOrderListByid3(String user_id,int start,int end);


}
