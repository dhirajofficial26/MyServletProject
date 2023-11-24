package com.studentdata;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class login extends HttpServlet {
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tvm", "root", "Dhiraj@26");

            PreparedStatement pt = con.prepareStatement("select * from praticestudent  where studentemail=? and studentpassword=?");

            pt.setString(1, email);
            pt.setString(2, password);

            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                out.println("<html>");
                out.println("<head>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; }");
                out.println(".container { text-align: center; margin-top: 50px; }");
                out.println(".result { border: 1px solid #ccc; padding: 20px; background-color: #fff; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("<div class='result'>");
                out.println("<h2>Welcome, " + rs.getString("StudentName") + "!</h2>");
                out.println("<p>Email: " + rs.getString("Studentemail") + "</p>");
                out.println("<p>Gender: " + rs.getString("Studentgender") + "</p>");
                out.println("<p>City: " + rs.getString("Studentcity") + "</p>");
                out.println("</div>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; }");
                out.println(".container { text-align: center; margin-top: 50px; }");
                out.println(".error { color: red; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("<h1 class='error'>User data not match</h1>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");

                RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
                rd.include(req, resp);
            }

            pt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            rd.include(req, resp);
        }
    }
}
