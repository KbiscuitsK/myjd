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
        //��������
        //1.ֱ�Ӳ�ѯ���ݿ� �� ����isbn---����  �����ǲ����ã���Ҫ��д���ݿ⣬�ٶȺʹ�����Ӱ��
        //2.list.jsp�����Ѿ���ѯ���б��ˣ�ֱ�ӱ��������ٶȿ죡
        List<Titles> books=(List<Titles>)session.getAttribute("books");
        //out.println(books.size());
        Titles newBook=new Titles();//�����ն���
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
                <img alt="����" src="images/<%=newBook.getImagefile() %>">
           </td>
           <td align="right">
                            ͼ���ţ� 
           </td>
            <td align="left">
               <%=isbn %>
           </td>
       </tr>
       <tr>
           <td align="right">
              ͼ���Ȩ��
           </td>
           <td>
               <%=newBook.getCopyright() %>
           </td>
       </tr>
       <tr>
           <td align="right">
              ͼ��۸�
           </td>
           <td>
               <%=newBook.getPrice() %>
           </td>
       </tr>
       <tr>
           <td align="right">
                 <form action="AddToCart">
                    <input type="submit" value="���빺�ﳵ">
                 </form>
           </td>
            <td>
               <form action="">
                    <input type="submit" value="�鿴���ﳵ">
                 </form>   
            </td>
       </tr>
    </table>
</body>
</html>