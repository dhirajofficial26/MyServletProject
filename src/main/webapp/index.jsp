<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            background-image: url('https://wallpaperaccess.in/wallpaper/sylvie-and-loki-season-2-episode-6-pb3');
            background-size: cover;
            background-repeat: no-repeat;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            animation: fadeIn 1s ease-in-out;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        .loki {
            text-align: center;
            background: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            width: 300px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="loki">
        <form action="signup" method="get">
            <h2>Registration Form</h2>
            Name: <input type="text" name="name" placeholder="Enter your name">
            <br><br>
            Email: <input type="email" name="email" placeholder="Enter your email">
            <br><br>
            Password: <input type="password" name="password" placeholder="Enter your password">
            <br><br>
            Gender:
            <label><input type="radio" name="gender" value="male" />Male</label>
            <label><input type="radio" name="gender" value="female" />Female</label>
            <br><br>
            Select City:
            <select NAME="city">
                <option>Jalgaon</option>
                <option>Hollywood</option>
                <option>Seoul</option>
                <option>Pune</option>
                <option>Mumbai</option>
            </select>
            <br><br>
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
