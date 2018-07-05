package com.springboot.controller;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: zhangHaiWen
 * @date : 2018/7/5 0005 上午 11:40
 * @DESC :
 */
@RestController
public class UserController {

    //事务注解，在方法上添加一个注解就可以了
    @Transactional(propagation = Propagation.REQUIRED)
    public Map getUserMap(){
        //因为在getUser的方法上加了注解Required，所以两个方法在同一个事务中
        getUser();
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String getUser(){
        return "1";
    }
}
