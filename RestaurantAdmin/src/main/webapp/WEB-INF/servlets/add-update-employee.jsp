<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/employee/added" var="userActionUrl"/>
<div class="container">
    <c:choose>
        <c:when test="${employeeForm['new']}">
            <h1>Додати працівника</h1>
        </c:when>
        <c:otherwise>
            <h1>Оновити дані працівника</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <form:form class="form-horizontal" method="post"
               modelAttribute="employeeForm" action="${userActionUrl}">

        <form:hidden path="id"/>

        <spring:bind path="firstName">
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">Ім'я</label>
                <div class="col-sm-9">
                    <form:input path="firstName" type="text" class="form-control" aria-describedby="basic-addon1"
                                id="name" placeholder="Ім'я"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="lastName">
            <div class="form-group">
                <label for="lastName" class="col-sm-3 control-label">Прізвище</label>
                <div class="col-sm-9">
                    <form:input path="lastName" type="text" class="form-control" aria-describedby="basic-addon1"
                                id="lastName" placeholder="Прізвище"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="dateBirth">
            <div class="form-group">
                <label for="dateBirth" class="col-sm-3 control-label">Дата народження</label>
                <div class="col-sm-9">
                    <form:input path="dateBirth" type="text" class="form-control" aria-describedby="basic-addon1"
                                id="dateBirth" placeholder="Дата народження"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="salary">
            <div class="form-group">
                <label for="salary" class="col-sm-3 control-label">Оклад</label>
                <div class="col-sm-9">
                    <form:input path="salary" type="text" class="form-control" aria-describedby="basic-addon1"
                                id="salary" placeholder="Оклад"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="position">
            <div class="form-group">
                <label for="position" class="col-sm-3 control-label">Посада</label>
                <div class="col-sm-9">
                    <form:select path="position" class="form-control">
                        <option value="0">--- Виберіть ---</option>
                        <c:forEach items="${positionsList}" var="map">
                            <option value="${map.id}" <c:if test="${employeeForm['position'].id==map.id}">selected</c:if> >${map.position}</option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2">
                <c:choose>
                    <c:when test="${employeeForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Додати</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Оновити</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</div>

