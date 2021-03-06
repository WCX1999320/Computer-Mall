package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IOrderService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController{
    @Autowired
    private IOrderService orderService;
    @PostMapping("")
    public JsonResult<Order> create(Integer aid,Integer [] cids,HttpSession session){
        Order data=orderService.create(aid,cids,getUidFromSession(session),getUsernameFromSession(session));
        return new JsonResult<>(OK,data);
    }
}
