package com.gmh.cjcx.controller;

import com.gmh.cjcx.dto.MemberDto;
import com.gmh.cjcx.entity.Member;
import com.gmh.cjcx.entity.Role;
import com.gmh.cjcx.service.IMemberService;
import com.gmh.cjcx.service.IRoleService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gmh on 2017/6/7 0007.
 */
@RestController
public class MemberController {

    @Autowired
    private IMemberService memberService;

    @Autowired
    private IRoleService roleService;

    @GetMapping("/get/{id}")
    public String getMember(@PathVariable("id") Integer id){
        MemberDto m = memberService.findById(id);

        //Role m = roleService.findById(id);
        Gson gson = new Gson();
        return gson.toJson(m);
    }
}
