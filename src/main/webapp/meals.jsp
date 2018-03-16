<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Meals</title>
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }
    </style>
</head>
<body>
<h2>MEALS</h2>
<h3><a href="index.html">Home</a></h3>
<table><thread>
    <tr>

        <th >Time</th>
        <th width="120">Description</th>
        <th width="100">Calories</th>

    </tr>  </thread>
    <c:forEach items="${mealList}" var="meal">
        <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
        <tr class="${meal.exceed ? 'normal' : 'exceeded'}">
            <th>${meal.dateTime.toLocalTime()} ${meal.dateTime.toLocalDate()}</th>
            <th>${meal.description}</th>
            <th>${meal.calories}</th>
        </tr>
    </c:forEach>
</table>

</body>
</html>
