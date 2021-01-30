<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>网上书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>
<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td width="25%">
					<table width="100%" border="0" cellspacing="0"
						style="margin-top:30px">
						<tr>
							<td class="listtitle">我的帐户</td>
						</tr>
						<tr>
							<td class="listtd">
								<img src="images/icon1.png" width="15" height="10" />&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="#">用户信息修改</a>
							</td>
						</tr>
						<tr>
							<td class="listtd">
								<img src="images/icon2.png" width="15" height="10" />&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="orderInfo.jsp">订单查询</a>
							</td>
						</tr>
						<tr>
							<td class="listtd">
								<img src="images/icon3.png" width="15" height="10" />&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="#">用戶退出</a>
							</td>
						</tr>
					</table>
				</td>
				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
						<a href="myAccount.jsp">&nbsp;我的帐户</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;用户信息修改
					</div>
					<form action="updateuser" method="post">
					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="2" class="upline">
									<tr>
										<td style="text-align:right; width:20%">会员邮箱：</td>
										<td style="width:40%; padding-left:20px">${sessionScope.loginuser.email }</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td style="text-align:right">会员名：</td>
										<td style="padding-left:20px">${sessionScope.loginuser.username }</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td style="text-align:right">原始密码：</td>
										<td><input type="password" class="textinput" name="oldpwd"/></td>
										<td><font color="#999999">${msg }</font></td>
									</tr>
									<tr>
										<td style="text-align:right">新密码：</td>
										<td><input type="password" class="textinput" name="newpwd"/></td>
										<td>&nbsp;</td>
									</tr>

									<tr>
										<td style="text-align:right">联系方式：</td>
										<td colspan="2">
											<input name="telephone" type="text" value="${sessionScope.loginuser.telephone }" class="textinput" />
										</td>
									</tr>
									<tr>
										<td style="text-align:right">&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
								</table>
								<p style="text-align:center">
									<input type="submit" value="提交" />
								</p>
								<p style="text-align:center">&nbsp;</p>
							</td>
						</tr>
					</table>
					</form>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
