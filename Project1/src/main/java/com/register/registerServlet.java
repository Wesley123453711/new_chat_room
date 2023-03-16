package com.register;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
/**
 * Servlet implementation class registerServlet
 */
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/javaeeproject?useSSL=false";
	static final String USER="root";
	static final String PASS=null;
	private static final String INSERT_USERS_SQL = "INSERT INTO registerdata" + "  (account, password, name, phone, sex, age, email, ad) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	
	private static final String SELECT_USER_BY_ID = "select id,accound,password,name,phone,sex,age,email,ad from registerdata where id =?;";
	private static final String SELECT_PHONE_USERS = "select phone from registerdata where phone =?;";
	private static final String DELETE_USERS_SQL = "delete from registerdata where id = ?;";
	private static final String UPDATE_USERS_SQL = "update registerdata set name = ?,phone =?, sex =?,age =?,email =?,ad =? where id = ?;";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
		Connection conn = null;
		Statement stmt = null;
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String ad = request.getParameter("ad");
		PrintWriter out = response.getWriter();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,"root",PASS);
			stmt= conn.createStatement();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, account);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, phone);
			preparedStatement.setString(5, sex);
			preparedStatement.setString(6, age);
			preparedStatement.setString(7, email);
			preparedStatement.setString(8, ad);
			preparedStatement.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("link.html");
			rd.include(request, response);
			out.println("您已成功申請,請點選會員中心回到登入頁面登入^^");
			
		} catch (ClassNotFoundException | SQLException e) {
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
