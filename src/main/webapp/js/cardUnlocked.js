var CARDUNLOCKED=(function(){
	var jsessionid = QJ_JSESSIONID+"PC";
	var info={
		unlockedInfo:{
			
		},
		//根据号码查询解锁信息
		queryUnlockedInfo:function(){
			$.ajax({
		  		type : "POST",
		  		url : "/uss_web/" + "rest/integratedChange/QueryXimInfo",
		  		data : {
		  			 "jsessionid":jsessionid,
		             "device_number":CUSTOMER_INFO_SEARCH.customer_info.device_number
		  			},
		  		async:true,
		  		waitMsg:"请稍等，正在为您进行卡解锁......",
		  		success:function(message){
		  			if(message.type=="success"){
		  				var customerInfo=CUSTOMER_INFO_SEARCH.customer_info;
		  				var data=message.args.xim_info;
		  				$("#unlock_repeat").hide();
		  				$("#number_unlocked").html(customerInfo.device_number);
		  				$("#name_unlocked").html(customerInfo.customer_name);
		  				$("#status_unlocked").html(customerInfo.device_status);
		  				$("#feeaVailable_unlocked").html(customerInfo.current_balance);
		  				$("#usim_unlocked").html(data.xim_number);
		  				$("#puk1_unlocked").html(data.puk1);
		  				$("#imsi_unlocked").html(data.imsi);
		  				$("#puk2_unlocked").html(data.puk2);
		  				$("#pin1_unlocked").html(data.pin1);
		  				$("#pin2_unlocked").html(data.pin2);
		  				$.alert("恭喜您，解锁成功！");
		  			}else{
		  				$("#unlock_repeat").show();
		  				$.alert(message.content);
		  				return;
		  			}
		  		 },
		  		error:function(message){
					var dialog=$.dialog({
						   title:'提示',//提示title
						   content:'查询解锁信息异常',//显示的内容，支持html格式。
						   buttons:[{id:'btn_ok',text:'确定',
							   onClick:function(){					   
								   dialog.close();
							   }//点击时候回调函数
						   }]
					});
					$("#unlock_repeat").show();
				}
		  		});
		}
	};
	return info;
})();