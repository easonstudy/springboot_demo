package com.gmh.framework.controller;

import com.gmh.framework.config.RedisConfig;
import com.gmh.framework.vcode.Captcha;
import com.gmh.framework.vcode.GifCaptcha;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by sun on 2017-4-6.
 */
@Controller
@RequestMapping("vcode")
public class CodeController {

    private final Logger logger = Logger.getLogger(CodeController.class);

    /**
     * 获取验证码（Gif版本）
     * @param response
     */
    @RequestMapping(value="/gif",method= RequestMethod.GET)
    public void getGifCode(HttpServletResponse response, HttpServletRequest request){
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            /**
             * gif格式动画验证码
             * 宽，高，位数。
             */
            Captcha captcha = new GifCaptcha(146,33,4);
            //输出
            captcha.out(response.getOutputStream());
            //request.getSession();
            HttpSession session = request.getSession(true);
            //存入Session
            session.setAttribute("gifCode",captcha.text().toLowerCase());
            logger.info("Gif Code:" + captcha.text().toLowerCase());
        } catch (Exception e) {
            System.err.println("获取验证码异常："+e.getMessage());
        }
    }

}
