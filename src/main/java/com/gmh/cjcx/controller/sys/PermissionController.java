package com.gmh.cjcx.controller.sys;

import com.gmh.cjcx.dto.MemberDto;
import com.gmh.cjcx.service.IMemberService;
import com.gmh.framework.annotation.CheckPermission;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gmh on 2017/6/7 0007.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @CheckPermission
    @GetMapping("list")
    public String list(){

        return "/permission/list";
    }

    @CheckPermission
    @GetMapping("edit")
    public String edit(){

        return "/permission/edit";
    }
}
