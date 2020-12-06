package com.shortrent.dao;

import java.util.Collection;
import java.util.List;

import com.shortrent.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.shortrent.pojo.OrderList;

@Mapper
public interface OrderListDao {
	
	void addOrder(OrderList order);
	
	//删除订单
	void deleteOrder(@Param("order_id") int order_id);
	
	//审核订单
	void auditOrder(@Param("order_id") int order_id);
	
	//查询所有未审核的订单信息
	Collection<OrderList> getAllOrders2(@Param("start") int start, @Param("end")int end);
	
	//得到所有未审核的订单数量
    int getCount();
    
    //根据用户id查看所有的订单
    List<OrderList> getOrderListByid(@Param("user_id") String user_id,@Param("start") int start, @Param("end")int end);
    
    //得到用户id所有的订单数量
    int getCountbyid(String user_id);

	//根据订单id修改订单为支付状态
	void updateOrderPay(@Param("order_id") int order_id);


	//得到所有用户id所有的订单数量没有被支付的
	int getCount2(String user_id);
	//根据用户id查看所有没有支付的订单
	List<OrderList> getOrderListByid2(@Param("user_id") String user_id,@Param("start") int start, @Param("end")int end);


	int getCount3(String user_id);
	//根据用户id查看所有已经支付的订单
	List<OrderList> getOrderListByid3(@Param("user_id") String user_id,@Param("start") int start, @Param("end")int end);
}
