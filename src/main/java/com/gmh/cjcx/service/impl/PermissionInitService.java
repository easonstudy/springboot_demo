package com.gmh.cjcx.service.impl;

import com.gmh.cjcx.dao.PermissionInitDao;
import com.gmh.cjcx.entity.PermissionInit;
import com.gmh.cjcx.service.IPermissionInitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PermissionInitService implements IPermissionInitService {

    @Autowired
    PermissionInitDao permissionInitDao;

    @Override
    public List<PermissionInit> getPermissionInitList() {
        List<PermissionInit> list = permissionInitDao.getPermissionInitList();
        return list;
    }




}

