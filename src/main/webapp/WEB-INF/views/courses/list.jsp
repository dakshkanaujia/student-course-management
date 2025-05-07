<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courses List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Courses List</h2>
        <a href="/courses/new" class="btn btn-primary mb-3">Add New Course</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Credits</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${courses}" var="course">
                    <tr>
                        <td>${course.id}</td>
                        <td>${course.code}</td>
                        <td>${course.name}</td>
                        <td>${course.credits}</td>
                        <td>
                            <a href="/courses/edit/${course.id}" class="btn btn-sm btn-warning">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/students" class="btn btn-secondary">View Students</a>
    </div>
</body>
</html>