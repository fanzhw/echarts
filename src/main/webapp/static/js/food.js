$(function(){
	$("#foodTablePage").html($("#foodCateList").html());
	$("#category").addClass("active");
	showFoodCateList();
})

function showFoodCateList(){
	var url = path+"/foodCateController/showFoodCateList";
	  $('#foodcatetab').dataTable( {  
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
               "sZeroRecords": "没有符合条件的数据...",  
               "sInfo": "总共有 _TOTAL_ 条记录",  
               "sInfoEmpty": "",  
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
   			$("#tableLength").val(data.iTotalRecords);
   		    $("#foodcatetbody").empty();
   			fnCallback(data);
   		  }
   	  }
   	  });
}

function showFoodList(){
	var url = path+"/foodController/showFoodList";
	  $('#foodtab').dataTable( {  
           'bPaginate': false,    
           "bProcessing": false,  
           'bLengthChange': false, 
           'bSort':false,
           'bFilter':false,
           'sPaginationType': 'full_numbers',  
           'sAjaxSource': url,    
           'fnServerData':receiveFoodData ,
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

function receiveFoodData(sSource, aoData, fnCallback){
	 $.ajax( {
   	  "dataType": 'json',
   	  "type": "POST",
   	  "url": sSource,
   	  "data": aoData,
   	  "success": function (data,textStatus){
   		  if(data.iTotalRecords==0){
   			  $("#foodtbody").html("内容为空");
   		  }else{
   			$("#tableLength").val(data.iTotalRecords);
   		    $("#foodtbody").empty();
   			fnCallback(data);
   		  }
   	  }
   	  });
}


//编辑信息时获取类别的具体信息
function getFoodCateDetail(id){
	var url = path+"/foodCateController/getFoodCateBySerialNum"
	 $.ajax({
	       url: url,
	       data:{
	      	 id : id
	       },
	       type:'POST',
	       dataType:'json',
	       async: true,
	       success:function(data) {
	           if(data.status == "success"){
	        	 $("#editSerial").val(data.productCategory.num);
	        	 $("#editId").val(data.productCategory.id);
	        	 $("#editFoodCateName").val(data.productCategory.name);
	        	 $("#editFoodCateContent").val(data.productCategory.description);
	           }else{
	               alert("获取菜品类别信息失败。");
	            }
	            
	       },
	       error:function(){
	          alert("获取菜品类别信息失败。");
	   }
	        
	   });
}



//重置添加的model层
function resetModel(){
	$("#serial").val("");
	$("#foodCateName").val("");
	$("#foodCateContent").val("");
  $('#myAddModal').modal('hide');  
}


//确认是否删除，分为批量删除和单个删除
function confirmDelBySerialNum(type){
	if(confirm("确认删除选中数据？")){
		if(type=="all"){
		  delFoodCategoryBySerialNums();
		}else{
		  delFoodCateBySerialNum(type);
		}
	}
}



//添加菜品类别
function addFoodCategory(serialNum,foodCateName,foodCateContent){
	var url = path+'/foodCateController/addFoodCategory';
	 $.ajax({
       url: url,
       data:{
      	 serialNum : serialNum ,
      	 foodCateName: foodCateName,
      	 foodCateContent:foodCateContent
       },
       type:'POST',
       dataType:'json',
       async: true,
       success:function(data) {
           if(data.status == "success"){
          	 resetModel();
          	 showFoodCateList_setting();
           }
            
       },
       error:function(){
          alert("添加菜品类别失败。");
   }
        
   });
	 
} 
//根据序号编辑菜品类别
function editFoodCate(){
	var url = path+'/foodCateController/editFoodCategoryBySerialNum';
  var id = $("#editId").val();
  var num =  $("#editSerial").val();
	var name = $("#editFoodCateName").val();
  var description = $("#editFoodCateContent").val();
	 $.ajax({
       url: url,
       data:{
      	 id : id,
      	 num: num,
      	 name: name,
      	 description: description
       },
       type:'POST',
       dataType:'json',
       async: true,
       success:function(data) {
           if(data.status == "success"){
          	 $('#editcateModal').modal('hide');
          	 showFoodCateList_setting();
           }
            
       },
       error:function(){
          alert("编辑菜品类别失败。");
   }
        
   });
}

//根据序号删除单个菜品类别
function delFoodCateBySerialNum(id){
	var url = path+'/foodCateController/delFoodCategoryBySerialNum';
	 $.ajax({
      url: url,
      data:{
     	 id : id
      },
      type:'POST',
      dataType:'json',
      async: true,
      success:function(data) {
          if(data.status >0){
             alert("删除数据成功");
         	 showFoodCateList_setting();
          }else if(data.status == -1){
        	  alert("该类别下有菜品，不可删除");
          }else{
        	  alert("删除菜品类别失败。");
        	  
          }
           
      },
      error:function(){
         alert("删除菜品类别失败。");
  }
       
  });
}


//删除checkbox选中的数据
function delFoodCategoryBySerialNums(){
	if(getChecked()){
		var url = path+'/foodCateController/delFoodCategoryBySerialNums';
		var serialNums = $("#selectList").val();
		 $.ajax({
	       url: url,
	       data:{
	      	 serialNums : serialNums
	       },
	       type:'POST',
	       dataType:'json',
	       async: true,
	       success:function(data) {
	           if(data.status == "success"){
	        	 alert("删除数据成功");
	          	 showFoodCateList_setting();
	           }else{
	               alert("删除菜品类别失败。");
	            }
	            
	       },
	       error:function(){
	          alert("删除菜品类别失败。");
	   }
	        
	   });
	}
}

function getFoodCate(){
	$.ajax({
	       url: path+'/foodCateController/getFoodCate',
	       data:{},
	       type:'POST',
	       dataType:'json',
	       async: true,
	       success:function(data) {
	    	var foodCateList = data.foodCateList;
	    	var str = null;
	    	var selectObj=document.getElementById("foodCateselect");
	    	selectObj.options.length=0; 
	    	selectObj.options[selectObj.length] = new Option("---请选择---", "default"); 
	    	for(var i = 0;i<foodCateList.length;i++){
	    		var foodCate = foodCateList[i];
//	    		str+="<option id='"+foodCate.id+"' value='"+foodCate.id+"'>"+foodCate.name+"</option>"
	    		selectObj.options[selectObj.length] = new Option(foodCate.name, foodCate.id); 
	    	}
	    	
	       },
	       error:function(){
	          alert("获取菜品类别失败。");
	   }
	        
	   });
}
function showCateList_setting(){
    $("#foodPageNav li").removeClass("active");
    $("#category").addClass("active");
	$("#foodTablePage").empty();
	$("#foodTablePage").html($("#foodCateList").html());
	showFoodCateList();
}
function showfoodList_setting(){
    $("#foodPageNav li").removeClass("active");
    $("#foodlist").addClass("active");
	$("#foodTablePage").empty();
	$("#foodTablePage").html($("#foodList").html());
	showFoodList();
}

function checkAddFoodInput(){
	var reg = /^[0-9]*[1-9][0-9]*$/;
	var reg1= /^\d+(\.\d{2})?$/;
	var foodserial = $("#foodserial").val();
	var foodName = $("#foodName").val();
	var foodContent = $("#foodContent").val();
	var foodPrice = $("#foodPrice").val();
	var foodCate = $("#foodCateselect").val();
	
    if(!reg.test(foodserial)){
	   alert("输入序号格式不正确！")
   }else if(foodName.length>45){
	   alert("输入菜品名称过长");
   }else if(foodName.length==0){
	   alert("菜品名称不能为空");
   }else if(foodContent>200){
	   alert("输入菜品描述名称过长");
   }else if(!reg.test(foodPrice)){
	   alert("输入菜品价格格式不正确，只能有两位小数");
   }else if(foodCate==null||foodCate=='default'){
	   alert("请选择一种菜品类别");
   }else{
	   $.ajax({
	       url: path+"/foodController/checkInput",
	       data:{
	      	 num : foodserial,
	      	 name: foodName,
	      	 content: foodContent,
	      	 price: foodPrice,
	      	 foodCate: foodCate
	       },
	       type:'POST',
	       dataType:'json',
	       async: true,
	       success:function(data) {
	           if(data.message == "NONE"){
	        	   addFood(foodserial,foodName,foodContent,foodPrice,foodCate);
	           }else if(data.message == "figure"){
	               alert("序号格式不正确，请重新输入。");
	            }else if(data.message == "namelength"){
	            	alert("名称过长，请重新输入.");
	            }else if(data.message == "conlength"){
	            	alert("描述信息过长，请重新输入");
	            }else if(data.message == "empty"){
	            	alert("必填信息不能为空");
	            }else if(data.message == "price"){
	            	alert("价格格式不正确，请重新输入。");
	            }
	            
	       },
	       error:function(){
	          alert("校验信息失败。");
	   }
	        
	   });
   }
}


//添加菜品类别
function addFood(foodserial,foodName,foodContent,foodPrice,foodCate){
	var url = path+'/foodController/addFood';
	 $.ajax({
       url: url,
       data:{
      	 serialNum : foodserial ,
      	 foodName: foodName,
      	 foodContent:foodContent,
      	 foodPrice:foodPrice,
      	 foodCate: foodCate
       },
       type:'POST',
       dataType:'json',
       async: true,
       success:function(data) {
           if(data.status == "success"){
        	   resetFoodModel();
        	   showfoodList_setting();
           }
            
       },
       error:function(){
          alert("添加菜品类别失败。");
   }
        
   });
	 
} 
//重置添加的model层
function resetFoodModel(){
     $("#foodserial").val("");
	 $("#foodName").val("");
	 $("#foodCateContent").val("");
	 $("#foodPrice").val("");
     $('#myAddFoodModal').modal('hide');  
}