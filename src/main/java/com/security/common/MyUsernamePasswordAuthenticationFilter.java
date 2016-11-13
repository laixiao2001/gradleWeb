package com.security.common;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by liusven on 2016/11/6.
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    //用户名
    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "username";
    //密码
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";
    //需要回调的URL 自定义参数
    public static final String SPRING_SECURITY_FORM_REDERICT_KEY = "spring-security-redirect";

    private String usernameParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
    private String passwordParameter = SPRING_SECURITY_FORM_PASSWORD_KEY;

    private boolean postOnly = true;

    public MyUsernamePasswordAuthenticationFilter() {
        super();
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
        AuthenticationException
    {
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("password", password);
        String redirectUrl = obtainRedercitUrl(request);
        String captcha = obtainCaptcha(request);
        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }
        if(redirectUrl != null && !"".equals(redirectUrl)){
            request.getSession().setAttribute("callCustomRedirectUrl", redirectUrl);
        }
        HttpSession session = request.getSession(false);
        if(!captcha.equals(session.getAttribute("captcha")))
        {
            throw new CaptchaException("");
        }
        username = username.trim();
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    private String obtainCaptcha(HttpServletRequest request)
    {
        return request.getParameter("captcha");
    }

    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(passwordParameter);
    }

    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter(usernameParameter);
    }

    protected String obtainRedercitUrl(HttpServletRequest request) {
        String redirectParameter = SPRING_SECURITY_FORM_REDERICT_KEY;
        return request.getParameter(redirectParameter);
    }

    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    public void setUsernameParameter(String usernameParameter) {
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.usernameParameter = usernameParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
        Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
        this.passwordParameter = passwordParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }
}
