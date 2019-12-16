package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;

import com.classes.User;
import com.connections.DAOUsers;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		
		String userName=request.getParameter("userName");
		String userNickname=request.getParameter("userNickname");
		String e_mail=request.getParameter("e_mail");
		String pass =DigestUtils.md5Hex(request.getParameter("pass"));
		String pass2 =DigestUtils.md5Hex(request.getParameter("pass2"));
		
		boolean error=false;
		
		request.setAttribute("blank", false);
		request.setAttribute("pass", false);
		request.setAttribute("e_mail", false);
		request.setAttribute("userNickname", false);
		
		if(userName.isBlank()|userNickname.isBlank()|e_mail.isBlank()|request.getParameter("pass").isBlank()|request.getParameter("pass2").isBlank())
		{
			error=true;
			request.setAttribute("blank", true);
		}
		if(!pass.equalsIgnoreCase(pass2))
		{
			error=true;
			request.setAttribute("pass", true);
		}
		
		if(duplicate(e_mail,1))
		{
			error=true;
			request.setAttribute("e_mail", true);
		}
		
		if(duplicate(userNickname,2))
		{
			error=true;
			request.setAttribute("userNickname", true);
		}
		
		User user=new User();
		user.setUserNickname(userNickname);
		user.setUserName(userName);
		user.setE_mail(e_mail);
		user.setPass(pass);
		
		if(error)
		{
			request.setAttribute("user", user);
			request.setAttribute("error", true);
			RequestDispatcher rd=request.getRequestDispatcher("SignUp.jsp");
			rd.forward(request, response);
		}
		
		else
		{
			dao.add(user);
			
			RequestDispatcher rd2=request.getRequestDispatcher("ListResources.jsp");
			rd2.forward(request, response);
		}
		
	}
	
	DAOUsers dao=DAOUsers.getInstance();
	private boolean duplicate(String value,int option)
	{
		boolean result=false;
		ArrayList<String> list =dao.list(option);
		for(String current:list)
		{
			if(value.equalsIgnoreCase(current))
			{
				result=true;
				break;
			}
		}
		return result;
	}

}
