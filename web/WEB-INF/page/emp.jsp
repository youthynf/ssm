<%--
  Created by IntelliJ IDEA.
  User: yannengfa
  Date: 2021/4/13
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
empno:${requestScope.emp.empno}<br/>
ename:${requestScope.emp.ename}<br/>
job:${requestScope.emp.job}<br/>
mgr:${requestScope.emp.mgr}<br/>
hiredate:${requestScope.emp.hiredate}<br/>
comm:${requestScope.emp.comm}<br/>
deptno:${requestScope.emp.deptno}<br/>
</body>
</html>
