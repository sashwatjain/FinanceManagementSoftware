<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="styles.css">
    <title>User Login</title>
</head>
<body>
    <h1>User Login</h1>
    <form action="LoginServlet" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
    <p><%= request.getParameter("error") == null ? "" : "Invalid username or password." %></p>
</body>
</html>
