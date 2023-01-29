package com.ritam.testdbconnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckJDBCConnection
 */
@WebServlet(name = "CheckJdbcConnection", urlPatterns = { "/CheckJdbcConnection" })
public class CheckJDBCConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username="springstudent";
		String password="springstudent";
		
		String driver="com.mysql.cj.jdbc.Driver";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=FALSE&serverTimezone=UTC";
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database...");
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			
			out.println("Connection Successfull...");
			
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
