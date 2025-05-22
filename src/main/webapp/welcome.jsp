<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List, com.codewithmotari.scims.Contact" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">SCIMS</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                        User
                    </button>
                    <ul class="dropdown-menu dropdown-menu-dark">
                        <li><a class="dropdown-item" href="#">Logout</a></li>
                        <li><a class="dropdown-item" href="#">Switch User</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<% String username=session.getAttribute("username").toString(); %>

<h2>WELCOME <%= username %></h2>
<hr>


<div class="input-group input-group-lg">
    <div class="input-group-prepend">
        <span class="input-group-text" id="inputGroup-sizing-lg">Filter By</span>
    </div>
    <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm">
</div>


<table class="table">
    <thead>
        <tr>
            <th scope="col">Full Names</th>
            <th scope="col">Email Address</th>
            <th scope="col">Phone Number</th>
            <th scope="col">DOB</th>
            <th scope="col">Gender</th>
            <th scope="col">County</th>
            <th scope="col">Update</th>
            <th scope="col">Delete</th>
        </tr>
    </thead>
    <tbody>
        <%

            // Retrieve the list of contacts from the session
            List<Contact> contacts = (List<Contact>) session.getAttribute("contacts");
            // Check if contacts are available and not empty
            if (contacts != null && !contacts.isEmpty()) {
                for (Contact contact : contacts) {
        %>
        <tr>
            <th scope="row"><%= contact.getFullName() %></th>
            <td><%= contact.getEmailAddress() %></td>
            <td><%= contact.getPhoneNumber() %></td>
            <td><%= contact.getDOB() %></td>
            <td><%= contact.getGender() %></td>
            <td><%= contact.getCounty() %></td>
            <td><a href="/contacts/update?id=<%=contact.getId()  %>" class="btn btn-warning">Update</a></td>
            <td><a href="/contacts/delete?id=<%= contact.getId() %>" class="btn btn-danger">Delete</a></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="8">No contacts available</td></tr>
        <%
            }
        %>
    </tbody>
</table>

<button type="button" class="btn btn-success" onClick="location.href='/contacts/add';">Add New</button>
<form action="/" method="get">
    <button type="submit" class="btn btn-outline-danger">Log Out</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>

</body>
</html>
