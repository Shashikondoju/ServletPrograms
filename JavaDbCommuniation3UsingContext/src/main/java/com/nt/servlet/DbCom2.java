package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DbCom2 extends HttpServlet {

@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pe=res.getWriter();
		res.setContentType("text/html");
		ServletContext sc=getServletContext();
		System.out.println("DbCom2 servletContext hash code::"+sc.hashCode());
		
		//read context parameter
		pe.println("User name::"+sc.getInitParameter("dbuser"));
		pe.println("class name::"+sc.getClass());
		pe.println("<br> <b> server info::"+sc.getServerInfo()+"</b");
		pe.println("<br> <b> servlet api version::"+sc.getMajorVersion()+"</b");
		pe.println("<br> <b> MIME type of search ::"+sc.getMimeType("/home.html")+"</b");
		pe.println("<br><b> path of web application::"+sc.getRealPath("/")+"</b>");
		pe.println("<br><b> name of web application::"+sc.getContextPath()+"</b>");
		pe.println("<br><b> Virtual host name:"+sc.getVirtualServerName()+"</b>");
		
		pe.close();
	}
}
