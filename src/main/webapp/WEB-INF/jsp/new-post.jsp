<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>$AddPOST$</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">

        $(document).ready(function() {

            $('#newPostForm').submit(function(event) {

                var txt = $('#txt').val();
                var json = { "txt" : txt};

                $.ajax({
                    url: $("#newPostForm").attr( "action"),
                    data: JSON.stringify(json),
                    type: "POST",

                    beforeSend: function(xhr) {
                        xhr.setRequestHeader("Accept", "application/json");
                        xhr.setRequestHeader("Content-Type", "application/json");
                    },
                    success: function(post) {
                        var respContent = "";

                        respContent += "<span class='success'>Post was created: [";
                        respContent += post.txt + "]</span>";

                        $("#PostFromResponse").html(respContent);
                    }
                });

                event.preventDefault();
            });

        });

    </script>


</head>
<body class="w3-light-grey">

<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>POST_ADD!</h1>
</div>

<div class="w3-card-4">
    <div class="w3-container w3-center w3-green">
        <h2>Add post</h2>
    </div>
    <div class="w3-container w3-center w3-green">
        <div id="sPhoneFromResponse"></div>
    </div>


    <form:form id="newPostForm" action="${pageContext.request.contextPath}/create.json" commandName="Post">
        <table>
            <tbody>
            <tr>
                <td>Post:</td>
                <td><form:input path="txt"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Create"/></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </form:form>


</div>


</body>
</html>