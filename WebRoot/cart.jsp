<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<a href="product_list.jsp">首页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;购物车
					</div>
					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td>
											<img src="images/buy1.gif" width="635" height="38" />
										</td>
									</tr>
									<tr>
										<td>
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="10%">商品编号</td>
													<td width="30%">商品名称</td>
													<td width="10%">价格</td>
													<td width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量</td>
													<td width="10%">库存</td>
													<td width="10%">小计</td>
													<td width="10%">取消</td>
												</tr>
											</table>
											<!-- 循环输出商品信息 -->
											<c:forEach items="${carts }" var="c">
												<table width="100%" border="0" cellspacing="0">
													<tr>
														<td width="10%">${c.productid }</td>
														<td width="30%">${c.pname }</td>
														<td width="10%">${c.price }</td>
														<td width="20%">
														    <!-- 减少商品数量 -->
															<!-- <input type="button" value='-' style="width:20px"/> -->
															<a href="reducenum?no=${c.productid }" style="color:#FF0000; font-weight:bold">&nbsp;-&nbsp;</a>
															 <!-- 商品数量显示 -->
															<input name="text" type="text" value="${c.buynum }" style="width:40px;text-align:center" />
															<!-- 增加商品数量 -->
															<!-- <input type="button" value='+' style="width:20px"/> -->
															<a href="addnum?no=${c.productid }" style="color:#FF0000; font-weight:bold">&nbsp;+&nbsp;</a>
														</td>
														<td width="10%">${c.pnum }</td>
														<td width="10%">${c.subtotal }</td>
														<td width="10%">
														    <!-- 删除商品 -->
															<a href="delcart?no=${c.productid }" style="color:#FF0000; font-weight:bold" 
															onclick="return confirm('确定删除？')">X</a>
														</td>
													</tr>
												</table>
											</c:forEach>

											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align:right; padding-right:40px;">
														<font style="color:#FF6600; font-weight:bold">合计：&nbsp;&nbsp;${total}元</font>
													</td>
												</tr>
											</table>
											<div style="text-align:right; margin-top:10px">
											    <!--继续购物 -->
												<a href="list?page=${sessionScope.page }">
													<img src="images/gwc_jx.gif" border="0" />
												</a>
												&nbsp;&nbsp;&nbsp;&nbsp;
                                                 <!--结账 -->
												<a href="order">
													<img src="images/gwc_buy.gif" border="0" />
												</a>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
