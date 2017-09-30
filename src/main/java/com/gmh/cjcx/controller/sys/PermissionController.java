package com.gmh.cjcx.controller.sys;

import com.gmh.cjcx.dto.MemberDto;
import com.gmh.cjcx.service.IMemberService;
import com.gmh.cjcx.service.IShiroService;
import com.gmh.framework.annotation.CheckPermission;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gmh on 2017/6/7 0007.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    IShiroService shiroService;

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

    @GetMapping("update")
    @ResponseBody
    public String updatePermission(){
        JSONObject json = new JSONObject();
        try {
            shiroService.updatePermission();
            json.put("code", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
