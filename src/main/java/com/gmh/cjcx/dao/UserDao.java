package com.gmh.cjcx.dao;

import com.gmh.cjcx.dto.RoleDto;
import com.gmh.cjcx.entity.User;
import com.gmh.framework.orm.IBaseDao;

/**
 *
 */
public interface UserDao {

    User findById(Integer id);

    User findByUserEmail(String email);
}
