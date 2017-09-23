package com.gmh.cjcx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by gmh on 2017/6/6 0006.
 */
@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String loginFomr(){
        return "/login";
    }

    @PostMapping(value = "/login")
    public String login(){



        return "/index";
    }

}