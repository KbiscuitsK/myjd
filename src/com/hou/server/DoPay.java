package com.hou.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hou.dao.AccountDao;
import com.hou.dao.impl.AccountDaoImpl;

/**
 * Servlet implementation class DoPay
 */
public class DoPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoPay() {
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
		//1
		request.setCharacterEncoding("gbk");
		//2
		HttpSession session=request.getSession();
		String card=request.getParameter("card");
		double total=(double)session.getAttribute("total");
		//3
		AccountDao dao=new AccountDaoImpl();
		boolean ret=dao.isPay(card, total);
		//4
		if(ret){
			request.getRequestDispatcher("bye.jsp").forward(request, response);
		}else{
		//5
			response.sendRedirect("list.jsp");
		}
	}

}
