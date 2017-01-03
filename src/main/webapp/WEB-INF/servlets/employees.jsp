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
    <div class="panel-heading">Перелік працівників</div>
    <table class="table">
        <thead>
        <tr>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Дата народження</th>
            <th>Посада</th>
            <th>Оклад</th>
            <th>Операції</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.dateBirth}</td>
                <td>${employee.position.position}</td>
                <td>${employee.salary}</td>
                <td>
                    <%--<spring:url value="/employee/${employee.key.id}" var="userUrl" />--%>
                    <spring:url value="/employee/${employee.id}/delete" var="deleteUrl" />
                    <spring:url value="/employee/${employee.id}/update" var="updateUrl" />

                    <%--<button class="btn btn-info" onclick="location.href='${userUrl}'">Переглянути</button>--%>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Оновити</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Видалити</button></td>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
