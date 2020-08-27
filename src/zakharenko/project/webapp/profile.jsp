<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
        <form class="form-horizontal" method="post" action="do?command=Profile" style="margin-top: 1%">
            <fieldset>

              <!-- Form Name -->
              <legend><b>Данные профиля</b></legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="login">Имя:</label>
                    <div class="col-md-4">
                        <input id="login" name="login" type="text" placeholder="" class="form-control input-md"
                               value="${user.login}">
                        <span class="help-block">${help_login}</span>
                    </div>
                </div>

                <!-- Password input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="password">Фамилия:</label>
                    <div class="col-md-4">
                        <input id="password" name="password" type="text" placeholder="" class="form-control input-md" required=""
                               value="${user.password}">
                        <span class="help-block">${help_password}</span>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="email">Email:</label>
                    <div class="col-md-4">
                        <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required=""
                               value="${user.email}">
                        <span class="help-block">${help_email}</span>
                    </div>
                </div>


                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="update"></label>
                    <div class="col-md-4">
                        <button id="update" name="update" class="btn btn-success">Обновить</button>
                    </div>
                </div>

            </fieldset>
        </form>

            <!-- Form Name -->
            <legend><b>Мои заявки</b></legend>

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

    <form class="form-horizontal" method="post" action="do?command=Profile">
        <fieldset>

            <!-- Form Name -->
            <legend><b>Выход</b></legend>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="logout"></label>
                <div class="col-md-4">
                    <button id="logout" name="logout" value="1" class="btn btn-success">Выйти</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
