package com.gmh.cjcx.service.impl;

import com.gmh.cjcx.dao.PermissionInitDao;
import com.gmh.cjcx.service.IShiroService;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroService implements IShiroService{
    @Autowired
    PermissionInitDao permissionInitDao;
    //http://www.jianshu.com/p/22f78f8677f3
}
