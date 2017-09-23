package com.gmh.cjcx.dao;

import com.gmh.cjcx.entity.Permission;

import java.util.List;

public interface PermissionDao {

    Permission findById(Integer id);

    /**
     * 根据用户ID获得该用户的角色名集合
     * @param roleId
     * @return
     */
    List<String> getPermissionsName(Integer roleId);
}
