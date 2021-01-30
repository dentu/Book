$(".ls span").on("click",function(){
	var a =$(this).index();//获取当前点击的下标
	page.pageNo = a+1;
	// 加载页面显示文件
	$.getScript('js/home_list/ajax_list.js',function(){
		console.log("span加载成功");
	});
	if(page.pageNo == 1){
		$("#pgup").attr('src','images/previous_page2.png');
	    $("#pgdn").attr('src','images/next_page.png');
	}else if(page.pageNo == total_page){
	    $("#pgup").attr('src','images/previous_page.png');
	    $("#pgdn").attr('src','images/next_page2.png');
	}else{
	    $("#pgup").attr('src','images/previous_page.png');
	    $("#pgdn").attr('src','images/next_page.png');
	}
});