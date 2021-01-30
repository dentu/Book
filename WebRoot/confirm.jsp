<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认支付</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>
<body>
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />
	<form action="ok?id=${o.id }" method="post" id="divpagecontent">
		<h3>订单号：${o.id }  付款金额 ：${o.money }</h3>
			<input type="hidden" name="orderid" value=""/> 
			<input type="submit" value="确认支付" />
	</form>
	<jsp:include page="foot.jsp" />
</body>
</html>