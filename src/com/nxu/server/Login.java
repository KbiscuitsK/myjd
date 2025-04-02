package com.nxu.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nxu.dao.UsersDao;
import com.nxu.dao.impl.UsersDaoImpl;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1中文处理
		request.setCharacterEncoding("gbk");
		//2获取页面参数
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		String usertype=request.getParameter("usertype");
		System.out.println("username: "+username+"password: "+pwd+"usertype: "+usertype);
		//3调用业务接口
		UsersDao dao=new UsersDaoImpl();
		boolean ret=dao.isLogin(username, pwd);
		
		//4转发试图
		if(ret){
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.jsp");
		}
		
		
	}

}
