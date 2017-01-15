<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/ingredient/added" var="userActionUrl"/>
<div class="container">
    <c:choose>
        <c:when test="${ingredient['new']}">
            <h1>Додати складову</h1>
        </c:when>
        <c:otherwise>
            <h1>Оновити складову</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <form:form class="form-horizontal" method="post"
               modelAttribute="ingredient" action="${userActionUrl}">

        <form:hidden path="id"/>

        <spring:bind path="name">
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">Назва</label>
                <div class="col-sm-9">
                    <form:input path="name" type="text" class="form-control" aria-describedby="basic-addon1"
                                id="name" placeholder="Назва"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="amount">
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">Кількість</label>
                <div class="col-sm-9">
                    <form:input path="amount" type="text" class="form-control" aria-describedby="basic-addon1"
                                id="name" placeholder="0"/>
                </div>
            </div>
        </spring:bind>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2">
                <c:choose>
                    <c:when test="${ingredient['new']}">
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