package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DbCom extends HttpServlet {
	private static final String dbquery="SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE EMPNO=?";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		int no=Integer.parseInt(req.getParameter("eno"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		
		try(
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sha","shi");
				PreparedStatement ps=con.prepareStatement(dbquery)
				){
					if (ps!=null) {
						ps.setInt(1, no);
					}
					try(ResultSet rs=ps.executeQuery()){
							if (rs!=null) {
								if (rs.next()) {
									pw.println("<h1 style='color:red; text-align:center'>Emp detatils are::</h1><br>");
									pw.println("<h1 style='color:green; text-align:center'>Emp number: "+rs.getInt(1)+"</h1>");
									pw.println("<h1 style='color:green; text-align:center'>Emp name: "+rs.getString(2)+"</h1>");
									pw.println("<h1 style='color:green; text-align:center'>Emp sal: "+rs.getFloat(3)+"</h1>");
									pw.println("<h1 style='color:green; text-align:center'>Emp job: "+rs.getString(4)+"</h1>");
									pw.println("<h1 style='color:green; text-align:center'>Emp deptno: "+rs.getString(5)+"</h1>");
								}
								else
									pw.println("<h1 style='color:red; text-align:center'>Emp details not found...</h1>");
							}
						
					}//try2
			pw.close();
		}//try1
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
