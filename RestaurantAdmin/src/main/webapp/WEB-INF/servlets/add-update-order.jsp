<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/order/added" var="userActionUrl"/>
<div class="container">
    <c:choose>
        <c:when test="${orderForm['new']}">
            <h1>Додати замовлення</h1>
        </c:when>
        <c:otherwise>
            <h1>Оновити замовлення</h1>
        </c:otherwise>
    </c:choose>
    <br />

    <form:form class="form-horizontal" method="post"
               modelAttribute="orderForm" action="${userActionUrl}">

        <form:hidden path="id"/>
        <spring:bind path="employee">
            <div class="form-group">
                <label for="employee" class="col-sm-3 control-label">Хто прийняв замовлення:</label>
                <div class="col-sm-9">
                    <form:select path="employee" class="form-control">
                        <option value="0">--- Виберіть ---</option>
                        <c:forEach items="${employees}" var="employee">
                            <option value="${employee.id}" <c:if test="${orderForm['employee'].id==employee.id}">selected</c:if> >${employee.firstName} ${employee.lastName}</option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="tableNum">
            <div class="form-group">
                <label for="tableNum" class="col-sm-3 control-label">Номер столику</label>
                <div class="col-sm-9">
                    <form:input path="tableNum" type="text" class="form-control" aria-describedby="basic-addon1"
                                id="tableNum" placeholder="Номер столику"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="date">
            <div class="form-group">
                <label for="tableNum" class="col-sm-3 control-label">Дата</label>
                <div class="col-sm-9">
                    <form:input path="date" type="text" class="form-control" aria-describedby="basic-addon1"
                                id="date" placeholder="YYYY-MM-DD"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="open">
            <div class="form-group">
                <label for="tableNum" class="col-sm-3 control-label">Відкритий?</label>
                <div class="col-sm-9">
                    <form:checkbox path="open" class="form-control" aria-describedby="basic-addon1"
                                id="open"/>
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-2">
                <c:choose>
                    <c:when test="${orderForm['new']}">
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