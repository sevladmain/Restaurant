<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
    <title><tiles:insertAttribute name="title"/></title>
    <!-- Bootstrap -->
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
    <spring:url value="/resources/js/script.js" var="script" />

    <link href="${bootstrapCss}" rel="stylesheet">
    <script src="${script}"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- Static navbar -->
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Працівники<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/employee/add">Додати</a></li>
                        <li><a href="/employee/find">Пошук за іменем</a></li>
                        <li><a href="/employee/all">Вивести всіх</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Страва<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/dish/add">Додати</a></li>
                        <li><a href="/dish/find">Пошук за назвою</a></li>
                        <li><a href="/dish/all">Вивести всіх</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Меню<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/menu/add">Додати</a></li>
                        <li><a href="/menu/find">Пошук за назвою</a></li>
                        <li><a href="/menu/all">Вивести всіх</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Замовлення<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/order/add">Створити</a></li>
                        <li><a href="/order/allOpen">Вивести відкриті замовлення</a></li>
                        <li><a href="/order/allClosed">Вивести закриті замовлення</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Складові<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/ingredient/add">Додати</a></li>
                        <li><a href="/ingredient/find">Пошук</a></li>
                        <li><a href="/ingredient/all">Вивести всі складові</a></li>
                        <li><a href="/ingredient/min">Вивести складові, що закінчуються</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>


<tiles:insertAttribute name="content"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${bootstrapJs}"></script>
</body>
</html>
