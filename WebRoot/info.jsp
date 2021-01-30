<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
						<a href="#">首页</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
						<a href="product_list.jsp">&nbsp;全部商品</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;Java基础入门
					</div>
					<table cellspacing="0" class="infocontent">
						<tr>
							<td><img src="ad/index_ad1.jpg"  />
								<table width="100%%" border="0" cellspacing="0">
									<tr>
										<td width="30%">
											<div class="divbookcover">
												<p>
													<img src="${p.imgurl }" width="213" height="269" border="0" />
												</p>
											</div>
											<div style="text-align:center; margin-top:10px">
												<a href="buy?id=${p.id }">
													<img src="images/buybutton.gif" border="0" width="100" height="25" /> 
												</a>
												${msg }
											</div>
										</td>
										<td style="padding:20px 5px 5px 5px">
											<img src="images/miniicon3.gif" width="16" height="16" />
											<font class="bookname">${p.name }</font>
											<hr />售价：<font color="#FF0000">￥${p.price }</font>
											<hr /> 类别：${p.category }
											<hr />
											<p>
												<b>内容简介：</b>
											</p> ${p.description }
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
