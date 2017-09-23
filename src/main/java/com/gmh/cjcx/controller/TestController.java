package com.gmh.cjcx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gmh on 2017/6/6 0006.
 */
@Controller
public class TestController {

    @GetMapping("/hello")
    String test(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("name", "java");
        return "/hello";
    }
    @RequestMapping(value = {"/hello/{id}", "/hi/{id}"}, method = RequestMethod.GET)
    public String test(@PathVariable("id") Integer id){

        return "CupSize_1:" + "id:" + id;
    }

}