$(".button img").on("click",function(){
	//账号
	var account = $(".account_number input").val();
	//密码
	var pwd = $(".password input").val();
	if(account == "" || pwd == ""){
		$(".prompt").html("还没输入完,请输入");
	}else if(account != "" || pwd != ""){
		$.get('log',{passwd:pwd,acct:account},function(login_data){
			if(login_data==null){
				$(".prompt").html("账号或密码错误");
				$(".account_number input").val("");
				$(".password input").val("");
			}else{
				$(".prompt").html("");
				console.log(login_data);
			}
		});
	}
});