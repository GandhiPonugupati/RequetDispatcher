package org.jecm12.chainApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/fs")*/
public class ChainApp extends HttpServlet
{ @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
	String fname=req.getParameter("fname");
	String lname=req.getParameter("lname");
	System.out.println("fname "+fname+ " lname "+lname);
	req.setAttribute("fname", fname);
	req.setAttribute("lname", lname);
	
	RequestDispatcher rd=req.getRequestDispatcher("ss");
	rd.forward(req, resp);
			}

}
