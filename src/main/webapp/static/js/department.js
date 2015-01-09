
$(function(){
	$("#headerNav li").removeClass("active");
    $("#department").addClass("active");
	showDepartmentList();
})

function showDepartmentList(){
	var url = path+"/departmentController/showDepList";
	  $('#departmenttab').dataTable( {  
           'bPaginate': false,    
           "bProcessing": false,  
           'bLengthChange': false, 
           'bSort':false,
           'bFilter':false,
           'sPaginationType': 'full_numbers',  
           'sAjaxSource': url,    
           'fnServerData':receiveData ,
           "oLanguage": {  
               "sProcessing": "正在加载数据...",  
               'sSearch': '数据筛选:',  
               "sLengthMenu": "每页显示 _MENU_ 项记录",  
               "sZeroRecords": "没有符合项件的数据...",  
               "sInfo": "总共有 _TOTAL_ 条记录",  
               "sInfoEmpty": "显示 0 至 0 共 0 项",  
               "sInfoFiltered": "(_MAX_)"  
           },
     } );  
	 
}

function receiveData(sSource, aoData, fnCallback){
	 $.ajax( {
   	  "dataType": 'json',
   	  "type": "POST",
   	  "url": sSource,
   	  "data": aoData,
   	  "success": function (data,textStatus){
   		  if(data.iTotalRecords==0){
   			  
   		  }else{
   		    $("#deptbody").empty();
   			fnCallback(data);
   		  }
   	  }
   	  });
}
function gotoFoodService(){
	var urlLogin = path+"/foodCateController/gotoFoodCategoryList";
	 window.location.href = urlLogin;
	
}

function gotoProductManage(){
	var urlLogin = path+"/productCateController/gotoProductCategoryList";
	 window.location.href = urlLogin;
	
}

function gotoService(){
	var urlLogin = path+"/microServiceController/gotoMicroServiceList";
	 window.location.href = urlLogin;
	
}

function gotoDepManage(){
	var urlLogin = path+"/departmentController/gotoDepList";
	 window.location.href = urlLogin;
	
}

