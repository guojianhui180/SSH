var aj=new Ajax();
var hostname=window.location.hostname;
//alert(hostname);
str=null;
$(document).ready(function() { 
    
	$.blockUI({ message: '<h1><img width="60px" height="60px"  />权限验证...</h1>' });
 
       
   
}); 

//如下使得Ajax 已经获取权限并写入PHP_Session
//从PHP获取权限,并在Servlet中验证，保存在Session中
aj.post("http://"+hostname+"/work/Export/php_session_to_java.php",str,function(data){
	if(data=="login failed")
    {
		$.unblockUI();
		alert("登陆已失效,请重新登陆");
		return;
    }
	var aj_java=new Ajax();
	var b={php_session:data};
	//从PHP获取用户信息,并在Servlet中验证，保存在Session中
	aj_java.post("http://"+hostname+":8080/saveAuthority.action",b,function(data){
		var aj_user=new Ajax;
		str=null;
		aj_user.post("http://"+hostname+"/work/Export/php_session_to_java_user.php",str,function(data){
			var aj_java=new Ajax();
			var b={php_user:data};
			aj_java.post("http://"+hostname+":8080/saveUser.action",b,function(){
				$.unblockUI();
			});
			
		});
	});
	
});


