<%-- 
    Document   : registration
    Created on : Apr 12, 2022, 6:57:02 PM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Account</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div class="container">
            <div class="regbox box">
                <img src='resources/ESHOP.png' alt="ESHOP" style='width:150px'>
                <h1>Register Account</h1>
                <form action="RegisterServlet" method="post">
                   <p>Username</p>
                    <input type="text" placeholder="Username" name="name" required>
                   <p>Password</p>
                   <input type="password" placeholder="Password" name="password" required>
                   <input type="submit" value="Register">
                   <a href="index.html">Already have Account?</a>
                </form>
            </div>
        </div>
    </body>
</html>

