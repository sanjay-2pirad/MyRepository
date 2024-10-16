<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>View Employees</title>
    <!-- Add Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Add Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- Add DataTables CSS -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css">

    <style>
        body {
            background-color: #f4f6f9;
            padding: 20px;
        }
        table {
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th {
            background-color: #008000; /* Light green background for headers */
            color: #000; /* Black text for contrast */
        }
        td, th {
            text-align: center;
            padding: 12px;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .container {
            max-width: 100%;  /* Ensure the container fits the full width */
            overflow-x: auto; /* Allow horizontal scrolling if the content overflows */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="my-4 text-center">Employee List <i class="fas fa-users"></i></h2>
        <!-- DataTable HTML -->
        <table id="employeeTable" class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th>employeeId</th>
                    <th>Name</th>
                    <th>Sex</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.employeeId}</td>
                        <td>${employee.name}</td>
                        <td>${employee.sex}</td>
                        <td>${employee.age}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Add jQuery and DataTables JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

    <!-- DataTable Initialization -->
    <script>
        $(document).ready(function() {
            $('#employeeTable').DataTable({
                "paging": true,        // Enable pagination
                "searching": true,     // Enable filtering
                "ordering": true,      // Enable sorting
                "info": true,          // Table information (e.g., "Showing X to Y of Z entries")
                "lengthChange": true,  // Allow users to change the number of rows shown
                "pageLength": 5,       // Default number of rows per page
                "autoWidth": false     // Disable automatic width calculation by DataTables
            });
        });
    </script>
</body>
</html>
