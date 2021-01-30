// JS 工具
//表单数据转换JSON对象
function formToJson(frm){
	var json={};
	frm.find('input').each(function(){
		switch($(this).attr('type')){
			case 'text':
			case 'password':
				json[$(this).attr('name')]=$(this).val();
				break;
			case 'radio':
				if($(this).prop('checked')){
					json[$(this).attr('name')]=$(this).val();
				}
				break;
			case 'checkbox':
				if($(this).prop('checked')){
					var fld=$(this).attr('name');
					if(!json[fld]){
						json[fld]=[];
					}
					json[fld].push($(this).val());
				}
				break;
		}
	});
	frm.find('textarea').each(function(){
		json[$(this).attr('name')]=$(this).val();
	});
	frm.find('select').each(function(){
		json[$(this).attr('name')]=$(this).val();
	});
	return json;
}