package com.gmh.cjcx.service;

import com.gmh.cjcx.entity.Role;
import com.gmh.cjcx.entity.User;

import java.util.List;
import java.util.Set;

public interface IPermissionService {
    User findByUserEmail(String email);

    Set<String> getRolesName(Integer userId);
    List<Role> getRoleList(Integer userId);
    List<String> getPermissionsName(Integer roleId);



}
