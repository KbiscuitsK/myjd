<%@page import="com.hou.entity.Titles"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
   <table border="1" width="600" bgcolor="pink">
    <%
        String isbn=request.getParameter("isbn");
        //遍历集合
        //1.直接查询数据库 ： 根据isbn---对象  ，我们不采用？？要读写数据库，速度和带宽有影响
        //2.list.jsp我们已经查询出列表了，直接遍历集合速度快！
        List<Titles> books=(List<Titles>)session.getAttribute("books");
        //out.println(books.size());
        Titles newBook=new Titles();//声明空对象
        for(Titles book:books){
        	if(book.getIsbn().equals(isbn)){
        		newBook=book;
        		session.setAttribute("bookToAdd", book);
        		break;
        	}
        }
    %>
       <tr>
           <td colspan="3" align="center">
              <%=newBook.getTitle() %>
           </td>
       </tr>
     <tr>
           <td rowspan="4" align="center">
                <img alt="好书" src="images/<%=newBook.getImagefile() %>">
           </td>
           <td align="right">
                            图书编号： 
           </td>
            <td align="left">
               <%=isbn %>
           </td>
       </tr>
       <tr>
           <td align="right">
              图书版权：
           </td>
           <td>
               <%=newBook.getCopyright() %>
           </td>
       </tr>
       <tr>
           <td align="right">
              图书价格：
           </td>
           <td>
               <%=newBook.getPrice() %>
           </td>
       </tr>
       <tr>
           <td align="right">
                 <form action="AddToCart">
                    <input type="submit" value="放入购物车">
                 </form>
           </td>
            <td>
               <form action="">
                    <input type="submit" value="查看购物车">
                 </form>   
            </td>
       </tr>
    </table>
</body>
</html>