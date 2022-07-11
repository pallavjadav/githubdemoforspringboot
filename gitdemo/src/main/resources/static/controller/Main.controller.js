sap.ui.define([

	"sap/ui/core/mvc/Controller",
	"namespace/util/service",
	"sap/m/MessageBox"

],function(Controller, service,MessageBox){
	return Controller.extend("namespace.controller.Main",{
	
		onInit:function(){
		var oModel = new sap.ui.model.json.JSONModel();
		oModel.setData({
		"postPayload":{
			"companyName": "New Company",
                "contactName": "Pallav",
                "lastName": "Jadav",
                "website": "pallav.com",
                "email": "jadav@dmail.com",
                "status": "APPROVED",
                "gstNo": "GSTIN132546",
		},
		"vendor":{}
		});
		//oModel.setDefaultBindingMode(sap.ui.model.BindingMode.OneWay);
		sap.ui.getCore().setModel(oModel);
		},
		onLoadData: function(){
		var that = this;
		//alert("Load Data")
		
		service.callService("/vendor", "GET" , {})
		.then(function(data){
			debugger;
			var oTable = that.getView().byId("idTable");
			var oModel = sap.ui.getCore().getModel();
			oModel.setProperty("/vendor", data);
			sap.ui.getCore().getModel(oModel);
			oTable.bindRows("/vendor");
		})
		.catch(function(){});
		
			
		},
		onSave:function(){
		var that = this;
		var oModel = sap.ui.getCore().getModel();
		var payload = oModel.getProperty("/postPayload");
		service.callService("/vendor", "POST" , payload)
		.then(function(data){
		that.onLoadData();
			MessageBox.confirm("Success");
			
		})
		.catch(function(){
			MessageBox.error("Post Failed");
		});
		}
	});
});