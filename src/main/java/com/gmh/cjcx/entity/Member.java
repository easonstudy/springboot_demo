package com.gmh.cjcx.entity;

import com.gmh.framework.orm.BaseEntity;

/**
 * 会员主表
 */
public class Member extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/** 会员id主键  */
	private Integer id;

    private String username;

    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


	
}
