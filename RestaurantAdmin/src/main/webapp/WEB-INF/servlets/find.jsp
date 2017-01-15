<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SeVlad
  Date: 09.11.2016
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <c:choose>
        <c:when test="${findWhat == 'EMPLOYEE'}">
            <h1>Введіть ім'я або прізвище працівника</h1>
            <spring:url value="/employee/finded" var="userActionUrl"/>
        </c:when>
        <c:when test="${findWhat == 'DISH'}">
            <h1>Введіть назву страви</h1>
            <spring:url value="/dish/finded" var="userActionUrl"/>
        </c:when>
        <c:when test="${findWhat == 'MENU'}">
            <h1>Введіть назву меню</h1>
            <spring:url value="/menu/finded" var="userActionUrl"/>
        </c:when>
        <c:when test="${findWhat == 'INGREDIENT'}">
            <h1>Введіть назву складової</h1>
            <spring:url value="/ingredient/finded" var="userActionUrl"/>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
    <br/>
    <form:form class="form-horizontal" method="post" action="${userActionUrl}">
        <div class="form-group">
            <label class="col-sm-3 control-label">Пошук</label>
            <div class="col-sm-9">
                <input type="text" class="form-control"
                       name="findString" placeholder="Ім'я"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2">
                <button type="submit" class="btn-lg btn-primary pull-right">Знайти</button>
            </div>
        </div>
    </form:form>
</div>
