/**
 * 当页面加载是加载数据
 */
//var a= id;
console.log(id)
//var ids={"id":id}
//ajax传值
$.get('info',ids,function(info_data){
	if(info_data!=null && info_data!=0){
		console.log(info_data);
	}
})