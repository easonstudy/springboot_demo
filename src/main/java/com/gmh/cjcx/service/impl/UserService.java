package com.gmh.cjcx.service.impl;

import com.gmh.cjcx.dao.PermissionDao;
import com.gmh.cjcx.dao.RoleDao;
import com.gmh.cjcx.dao.UserDao;
import com.gmh.cjcx.entity.Role;
import com.gmh.cjcx.entity.User;
import com.gmh.cjcx.service.IPermissionService;
import com.gmh.cjcx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    public User findByUserEmail(String userName){
        return userDao.findByUserEmail(userName);
    }

}
