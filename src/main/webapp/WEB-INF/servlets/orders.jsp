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
    <div class="panel-heading">
        <c:choose>
            <c:when test="${isClosed == 'OPEN'}">
                Відкриті замовлення
            </c:when>
            <c:otherwise>
                Закриті замовлення
            </c:otherwise>
        </c:choose>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>Номер замовлення</th>
            <th>Хто прийняв замовлення</th>
            <th>Номер столику</th>
            <th>Дата</th>
            <th>Операції</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.employee.firstName} ${order.employee.lastName}</td>
                <td>${order.tableNum}</td>
                <td>${order.date}</td>
                <td>
                    <spring:url value="/order/${order.id}/delete" var="deleteUrl"/>
                    <spring:url value="/order/${order.id}/update" var="updateUrl"/>
                    <spring:url value="/order/${order.id}/details" var="detailsUrl"/>
                    <c:if test="${isClosed == 'OPEN'}">
                        <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Редагувати</button>
                        <button class="btn btn-info" onclick="location.href='${detailsUrl}'">Детальна інформація
                        </button>
                    </c:if>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Видалити</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
