<%@ page language="java"  pageEncoding="utf-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE>
<html>
<head>
    <title>测试dsf</title>
</head>

<body>
<h2>dfsg</h2>


<table boder="1" bgcolor="red" cellpadding="5">

    <tr>
        <td>书名</td>
        <td>编号</td>
    </tr>
    <c:forEach items="${blist}" var="book" >

        <tr>
            <td>${book.name}</td>
            <td>${book.number}</td>
        </tr>

    </c:forEach>


</table>


</body>
</html>