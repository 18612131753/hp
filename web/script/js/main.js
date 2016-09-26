String.prototype.replaceAll  = function(s1,s2){
  return this.replace(new RegExp(s1,"gm"),s2);    
};
//右下角提示信息
function main_messageTip_show( content ){
	$.omMessageTip.show({
	    title : '提示',
	    content : content,
	    timeout : 1500
	});
}

function main_messageBox_alert(contentText){
	$.omMessageBox.alert({
        content: contentText
    });
}

//替换DIV的HTML
function main_ChangeDivContent(divId,url){
	SuperMan_show_bg();
	$.ajax({
		type : "POST",
		url : url,
		async : false,
		dataType : "html",
		success : function(result) {
			SuperMan_hide_bg() ;
			$("#" + divId).html(result);
		},
		error:function(){
			SuperMan_hide_bg() ;
			main_messageTip_systemError_show();
		}
	});
}

function main_openWindow(url){
	var nw = window.open (url,'_blank','height=400,width=750,top=100,left=270,toolbar=no,menubar=no,scrollbars=yes, resizable=no,location=no, status=no');
}

/****
*时间格式转换方法
*@param formatStr 时间格式
*@param fdate 时间
*/
function formatDate(fdate,formatStr){
	 var fTime, fStr = 'ymdhis';
	 if (!formatStr)
	 	formatStr= "y-m-d h:i:s";
	 if (fdate)
	 	fTime = new Date(fdate);
	 else return fdate;
	 	//fTime = new Date();
	 var formatArr = [
	 fTime.getFullYear().toString(),
	 (fTime.getMonth()+1).toString().length==2?(fTime.getMonth()+1).toString():"0"+(fTime.getMonth()+1).toString(),
	 fTime.getDate().toString().length==2? fTime.getDate().toString():"0"+ fTime.getDate().toString(),
	 fTime.getHours().toString().length==2?fTime.getHours().toString():"0"+fTime.getHours().toString(),
	 fTime.getMinutes().toString().length==2?fTime.getMinutes().toString():"0"+fTime.getMinutes().toString(),
	 fTime.getSeconds().toString().length==2?fTime.getSeconds().toString():"0"+fTime.getSeconds().toString()
	 ];
	 for (var i=0; i<formatArr.length; i++)
	 {
	  formatStr = formatStr.replace(fStr.charAt(i), formatArr[i]);
	 }
	 return formatStr;
}