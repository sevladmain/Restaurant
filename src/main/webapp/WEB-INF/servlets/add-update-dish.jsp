<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/dish/added" var="userActionUrl"/>
<div class="container">
    <c:choose>
        <c:when test="${dishForm['new']}">
            <h1>Додати страву</h1>
        </c:when>
        <c:otherwise>
            <h1>Оновити страву</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <form:form class="form-horizontal" method="post"
               modelAttribute="dishForm" action="${userActionUrl}">

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
        <spring:bind path="category">
            <div class="form-group">
                <label for="category" class="col-sm-3 control-label">Категорія</label>
                <div class="col-sm-9">
                    <form:select path="category" class="form-control">
                        <option value="0">--- Виберіть ---</option>
                        <c:forEach items="${categoriesList}" var="map">
                            <option value="${map.id}" <c:if test="${dishForm['category'].id==map.id}">selected</c:if> >${map.name}</option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="weight">
            <div class="form-group">
                <label for="weight" class="col-sm-3 control-label">Вага</label>
                <div class="col-sm-9">
                    <form:input path="weight" type="text" class="form-control" aria-describedby="basic-addon1"
                                id="weight" placeholder="Вага"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="price">
            <div class="form-group">
                <label for="price" class="col-sm-3 control-label">Ціна</label>
                <div class="col-sm-9">
                    <form:input path="price" type="text" class="form-control" aria-describedby="basic-addon1"
                                id="price" placeholder="Ціна"/>
                </div>
            </div>
        </spring:bind>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2">
                <c:choose>
                    <c:when test="${dishForm['new']}">
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