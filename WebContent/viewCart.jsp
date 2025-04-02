<%@page import="java.text.DecimalFormat"%>
<%@page import="com.hou.entity.CartItemBean"%>
<%@page import="com.hou.entity.Titles"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
    <%
          Map cart=(Map)session.getAttribute("cart");
          double total=0;
          if(cart==null||cart.size()==0)
            out.println("<p>购物车当前为空！</p>");
            else{
            Set cartItems=cart.keySet();
            Object[]isbn=cartItems.toArray();
            Titles book;
            CartItemBean cartItem;
            int quantity;
            double price,subtotal;
       %>
       <table width=590 border=1>
           <tr align="center">
               <th>书籍名称</th>
               <th>数量</th>
               <th>价格</th>
               <th>小计</th>
           </tr>
           <%
              int i=0;
              while(i<isbn.length){
              cartItem=(CartItemBean)cart.get(isbn[i]);
              book=cartItem.getBook();
              quantity=cartItem.getQuantity();
              price=book.getPrice();
              subtotal=price*quantity;
              total+=subtotal;
              i++;
            %>
            <tr>
               <td><%=book.getTitle() %></td>
               <td><%=quantity %></td>
               <td><%=new DecimalFormat("0.00").format(price) %></td>
               <td><%=new DecimalFormat("0.00").format(subtotal) %></td>
            </tr>
            <%} %>
            <tr>
                <td colspan="4">
                 <b>总计：</b><%=new DecimalFormat("0.00").format(total) %>
                </td>
            </tr>
       </table>
       <%
          session.setAttribute("total",new Double(total));
       }
        %>
        <p>
           <a href="list.jsp">继续购物</a>
        </p>
        <form action="order.html">
           <p>
              <input type="submit" value="结账">
           </p>
        </form>
</body>
</html>