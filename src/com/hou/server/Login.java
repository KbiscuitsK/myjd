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
public class Login extends HttpServlet {  //��һ�ж�����һ����ΪLogin���࣬����̳���HttpServlet������ζ�����ܹ�����HTTP����
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {  //����һ�����캯�������ø���Ĺ��캯����
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//���������д�˸����doGet��������ֻ�Ǽ򵥵ص�����doPost����������ζ��������GET������POST���󣬶���ִ����ͬ���߼���
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//���������д�˸����doPost���������ڴ���POST����
		//1���Ĵ���
		request.setCharacterEncoding("gbk");
		//2���տͻ��˵�����
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		//3����ҵ���
		UsersDao dao =new UsersDaoImpl();   //����UsersDao���󣬲�������isLogin��������֤�û����������Ƿ���ȷ��
		boolean ret=dao.isLogin(uname, upwd);
		//�ڷ������ڲ������ڴ汣������
		//��η��ʷ������лỰ��һ�β��лỰ������
		HttpSession session=request.getSession(); //��ȡHTTP�Ự����
		
		//4ת����ͼ
		if(ret){
			session.setAttribute("user", uname); //���ڻỰ�б����û�����
			//ת����list.jsp
			request.getRequestDispatcher("list.jsp").forward(request, response); //�����¼�ɹ���retΪtrue������ת����list.jspҳ�棻�����ض���login.jspҳ�档
		}else{
			//���µ�¼
			response.sendRedirect("login.jsp");
		}
	}

}
