$.get('list',page,function(data){
	
	//当前是否接受到了数据,接受到了才修改
    if (data != null && data != 0){	
    	var data_item = data.items;
    	total_page = data.totalPage;
    	var clone_div = $(".all_book div").first().clone(true);	//克隆第一个元素
    	$(".all_book div").remove();		//删除默认的图片数据
    	$(".ls span").remove();		//删除默认的页数
    	// 遍历把数据加入到页面
    	for(var i = 0; i < data_item.length; i++){
    		clone_div.find("a").html(data_item[i].name+i);  //名字
    		clone_div.find("img").attr('src',data_item[i].imgurl); //图片路径
    		clone_div.find("span").html(data_item[i].price);	//单价
    		$(".all_book").append(clone_div);	//添加到页面
    		clone_div = $(".all_book div").first().clone(true);	//重新克隆
    	}
    	
    	// 把页数传到页面
    	for(var i = 1; i<=data.totalPage;i++){
    		$(".ls").append("<span class='list_color'>"+i+"</span>");
    	}
    	//改变span颜色
    	$(".ls span").eq(page.pageNo-1).removeClass("list_color").addClass("chenge_coloe");
    	//调用点击span
		$.getScript('js/home_list/click_span.js',function(){
			console.log("点击span成功");
		});
    }
});

