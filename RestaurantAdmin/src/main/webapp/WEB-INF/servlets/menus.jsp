<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <div class="panel-heading">Перелік меню</div>
    <table class="table">
        <thead>
        <tr>
            <th>Назва меню</th>
            <th>Операції</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${menus}" var="orderId">
            <tr>
                <td>${orderId.name}</td>
                <td>
                    <spring:url value="/menu/${orderId.id}/delete" var="deleteUrl" />
                    <spring:url value="/menu/${orderId.id}/update" var="updateUrl" />
                    <spring:url value="/menu/${orderId.id}/details" var="detailsUrl" />
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Редагувати назву</button>
                    <button class="btn btn-info" onclick="location.href='${detailsUrl}'">Детальна інформація</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Видалити</button></td>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
