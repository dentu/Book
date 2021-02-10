/**
 * list的点击事件
 * 1、点击图片跳转
 * 2、点击文字跳转
 */
var id ;
$(".all_book div").on("click",function(){
	// 获取点击元素的id
	id = $(this).find(".book_id").text();
	var ids = {bookId:id};
	//把值传入服务器(GlobalVariable)
	$.get('global',ids,function(){
		
	});
	//跳转页面
	location.href='info.html';
});

