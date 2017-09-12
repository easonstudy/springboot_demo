package com.gmh.cjcx.entity;

import java.io.Serializable;

import com.gmh.framework.orm.BaseEntity;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author Guominghua
 * @since 2017-08-15
 */
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                ", remark=" + remark +
                "}";
    }
}
