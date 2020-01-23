package com.servlets;

import java.io.IOException;
import java.text.DecimalFormat;
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

	@Override
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
			request.setAttribute("x", x);
		}

		catch(Exception e)
		{
			error=true;		
		}
		
		if(error)
		{
			answer="the parameter is not allowed :(";
		}
		else
		{
			//calculate
			
	        try
	        {
	        	Class<?> integral=Class.forName("com.integrals."+name);
	        	Integral in=(Integral) integral.newInstance();
	        	in.setIntegral(in);
	        	
	        	double area=0;
	        	if(in.getMiscellaneous())
	        	{
	        		area=in.miscellaneous(0,x,in.getFactor());
	        	}
	        	else
	        	{
	        		area=in.calculate(0,x,in.getFactor());
	        	}	        	
	        	answer = f.format(area);     	
	        }
	        
	        catch(Exception e)
			{
				error=true;		
			}
			
			if(error)
			{
				answer="a error has appeared :( ";
			}
				        
			answer="Result: "+answer;			
		}
		
		request.setAttribute("ans", answer);		
		RequestDispatcher rd=request.getRequestDispatcher("Parameters.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
