
<!DOCTYPE html>
<%@ page import="com.codewithmotari.scims.Contact" %>
<%@ page language="java"
contentType="text/html;charset=UTF-8"
%>


<html lang="en">
<head>
    <meta charset="UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <title>Please Add the new Contact</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- intl-tel-input CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/css/intlTelInput.min.css">

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- intl-tel-input JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/intlTelInput.min.js"></script>

    <!-- Bootstrap JS (optional, for additional Bootstrap components) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<%
    Object username=request.getSession().getAttribute("username");
    if(username==null){
        request.getRequestDispatcher("/logo.jsp").forward(request,response);
    }
%>
<h1 class="text-uppercase text-center">Contact Add Form</h1>



<form class="row g-3 w-50 needs-validation" style="margin:auto;" method="POST" enctype="multipart/form-data" >
    <div class="col-md-12">
        <label for="firstname" class="form-label">Full Name</label>
        <input type="text" class="form-control" id="firstname" name="firstname" placeholder="john">
    </div>



    <div class="col-12">
        <label for="phonenumber" class="form-label">Phone Number</label>
        <input type="tel" class="form-control" id="phonenumber" name="phonenumber" placeholder="0700000000">
    </div><br>
    <div class="col-12">
        <label for="emailaddress" class="form-label">Email Address</label>
        <input type="email" class="form-control" id="emailaddress" name="emailaddress" placeholder="johndoe@email.mail">
    </div><br>

        <div class="col-12">
            <label for="date_of_birth" class="form-label">Date of birth</label>
            <input type="date" class="form-control" id="date_of_birth" name="date_of_birth" placeholder="johndoe@email.mail">
        </div><br>

    <div class="col-12">
        <label for="idnumber" class="form-label">ID Number</label>
        <input type="number" class="form-control" name="idnumber" id="idnumber">
    </div><br>

    <label class="form-label" for="idfile">Please Upload your ID</label>
    <input type="file" class="form-control" id="idfile" name="idfile" />

    <div class="col-md-12">
        <label for="gender" class="form-label">Gender</label>
        <select id="gender" class="form-select" name="gender">
            <option selected>Male</option>
            <option>Female</option>
            <option>NonBinary</option>
        </select>
    </div><br>
        <div class="col-md-12">
            <label for="county" class="county">County</label>
            <select id="county" class="form-select" name="county">
            <>
                <option selected>County</option>
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
        </div><br>


    <div   class="col-md-12">
        <button type="submit" class="col-12 btn btn-primary btn-lg">Register</button>
    </div><br>
</form>
     <br>
    <form action="/" method="get" class="row g-3 w-50 "style="margin:auto;">
    <button type="submit" class="btn btn-outline-danger">Log Out</button>
    </form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>

<script>
    $(document).ready(function() {
        var input = document.querySelector("#phone");
        window.intlTelInput(input, {
            initialCountry: "auto",
            geoIpLookup: function(callback) {
                $.get("https://ipinfo.io", function() {}, "jsonp").always(function(resp) {
                    var countryCode = (resp && resp.country) ? resp.country : "us";
                    callback(countryCode);
                });
            },
            utilsScript: "https://cdnjs.cloudflare.com/ajax/libs/intl-tel-input/17.0.8/js/utils.js"
        });
    });
</script>

</body>
</html>