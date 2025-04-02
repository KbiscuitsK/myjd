package com.hou.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hou.dao.UsersDao;
import com.hou.dao.impl.UsersDaoImpl;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {  //这一行定义了一个名为Login的类，该类继承了HttpServlet，这意味着它能够处理HTTP请求
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {  //这是一个构造函数，调用父类的构造函数。
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//这个方法重写了父类的doGet方法。它只是简单地调用了doPost方法，这意味着无论是GET请求还是POST请求，都会执行相同的逻辑。
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//这个方法重写了父类的doPost方法，用于处理POST请求。
		//1中文处理
		request.setCharacterEncoding("gbk");
		//2接收客户端的请求
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		//3调用业务层
		UsersDao dao =new UsersDaoImpl();   //创建UsersDao对象，并调用其isLogin方法来验证用户名和密码是否正确。
		boolean ret=dao.isLogin(uname, upwd);
		//在服务器内部创建内存保存数据
		//多次访问服务器叫会话，一次不叫会话？？？
		HttpSession session=request.getSession(); //获取HTTP会话对象，
		
		//4转发视图
		if(ret){
			session.setAttribute("user", uname); //并在会话中保存用户名。
			//转发到list.jsp
			request.getRequestDispatcher("list.jsp").forward(request, response); //如果登录成功（ret为true），则转发到list.jsp页面；否则，重定向到login.jsp页面。
		}else{
			//重新登录
			response.sendRedirect("login.jsp");
		}
	}

}
