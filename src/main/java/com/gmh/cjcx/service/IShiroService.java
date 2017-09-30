package com.gmh.cjcx.service;

import com.gmh.cjcx.entity.PermissionInit;

import java.util.List;
import java.util.Map;

public interface IShiroService {


    Map<String, String> loadFilterChainDefinitions();

    void updatePermission();
}
