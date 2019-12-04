package com.servlets;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Format;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.classes.Integral;

@WebServlet("/Results")
public class Results extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Results() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DecimalFormat f= new DecimalFormat("###,###.#####");
		HttpSession session=request.getSession();
		String name=session.getAttribute("name").toString();
		String answer="";
		double x=0;
		boolean error=false;
		
		try
		{
			x=Double.parseDouble(request.getParameter("x"));
		}

		catch(Exception e)
		{
			error=true;		
		}
		
		if(error)
		{
			answer="El dato ingresado no es valido :(";
		}
		else
		{
			//calculate
			
	        try
	        {
	        	Class<?> integral=Class.forName("com.integrals."+name);
	        	Integral in=(Integral) integral.newInstance();
	        	in.setIntegral(in);
	        	double area=in.calculate(0, x);
	        	answer = f.format(area);     	
	        }
	        
	        catch(Exception e)
			{
				error=true;		
			}
			
			if(error)
			{
				answer="ocurrio un error :( ";
			}
				        
			answer="Result: "+answer;			
		}
		
		request.setAttribute("ans", answer);		
		RequestDispatcher rd=request.getRequestDispatcher("Parameters.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
