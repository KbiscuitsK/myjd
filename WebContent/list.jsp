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
           //�ӿ�   ���� =new ʵ���˽ӿڵ��ࣨ��
			TitlesDao dao=new TitlesDaoImpl(); //������һ�� TitlesDao �ӿڵ����� dao��������ʵ����Ϊ TitlesDaoImpl ���һ������
			                                   //����ζ�� dao ���Ե��� TitlesDaoImpl ����ʵ�ֵ� Titlespao �ӿڵ����з���,
			List<Titles> books=dao.getAll();   //��dao ����� getA11 �����������������һ���������� Titles������б���Щ�����Ǵ����ݿ��м��������ġ�
			session.setAttribute("books", books);
			out.println("����ѯ����"+books.size()+"����");
			Titles book=new Titles();//�����ն���
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
                                <img alt="����" src="images/<%=book.getImagefile() %>">
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
                                                               �����ۣ� <%=book.getPrice() %>
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
