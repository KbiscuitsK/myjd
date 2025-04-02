package com.hou.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hou.dao.OrderDao;
import com.hou.dao.impl.OrderDaoImpl;

/**
 * Servlet implementation class DoOrder
 */
public class DoOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoOrder() {
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
		String resaver=request.getParameter("resaver");
		String phone=request.getParameter("phone");
		String addr=request.getParameter("addr");
		String zipcode=request.getParameter("zipcode");
		String card=request.getParameter("card");
		HttpSession session=request.getSession();
		//3
		OrderDao dao=new OrderDaoImpl();
		boolean ret=dao.isWriteOrder(resaver, phone, addr, zipcode, card);
		//4
		if(ret){
			session.setAttribute("user", resaver);
			session.setAttribute("card", card);
			request.getRequestDispatcher("confirm.jsp").forward(request, response);
		}else{
		//5
			response.sendRedirect("list.jsp");
		}
	}

}
