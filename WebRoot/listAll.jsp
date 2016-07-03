<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="pojo.Message"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listAll.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
  hello!!!<br/>
  <%
  	List<Message> ms=(List<Message>)request.getAttribute("ms");
   %>
  
    <table>
    <%
    	for(Message m:ms){
    		out.print("<tr>");
    		out.print("<td><a href='messageDetail?id="+m.getId()+"'>");
    		out.print(m.getTitle());
    		out.print("</td>");
    		out.print("<td>");
    		out.print(m.getU().getUname());
    		out.print("</td>");
    		out.print("</tr>");
    		
    	}
    %>
    </table>
  </body>
</html>
