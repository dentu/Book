/**
 * 当页面加载是加载数据
 */
$.get('info',function(info_data){
	if(info_data == null){
		alert("加载失败,请重新选择");
		location.href='product_list.html';
	}else{
		//图片路径
		$(".books img").first().attr('src',info_data.imgurl);
		//名字
		$(".book_name span").html(info_data.name);
		//单价
		$(".danjia span").html(info_data.price);
		//类别
		$(".class span").html(info_data.category);
		//说明
		$(".description span").html(info_data.description);
	}
});