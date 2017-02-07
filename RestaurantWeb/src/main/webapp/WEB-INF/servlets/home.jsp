<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty msg}">
    <div class="alert alert-${css} alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        <strong>${msg}</strong>
    </div>
</c:if>
<div class="page-header">
    <%--
        Общую информация о ресторане (название, адрес, контактный телефон, почта, и т.п.)
        Меню. Меню должно содержать краткое описание блюда: назван, вес, цена
        На отдельной странице просматривать детальную информацию о каждом блюде: название, вес, цена, список ингредиентов (можно добавить фото). Переход на нее должен осуществляется по нажатию на соответствующее блюдо в меню
        На главной странице должна быть возможность искать блюда по названию
    --%>
    <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-12 col-sm-9">
            <div class="jumbotron">
                <h1 id="name">Вітаємо! </h1>
                <p>Ви на сторінці <b>Ресторану у загубленого альпініста</b>. </p>
                <p>Найкращого ресторану Диканьки</p>
                <h2>Наші контакти:</h2>
                <p><b>Адреса:</b> Диканька</p>
                <p><b>Контактний телефон:</b> 223-22-3-22</p>
                <p><b>Пошта:</b> <a href="mailto:dykanka@restaurant.ua">dykanka@restaurant.ua</a></p>
            </div>
        </div>
    </div>
</div>
