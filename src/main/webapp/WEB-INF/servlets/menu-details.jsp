<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-default">
    <!-- Default panel contents -->
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>
    <div class="panel-heading">Страви, що входять в меню ${menu.name}</div>
    <table class="table">
        <thead>
        <tr>
            <th>Назва</th>
            <th>Операції</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dishes}" var="dish">
            <tr>
                <td>${dish.name}</td>
                <td>
                    <spring:url value="/menu/${menu.id}/dish/${dish.id}/delete" var="deleteUrl"/>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Видалити</button>
                </td>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/menu/${menu.id}/dish/add" var="userActionUrl"/>

    <form:form modelAttribute="newDish" class="form-horizontal" action="${userActionUrl}"
               method="post">
        <spring:bind path="id">
            <div class="form-group">
                <label class="col-sm-3 control-label">Нова страва:</label>
                <div class="col-sm-9">
                    <form:select path="id" class="form-control">

                        <c:forEach items="${newDishes}" var="dish">
                            <option value="${dish.id}">${dish.name}</option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
        </spring:bind>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2">
                <button class="btn btn-info">Додати</button>
            </div>
        </div>
    </form:form>
</div>
