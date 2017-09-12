package com.gmh.cjcx.service.impl;

import com.gmh.cjcx.dao.MemberDao;
import com.gmh.cjcx.dto.MemberDto;
import com.gmh.cjcx.service.IMemberService;
import com.gmh.framework.orm.IBaseDao;
import com.gmh.framework.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Guominghua
 * @since 2017-08-15
 */
@Service
public class MemberServiceImpl extends BaseService<MemberDto, Integer> implements IMemberService {

    @Autowired
    MemberDao memberDao;

    @Override
    protected IBaseDao<MemberDto, Integer> getDao() {
        return memberDao;
    }

}
