<%@ page import="com.codewithmotari.scims.model.Contact" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Please Add the new Contact</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- intl-tel-input CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/intl-tel-input@18/build/css/intlTelInput.min.css"/>

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- intl-tel-input JS -->
    <script src="https://cdn.jsdelivr.net/npm/intl-tel-input@18/build/js/intlTelInput.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/intl-tel-input@18/build/js/utils.js"></script>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<%
    Object username = request.getSession().getAttribute("username");
    if (username == null) {
        request.getRequestDispatcher("/logo.jsp").forward(request, response);
    }
%>

<h1 class="text-uppercase text-center">Contact Add Form</h1>

<form action="/contacts/add" class="row g-3 w-50 needs-validation" style="margin:auto;" method="POST" enctype="multipart/form-data" id="contactForm">
    <div class="card p-4 shadow">
        <!-- Step 1 -->
        <div class="wizard-step" id="step1">
            <h4 class="mb-3">Step 1: Personal Info</h4>
            <div class="col-md-12">
                <label for="firstname" class="form-label">Full Name</label>
                <input type="text" class="form-control" id="firstname" name="firstname" placeholder="John" required>
            </div>

            <div class="col-12">
                <input type="hidden" name="full_phone" id="full_phone">
                <label for="phone" class="form-label">Phone Number</label><br>
                <input type="tel" id="phone" class="form-control" name="phone" required>
                <div id="phone-error" style="color: red; display: none; font-size: 0.9em;"></div>
            </div>

            <div class="col-12">
                <label for="emailaddress" class="form-label">Email Address</label>
                <input type="email" class="form-control" id="emailaddress" name="emailaddress" placeholder="johndoe@email.mail" required>
                <div id="email-error" style="color: red; display: none; font-size: 0.9em;"></div>
            </div>

            <button type="button" class="btn btn-primary" onclick="nextStep(2)">Next</button>
        </div>

        <!-- Step 2 -->
        <div class="wizard-step d-none" id="step2">
            <h4 class="mb-3">Step 2: Identity Info</h4>
            <div class="col-12">
                <label for="date_of_birth" class="form-label">Date of Birth</label>
                <input type="date" class="form-control" id="date_of_birth" name="date_of_birth" required>
                <div id="date_of_birth-error" style="color: red; display: none; font-size: 0.9em;"></div>
            </div>

            <div class="col-12">
                <label for="idnumber" class="form-label">ID Number</label>
                <input type="number" class="form-control" name="idnumber" id="idnumber" required>
                <div id="idnumber-error" style="color: red; display: none; font-size: 0.9em;"></div>
            </div>

            <div class="col-12">
                <label class="form-label" for="idfile">Please Upload your ID</label>
                <input type="file" class="form-control" id="idfile" name="idfile" required/>
            </div>
            <button type="button" class="btn btn-secondary" onclick="nextStep(1)">Back</button>
            <button type="button" class="btn btn-primary" onclick="nextStep(3)">Next</button>
        </div>

        <!-- Step 3 -->
        <div class="wizard-step d-none" id="step3">
            <h4 class="mb-3">Step 3: Demographics</h4>
            <div class="col-md-12">
                <label for="gender" class="form-label">Gender</label>
                <select id="gender" class="form-select" name="gender" required>
                    <option selected disabled>Choose...</option>
                    <option>Male</option>
                    <option>Female</option>
                    <option>NonBinary</option>
                </select>
            </div>

            <div class="col-md-12">
                <label for="county" class="form-label">County</label>
                <select id="county" class="form-select" name="county" required>
                    <option selected disabled>County</option>
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


            <button type="button" class="btn btn-secondary" onclick="nextStep(2)">Back</button>
            <button type="submit" class="btn btn-success">Submit</button>
        </div>

    </div>
</form>


<br>

<form action="/" method="get" class="row g-3 w-50" style="margin:auto;">
    <button type="submit" class="btn btn-outline-danger">Log Out</button>
</form>

<script>
    const input = document.querySelector("#phone");
    const fullPhoneInput = document.querySelector("#full_phone");
    const phoneError = document.querySelector("#phone-error");
    const form = document.querySelector("#contactForm");
    let iso2="";

    const iti = window.intlTelInput(input, {
        initialCountry: "auto",
        geoIpLookup: function (callback) {
            fetch("https://ipinfo.io/json?token=efa15fc6c75fba")
                .then((resp) => resp.json())
                .then((resp) => callback(resp.country))
                .catch(() => callback("us"));
        },
        utilsScript: "https://cdn.jsdelivr.net/npm/intl-tel-input@18/build/js/utils.js"
    });

    function nextStep(step) {
        document.querySelectorAll(".wizard-step").forEach(div => div.classList.add("d-none"));
        document.getElementById("step" + step).classList.remove("d-none");
    }

    function validatePhoneNumber() {
        if (input.value.trim()) {
            if (iti.isValidNumber()) {
                fullPhoneInput.value = iti.getNumber();
                iso2=iti.getSelectedCountryData().iso2;
                phoneError.style.display = "none";
                return true;
            } else {
                const errorCode = iti.getValidationError();
                let message = "Invalid phone number.";
                switch (errorCode) {
                    case intlTelInputUtils.validationError.TOO_SHORT:
                        message = "Phone number is too short.";
                        break;
                    case intlTelInputUtils.validationError.TOO_LONG:
                        message = "Phone number is too long.";
                        break;
                    case intlTelInputUtils.validationError.INVALID_COUNTRY_CODE:
                        message = "Invalid country code.";
                        break;
                    case intlTelInputUtils.validationError.NOT_A_NUMBER:
                        message = "Input is not a number.";
                        break;
                }
                phoneError.textContent = message;
                phoneError.style.display = "block";
                fullPhoneInput.value = "";
                return false;
            }
        } else {
            phoneError.textContent = "Phone number is required.";
            phoneError.style.display = "block";
            return false;
        }
    }

    input.addEventListener("blur", validatePhoneNumber);

    form.addEventListener("submit", function (e) {
        if (!validatePhoneNumber()) {
            e.preventDefault();
        }
    });
</script>

</body>
</html>
