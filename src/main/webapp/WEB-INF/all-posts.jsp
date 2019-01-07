<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>All posts</title>
    <jsp:include page="head.jsp"/>
    <script>
        function deletePost(id) {

            $.ajax({
                type: "DELETE",
                url: "/post/"+id,
                success: function () {
                    console.log( "delete " + id );
                    var info = $("#tr"+id);
                    info.remove();
                    M.toast({html: 'Post id ='
                            + id
                            + " and content = '"
                            + info[0].getElementsByTagName("td")[1].textContent
                            + "' was deleted" });
                }
            });
        }
        $(document).ready(function () {

        });
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="container">
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Post</th>
                    <th>Actions</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="post" items="${posts}">
                    <tr id="tr${post.id}">
                        <td>${post.id}</td>
                        <td>${post.txt}</td>
                        <td>
                            <a class="waves-effect waves-light btn" id="btn_all" onclick="deletePost(${post.id})">
                                DELETE
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
</main>

</body>
</html>
