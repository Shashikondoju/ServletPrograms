package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCapitalServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<h1 style='color:red;text-align:center'>Servlet Connection with using java-script Ushing Onclick</h1>");
		 int country=Integer.parseInt(req.getParameter("country"));
		String capitals[]=new String[] {"NewDelhi","Bijing","WashingtonDC","Tokyo","Islamabad" };
		String countries[]=new String[] {"India","china","USA","Japan","Pakisthan"};
		pw.println("<h1 style='color:blue;text-align:center'>Capital city of "+countries[country]+" is :"+capitals[country]+"</h1>");
		pw.println("<a href='page.html'>home</h1>");
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
