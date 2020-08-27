<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<%@ include file="include/head.htm" %>
<body>
<div class="container">
    <%@ include file="include/menu.htm" %>
    <form class="form-horizontal" method="post" action="do?command=CreateBook">
        <fieldset>

            <!-- Form Name -->
            <legend><b>Оформление заявки</b></legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Вид продукции (услуг):</label>
                <div class="col-md-4">
                    <input id="name" name="name" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="material">Материал:</label>
                <div class="col-md-4">
                    <input id="material" name="material" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="parameter">Параметры:</label>
                <div class="col-md-4">
                    <input id="parameter" name="parameter" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="client">Клиент:</label>
                <div class="col-md-4">
                    <input id="client" name="client" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="number">Количество:</label>
                <div class="col-md-4">
                    <input id="number" name="number" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Text input -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="date">Дата сдачи:</label>
                <div class="col-md-4">
                    <input id="date" name="date" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Оформить заявку</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>