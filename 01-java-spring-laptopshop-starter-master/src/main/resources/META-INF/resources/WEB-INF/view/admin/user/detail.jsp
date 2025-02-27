<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Detail ${id}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <link href="/css/styles.css" rel="stylesheet"/>
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
                <div class="mt-5">
                    <div class="d-flex justify-content-between align-items-center mb-4">
                        <h3>User Detail with id = ${id}</h3>
                    </div>
                    <hr/>
                    <c:if test="${not empty user}">
                        <div class="card" style="width: 60%;">
                            <img style="height: 150px; width: auto; object-fit: contain;" class="card-img-top"
                                 src="${user.avatar}"
                                 alt="Card image cap">
                            <div class="card-header">
                                User information
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">ID: ${user.id}</li>
                                <li class="list-group-item">Role: ${user.role.name}</li>
                                <li class="list-group-item">Email: ${user.email}</li>
                                <li class="list-group-item">Password: ${user.password}</li>
                                <li class="list-group-item">Phone number: ${user.phone}</li>
                                <li class="list-group-item">Full name: ${user.fullName}</li>
                                <li class="list-group-item">Address: ${user.address}</li>
                            </ul>
                        </div>
                    </c:if>
                </div>

            </div>
        </main>
        <jsp:include page="../layout/footer.jsp"/>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
</body>

</html>
