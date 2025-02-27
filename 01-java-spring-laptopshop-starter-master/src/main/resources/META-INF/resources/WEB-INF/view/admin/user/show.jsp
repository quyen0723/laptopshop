<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
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
                        <h3>Table users</h3>
                        <a href="/admin/user/create" class="btn btn-primary">Create a user</a>
                    </div>
                    <hr/>
                    <table class="table table-hover table-bordered text-center">
                        <thead class="table-light">
                        <tr>
                            <th>ID</th>
                            <th>Email</th>
                            <th>Full Name</th>
                            <th>Role</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${userList}">
                            <tr>
                                <td class="font-weight-bold">${user.id}</td>
                                <td>${user.email}</td>
                                <td>${user.fullName}</td>
                                <td>${user.role.name}</td>
                                <td>
                                    <a href="/admin/user/${user.id}" class="btn btn-success btn-sm">View</a>
                                    <a href="/admin/user/update/${user.id}" class="btn btn-warning btn-sm">Update</a>
                                    <a href="/admin/user/delete/${user.id}" class="btn btn-danger btn-sm">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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
