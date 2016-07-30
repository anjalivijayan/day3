package com.niit.shoppingcart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*; 
/**
 * Servlet implementation class LoginServlet
 * @param <RequestDispatcher>
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("abc");
		String UserID=request.getParameter("UserID");
		 System.out.println("abc");
        String Password=request.getParameter("Password");
       System.out.println("abc");
        LoginDAO loginDAO=new LoginDAO();
        
        RequestDispatcher ds=request.getRequestDispatcher("home.html");;
        
        if(loginDAO.isValidUser(UserID, Password)==true)
        {
        	ds=  request.getRequestDispatcher("home.html");
        	
        	ds.forward(request, response);
        	
        
        	
        }
        else
        {
        	PrintWriter writer=response.getWriter();
        	writer.println("Please enter valid credentials");
        	ds=  request.getRequestDispatcher("login.html");
        	ds.include(request, response);
        	//Navigate to login page
        	//I have an error message
        }
		
	}


}
