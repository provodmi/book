<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>$AddPOST$</title>
</head>
<body class="w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>POST_ADD!</h1>
</div>

<div class="w3-card-4">
    <div class="w3-container w3-center w3-green">
        <h2>Add post</h2>
    </div>
    <%--<form method="post" class="w3-selection w3-light-grey w3-padding">--%>
        <%--&lt;%&ndash;<label>ID:&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="id" name="id" class="w3-input  w3-border w3-round-large" required pattern="^[0-9]+$" style="width: 10%"><br/>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</label>&ndash;%&gt;--%>

        <%--<label>Name:--%>
            <%--<input type="name" name="txt" class="w3-input w3-animate-input w3-border w3-round-large" required--%>
                   <%--style="width: 30%"><br/>--%>
        <%--</label>--%>
        <%--<button formmethod="addPost" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>--%>
    <%--</form>--%>

    <%--<form:form method="POST" action="add" modelAttribute="post">--%>
    <%--<form:form method="POST" action="add" >--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>Post:</td>--%>
            <%--<td><form:input path="post" /></td>--%>

        <%--<td colspan="3"><input type="submit" value="post" /></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
    <%--</form:form>--%>

    <form:form method="POST" action="/add" modelAttribute="post" >
        <table>
            <tr>
                <td><form:label path="post">PostName</form:label></td>
                <td><form:input path="post"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>

</div>

<%--<div class="w3-container w3-center">--%>
    <%--<div class="w3-bar w3-padding-large w3-padding-24">--%>
        <%--<button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/posts'">List posts</button>--%>
    <%--</div>--%>
<%--</div>--%>
</body>
</html>