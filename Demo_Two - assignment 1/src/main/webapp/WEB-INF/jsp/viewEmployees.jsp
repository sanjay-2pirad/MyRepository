<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>View Employees</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
            background-color: #008000;
            color: #000;
        }
        td, th {
            text-align: center;
            padding: 12px;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .container {
            max-width: 100%;
            overflow-x: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="my-4 text-center">Employee List <i class="fas fa-users"></i></h2>
        <table id="employeeTable" class="table table-hover table-bordered">
            <thead>
                <tr>
                    <th>employeeId</th>
                    <th>Name</th>
                    <th>Sex</th>
                    <th>Age</th>
                    <th>Dependent Details</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.employeeId}</td>
                        <td>${employee.name}</td>
                        <td>${employee.sex}</td>
                        <td>${employee.age}</td>
                        <td>
                            <button class="btn btn-primary" onclick="viewDependents(`${employee.employeeId}`)">View Dependents</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap Modal for Dependents -->
    <div class="modal fade" id="dependentsModal" tabindex="-1" aria-labelledby="dependentsModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="dependentsModalLabel">Dependents</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div id="dependentsList"></div>
                </div>
            </div>
        </div>
    </div>
<script>
        function viewDependents(employeeId) {
            $.ajax({
                url: employeeId + '/dependents', // Endpoint to get dependents view
                method: 'GET',
                success: function(html) {
                console.log("html response received:");
                    // Inject the HTML response into the modal's content
                    $('#dependentsList').html(html);
                    // Show the modal
                    $('#dependentsModal').modal('show');
                },
                error: function() {
                    alert('Error retrieving dependents.');
                }
            });
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        $(document).ready(function() {
            $('#employeeTable').DataTable({
                "paging": true,
                "searching": true,
                "ordering": true,
                "info": true,
                "lengthChange": true,
                "pageLength": 5,
                "autoWidth": false
            });
        });
    </script>
</body>
</html>
