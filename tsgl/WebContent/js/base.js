$(function(){

	var $main_menu=$(".nav-ul > li"),
	$sub_menu=$(".sub-menu"),
	host_name=["cuis"];
	
	$main_menu.click(function(){
		var a=$(this);
		a.hasClass("active")?

				(a.find(".sub-menu").hide(),a.removeClass("active")):
					($sub_menu.slideUp(),$main_menu.removeClass("active"),a.find(".sub-menu").show(),a.addClass("active"))


	}),$sub_menu.find("a").click(function(a){
		$sub_menu.find("li").removeClass("active"),e.parent().addClass("active")});
	
	//选中高亮
	var path=window.location.href.substring();

	var newPath = path.split("Action");
	console.log(newPath);
	  $('li a[href="'+path+'+'%'"]').parent().addClass("active")
	                            .parent().show()

	
	/*if(path.indexOf("searchChronicPeople.action")>0
			||path.indexOf("chronicManagerAction!bloodPressDataAnalysis.action")>0
			||path.indexOf("chronicManagerAction!bloodPressTendAnalysis.action")>0
			||path.indexOf("chronicManagerAction!bloodPressDataDetail.action")>0
			||path.indexOf("chronicManagerAction!toEditBPCloud.action")>0
	){
		var loc = path.substring(0,path.lastIndexOf("/")+1);
		path=loc+"chronicManagerAction!getAllDiabeteManager.action";
	}
	
	if(path.indexOf("searchChronicPeople.action")>0){
		var loc = path.substring(0,path.lastIndexOf("/")+1);
		path=loc+"chronicManagerAction!getAllHighBloodManager.action";
	}

	*/
	var yemianname = $("input[name='yemianname']").val();
	var url=path.substring(0,path.lastIndexOf("jmjkms/")+7);
	//档案管理
	if(yemianname=='01201'){
		path=url+"healthFileAction!showHealthFile.action";
	}
	if(yemianname=='01202'){
		path=url+"showOldChronicAction!firstShowChronic.action";
	}
	//健康管理
	if(yemianname=='02201'){
		path=url+"HealthManagerAction!getHealthFileList.action";
	}
	if(yemianname=='02202'){
		path=url+"HealthDailyCheckAction!getHealthFileList.action";
	}
	if(yemianname=='02203'){
		path=url+"healthAlarmAction!toAlarmManager.action";
	}
	
	if(yemianname=='02204'){
		path=url+"chronicManagerAction!getAllHighBloodManager.action";
	}
	if(yemianname=='02205'){
		path=url+"chronicManagerAction!getAllDiabeteManager.action";
	}
	if(yemianname=='02206'){
		path=url+"chronicManagerAction!getAllOtherManager.action";
	}
	if(yemianname=='02207'){
		path=url+"xkHealthMachineAction!getList.action";
	}
	//健康理疗
	if(yemianname=='04201'){
		path=url+"healthPhysiotherapyAction.action";
	}
	if(yemianname=='04202'){
		path=url+"healthPhysiotherapyAction!getAllPlan.action";
	}
	if(yemianname=='04203'){
		path=url+"healthPhysiotherapyAction!getRecovery.action";
	}
	//健康关怀
	if(yemianname=='05201'){
		path=url+"healthEducationAction!getHealthEducationList.action";
	}
	if(yemianname=='05202'){
		path=url+"doorKnockingAction!getDoorKnockingListById.action";
	}
	if(yemianname=='05203'){
		path=url+"knowledgeLectureAction!getKnowledgeLectureListById.action";
	}
	if(yemianname=='05204'){
		path=url+"comminityClinicAction!getComminityClinicListById.action";
	}
	
	//门诊记录
	if(yemianname=='06201'){
		path=url+"followRecordAction!showFollowRecord.action";
	}
	if(yemianname=='06202'){
		path=url+"incompleteRecordAction2!showIncompleteRecord.action";
	}
	if(yemianname=='06203'){
		path=url+"consultationRecordAction!showConsultationRecord.action";
	}
	if(yemianname=='06204'){
		path=url+"dualReferralRecordAction!showDualReferralRecord.action";
	}
	if(yemianname=='06205'){
		path=url+"medicalRecordAction!showMedicalRecord.action";
	}
	if(yemianname=='06206'){
		path=url+"familyBedHistoryAction!showFamilyBedHistory.action";
	}
	if(yemianname=='06207'){
		path=url+"inHospitalHistoryAction!showInHospitalHistory.action";
	}
	//员工管理
    if(yemianname=='07201'){
		path=url+"staffAction.action";
	}
	if(yemianname=='07202'){
		path=url+"staffAction!getAllStaffLeaves.action";
	}
	if(yemianname=='07203'){
		path=url+"staffRewardPunishAction!getAllStaffRewardPunish.action";
	}
	if(yemianname=='07204'){
		path=url+"oparetorAction!getAllOperators.action";
	}
	//统计分析
     if(yemianname=='08201'){
  		path=url+"statisticsAction!staticticsList.action";
  	}
  	if(yemianname=='08202'){
  		path=url+"statisticsAction!jumpDeviceStatistics.action";
  	}
  	if(yemianname=='08203'){
  		path=url+"statisticsAction!jumpALLCurrentCount.action";
  	}
	//系统管理
  	
  	if(yemianname=='10201'){
   		path=url+"communityHospitalAction!getHospitalList.action";
   	}
   	if(yemianname=='10202'){
   		path=url+"healthPhysiotherapyAction!getExpertScheme.action";
   	}
   	if(yemianname=='10203'){
   		path=url+"MaintainaleAction!getMaintainableByPage.action";
   	}
	if(yemianname=='10204'){
   		path=url+"roleAction!getRoleList.action";
   	}
	if(yemianname=='10205'){
   		path=url+"communityHospitalGroupAction!getHosGroupList.action";
   	}
	
	
	$('li a[href="'+path+'"]').parent().addClass("active")
	                            .parent().show()

	                            .parent().addClass("active");
	    
//	返回按钮
	$('.btn-back').click(function(){
		console.log('hello');
		history.go(-1);
	});
	//页面加载时，检查DynaForm的个数
	  function checkDynaForm () {
	    var dynaForms = $('.dyna-form');
	    //序号
	    var number = 0;
	    for(var i = 0; i < dynaForms.length;i++){
	      var currentTr = $(dynaForms[i]);
	      // var curInput = currentTr.find('input');
	      // console.log(curInput);
	      if (currentTr.next().attr('class') == undefined && currentTr.prev().attr('class') == undefined) {
	        currentTr.find('.btn-add').show();
	        currentTr.find('.btn-del').hide();
	      }else if(currentTr.next().attr('class') == undefined){
	        currentTr.find('.btn-del').show();
	        currentTr.find('.btn-add').show();
	      }else{
	        currentTr.find('.btn-add').hide();
	      };
	      
	     
	    	//设置每个name不同，增加 | 编辑 都可以用
		    var curInput = currentTr.find('input');
		    curInput.each(function  (i) {
		        var curName = this.name;
		        this.name = curName.replace(/\d+/, function(n){return number});
		    });
		    number++;
	      
	    }
	  };

	  checkDynaForm();

	  //增加
	  $('.btn-add').click(function  () {
	    $(($(this).parent().parent())).clone(true).insertAfter(($(this).parent().parent()));
	    $(this).hide();
	    $(this).prev().show();
	    $(this).parent().parent().next().find('input').val('');

	    var $name = $(this).parent().parent().next().find('input');

	    // });
	    // $name.each(function  (i) {
	    //   var curName = this.name;
	    //   this.name = curName.replace(/\d+/, function(n){return ++n});
	    // });

	    checkDynaForm();
	  });
	  //删除
	  $('.btn-del').click(function() {
	    $(($(this).parent().parent())).remove();
	    checkDynaForm();
	  });
  
	//select2可输可选
	//$(".js-example-basic-single").select2();
	
	//打印
	$('.btn-print').click(function(){
		$('#jqprint').jqprint();
	});
});

