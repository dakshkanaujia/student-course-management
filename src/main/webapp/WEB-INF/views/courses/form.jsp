<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${course.id == null ? 'Create' : 'Edit'} Course</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>${course.id == null ? 'Create' : 'Edit'} Course</h2>
        <form:form method="post" modelAttribute="course" class="needs-validation" novalidate="true">
            <div class="mb-3">
                <form:label path="code" class="form-label">Course Code</form:label>
                <form:input path="code" class="form-control" required="true"/>
                <form:errors path="code" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="name" class="form-label">Course Name</form:label>
                <form:input path="name" class="form-control" required="true"/>
                <form:errors path="name" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="credits" class="form-label">Credits</form:label>
                <form:input path="credits" type="number" class="form-control" required="true"/>
                <form:errors path="credits" class="text-danger"/>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/courses" class="btn btn-secondary">Cancel</a>
        </form:form>
    </div>
</body>
</html>