<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${student.id == null ? 'Create' : 'Edit'} Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>${student.id == null ? 'Create' : 'Edit'} Student</h2>
        <form:form method="post" modelAttribute="student" class="needs-validation" novalidate="true">
            <div class="mb-3">
                <form:label path="firstName" class="form-label">First Name</form:label>
                <form:input path="firstName" class="form-control" required="true"/>
                <form:errors path="firstName" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="lastName" class="form-label">Last Name</form:label>
                <form:input path="lastName" class="form-control" required="true"/>
                <form:errors path="lastName" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="email" class="form-label">Email</form:label>
                <form:input path="email" type="email" class="form-control" required="true"/>
                <form:errors path="email" class="text-danger"/>
            </div>
            <div class="mb-3">
                <form:label path="courses" class="form-label">Courses</form:label>
                <form:select path="courses" items="${courses}" itemValue="id" itemLabel="name" 
                           class="form-control" multiple="true"/>
                <form:errors path="courses" class="text-danger"/>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/students" class="btn btn-secondary">Cancel</a>
        </form:form>
    </div>
</body>
</html>