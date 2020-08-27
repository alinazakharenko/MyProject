<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Вид продукции (услуг)</th>
            <th scope="col">Материал</th>
            <th scope="col">Параметры</th>
            <th scope="col">Клиент</th>
            <th scope="col">Количество</th>
            <th scope="col">Дата сдачи</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.name}</td>
                <td>${book.material}</td>
                <td>${book.parameter}</td>
                <td>${book.client}</td>
                <td>${book.number}</td>
                <td>${book.date}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>