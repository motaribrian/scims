<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List, com.codewithmotari.scims.model.Contact" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <!-- intl-tel-input CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/intl-tel-input@17/build/css/intlTelInput.min.css"/>

    <!-- intl-tel-input JS -->
    <script src="https://cdn.jsdelivr.net/npm/intl-tel-input@17/build/js/intlTelInput.min.js"></script>

    <!-- Optional: utils.js for formatting/validation -->
    <script src="https://cdn.jsdelivr.net/npm/intl-tel-input@17/build/js/utils.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <title>Update Contact</title>
</head>
<body>
<%
    Object username=request.getSession().getAttribute("username");
    if(username==null){
        request.getRequestDispatcher("/logo.jsp").forward(request,response);
        return;
    }

%>

<% Contact contact=(Contact) request.getAttribute("contact"); %>
<h1 class="text-center">Update  <%= contact.getFullName() %> </h1>



<form class="row g-3 w-50 needs-validation" style="margin:auto" style="margin:auto;" method="POST" action="/contacts/update?id=<%=contact.getId()  %>" >
        <div class="col-md-12">
        <label for="fullname" class="form-label">Full Name</label>
        <input type="text" class="form-control" id="fullname" name="fullname" value="<%= contact.getFullName() %>">
    </div>

    <div class="col-12">
        <input type="hidden" name="full_phone" id="full_phone">
        <label for="phone" class="form-label">Phone Number</label><br>
        <input type="tel" id="phone" class="form-control" name="phone" value=<%=contact.getPhoneNumber()%>>
    </div>


<%--    <div class="col-12">--%>
<%--        <label for="phonenumber" class="form-label">Phone Number</label>--%>
<%--        <input type="number" class="form-control" id="phonenumber" name="phonenumber" value="<%= contact.getPhoneNumber() %>">--%>
<%--    </div>--%>
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
            <option selected ><%=contact.getGender()%></option>
            <option>Female</option>
            <option>NonBinary</option>
        </select>
    </div>

            <div class="col-md-10">
                <label for="county" class="county">County</label>
                <select id="county" class="form-select" name="county" value="<%=contact.getCounty()%>">
                <>
                    <option selected><%=contact.getCounty()%></option>
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
                    <option>Meru</option>
                    <option>Tharaka-Nithi</option>
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

<script>
    const phoneInput = document.querySelector("#phone");
    const fullPhoneInput = document.querySelector("#full_phone");

    const iti = window.intlTelInput(phoneInput, {
        initialCountry: "auto",
        geoIpLookup: function (callback) {
            fetch("https://ipinfo.io?token=efa15fc6c75fba")
                .then((resp) => resp.json())
                .then((resp) => callback(resp.country))
                .catch(() => callback("us"));
        },
        utilsScript: "https://cdn.jsdelivr.net/npm/intl-tel-input@17/build/js/utils.js",
        separateDialCode: true,
    });

    // Add submit handler
    const form = phoneInput.closest("form");
    form.addEventListener("submit", function (e) {
        // Store the full number in the hidden input
        fullPhoneInput.value = iti.getNumber();
    });
</script>


</body>
</html>