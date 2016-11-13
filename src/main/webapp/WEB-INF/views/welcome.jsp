<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/style.css">
    <script src="/static/js/jquery-3.1.1.min.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <script src="static/js/weather.js" ></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Just do it !</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Page 1-1</a></li>
                        <li><a href="#">Page 1-2</a></li>
                        <li><a href="#">Page 1-3</a></li>
                    </ul>
                </li>
                <li><a href="#">Page 2</a></li>
                <li><a href="#">Page 3</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_USER,ROLE_DBA')">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <span class="glyphicon glyphicon-user .navbar-text"></span>
                            Hi <sec:authentication property="principal.username"/>
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Page 1-1</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Page 1-2</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Page 1-3</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="/logout"><span class="glyphicon glyphicon-plane .navbar-text"></span>
                            退出
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAnonymous()">
                    <li><a href="#"><span class="glyphicon glyphicon-hand-right .navbar-text"></span>注册</a></li>
                    <li><a href="/login"><span class="glyphicon glyphicon-user .navbar-text"></span>登录</a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>
<script src="http://fw.qq.com:80/ipaddress"></script>
<script type=text/javascript>
    document.write(IPData[3]);
</script>
<div id="weatherItem">
    <div id="weatherWrap">
        <span id="echoData"></span>
        <span id="echoWeek"></span>
        <a href="http://weather.news.qq.com/" target="_blank" bosszone="weather">
            <span id="wCity"></span>
            <span id="weatherIco"></span>
            <span id="wTp"></span>
        </a>
    </div>
</div>
</body>
</html>
