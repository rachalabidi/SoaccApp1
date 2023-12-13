package com.coffee.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidate the session, effectively logging the user out
    	HttpSession session = request.getSession(false);
       
      
          request.getSession().setAttribute("username", null);

          session.invalidate();
 
          System.out.print(request.getSession().getAttribute("username"));
        // Redirect to the login page or any other desired page after logout
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LogIn.jsp");
      dispatcher.forward(request, response);
    }
}