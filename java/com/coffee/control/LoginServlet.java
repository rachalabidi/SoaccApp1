package com.coffee.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
			
			/*
			 * HttpSession session = request.getSession(false); // Get the existing session
			 * without creating a new one if (session != null) { session.invalidate();
			 * request.getSession().setAttribute("username", null); // Invalidate the
			 * existing session }
			 * 
			 * }
			 */
			 
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LogIn.jsp");
	        dispatcher.forward(request, response);
	    }
	 

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
      

      
            // User came from the login.jsp page
            if ("RASHA".equals(username) && "COFFE".equals(password)) {
               
            	HttpSession  session = request.getSession(true);
                session.setAttribute("username", username);

                response.sendRedirect(request.getContextPath() + "/listEns");
                System.out.print(session.getAttribute("username"));

            } else {

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/LogIn.jsp");
                dispatcher.forward(request, response);
            }
       
	}
}
