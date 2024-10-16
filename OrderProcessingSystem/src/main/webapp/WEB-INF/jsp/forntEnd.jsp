<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Processing System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        label, input {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            background-color: #5cb85c;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #4cae4c;
        }
        #orderList ul {
            background-color: #fff;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            list-style-type: none;
        }
        #orderList ul li {
            padding: 8px 0;
            border-bottom: 1px solid #ddd;
        }
    </style>
</head>
<body>

    <h1>Order Processing System</h1>

    <form id="orderForm">
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" placeholder="Enter product name" required>

        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" placeholder="Enter quantity" required>

        <button type="button" id="placeOrder">Place Order</button>
    </form>

    <div id="orderList">
        <h2>Order List</h2>
        <ul></ul>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            // Load orders on page load
            loadOrders();

            // Place order button click event
            $('#placeOrder').click(function() {
                const productName = $('#productName').val();
                const quantity = $('#quantity').val();

                // Validate inputs
                if (productName.trim() === "" || quantity.trim() === "" || quantity <= 0) {
                    alert('Please provide valid product name and quantity.');
                    return;
                }

                // Make AJAX POST request to place the order
                $.ajax({
                    url: '/api/orders',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify({
                        productName: productName,
                        quantity: quantity
                    }),
                    success: function(result) {
                        alert('Order placed successfully');
                        // Clear input fields
                        $('#productName').val('');
                        $('#quantity').val('');
                        // Reload orders list
                        loadOrders();
                    },
                    error: function() {
                        alert('Failed to place order. Please try again.');
                    }
                });
            });

            // Load orders using AJAX GET request
            function loadOrders() {
                $.ajax({
                    url: '/api/orders',
                    type: 'GET',
                    success: function(result) {
                        let orderList = '';
                        if (result.length > 0) {
                            result.forEach(function(order) {
                                orderList += `<li>Order ID: ${order.id}, Product: ${order.productName}, Quantity: ${order.quantity}</li>`;
                            });
                        } else {
                            orderList = '<li>No orders placed yet.</li>';
                        }
                        $('#orderList ul').html(orderList);
                    },
                    error: function() {
                        alert('Failed to load orders.');
                    }
                });
            }
        });
    </script>

</body>
</html>
