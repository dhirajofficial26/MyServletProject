package com.studentdata;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

//@WebServlet(urlPatterns="/signup")
public class Showdata extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html"); 
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String city=req.getParameter("city");
		
		PrintWriter out=resp.getWriter() ;
		out.println(name);
		out.println(" \n");
		out.println(email);
		out.println(" \n");
		out.println(gender);
		out.println(" \n");
		out.println(city);
		out.println(" \n");
	
		out.println("<h1 Style='colour=green;'>from submit</h1>");
		System.out.println("submited");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/tvm",
					"root","Dhiraj@26");
			
			
						   PreparedStatement pt = con.prepareStatement("INSERT INTO praticeStudent  VALUES (?, ?, ?, ?, ?)");
			    pt.setString(1, name);
			    pt.setString(2, email);
			    pt.setString(3, password);
			    pt.setString(4, gender);
			    pt.setString(5, city);

			int count=    pt.executeUpdate();
			    if (count > 0) {
			        resp.setContentType("text/html");
			        out.println("<h1 style='colour:green'>User data added successfully</h1>");

			
			    } else {
			    	 resp.setContentType("text/html");
				        out.println("<h1 style=' colour:red'>User data not added</h1> ");

			        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			       rd.include(req, resp);  // Use forward instead of include
			    }
		
		
		
		
		pt.close();
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
		
	}

}
