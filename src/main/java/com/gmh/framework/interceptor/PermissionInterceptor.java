package com.gmh.framework.interceptor;

import com.gmh.framework.annotation.CheckPermission;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = Logger.getLogger(PermissionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle");

         //方法
        if(handler instanceof HandlerMethod) {
            //根据controller与method的RequestMapping设置来生成权限String
            HandlerMethod hm = (HandlerMethod)handler;
            CheckPermission checkPermission = hm.getMethodAnnotation(CheckPermission.class);
            if(checkPermission != null) {
                //通过RequestMapping 获取请求URL
                RequestMapping controllerMapping =  hm.getBeanType().getAnnotation(RequestMapping.class);
                String url = "";
                if (controllerMapping != null) {
                    url = controllerMapping.value()[0];
                }

                RequestMapping methodMapping = hm.getMethodAnnotation(RequestMapping.class);
                if(methodMapping != null){
                    url += (url == "" ? "" : "/") + methodMapping.value()[0];
                    String[] permissions = checkPermission.value();
                    if ((permissions == null || permissions.length == 0) && StringUtils.isNotEmpty(url)) {
                        permissions = new String[] { url };
                    }

                    Subject currentUser = SecurityUtils.getSubject();

                    //logger.info("进入检查, 跳过检查");
                    //检查是否有权限
                    boolean permitted = true;
                    for (String perms : permissions) {
                        if (!currentUser.isPermitted(perms)) {
                            permitted = false;
                            break;
                        }
                    }

                    if (!permitted) {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
