<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action="do?command=SignUp" id="signup" style="margin-top: 1%">
        <fieldset>

            <!-- Form Name -->
            <legend><b>Регистрация</b></legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Имя:</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">${help_login}</span>
                </div>
            </div>


            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">Фамилия:</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">${help_password}</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">Email:</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="">
                    <span class="help-block">${help_email}</span>
                </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-success">Зарегистрироваться</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>