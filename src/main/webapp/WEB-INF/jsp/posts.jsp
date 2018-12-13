<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Posts for the GuestBook</title>
</head>
<body class="w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1><a href="/" class="w3-bar-item w3-button">MAINPAGE</a></h1>
</div>
<div class="w3-container w3-padding">

    <div class="w3-card-4">
    <form:form method="POST" action="/add" modelAttribute="post" class="w3-selection w3-light-grey w3-padding">
    <table>
    <tr>
    <td><form:label path="txt">Text:</form:label></td>
    <td><form:input path="txt" class="w3-input w3-animate-input w3-border w3-round-large"
    pattern="^[a-zA-Z0-9]+$" style="width: 30%"/></td>
    </tr>
    <tr>
    <td><input type="submit" value="Submit" class="w3-btn w3-green w3-round-large w3-margin-bottom"/></td>
    </tr>
    </table>
    </form:form>
    </div>



    <div class="w3-card-4">
        <div class="w3-container w3-center w3-margin-bottom w3-padding">
            <table class="w3-table-all w3-hoverable">
                <tr class="w3-green">
                    <th>ID</th>
                    <th>POST</th>
                    <th>edit</th>
                </tr>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td><c:out value="${post.id}"></c:out></td>
                        <td><c:out value="${post.txt}"></c:out></td>
                        <td><a style="color:red" href="/delete/?id=${post.id}">x</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
