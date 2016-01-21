
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Resource list</h1>

<table class="table">
    <thead
        <tr>
            <th>ID</th>
            <th>AUTHOR</th>
            <th>TITLE</th>

        </tr>
    </thead>

    <tbody>
        <c:forEach items="${resources}" var="r">

            <tr>

                <td>${r.id}</td>

                <td>

                    <c:catch var="exception"> ${r.author} </c:catch>
                    <c:if test="${not empty exception}"></c:if>

                    </td>
                    <td>${r.title}</td>

            </tr>

        </c:forEach>  
    </tbody>

</table>



