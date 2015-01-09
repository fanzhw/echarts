
$(function(){
	$("#productCate").addClass("active");
	$("#headerNav li").removeClass("active");
    $("#product").addClass("active");
	$("#contentDivPage").html($("#productCateList").html());
	showProductCateList();
})


function showProductCateList(){
	var url = path+"/productCateController/showProductCateList";
	  $('#proCatetab').dataTable( {  
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
   		    $("#proCatetbody").empty();
   			fnCallback(data);
   		  }
   	  }
   	  });
}

		
function showProductCateList_setting(){
	        $("#productNav li").removeClass("active");
	        $("#productCate").addClass("active");
			$("#contentDivPage").empty();
			$("#contentDivPage").html($("#productCateList").html());
			showProductCateList();
		}
function showProductList_setting(){
	        $("#productNav li").removeClass("active");
	        $("#productMenu").addClass("active");
			$("#contentDivPage").empty();
			$("#contentDivPage").html($("#productList").html());
			showProductList();
		}
function showProductMenuList_setting(){
	        $("#productNav li").removeClass("active");
	        $("#bill").addClass("active");
			$("#contentDivPage").empty();
			$("#contentDivPage").html($("#menuList").html());
			showFoodMenuList();
		}
function showProductOrderList_setting(){
      	    $("#productNav li").removeClass("active");
	        $("#order").addClass("active");
			$("#contentDivPage").empty();
			$("#contentDivPage").html($("#orderList").html());
			showProductOrderList();
		}


