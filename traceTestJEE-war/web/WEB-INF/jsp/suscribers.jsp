
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Suscriber list:</h1>

<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>TYPE</th>
            <th>NAME</th>
            <th>INSTITUTION</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${suscribers}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.susType}</td>
                <td>${s.name}</td>
                <td><c:catch var="exception">${s.institution}</c:catch>
                    <c:if test="${not empty exception}"></c:if></td>
                </tr>
        </c:forEach>    
    </tbody>
</table>