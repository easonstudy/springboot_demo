package com.gmh.framework.service;

import com.gmh.framework.orm.BaseEntity;
import com.gmh.framework.orm.IBaseDao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public abstract class BaseService<E extends BaseEntity, Id extends Serializable> implements IBaseService<E, Id> {

    protected abstract IBaseDao<E, Id> getDao();

    @Override
    public int insert(E entity) {
        return getDao().insert(entity);
    }

    @Override
    public int updateById(E entity) {
        return getDao().updateById(entity);
    }

    @Override
    public int deleteById(Id id) {
        return getDao().deleteById(id);
    }

    @Override
    public E findById(Id id) {
        return getDao().findById(id);
    }

    @Override
    public List<E> findByIds(Id[] ids) {
        return getDao().findByIds(ids);
    }

    @Override
    public E findByEntityId(E entity) {
        if (entity == null) {
            return null;
        }

        return getDao().findByEntityId(entity);
    }

    @Override
    public List<E> findAll() {
        return getDao().findAll();
    }

    @Override
    public List<E> findByCondition(E condition) {
        if (condition == null) {
            return getDao().findAll();
        }
        return getDao().findByCondition(condition);
    }

    @Override
    public Integer countAll() {
        return getDao().countAll();
    }

    @Override
    public Integer countByCondition(E condition) {
        return getDao().countByCondition(condition);
    }

    @Override
    public Integer checkUnique(E dto, String uniquePropertyNames) {
        return getDao().checkUnique(dto, uniquePropertyNames);
    }
}
