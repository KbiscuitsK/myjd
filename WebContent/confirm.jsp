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
       double total=(double)session.getAttribute("total");
       String user=(String)session.getAttribute("user");
       String card=(String)session.getAttribute("card");
       out.println(user+"���������ܶ"+total+"��Ԫ  ���֧�������ǣ�"+card);
    %>
    <form action="DoPay">
       ֧������<input type="text" name="card"><br>
       
       <input type="submit" value="ȷ��֧��">
    </form>
    <p>
       <a href="list.jsp">
                 ȡ��֧����������Ʒ�б�
                 </a>
    </p>
</body>
</html>