//页面重置
/*$(document).ready(function(){

    $("#news").click(function(){

        $(":text").val("");
        $("textarea").val("");
        $("select").val("");
        $("input[type='checkbox']:checked").attr("checked",false);
        
        $("#all-sex").attr("checked",true);
        $("#zhengchang").attr("checked",true);
    });

 
});*/
//页面重置第二个
/*var news=document.getElementById("chongzhi");
	news.onclick = function(){
			document.getElementById("entity").reset(); 
	}*/
	


//全选
function allCheck() {
	
	var obj = document.getElementsByClassName("zyq");
	if (document.getElementById("all").checked == true) {
		for (var i = 0; i < obj.length; i++) {
			obj[i].checked = true;
		}
	} else {
		for (var i = 0; i < obj.length; i++) {
			obj[i].checked = false;
		}
	}
};
function checkT_F() {
	var obj = document.getElementsByClassName("zyq");
	var j = 0;
	for (var i = 0; i < obj.length; i++) {
		if (obj[i].id != 'all') { //如果是复选框
			if (obj[i].checked == true) { //并且为选中
				j++;
			}
		}
	}
	if (j == (obj.length - 1)) { //如果复选框选中的数量等于（复选框总和减去全选这个选框的数量）
		document.getElementById("all").checked = true; //全选被激活
	} else {
		document.getElementById("all").checked = false; //取消全选
	}
};

