package com.hou.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hou.entity.CartItemBean;
import com.hou.entity.Titles;

/**
 * Servlet implementation class AddToCart
 */
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
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
		//����session����
				//false�ĺ��壺���֮ǰ�лỰ�����ٴ����µĻỰ
				//���û�лỰ���򴴽��µĻỰ
				//1
				HttpSession session=request.getSession(false);
				//ת����
				RequestDispatcher dispatcher;
				
				//���û�лỰ���͵�֮ǰ��ҳ�������Ӧ�ĻỰ
				if(session==null){
					dispatcher=request.getRequestDispatcher("list.jsp");
					dispatcher.forward(request, response);
				}
				//2����лỰ����ӻỰ��ȡ��֮ǰ��Ҫ����Ķ���
				Titles book=(Titles)session.getAttribute("bookToAdd");
				//���ﳵʵ��
				//��һ���ڻỰ���ó����ﳵ
				//���ҵ�һ�εĻ����϶������ڹ��ﳵ
				//��������
				Map cart=(Map)session.getAttribute("cart");
				//�����ڹ��ﳵ���򴴽�һ��hashMaP���������ﳵ
				//���ҽ����µĹ��ﳵ���󱣴��ڻỰ��
				//���Ĳ�����һ�δ������ﳵ
				if(cart==null){
					cart=new HashMap();//�ɴ���䴴�����ﳵ
					session.setAttribute("cart", cart);//���湺�ﳵ
				}
				
				//��һ�θ�����Ʒ��Ų�ѯ���ﳵ�嵥������
				//���´����Ĺ��ﳵ��ȡ����Ʒ,��һ�ο϶��ǿյ�
				//�������ﳵʱ��һ�����ѵ�֪�������ﳵ�е���Ʒ�ɾ������Ʒ������������
				//����map���ص㣺��get(key)�����ӹ��ﳵ�в鿴�����·��õ���Ʒ����
				//���岽����һ���ڹ��ﳵ��ȡ����Ʒ������һ���ǿյ�
				CartItemBean cartItem=
					(CartItemBean)cart.get(book.getIsbn());
				//��һ�η�������Ʒǰ���鿴���ﳵʱ���϶���Ʒ�����ǿյ�
				//����map��put(key,value)�ķ������ö���
				//һ��������ﳵ�������������ԣ���Ʒ���������
				//����ǵڶ��μ����ϲ鿴���ﳵʱ���ٴη�������Ʒ�복����ֻ��������
				//�������������η��빺�ﳵ
				if(cartItem==null){
					//put(key,value)
					cart.put(book.getIsbn(), new CartItemBean(book,1));
				}else{
					cartItem.setQuantity(cartItem.getQuantity()+1);
				}
				dispatcher=request.getRequestDispatcher("viewCart.jsp");
				dispatcher.forward(request, response);
	}

}
