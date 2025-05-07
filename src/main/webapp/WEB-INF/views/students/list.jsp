<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Students List</h2>
        <a href="/students/new" class="btn btn-primary mb-3">Add New Student</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Courses</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.email}</td>
                        <td>
                            <c:forEach items="${student.courses}" var="course">
                                ${course.code} - ${course.name}<br>
                            </c:forEach>
                        </td>
                        <td>
                            <a href="/students/edit/${student.id}" class="btn btn-sm btn-warning">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/courses" class="btn btn-secondary">View Courses</a>
    </div>
</body>
</html>