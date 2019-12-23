package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import com.connections.DAOUsers;
import com.classes.*;
/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String password=DigestUtils.md5Hex(pass);
		
		DAOUsers dao=DAOUsers.getInstance();
		User userRes=dao.prove(user, password);
		request.setAttribute("error", false);
		if(userRes!=null)
		{
			Cookie cookieUser=new Cookie("ImpossibleIntegralsUser", user);
			cookieUser.setMaxAge(365*24*60*60);
			
			response.addCookie(cookieUser);
			RequestDispatcher rd= request.getRequestDispatcher("ListResources.jsp");
			rd.forward(request, response);
		}
		
		else
		{
			request.setAttribute("error", true);
			RequestDispatcher rd= request.getRequestDispatcher("SignIn.jsp");
			rd.forward(request, response);		
		}
	}

}
