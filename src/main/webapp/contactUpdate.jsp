<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List, com.codewithmotari.scims.Contact" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <title>Update Contact</title>
</head>
<body>

<% Contact contact=(Contact) request.getAttribute("contact"); %>
<h1 class="text-center">Update  <%= contact.getFullName() %> </h1>



<form class="row g-3 w-50 needs-validation" style="margin:auto" style="margin:auto;" method="POST" action="/contacts/update?id=<%=contact.getId()  %>" >
        <div class="col-md-12">
        <label for="fullname" class="form-label">Full Name</label>
        <input type="text" class="form-control" id="fullname" name="fullname" value="<%= contact.getFullName() %>">
    </div>


    <div class="col-12">
        <label for="phonenumber" class="form-label">Phone Number</label>
        <input type="number" class="form-control" id="phonenumber" name="phonenumber" value="<%= contact.getPhoneNumber() %>">
    </div>
    <div class="col-12">
        <label for="emailaddress" class="form-label">Email Address</label>
        <input type="email" class="form-control" id="emailaddress" name="emailaddress" value="<%= contact.getEmailAddress() %>">
    </div>

            <div class="col-12">
                <label for="date_of_birth" class="form-label">Date of birth</label>
                <input type="date" class="form-control" id="date_of_birth" name="date_of_birth" value="<%= contact.getDOB() %>">
            </div>

    <div class="col-12">
        <label for="idnumber" class="form-label">ID Number</label>
        <input type="number" class="form-control" name="idnumber" id="idnumber" value="<%= contact.getIdNumber() %>">
    </div>

    <div class="col-md-12">
        <label for="gender" class="form-label">Gender</label>
        <select id="gender" class="form-select" name="gender" value="<%= contact.getGender() %>">
            <option selected>Male</option>
            <option>Female</option>
            <option>NonBinary</option>
        </select>
    </div>

            <div class="col-md-10">
                <label for="county" class="county">County</label>
                <select id="county" class="form-select" name="county">
                <>
                    <option selected>County1</option>
                    <option>County2</option>
                    <option>County3</option>
                </select>
            </div>



    <%=
        new java.util.Date()
     %>

    <div class="col-12">
        <button type="submit" class="btn btn-primary btn-lg">Update</button>
    </div>
</form>

    <form action="/" method="get">
    <button type="submit" class="btn btn-outline-danger">Log Out</button>
    </form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>