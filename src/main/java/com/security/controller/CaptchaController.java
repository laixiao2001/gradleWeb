package com.security.controller;

import com.security.common.CaptchaUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liusven on 2016/11/7.
 */
@Controller
@Scope("prototype")
@RequestMapping("/captcha")
public class CaptchaController
{

    @RequestMapping("/getImage")
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        String verifyCode = CaptchaUtils.generateVerifyCode(4);
        HttpSession session = request.getSession(true);
        session.removeAttribute("captcha");
        session.setAttribute("captcha", verifyCode.toLowerCase());
        int w = 100, h = 30;
        CaptchaUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }
}
