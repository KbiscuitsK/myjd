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
		//创建session对象
				//false的含义：如果之前有会话，不再创建新的会话
				//如果没有会话，则创建新的会话
				//1
				HttpSession session=request.getSession(false);
				//转发器
				RequestDispatcher dispatcher;
				
				//如果没有会话，就到之前的页面查找相应的会话
				if(session==null){
					dispatcher=request.getRequestDispatcher("list.jsp");
					dispatcher.forward(request, response);
				}
				//2如果有会话，则从会话中取出之前想要保存的对象
				Titles book=(Titles)session.getAttribute("bookToAdd");
				//购物车实现
				//第一次在会话内拿出购物车
				//而且第一次的话：肯定不存在购物车
				//第三步：
				Map cart=(Map)session.getAttribute("cart");
				//不存在购物车，则创建一个hashMaP对象当作购物车
				//并且将此新的购物车对象保存在会话内
				//第四步：第一次创建购物车
				if(cart==null){
					cart=new HashMap();//由此语句创建购物车
					session.setAttribute("cart", cart);//保存购物车
				}
				
				//第一次根据商品编号查询购物车清单的内容
				//从新创建的购物车内取出商品,第一次肯定是空的
				//开发购物车时，一定清醒的知道：购物车中的商品由具体的商品对象和数量组成
				//根据map的特点：由get(key)方法从购物车中查看有无新放置的商品对象
				//第五步：第一次在购物车内取出商品，而第一次是空的
				CartItemBean cartItem=
					(CartItemBean)cart.get(book.getIsbn());
				//第一次放置新商品前，查看购物车时，肯定商品对象是空的
				//利用map的put(key,value)的方法放置对象
				//一定清楚购物车对象由两个属性：商品，数量组成
				//如果是第二次及以上查看购物车时，再次放置新商品入车，则只设置数量
				//第六步：解决如何放入购物车
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
