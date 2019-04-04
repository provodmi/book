<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>Main page</title>
    <jsp:include page="head.jsp"/>
    <script>
        $(document).ready(function () {

            $("#save").click(function () {
                var txt = $('#txt').val();
                var json = {"txt": txt};
                console.log(txt);
                $.ajax({
                    type: "POST",
                    url: "/book/",
                    data: JSON.stringify(json),
                    success: function (data) {
                        console.log(data);
                    },
                    dataType: "application/json",
                    contentType: "application/json"
                });
            });

            // $('#save').onclick(function (event) {
            //     var txt = $('#txt').val();
            //     var json = {"txt": txt};
            //
            //     $.ajax({
            //         url: $("#newPostForm").attr("action"),
            //         data: JSON.stringify(json),
            //         type: "POST",
            //
            //         beforeSend: function (xhr) {
            //             xhr.setRequestHeader("Accept", "application/json");
            //             xhr.setRequestHeader("Content-Type", "application/json");
            //         },
            //         success: function (book) {
            //             var respContent = "";
            //
            //             respContent += "&lt;span class='success'>Book was created: [";
            //             respContent += book.txt + "]</span>";
            //
            //             $("#PostFromResponse").html(respContent);
            //         }
            //     });
            //
            //     event.preventDefault();
            // });

        });

    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="container">

    </div>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>