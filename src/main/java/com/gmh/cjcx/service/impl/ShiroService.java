package com.gmh.cjcx.service.impl;

import com.gmh.cjcx.dao.PermissionInitDao;
import com.gmh.cjcx.entity.PermissionInit;
import com.gmh.cjcx.service.IShiroService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShiroService implements IShiroService {

    @Autowired
    ShiroFilterFactoryBean shiroFilterFactoryBean;

    @Autowired
    PermissionInitDao permissionInitDao;

    @Override
    public Map<String, String> loadFilterChainDefinitions() {
        Map<String, String> map = new HashMap<String, String>();
        try {
            List<PermissionInit> list = permissionInitDao.getPermissionInitList();
            list.forEach(entity -> {
                map.put(entity.getUrl(), entity.getPermissionInit());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 权限更新
     */
    @Override
    public void updatePermission() {
        synchronized (shiroFilterFactoryBean) {
            AbstractShiroFilter shiroFilter = null;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
            } catch (Exception e) {
                throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
            }

            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

            // 清空老的权限控制
            manager.getFilterChains().clear();

            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());
            // 重新构建生成
            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim().replace(" ", "");
                manager.createChain(url, chainDefinition);
            }

            System.out.println("更新权限成功！！");

            System.out.println("清除redis缓存成功！！");
        }
    }

}
