package com.gmh.cjcx.dao;

import com.gmh.cjcx.dto.RoleDto;
import com.gmh.cjcx.entity.Role;
import com.gmh.cjcx.entity.RolePermission;
import com.gmh.framework.orm.IBaseDao;

import java.util.List;

/**
 *
 */
public interface RoleDao extends IBaseDao<RoleDto,Integer>{

    RoleDto findById(Integer id);

    /**
     * 根据用户ID获得该用户的角色名集合
     * @param userId
     * @return
     */
    List<String> getRolesName(Integer userId);

    /**
     * 根据用户ID获得该用户的角色集合
     * @param userId
     * @return
     */
    List<Role> getRoleList(Integer userId);
}
