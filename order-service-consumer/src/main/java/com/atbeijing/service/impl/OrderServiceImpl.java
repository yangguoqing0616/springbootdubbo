package com.atbeijing.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.gmall.beans.UserAddress;
import com.gmall.service.OrderService;
import com.gmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

	@Reference(loadbalance = "roundrobin")//设置轮训方式,还可以用url属性设置dubbo直连
	UserService userService;
	@Override
	public List<UserAddress> initOrder(String userId) {
		// TODO Auto-generated method stub
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		for (UserAddress userAddress : addressList) {
			System.out.println(userAddress.getUserAddress());
		}
		return addressList;
	}
	
	

}
