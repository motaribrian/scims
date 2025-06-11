<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List, com.codewithmotari.scims.model.Contact" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
<%
    Object username=request.getSession().getAttribute("username");
    if(username==null){
        request.getRequestDispatcher("/logo.jsp").forward(request,response);
        return;
    }

%>




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


<h2>WELCOME <%= username.toString().toUpperCase()%></h2>
<hr>


<form method="get" action="${pageContext.request.contextPath}/welcome" class="row g-3 my-3">

    <div class="col-md-3">

        <label for="gender" class="form-label">Search by Gender</label>
<%--        <input type="text" id="gender" name="gender" class="form-control" value="<%= request.getParameter("gender") != null ? request.getParameter("gender") : "" %>">--%>
        <select id="gender" class="form-select" name="gender">
            <option selected> <%= request.getParameter("gender") != null ? request.getParameter("gender") : "" %></option>
            <option></option>
            <option >Male</option>
            <option>Female</option>
            <option>NonBinary</option>
        </select>
    </div>
    <div class="col-md-3">
        <label for="county" class="form-label">Search by County</label>
<%--        <input type="text" id="county" name="county" class="form-control" value="<%= request.getParameter("county") != null ? request.getParameter("county") : "" %>">--%>
        <select id="county" class="form-select" name="county">
            <option selected> <%= request.getParameter("county") != null ? request.getParameter("county") : "" %></option>
            <option></option>
            <option >County</option>
            <option>Mombasa</option>
            <option>Kwale</option>
            <option>Kilifi</option>
            <option>Tana-River</option>
            <option>Lamu</option>
            <option>Taita-Taveta</option>
            <option>Garissa</option>
            <option>Wajir</option>
            <option>Mandera</option>
            <option>Marsabit</option>
            <option>Isiolo</option>
            <option>Meru</option><option>Tharaka-Nithi</option>
            <option>Embu</option>
            <option>Kitui</option>
            <option>Machakos</option>
            <option>Makueni</option>
            <option>Nyandarua</option>
            <option>Kirinyaga</option>
            <option>Nyeri</option>
            <option>Muranga</option>
            <option>Kiambu</option>
            <option>Turkana</option>
            <option>West-pokot</option>
            <option>Samburu</option>
            <option>Trans-Nzoia</option>
            <option>Uasin-Gishu</option>
            <option>Elgeyo-Marakwet</option>
            <option>Nandi</option>
            <option>Baringo</option>
            <option>Laikipia</option>
            <option>Nakuru</option>
            <option>Narok</option>
            <option>Kajiado</option>
            <option>Kericho</option>
            <option>Bomet</option>
            <option>Kakamega</option>
            <option>Vihiga</option>
            <option>Bungoma</option>
            <option>Busia</option>
            <option>Siaya</option>
            <option>Kisumu</option>
            <option>Homa-Bay</option>
            <option>Migori</option>
            <option>Kisii</option>
            <option>Nyamira</option>
            <option>Nairobi</option>



        </select>
    </div>
    <div class="col-md-3 d-flex align-items-end">
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
    <div class="col-md-3">
        <label for="gender" class="form-label">print</label>
        <button type="submit" class="form-input btn-btn-primary" formaction="/contacts/print">Print</button>
    </div>
</form>




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
        String genderFilter = request.getParameter("gender");
        String countyFilter = request.getParameter("county");

        List<Contact> contacts = (List<Contact>) session.getAttribute("contacts");
        if (contacts != null && !contacts.isEmpty()) {
            boolean matchFound = false;
            for (Contact contact : contacts) {
                boolean matchesGender = (genderFilter == null || genderFilter.isEmpty()) || contact.getGender().equalsIgnoreCase(genderFilter);
                boolean matchesCounty = (countyFilter == null || countyFilter.isEmpty()) || contact.getCounty().equalsIgnoreCase(countyFilter);

                if (matchesGender && matchesCounty) {
                    matchFound = true;
    %>
    <tr>
        <td><%= contact.getFullName() %></td>
        <td><%= contact.getEmailAddress() %></td>
        <td>+<%= contact.getPhoneNumber() %></td>
        <td><%= contact.getDOB() %></td>
        <td><%= contact.getGender() %></td>
        <td><%= contact.getCounty() %></td>
        <td><a href="/contacts/update?id=<%= contact.getId() %>" class="btn btn-warning">Update</a></td>
        <td><a href="/contacts/delete?id=<%= contact.getId() %>" class="btn btn-danger">Delete</a></td>
    </tr>
    <%
            }
        }
        if (!matchFound) {
    %>
    <tr><td colspan="8">No matching contacts found.</td></tr>
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
<form action="/login" method="get">
    <button type="submit" class="btn btn-outline-danger">Log Out</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>

</body>
</html>
