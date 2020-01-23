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

/**
 * Servlet implementation class ParametersCollector
 */
@WebServlet("/ParametersCollector")
public class ParametersCollector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParametersCollector() {
        super();
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
		
		String value=(String)request.getParameter("value");
		HttpSession session=request.getSession();
		String parameter=(String)session.getAttribute("action");
		SignUp signUp= new SignUp();
		User userTemp=(User)session.getAttribute("userTemp");
		boolean error=false;
		String me="";
		if(value.isBlank())
		{
			error=true;
			me="it is necessary to insert a value";
		}
		
		else
		{
			switch(parameter)
			{
			case "userName":
			userTemp.setUserName(value);
			break;

			case "nickName":
				if(signUp.duplicate(value, 2))
				{
					error=true;
					me="nickName inserted already is been used";
				}
				
				else
				{
					userTemp.setUserNickname(value);
				}
			break;

			case "mail":
				if(signUp.duplicate(value, 1))
				{
					error=true;
					me="E-mail inserted is been used in other account";
				}
				else
				{
					userTemp.setE_mail(value);
				}
			break;

			case "pass":
				String passn2=request.getParameter("passn2");
				if(!value.equalsIgnoreCase(passn2))
				{
					error=true;
					me="Passwords are different";
				}
				else
				{
					userTemp.setPass(DigestUtils.md5Hex(value));				
				}
			break;
			}
		}
		
		
		if (error)
		{
			request.setAttribute("error", error);
			request.setAttribute("me", me);
			RequestDispatcher rd=request.getRequestDispatcher("SettingsDetails.jsp");
			rd.forward(request, response);
		}
		
		else
		{
			session.setAttribute("modified", true);
			session.setAttribute("userTemp", userTemp);
			RequestDispatcher rd=request.getRequestDispatcher("Settings.jsp");
			rd.forward(request, response);
		}
	}
}
