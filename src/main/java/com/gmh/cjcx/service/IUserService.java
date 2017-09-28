package com.gmh.cjcx.service;

import com.gmh.cjcx.entity.Role;
import com.gmh.cjcx.entity.User;

import java.util.List;
import java.util.Set;

public interface IUserService {

    User findByUserEmail(String email);

}
