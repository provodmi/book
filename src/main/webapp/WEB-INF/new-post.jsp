<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
    <title>Add book</title>
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
        });

    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<main>
    <div class="container">
        <div class="row">
            <div class="col s8">
                <form>
                    <div class="row">
                        <div class="input-field col s6">
                            <input id="txt" type="text" required>
                            <label for="txt">Post</label>
                        </div>
                    </div>
                    <a class="waves-effect waves-light btn" id="save">Save</a>
                </form>
                </div>
            </div>
        </div>
    </div>
</main>
<jsp:include page="footer.jsp"/>
</body>
</html>