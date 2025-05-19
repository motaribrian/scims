<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.codewithmotari.scims.Contact" %> <!-- Import the actual package of your Contact class -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- Include Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            padding-top: 30px;
        }
        .card {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

<div class="container">

    <h1 class="text-center my-4">Admin Dashboard</h1>

    <!-- Gender Distribution Chart -->
    <div class="row">
        <div class="col-lg-6 col-md-12">
            <div class="card shadow-sm">
                <div class="card-header">
                    <h5 class="card-title mb-0">Users by Gender</h5>
                </div>
                <div class="card-body">
                    <canvas id="genderChart"></canvas>
                </div>
            </div>
        </div>

        <!-- Counties Distribution Chart -->
        <div class="col-lg-6 col-md-12">
            <div class="card shadow-sm">
                <div class="card-header">
                    <h5 class="card-title mb-0">Users by County</h5>
                </div>
                <div class="card-body">
                    <canvas id="countyChart"></canvas>
                </div>
            </div>
        </div>
    </div>

    <!-- Last 5 Added Contacts Section -->
    <div class="row">
        <div class="col-12">
            <div class="card shadow-sm">
                <div class="card-header">
                    <h5 class="card-title mb-0">Last 5 Added Contacts</h5>
                </div>
                <div class="card-body">
                    <ul class="list-group">
                        <%
                            // Retrieve the response map from the request
                            Map<String, Map<String, List<Contact>>> responseMap = (Map<String, Map<String, List<Contact>>>) request.getAttribute("admindto");

                            // Get the list of contacts by gender and last added contacts
                            Map<String, List<Contact>> genderData = responseMap.get("Gender");
                            Map<String, List<Contact>> countyData = responseMap.get("Counties");

                            // Check if last5Added is a Map<String, List<Contact>> or List<Contact>
                            Map<String, List<Contact>> last5AddedData = responseMap.get("last5Added");

                            // Prepare Gender Data
                            StringBuilder genderLabels = new StringBuilder("[");
                            StringBuilder genderCounts = new StringBuilder("[");
                            for (Map.Entry<String, List<Contact>> entry : genderData.entrySet()) {
                                genderLabels.append("'").append(entry.getKey()).append("', ");
                                genderCounts.append(entry.getValue().size()).append(", ");
                            }
                            if (genderLabels.length() > 1) {
                                genderLabels.setLength(genderLabels.length() - 2);
                                genderCounts.setLength(genderCounts.length() - 2);
                            }
                            genderLabels.append("]");
                            genderCounts.append("]");

                            // Prepare County Data
                            StringBuilder countyLabels = new StringBuilder("[");
                            StringBuilder countyCounts = new StringBuilder("[");
                            for (Map.Entry<String, List<Contact>> entry : countyData.entrySet()) {
                                countyLabels.append("'").append(entry.getKey()).append("', ");
                                countyCounts.append(entry.getValue().size()).append(", ");
                            }
                            if (countyLabels.length() > 1) {
                                countyLabels.setLength(countyLabels.length() - 2);
                                countyCounts.setLength(countyCounts.length() - 2);
                            }
                            countyLabels.append("]");
                            countyCounts.append("]");
                        %>

                        <!-- Displaying Last 5 Added Contacts -->
                        <% if (last5AddedData != null) { %>
                            <%
                                List<Contact> last5Contacts = null;
                                for (Map.Entry<String, List<Contact>> entry : last5AddedData.entrySet()) {
                                    last5Contacts = entry.getValue();
                                    break; // Only get the first list of contacts
                                }
                            %>
                            <% for (Contact contact : last5Contacts) { %>
                                <li class="list-group-item">
                                    <strong><%= contact.getFullName() %></strong>
                                    (Gender: <%= contact.getGender() %>, County: <%= contact.getCounty() %>)
                                </li>
                            <% } %>
                        <% } %>
                    </ul> <!-- Removed second closing </ul> here -->
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Bootstrap JS and dependencies (jQuery and Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    // Gender Distribution Chart
    var genderLabels = <%= genderLabels.toString() %>;
    var genderCounts = <%= genderCounts.toString() %>;

    var ctx1 = document.getElementById('genderChart').getContext('2d');
    var genderChart = new Chart(ctx1, {
        type: 'pie',
        data: {
            labels: genderLabels,
            datasets: [{
                label: 'Gender Distribution',
                data: genderCounts,
                backgroundColor: ['#FF9999', '#66B2FF', '#99FF99'],
                borderColor: '#fff',
                borderWidth: 1
            }]
        }
    });

    // Counties Distribution Chart
    var countyLabels = <%= countyLabels.toString() %>;
    var countyCounts = <%= countyCounts.toString() %>;

    var ctx2 = document.getElementById('countyChart').getContext('2d');
    var countyChart = new Chart(ctx2, {
        type: 'bar',
        data: {
            labels: countyLabels,
            datasets: [{
                label: 'County Distribution',
                data: countyCounts,
                backgroundColor: '#66B2FF',
                borderColor: '#007BFF',
                borderWidth: 1
            }]
        }
    });
</script>

</body>
</html>
