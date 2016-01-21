
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Trace Test</title>
    </head>
    <body>
        <div id="suscriberDisplay">
            <c:url value="Controller?section=subcsuscriber.kp&action=display" var="urlsusdisplay"/>
            <c:import url="${urlsusdisplay}"/>
        </div>
        <div id="resourceDisplay">
            <c:url value="Controller?section=subcresource.kp&action=display" var="urlresdisplay"/>
            <c:import url="${urlresdisplay}"/>
        </div>
        <div id="loanDisplay">
            <c:url value="Controller?section=subcloan.kp&action=display" var="urllndisplay"/>
            <c:import url="${urllndisplay}"/>
        </div>
    </body>
</html>
