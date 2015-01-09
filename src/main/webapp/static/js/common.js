function setChecked(p){
	if(!p.checked){
		document.getElementById("setCheckAll").checked=false;
	}else{
		var changeCheckedList = $("input[name='setCheckOne']");
		var selectLength = 0;
		for(var i = 0; i<changeCheckedList.length; i++){
			if(changeCheckedList[i].checked)
				selectLength++;
		}
	}
	var allTableLength = $("#tableLength").val();
	if(selectLength==allTableLength){
		document.getElementById("setCheckAll").checked=true;
	}
}



function checkAll(p){
	var changeCheckedList = $("input[name='setCheckOne']");
	for(var i = 0; i<changeCheckedList.length; i++){
		if(p.checked){
			changeCheckedList[i].checked = true;
		}else{
			changeCheckedList[i].checked = false;
		}
	}
}

function getChecked(){
	var temp = "";
	var selectList =  $("input[name='setCheckOne']:checked");
	for(var i=0;i<selectList.length;i++){
		temp += $(selectList[i]).val()+"#";
	}
	if(temp ==''){
		alert("未选中任何数据！");
		return false;
	}else{
		$("#selectList").val(temp.substring(0,temp.length-1));
		return true;
	}
}


function checkTime(){
	 var beginDate=$("#startTime").val();  
	 var endDate=$("#stopTime").val();  
	 var d1 = new Date(beginDate.replace(/\-/g, "\/"));  
	 var d2 = new Date(endDate.replace(/\-/g, "\/"));  

	  if(beginDate!=""&&endDate!=""&&d1 >=d2)  
	 {  
	  alert("开始时间不能大于结束时间！");  
	  return false;  
	 }else{
		 return true;
	 }
}