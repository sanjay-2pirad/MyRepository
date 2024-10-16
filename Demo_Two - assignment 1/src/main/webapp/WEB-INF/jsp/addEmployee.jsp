<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .dependent-section {
            border: 1px solid #ddd;
            padding: 15px;
            margin-top: 10px;
            background-color: #f9f9f9;
            position: relative;
        }
        .remove-button {
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
            color: red;
            font-size: 1.2em;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2>Add Employee Details</h2>
        <form id="employeeForm" action="/save-employee" method="post">
            <!-- Employee Information -->
            <div class="form-group">
                <label for="name">Employee Name:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" class="form-control" id="age" name="age" required>
            </div>
            <div class="form-group">
                <label for="sex">Sex:</label>
                <select class="form-control" id="sex" name="sex" required>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
            </div>

            <!-- Dependents Section -->
            <div id="dependents">
                <!-- Dependent fields will be added here dynamically using JavaScript -->
            </div>
            <button type="button" class="btn btn-info mt-3" onclick="addDependent()">Add Dependent</button>

            <!-- Save Employee Button -->
            <button type="submit" class="btn btn-primary mt-3">Save Employee</button>
        </form>
    </div>

    <script>
        let dependentCounter = 0; // Counter to keep track of dependents

        function addDependent() {
            // Create a new div to hold the dependent fields
            let dependentsDiv = document.getElementById("dependents");

            // HTML template for dependent fields
            let html = `
                <div class="dependent-section" id="dependent_${dependentCounter}">
                    <span class="remove-button" onclick="removeDependent(this)">×</span>
                    <div class="form-group">
                        <label for="dependents_${dependentCounter}_name">Dependent Name:</label>
                        <input type="text" class="form-control" id="dependents_${dependentCounter}_name" name="dependents[${dependentCounter}].name" required>
                    </div>
                    <div class="form-group">
                        <label for="dependents_${dependentCounter}_age">Dependent Age:</label>
                        <input type="number" class="form-control" id="dependents_${dependentCounter}_age" name="dependents[${dependentCounter}].age" required>
                    </div>
                    <div class="form-group">
                        <label for="dependents_${dependentCounter}_sex">Dependent Sex:</label>
                        <select class="form-control" id="dependents_${dependentCounter}_sex" name="dependents[${dependentCounter}].sex" required>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                    </div>
                </div>
            `;
            // Insert the new dependent section into the dependents div
            dependentsDiv.insertAdjacentHTML('beforeend', html);
            dependentCounter++; // Increment the counter
        }

        function removeDependent(element) {
            // Remove the dependent section
            element.parentElement.remove();
        }

        // Form submission validation
        document.getElementById("employeeForm").addEventListener("submit", function(event) {
            const dependents = document.querySelectorAll('.dependent-section');

            for (let dependent of dependents) {
                const name = dependent.querySelector('input[name*=".name"]').value;
                const age = dependent.querySelector('input[name*=".age"]').value;

                if (!name || !age) {
                    event.preventDefault(); // Prevent form submission if any fields are empty
                    alert("Please fill all dependent fields before submitting.");
                    return;
                }
            }
        });
    </script>
</body>
</html>
