<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
  
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/webapp/resources/css/login.css">
<style type="text/css">
@charset "ISO-8859-1";
*,
*:before,
*:after {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}

body {
    background-color: #435d7d;
}

.background {
    position: relative;
    width: 100vw;
    height: 100vh;
}

img {
    width: 200px; /* Adjust the width as needed */
    height: 200px; /* Adjust the height as needed */
    position: absolute;
    border-radius: 50%;
    top: 40px; /* Adjust the positioning as needed */
    right: 40px; /* Adjust the positioning as needed */
    object-fit: cover; /* Maintain the aspect ratio and cover the entire shape */
}

form {
    height: 520px;
    width: 400px;
    background-color: rgba(255, 255, 255, 0.13);
    position: absolute;
    transform: translate(-50%, -50%);
    top: 50%;
    left: 50%;
    border-radius: 10px;
    backdrop-filter: blur(10px);
    border: 2px solid rgba(255, 255, 255, 0.1);
    box-shadow: 0 0 40px rgba(8, 7, 16, 0.6);
    padding: 50px 35px;
}

form *{
    font-family: 'Poppins', sans-serif;
    color: #ffffff;
    letter-spacing: 0.5px;
    outline: none;
    border: none;
}

form h3{
    font-size: 32px;
    font-weight: 500;
    line-height: 42px;
    text-align: center;
}

label{
    display: block;
    margin-top: 30px;
    font-size: 16px;
    font-weight: 500;
}

input{
    display: block;
    height: 50px;
    width: 100%;
    background-color: rgba(255,255,255,0.07);
    border-radius: 3px;
    padding: 0 10px;
    margin-top: 8px;
    font-size: 14px;
    font-weight: 300;
}

::placeholder{
    color: #e5e5e5;
}

button{
    margin-top: 50px;
    width: 100%;
    background-color: #ffffff;
    color: #080710;
    padding: 15px 0;
    font-size: 18px;
    font-weight: 600;
    border-radius: 5px;
    cursor: pointer;
}

.social{
    margin-top: 30px;
    display: flex;
}

.social div{
    background: red;
    width: 150px;
    border-radius: 3px;
    padding: 5px 10px 10px 5px;
    background-color: rgba(255,255,255,0.27);
    color: #eaf0fb;
    text-align: center;
}

.social div:hover{
    background-color: rgba(255,255,255,0.47);
}

.social .fb{
    margin-left: 25px;
}

.social i{
    margin-right: 4px;
}
</style>
</head>
<body>
 
    
    <div class="background">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <h3>Login Here</h3>
            <label for="username">Username</label>
            <input type="text" placeholder="Email or Phone" name="username" id="username">
            <label for="password">Password</label>
            <input type="password" placeholder="Password" name="password" id="password">
            <button type="submit">Log In</button>
        </form>
    </div>
  
</body>
 
</html>
