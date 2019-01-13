package com.text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username1 = request.getParameter("username");
		//处理中文乱码
		username1 = new String(username1.getBytes("iso8859-1"),"utf-8");
	
		System.out.println(username1);
		
		try {
			//注册JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
			//实例化statement对象
			Statement st = conn.createStatement();
			st.executeUpdate("insert into html values(\""+username1+"\")");
			if(st != null) {
				st.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	

}
