<%@page import="com.hou.entity.Titles"%>
<%@page import="java.util.List"%>
<%@page import="com.hou.dao.impl.TitlesDaoImpl"%>
<%@page import="com.hou.dao.TitlesDao"%>
<%@ page language="java" contentType="text/html; charset=gb18030"
    pageEncoding="gb18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030">
<title>Insert title here</title>
</head>
<body>
      <table height="200">
      </table>
     <table  border="0" width="980" height="800" align="center">
           <%
           //接口   对象 =new 实现了接口的类（）
			TitlesDao dao=new TitlesDaoImpl(); //创建了一个 TitlesDao 接口的引用 dao，并将其实例化为 TitlesDaoImpl 类的一个对象。
			                                   //这意味着 dao 可以调用 TitlesDaoImpl 类中实现的 Titlespao 接口的所有方法,
			List<Titles> books=dao.getAll();   //调dao 对象的 getA11 方法，这个方法返回一个包含所有 Titles对象的列表，这些对象是从数据库中检索出来的。
			session.setAttribute("books", books);
			out.println("共查询到了"+books.size()+"本书");
			Titles book=new Titles();//声明空对象
               for(int i=0;i<books.size();i++){
            	   book=books.get(i);
            	   if(i%5==0){  %>
            	<tr>	   
            <%	   }  %>
                 <td align="center">
                    <table border="0">
                        <tr>
                            <td>
                                <a href="detail.jsp?isbn=<%=book.getIsbn() %>">
                                <img alt="好书" src="images/<%=book.getImagefile() %>">
                                </a>
                            </td>
                        </tr>
                        <tr>
                           <td>
                                <a href="detail.jsp?isbn=<%=book.getIsbn() %>">
                                     <%=getStr(book.getTitle()) %>
                                     <a>
                             
                                 
                                </td>
                        </tr>
                        <tr>
                           
                            <td align="center">
                                <font color="red" size="5"> 
                                                               促销价： <%=book.getPrice() %>
                                </font>
                            </td>    
                            
                        </tr>
                    
                    </table>
                 </td>
            	<%   if(i%5==4){ %>
            		   
            	</tr>	   
            <%	   }
               }
           
           %>
     
     </table>
</body>
</html>
<%!
     public String getStr(String str){
	 String ret=str;
	 if(str.length()>20){
		 ret=str.substring(0, 20);
	 }
	 return ret;
}
%>
