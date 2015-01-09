$(function(){
	$("#food").addClass("active");
	$("#headerNav li").removeClass("active");
    $("#foodService").addClass("active");
	$("#contentDivPage").html($("#foodPage").html());
})

//左侧导航菜单点击设置
function showFoodCateList_setting(){
    
    $("#headerNav li").removeClass("active");
    $("#foodService").addClass("active");
	        $("#foodNav li").removeClass("active");
	        $("#food").addClass("active");
			$("#contentDivPage").empty();
			$("#contentDivPage").html($("#foodPage").html());
			showFoodCateList();
		}
function showMenuList_setting(){
	        $("#foodNav li").removeClass("active");
	        $("#menu").addClass("active");
			$("#contentDivPage").empty();
			$("#contentDivPage").html($("#menuList").html());
			showFoodMenuList();
		}
function showOrderList_setting(){
      	    $("#foodNav li").removeClass("active");
	        $("#order").addClass("active");
			$("#contentDivPage").empty();
			$("#contentDivPage").html($("#orderList").html());
			showFoodOrderList();
		}


//搜索
function search(){
	if(checkTime()){
		
	}
}




function checkAddInput(){
	var reg = /^[0-9]*[1-9][0-9]*$/;
	var serialNum = $("#serial").val();
	var foodCateName = $("#foodCateName").val();
	var foodCateContent = $("#foodCateContent").val();
	
    if(!reg.test(serialNum)){
	   alert("输入序号格式不正确！")
   }else if(foodCateName.length>100){
	   alert("输入菜品类别名称过长");
   }else if(foodCateContent>200){
	   alert("输入菜品描述名称过长");
   }else{
	   $.ajax({
	       url: path+"/foodCateController/checkInput",
	       data:{
	      	 num : serialNum,
	      	 name: foodCateName,
	      	 content: foodCateContent
	       },
	       type:'POST',
	       dataType:'json',
	       async: true,
	       success:function(data) {
	           if(data.message == "NONE"){
	        	   addFoodCategory(serialNum,foodCateName,foodCateContent);
	           }else if(data.message == "figure"){
	               alert("序号格式不正确，请重新输入。");
	            }else if(data.message == "namelength"){
	            	alert("名称过长，请重新输入.");
	            }else if(data.message == "conlength"){
	            	alert("描述信息过长，请重新输入");
	            }
	            
	       },
	       error:function(){
	          alert("获取菜品类别信息失败。");
	   }
	        
	   });
   }
}
