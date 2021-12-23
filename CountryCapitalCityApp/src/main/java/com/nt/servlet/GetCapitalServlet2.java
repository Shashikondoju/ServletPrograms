package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCapitalServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<h1 style='color:red;text-align:center'>Servlet Connection with using java-script</h1>");
		 int country=Integer.parseInt(req.getParameter("i"));
		 String capitals[]=new String[] {"NewDelhi","WashingtonDC","Bijing","Tokyo","Islamabad" };
		String countries[]=new String[] {"India","USA","china","Japan","Pakisthan"};
			pw.println("<h1 style='color:blue;text-align:center'>Capital city of "+countries[country]+" is :"+capitals[country]+"</h1>");
		pw.println("<a href='page2.html'>home</h1>");
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
