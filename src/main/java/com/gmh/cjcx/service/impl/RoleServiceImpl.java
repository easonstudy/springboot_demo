package com.gmh.cjcx.service.impl;

import com.gmh.cjcx.dao.RoleDao;
import com.gmh.cjcx.dto.RoleDto;
import com.gmh.cjcx.entity.Role;
import com.gmh.cjcx.service.IRoleService;
import com.gmh.framework.orm.IBaseDao;
import com.gmh.framework.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseService<RoleDto, Integer>  implements IRoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    protected IBaseDao<RoleDto, Integer> getDao() {
        return roleDao;
    }
}
