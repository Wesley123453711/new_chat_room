package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/javaeeproject?useSSL=false";
	static final String USER="root";
	static final String PASS=null;
	static final String SELECT_USER = "select account,password from registerdata where account =? and password=?;";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			Class.forName(JDBC_DRIVER);
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			Connection ccon = DriverManager.getConnection(DB_URL,USER,PASS);
			PreparedStatement preparedStatement = ccon.prepareStatement(SELECT_USER);
			preparedStatement.setString(1,account);
			preparedStatement.setString(2,password);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				String x= rs.getString("account");
				String y= rs.getString("password");
				if(x.equals(account)&&y.equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("account", account);
					response.sendRedirect("center.jsp");
					};
			};//While終點
			out.println("查無此帳號或密碼");
		}catch(ClassNotFoundException | SQLException e) {
			out.print(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
