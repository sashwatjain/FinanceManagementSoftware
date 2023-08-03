<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="styles.css">
    <title>User Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f5f5f5;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>User Registration</h1>
    <form action="UserRegistrationServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" required><br>
        
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required><br>
        
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required><br>
        
        <label for="cardType">Card Type:</label>
        <select id="cardType" name="cardType">
            <option value="Gold">Gold</option>
            <option value="Titanium">Titanium</option>
        </select><br>
        
        <label for="bank">Bank:</label>
        <input type="text" id="bank" name="bank" required><br>
        
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="accountNumber" required><br>
        
        <label for="ifscCode">IFSC Code:</label>
        <input type="text" id="ifscCode" name="ifscCode" required><br>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>
