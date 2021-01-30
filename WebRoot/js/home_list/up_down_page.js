//上一页
$("#pgup").on("click",function(){
	// 判断是否是第一页
	if(page.pageNo == 1){
		alert("已经是第一页了");
	}else{
		page.pageNo -=1 ;
		//重新调用ajax文件
		$.getScript('js/home_list/ajax_list.js',function(){
			console.log("加载成功");
		});
	}
	// 改变上一页的图片
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
// 下一页
$("#pgdn").on("click",function(){
	total_page = $(".ls span").length;
	// 判断是否是最后一页
	if(page.pageNo == total_page){
		alert("已经是最后一页了");
	}else{
		page.pageNo +=1 ;
		//重新调用ajax文件
		$.getScript('js/home_list/ajax_list.js',function(){
			console.log("加载成功");
		});
	}
	// 改变下一页的图片
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

