function showFoodOrderList(){
	var url = path+"/foodOrderController/showFoodOrderList";
	  $('#ordertab').dataTable( {  
           'bPaginate': false,    
           "bProcessing": false,  
           'bLengthChange': false, 
           'bSort':false,
           'bFilter':false,
           'sPaginationType': 'full_numbers',  
           'sAjaxSource': url,    
           'fnServerData':receiveFoodOrderData ,
           "oLanguage": {  
               "sProcessing": "正在加载数据...",  
               'sSearch': '数据筛选:',  
               "sLengthMenu": "每页显示 _MENU_ 项记录",  
               "sZeroRecords": "没有符合项件的数据...",  
               "sInfo": "总共有 _TOTAL_ 条记录",  
               "sInfoEmpty": "",  
               "sInfoFiltered": "(_MAX_)"  
           },
     } );  
	 
}

function receiveFoodOrderData(sSource, aoData, fnCallback){
	 $.ajax( {
   	  "dataType": 'json',
   	  "type": "POST",
   	  "url": sSource,
   	  "data": aoData,
   	  "success": function (data,textStatus){
   		  if(data.iTotalRecords==0){
   			  $("#ordertbody").html("内容为空");
   		  }else{
   		    $("#ordertbody").empty();
   			fnCallback(data);
   		  }
   	  }
   	  });
}

