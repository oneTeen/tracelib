
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trace Test</title>
    </head>
    <body>
        <div id="navi">
            <c:url value="WEB-INF/jsp/navigation.jsp" var="urlnav"/>
            <c:import url="${urlnav}"/>
        </div>
        <div id="suscriberDisplay">
            <c:url value="Controller?section=subcsuscriber.kp&action=display" var="urldisplay"/>
            <c:import url="${urldisplay}"/>
        </div>
    </body>
</html>
