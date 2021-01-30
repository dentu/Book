<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>电子书城</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>
<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
						<a href="myAccount.jsp">我的账户</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
						<a href="orderInfo.jsp">订单查询</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;订单详细信息
					</div>
					<c:forEach items="${orders }" var="o">
					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td>
											<p>订单编号:${o.id }</p>
										</td>
									</tr>
									<tr>
										<td>
											
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="10%">序号</td>
													<td width="40%">商品名称</td>
													<td width="10%">价格</td>
													<td width="10%">数量</td>
													<td width="10%">小计</td>
												</tr>
											</table> 
												<c:forEach items="${o.items }" var="oi">
												<table width="100%" border="0" cellspacing="0">
													<tr>
														<td width="10%">${oi.productid }</td>
														<td width="40%">${oi.pname}</td>
														<td width="10%">${oi.price }</td>
														<td width="10%">${oi.buynum }</td>
														<td width="10%">${oi.subtotal }</td>
													</tr>
												</table>
												</c:forEach>
											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align:right; padding-right:40px;"><font
														style="color:#FF0000">合计：${o.money }&nbsp;&nbsp;</font>
													</td>
												</tr>
											</table>
											<p>
												收货地址：${o.receiverAddress }<br />
												收货人：${o.receiverName }<br />
												联系方式：${o.receiverPhone }
											</p>
											<hr>
											<c:if test="${o.paystate==0 }">
												<p style="text-align:right">
													<a href="delorderinfo?id=${o.id }">取消订单</a>
													<a href="pay?id=${o.id }">
														
														<img src="images/gif53_030.gif" width="204" height="51" border="0" /> 
													</a>
												</p>
											</c:if>
											<c:if test="${o.paystate==1 }">
												<p style="text-align:right">
													已支付
												</p>
											</c:if>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
					</c:forEach>
			</tr>
		</table>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
