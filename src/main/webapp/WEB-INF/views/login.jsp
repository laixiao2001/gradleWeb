<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link href="static/css/bootstrap.css"  rel="stylesheet">
    <link href="static/css/app.css" rel="stylesheet">
    <script type="text/javascript" src="static/js/jquery-3.1.1.min.js" charset="UTF-8"></script>
</head>
<body>
<div id="mainWrapper">
    <div class="login-container">
        <div class="login-card">
            <div class="login-form">
                <c:url var="loginUrl" value="/login" />
                <form action="${loginUrl}" method="post" class="form-horizontal">
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            <p>用户名或密码错误!</p>
                        </div>
                    </c:if>
                    <c:if test="${param.invalidCaptcha != null}">
                        <div class="alert alert-danger">
                            <p>验证码错误!</p>
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div class="alert alert-success">
                            <p>成功退出!</p>
                        </div>
                    </c:if>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                        <input value="${sessionScope.username}" type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
                    </div>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                        <input value="${sessionScope.password}" type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
                    </div>
                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                        <input type="text" class="form-control" id="captcha" name="captcha" placeholder="Enter Captcha" required>
                    </div>
                    <div class="input-group input-sm">
                        <img src="/captcha/getImage" id="captchaImage">
                    </div>
                    <div class="input-group input-sm">
                        <div class="checkbox">
                            <label><input type="checkbox" id="rememberme" name="remember-me"> Remember Me</label>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />

                    <div class="form-actions">
                        <input type="submit" class="btn btn-block btn-primary btn-default" value="Log in">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">
    $(function(){
        $("#captchaImage").click(function(){
            $("#captchaImage").attr("src","/captcha/getImage?"+Math.random())
        });
    })
    $.ajax({
        type: "GET",
        url: "http://www.toutiao.com/stream/widget/local_weather/data/?city=",
        headers: {
            "Accept": "text/javascript, text/html, application/xml, text/xml, */*",
            "Accept-Encoding": "gzip, deflate, sdch",
            "Accept-Language": "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4,ja;q=0.2",
            "Cache-Control": "no-cache",
            "Connection": "keep-alive",
            "Content-Type": "application/x-www-form-urlencoded",
            "Cookie": 'uuid="w:c8b8a43870f74fdf8f0c1e85c4bca1c9"; CNZZDATA1259612802=695498139-1478782062-https%253A%252F%252Fwww.baidu.com%252F%7C1478782062; utm_source=toutiao; tt_webid=35424651480; _ga=GA1.2.1725242165.1478786367; __tasessionId=j11nyb1lc1478786362754; csrftoken=77b252e0994fe0971446eb669fa594ac',
            "Host": "www.toutiao.com",
            "Pragma": "no-cache",
            "Referer": "http://www.toutiao.com/",
            "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36",
            "X-Requested-With": "XMLHttpRequest"
        }
    }).done(function(data){
        alert(JSON.stringify(data));
    }).fail(function(data)
    {
        alert(JSON.stringify(data));
    });
</script>
</html>