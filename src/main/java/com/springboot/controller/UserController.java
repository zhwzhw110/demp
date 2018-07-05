package com.springboot.controller;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangHaiWen
 * @date : 2018/7/5 0005 上午 11:40
 * @DESC :
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user",method = {RequestMethod.POST,RequestMethod.GET})
    //事务注解，在方法上添加一个注解就可以了
    @Transactional(propagation = Propagation.REQUIRED)
    public Map getUserMap(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","1");
        //因为在getUser的方法上加了注解Required，所以两个方法在同一个事务中
        getUser();
        return map;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    //@Transactional(propagation = Propagation.REQUIRES_NEW)//如果是新的事务，那么两个方法不在同一个事务之中
    //@Transactional(propagation = Propagation.NESTED) //事务嵌套 A事务满足成功，B事务满足成功，才可以commit或者callback
    public String getUser(){
        return "1";
    }
}
