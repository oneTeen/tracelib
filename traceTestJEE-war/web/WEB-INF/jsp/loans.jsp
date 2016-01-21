
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Loans list</h1>

<table class="table">
    <thead
        <tr>
            <th>ID</th>

            <th>SUBSCRIBER</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${loans}" var="l">
            <tr>
                <td>${l.id}</td>

                <td>${l.suscriber}</td>
            </tr>
        </c:forEach>  
    </tbody>

</table>



