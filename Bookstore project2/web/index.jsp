<%--
  Created by IntelliJ IDEA.
  User: 14647
  Date: 2019/6/19
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>主页的过渡页面，跳转到 index?action=showIndex</title>
</head>

<body>

<c:redirect url="/index">
  <c:param name="action" value="showIndex"></c:param>
</c:redirect>

</body>
</html>
