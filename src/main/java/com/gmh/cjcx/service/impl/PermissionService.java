package com.gmh.cjcx.service.impl;

import com.gmh.cjcx.dao.PermissionDao;
import com.gmh.cjcx.dao.RoleDao;
import com.gmh.cjcx.dao.UserDao;
import com.gmh.cjcx.entity.Role;
import com.gmh.cjcx.entity.User;
import com.gmh.cjcx.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PermissionService implements IPermissionService {

    @Autowired
    private UserDao userDao;


    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    public User findByUserEmail(String userName){
        return userDao.findByUserEmail(userName);
    }

    public Set<String> getRolesName(Integer userId){
        List<String> list = roleDao.getRolesName(userId);
        Set<String> set = new HashSet<String>();
        for (String roleName : list) {
            set.add(roleName);
        }
        return set;
    }

    public List<Role> getRoleList(Integer userId){
        return roleDao.getRoleList(userId);
    }

    public List<String> getPermissionsName(Integer roleId){
        return permissionDao.getPermissionsName(roleId);
    }
}
