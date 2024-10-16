<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
        }

        .form-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 15px;
        }

        .form-group label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }

        .form-group input {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
            box-sizing: border-box;
        }

        .form-group button,
        .form-group input[type="submit"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-group input[type="submit"]:hover,
        .form-group button:hover {
            background-color: #45a049;
        }

        /* Modal styles */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            justify-content: center;
            align-items: center;
        }

        .modal-content {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            width: 80%;
            max-width: 500px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.3);
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        .modal .form-group {
            margin-bottom: 10px;
        }

        .message {
            margin-top: 15px;
            color: green;
            font-weight: bold;
        }
    </style>

    <script type="text/javascript">
        function openDependentDetailsWindow() {
            document.getElementById('dependentModal').style.display = 'flex';
            document.getElementById('dependentForm').reset(); // Reset form fields
            document.getElementById('dependentMessage').innerHTML = ''; // Clear any previous messages
        }

        function closeModal() {
            document.getElementById('dependentModal').style.display = 'none';
        }

        // Close modal when clicking outside the modal content
        window.onclick = function(event) {
            const modal = document.getElementById('dependentModal');
            if (event.target === modal) {
                modal.style.display = 'none';
            }
        }
    </script>
</head>
<body>

    <div class="form-container">
        <form action="addEmployee" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" placeholder="Enter your name" required />
            </div>

            <div class="form-group">
                <label for="sex">Sex:</label>
                <input type="text" id="sex" name="sex" placeholder="Enter your sex" required />
            </div>

            <div class="form-group">
                <label for="age">Age:</label>
                <input type="text" id="age" name="age" placeholder="Enter your age" required />
            </div>

            <div class="form-group">
                <input type="submit" value="Save" />
            </div>

            <!-- Button to open modal for "dependent details" -->
            <div class="form-group">
                <button type="button" onclick="openDependentDetailsWindow()">Add Dependent</button>
            </div>
        </form>
    </div>

    <!-- Modal for adding dependent details -->
    <div id="dependentModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h2>Add Dependent Details</h2>

            <!-- Dependent form now submits to /addDependent in the backend -->
            <form id="dependentForm" action="addDependent" method="post">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" placeholder="Enter Name" required>
                </div>
                <div class="form-group">
                    <label for="age">Age:</label>
                    <input type="number" id="age" name="age" placeholder="Enter Age" required>
                </div>
                <div class="form-group">
                    <label for="sex">Sex:</label>
                    <input type="text" id="sex" name="sex" placeholder="Enter Sex" required>
                </div>
                <div class="form-group">
                    <label for="dependentOn">Dependent On:</label>
                    <input type="number" id="dependentOn" name="dependentOn" placeholder="Enter Dependent On" required>
                </div>
                <div class="form-group">
                    <button type="submit">Save</button>
                </div>
            </form>

            <!-- Success message and "Add More" button -->
            <div id="dependentMessage" class="message"></div>
            <button id="addMoreButton" type="button" style="display:none;" onclick="openDependentDetailsWindow()">Add More</button>
        </div>
    </div>

</body>
</html>
