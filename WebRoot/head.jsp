<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td>
				<a href="list">
				 <img src="images/logo_2.jpg" />
				</a>
			</td>
			<td style="text-align:right">
				
				  
				
				| <a href="#">帮助中心</a> 


				| <a href="register.jsp">新用户注册</a>
				<c:if test="${sessionScope.loginuser==null}">
				| <a href="login.jsp">用户登录</a>
				</c:if>	
				<c:if test="${sessionScope.loginuser!=null }">	
				<img src="images/cart.gif" width="26" height="23" style="margin-bottom:-4px" />
				   &nbsp;<a href="cart">购物车</a> 		
				| <a href="myAccount.jsp">我的账户</a>							
				| <a href="logout">用户退出</a>
				<br><br><br>欢迎您：${sessionScope.loginuser.username }
				</c:if>	 
						
			</td>		
		</tr>
	</table>
</div>