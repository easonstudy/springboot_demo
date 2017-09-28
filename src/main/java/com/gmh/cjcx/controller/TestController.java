package com.gmh.cjcx.controller;

import com.gmh.framework.annotation.CheckPermission;
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
@RequestMapping("test")
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String test(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("name", "java");
        return "/hello";
    }

}