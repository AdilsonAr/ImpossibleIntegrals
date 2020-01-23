package com.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import com.classes.User;
import com.connections.DAOUsers;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass1=request.getParameter("pass");
		String pass=DigestUtils.md5Hex(pass1);
		HttpSession session =request.getSession();
		String user = (String)session.getAttribute("userni");
		DAOUsers dao=DAOUsers.getInstance();
		User userObject=dao.prove(user, pass);
		User userTemp=new User();
		userTemp=userObject;
		//"user" is a boolean variable which indicates if some user is signed in, "userni" is the nickname of that user
		//and "usero" is the object user used to authentication and editing information
		session.setAttribute("usero", userObject);
		session.setAttribute("userTemp", userTemp);
		if(userObject!=null)
		{
			RequestDispatcher rd= request.getRequestDispatcher("Settings.jsp");
			rd.forward(request,response);
		}
		
		else
		{
			request.setAttribute("error", true);
			RequestDispatcher rd= request.getRequestDispatcher("Authentication.jsp");
			rd.forward(request,response);
		}
	}

}
