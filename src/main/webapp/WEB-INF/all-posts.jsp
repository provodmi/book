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
                url: "/book/"+id,
                success: function () {
                    console.log( "delete " + id );
                    var info = $("#tr"+id);
                    info.remove();
                    M.toast({html: 'Book id ='
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
                <c:forEach var="book" items="${posts}">
                    <tr id="tr${book.id}">
                        <td>${book.id}</td>
                        <td>${book.txt}</td>
                        <td>
                            <a class="waves-effect waves-light btn" id="btn_all" onclick="deletePost(${book.id})" >
                                DELETE
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>
