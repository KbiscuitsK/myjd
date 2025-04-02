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
       out.println(user+"您的消费总额："+total+"￥元  你的支付卡号是："+card);
    %>
    <form action="DoPay">
       支付卡：<input type="text" name="card"><br>
       
       <input type="submit" value="确认支付">
    </form>
    <p>
       <a href="list.jsp">
                 取消支付，返回商品列表
                 </a>
    </p>
</body>
</html>