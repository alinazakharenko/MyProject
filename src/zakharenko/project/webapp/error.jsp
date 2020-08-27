<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
<%@ include file="include/menu.htm" %>
 <hr>
    ERROR:<br> ${errMessage}
    <hr>
    STACK:<br> ${errStack}
    <hr>
</div>
</body>
</html>