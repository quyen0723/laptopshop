<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <link href="/css/styles.css" rel="stylesheet"/>
    <%--    <link href="${pageContext.request.contextPath}/css/demo.css" rel="stylesheet">--%>

</head>
<body class="sb-nav-fixed">
<jsp:include page="../layout/header.jsp"/>
<div id="layoutSidenav">
    <jsp:include page="../layout/sidebar.jsp"/>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">Management User</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                    <li class="breadcrumb-item active">users</li>
                </ol>
                <div class=" mt-5">
                    <div class="row">
                        <div class="col-md-6 col-12 mx-auto">
                            <h3>Update User</h3>
                            <hr/>
                            <%--@elvariable id="newUser" type=""--%>
                            <form:form method="post"
                                       action="${pageContext.request.contextPath}/admin/user/update"
                                       modelAttribute="newUser"
                                       enctype="multipart/form-data">
                                <div class="mb-3" style="display: none">
                                    <label class="form-label">Id: </label>
                                    <form:input type="id" class="form-control" path="id"/>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Email:</label>
                                    <form:input type="email" class="form-control" path="email" disabled="true"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Password:</label>
                                    <form:input type="password" class="form-control" path="password"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Phone number:</label>
                                    <form:input type="text" class="form-control" path="phone"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Full name:</label>
                                    <form:input type="text" class="form-control" path="fullName"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Address:</label>
                                    <form:input type="text" class="form-control" path="address"/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Role:</label>
                                    <form:select class="form-select" path="role.id">
                                        <c:forEach items="${roles}" var="role">
                                            <form:option value="${role.id}" selected="${role.id eq newUser.role.id}">
                                                ${role.name}
                                            </form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Avatar:</label>
                                    <input type="file" class="form-control" name="hoidanitFile" id="hoidanitFile"
                                           accept="image/*" onchange="previewImage(this)">
                                </div>

                                <div class="mb-3">
                                    <img id="avatarPreview"
                                         src="${pageContext.request.contextPath}${newUser.avatar != null ? newUser.avatar : '/images/default-avatar.png'}?t=<%= System.currentTimeMillis() %>"
                                         alt="Avatar Preview"
                                         width="150"/>
                                </div>

                                <button type="submit" class="btn btn-warning">Update</button>

                            </form:form>
                        </div>
                    </div>
                </div>


            </div>
        </main>
        <jsp:include page="../layout/footer.jsp"/>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {
        const avatarImg = $("#avatarPreview");
        let currentSrc = avatarImg.attr("src");
        avatarImg.attr("src", currentSrc + "?t=" + new Date().getTime());
    });
</script>


<script>
    function previewImage(input) {
        const file = input.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function (e) {
                document.getElementById('avatarPreview').src = e.target.result;
            };
            reader.readAsDataURL(file);
        }
    }
</script>
</body>

</html>