/* 时间 月  年 季度 获取*/
window.onload  = function(){
	var myDate = new Date();
	var month = myDate.getMonth();
	var lastMonth;
		if(month==0){
			lastMonth = 12;
		}
		else{
			lastMonth=month;
		}
		//上月
	var thisMonth = month+1;		//本月
	var nextMonth = month+2;		//下月
	var year = myDate.getFullYear();	//获取年份
	var LastMonthDays = new Date(year+"/"+thisMonth+"/0").getDate();	//获取上个月的天数
	var ThisMonthDays = new Date(year+"/"+nextMonth+"/0").getDate();   //获取本月的天数
	var LastDay2 = new Date(year+"/"+"3"+"/0").getDate();  //获取本年2月份的天数
	var FirstDay =1;
	// 获取季度信息
		//获取当前所在季度
		var thisQuarter = 0;
		var thisQuarterStartMonth =0;

		if(thisMonth<=3){
			thisQuarter = 1;
			thisQuarterStartMonth = 1;
		}
		else if(thisMonth>=4 && thisMonth<=6){
			thisQuarter = 2;
			thisQuarterStartMonth = 4;
		}
		else if(thisMonth>7 && thisMonth<=9){
			thisQuarter = 3;
			thisQuarterStartMonth = 7;
		}
		else{
			thisQuarter = 4;
			thisQuarterStartMonth = 10;
		}
	 
	// }
	 //当期季度的开始日期
	  var thisQuarterStartDay = year+"-"+thisQuarterStartMonth+"-"+FirstDay;
	  //获取当前日期
	  var today = new Date().getDate();
	  var thisDay = year+"-"+thisMonth+"-"+today;   //今天的日期

	//获取时间
	var thisMonthMeasure = year+"-"+thisMonth+"-"+FirstDay+","+year+"-"+thisMonth+"-"+today;

	var lastMonthMeasure = year+"-"+lastMonth+"-"+FirstDay+","+year+"-"+lastMonth+"-"+LastMonthDays;

	var thisQuarterMeasure = thisQuarterStartDay+","+thisDay;

	var thisYearMeasure = year+"-"+"1"+"-"+FirstDay+","+thisDay;



	//获取下拉框的值
	var thisSelect = document.getElementById('date');
	var AllOption = document.getElementsByTagName('option');
	var datePerson = document.getElementById('dateInput1');
	var datePerson2 = document.getElementById('dateInput2');
	thisSelect.onchange = function(){
		var thisSelectValue = document.getElementById('date').value;	//
		
		if(thisSelectValue == '1'){
			AllOption[1].setAttribute("name",thisMonthMeasure);
			datePerson.disabled="disabled";
			datePerson2.disabled="disabled";
			datePerson.value="";
			datePerson2.value="";
			
		}
		else if(thisSelectValue == '2'){
			AllOption[2].setAttribute("name",lastMonthMeasure);
			datePerson.disabled="disabled";
			datePerson2.disabled="disabled";
			datePerson.value="";
			datePerson2.value="";
		}
		else if(thisSelectValue == '3'){
			AllOption[3].setAttribute("name",thisQuarterMeasure);
			datePerson.disabled="disabled";
			datePerson2.disabled="disabled";
			datePerson.value="";
			datePerson2.value="";
		}
		else if(thisSelectValue == '4'){
			AllOption[4].setAttribute("name",thisYearMeasure);
			datePerson.disabled="disabled";
			datePerson2.disabled="disabled";
			datePerson.value="";
			datePerson2.value="";
		}
		else if(thisSelectValue == '5'){
			datePerson.disabled=false;
			datePerson2.disabled=false;
		}
	}
};

//根据登录用户权限实现动态菜单
$(function(){
	var location = (window.location+'').split('/');  
	var basePath = location[0]+'//'+location[2]+'/'+location[3];
	$(".nav-ul").hide();
	$.ajax({   
        type:"POST", //请求方式  
        url:basePath +'/LoginoutAction!getMenuList.action', //请求路径 
        dataType: "json",   //返回值类型  
        success:function(listNoMenue){
        	if(listNoMenue!=null){
	        	for(var i=0,l=listNoMenue.length;i<l;i++){
	        		var mo=listNoMenue[i];
	        		$("li").each(function(){
						if($(this).attr("name")==mo){
							$(this).remove();
						}
					});
	        	}
        	}
        	$('ul.nav-ul').show();
			 },
        error:function(){  
    		window.location.href=basePath +'/login.jsp';  
        }    
      });
});

