<!DOCTYPE html>
<%@ page import="com.codewithmotari.scims.Contact" %>
<%@ page language="java"
contentType="text/html;charset=UTF-8"
%>

Contact createContact(String name,String email,String phone){
    Contact contact=new Contact();
}
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <title>Please Add the new Contact</title>
</head>
<body>
<h1>Contact Add Form</h1>



<form class="row g-3" style="margin:auto;" method="POST" >
    <div class="col-md-5">
        <label for="firstname" class="form-label">First Name</label>
        <input type="text" class="form-control" id="firstname" name="firstname" placeholder="john">
    </div>
    <div class="col-md-5">
        <label for="lastname" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="lastname" name"lastname" placeholder="doe">
    </div>
    <div class="col-10">
        <label for="phonenumber" class="form-label">Phone Number</label>
        <input type="number" class="form-control" id="phonenumber" name="phonenumber" placeholder="0700000000">
    </div>
    <div class="col-10">
        <label for="emailaddress" class="form-label">Email Address</label>
        <input type="email" class="form-control" id="emailaddress" name="emailaddress" placeholder="johndoe@email.mail">
    </div>

        <div class="col-10">
            <label for="date_of_birth" class="form-label">Date of birth</label>
            <input type="date" class="form-control" id="date_of_birth" name="date_of_birth" placeholder="johndoe@email.mail">
        </div>

    <div class="col-10">
        <label for="idnumber" class="form-label">ID Number</label>
        <input type="number" class="form-control" name="idnumber" id="idnumber">
    </div>

    <div class="col-md-10">
        <label for="gender" class="form-label">Gender</label>
        <select id="gender" class="form-select" name="gender">
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
        <button type="submit" class="btn btn-primary btn-lg")">Register</button>
    </div>
</form>

    <form action="/" method="get">
    <button type="submit" class="btn btn-outline-danger">Log Out</button>
    </form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>