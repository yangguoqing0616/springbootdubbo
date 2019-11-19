package com.atbeijing.controller;

import com.gmall.beans.UserAddress;
import com.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/getAddre")
    public List<UserAddress> initOrderCtl(@RequestParam("uid") String userId){
        return orderService.initOrder(userId);
    }
}
