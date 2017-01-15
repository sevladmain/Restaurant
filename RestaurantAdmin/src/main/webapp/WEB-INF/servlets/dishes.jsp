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
    <div class="panel-heading">Перелік страв</div>
    <table class="table">
        <thead>
        <tr>
            <th>Назва</th>
            <th>Категорія</th>
            <th>Вага</th>
            <th>Ціна</th>
            <th>Операції</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dishes}" var="dish">
            <tr>
                <td>${dish.name}</td>
                <td>${dish.category.name}</td>
                <td>${dish.weight}</td>
                <td>${dish.price}</td>
                <td>
                    <spring:url value="/dish/${dish.id}/delete" var="deleteUrl" />
                    <spring:url value="/dish/${dish.id}/update" var="updateUrl" />

                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Оновити</button>
                    <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Видалити</button></td>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
