<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome page</title>
</head>
<body>
<div class="success">
   Hi
<sec:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_USER,ROLE_DBA')">
    <sec:authentication property="principal.username"/>
</sec:authorize>
    , welcome to my website.
<sec:authorize access="hasAnyRole('ROLE_ADMIN,ROLE_USER,ROLE_DBA')">
    <a href="<c:url value="/logout" />">Logout</a>
</sec:authorize>
</div>
</body>
</html>
