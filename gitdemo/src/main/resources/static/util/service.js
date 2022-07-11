sap.ui.define([
	"jquery.sap.global"
	],function(jQuery){

		return{
			callService: function(sUrl, sMethod, oPayload){
				return new Promise(function(resolve,reject){
					switch(sMethod.toUpperCase()){
					
					case "GET":
					$.ajax(sUrl,{
						type:"GET",
						success:function(data){
						resolve(data);
						},
						error:function(err){
						reject(err);
						}
					
					});
						
					break;
					case "POST":
					$.ajax(sUrl,{
						type:"POST",
						contentType:"application/json",
						data:JSON.stringify(oPayload),
						success:function(data){
						resolve(data);
						},
						error:function(err){
						reject(err);
						}
					
					});
					break;
					case "UPDATE":
					
					$.ajax(sUrl,{
						type:"UPDATE",
						contentType:"application/json",
						data:JSON.stringify(oPayload),
						success:function(data){
						resolve(data);
						},
						error:function(err){
						reject(err);
						}
					
					});
					
					break;
					case "DELETE":
					$.ajax(sUrl,{
						type:"DELETE",
						success:function(data){
						resolve(data);
						},
						error:function(err){
						reject(err);
						}
					
					});
					break;
					}
				});
				
			}
		
		}


});