//根据登录用户权限控制页面中的按钮
$(function(){
	var yemianname = $("input[name='yemianname']").val();
	var location = (window.location+'').split('/');  
	var basePath = location[0]+'//'+location[2]+'/'+location[3];
	 $.ajax({   
       type:"POST", //请求方式  
       url:basePath+'/LoginoutAction!getButtonlist.action', //请求路径 
       dataType: "json",   //返回值类型  
       success:function(msg){
       	var jsonm = eval("("+msg+")");
       	for(var i=0,l=jsonm.length;i<l;i++){
       			var module=jsonm[i].module;   //不用
       			var rightsCode=jsonm[i].rightsCode;
       			var rightsName=jsonm[i].rightsName;  //不用
       			var rigvalue=jsonm[i].rightsValue;
       			var rrva=rigvalue.split(",");
       			if(yemianname==rightsCode){
       				
       				if(jQuery.inArray("1", rrva)<0){
						 $("a.btn-xianshi").remove();
						 $("input.btn-xianshi").remove();
						 
					}
       				//2代表添加
       				if(jQuery.inArray("2", rrva)<0){
						 $("a.btn-xinzeng").remove();
						 
					}
       				//4代表修改
       				if(jQuery.inArray("4", rrva)<0){
						 $("a.btn-xiugai").remove();
					}
       				//8代表删除
       				if(jQuery.inArray("8", rrva)<0){
						 $("a.btn-shanchu").remove();
						 $("input.btn-shanchu").remove();
					}
       				//16代表打印
					if(jQuery.inArray("16", rrva)<0){
						 $("a.btn-dayin").remove();
					}
					//32代表导出
					if(jQuery.inArray("32", rrva)<0){
						 $("a.btn-daochu").remove();
						 $("input.btn-daochu").remove();
					}
       			}
		}
       	$("a.btn-xianshi").show();
		$("input.btn-xianshi").show();
		$("a.btn-xinzeng").show();
		$("a.btn-xiugai").show();
		$("a.btn-shanchu").show();
		$("input.btn-shanchu").show();
		$("a.btn-dayin").show();
		$("a.btn-daochu").show();
		$("input.btn-daochu").show();
       },
      
       error:function(){  
    	   
       }    
     });
});



//分页用的js（GO的点击）
function isNumber2(oNum) {
	if (!oNum)
		return false;
	var strP = /^\d+/;
	if (!strP.test(oNum))
		return false;
	try {
		if (parseFloat(oNum) != oNum)
			return false;
	} catch (ex) {
		return false;
	}
	return true;
}

//各模块首页重置按钮清空

$("#news").bind("click", function () {
    $("[name = searchbean.renqun]:checkbox").attr("checked", false);
   	$(":radio").eq(0).attr("checked", true);
    $(":radio").eq(3).attr("checked", true);
     $(":text").val("");
	$("textarea").val("");
	$("select").val("");
	$(".select2-selection__rendered").text("请选择");
});

$("#sub").bind("click",function(){
	var number=$("#num").val();
	if(number!=null||number!=""){
		if(number%1!=0){
			alert('不是整数')
			return false;
		}
	}
})
//特殊字符校验
$(function(){
			
			var oText01 = $(".temp");
			oText01.each(function(index, element) {
            	var oText = $(element);
				var reg = /[~!@#$%^&*()+{}|:"<>?！￥……（）——：“《》？]/g;
			   	oText.bind("keyup",function(){
					var sVal = $(this).val();
					var aaa = sVal.replace(reg,'');
					oText.val(aaa);
				});
			    
            });
			
			
			
		});

	/*var temps = document.getElementsByClassName('temp');
for (var i = 0; i < temps.length; i++) {

	temps[i].isShift = false;
for (var i = 0; i < temps.length; i++) {
		temps[i].onkeydown = function (e) {
        e = e || window.event;
        var key = e.keyCode;
        console.log(key);
        if (key === 16) {
            this.isShift = true;
        } else {
            var reg = /^(48|49|50|51|52|53|54|55|56|57)$/;//->特殊字符的键值正则(前提是按了shift键)
            if (reg.test(key) && this.isShift === true) {   
                return false;
            }
        }
        return true;
    }
	}	
    

for (var i = 0; i < temps.length; i++) {
	temps[i].onkeyup=function(e){
    	 e = e || window.event;
        var key = e.keyCode;
        if(key===16){
        	this.isShift = false;
        }
    }
}
    
	
}*/