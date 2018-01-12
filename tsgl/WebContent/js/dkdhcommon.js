function editReturn(){
	  window.parent.location.href = 'incompleteRecordAction2!showIncompleteRecord.action';
	}

var DKDH = {};
//添加接诊记录时，修改高血压、糖尿病相同的文本输入内容
DKDH.addJzsj = function(){
	var jzjlForm = document.getElementById("registerform");
	var fieldsNameObserve = ['incompleteRecord.sg','incompleteRecord.tz'
	                         ,'incompleteRecord.tizhi','incompleteRecord.ssy'
	                         ,'incompleteRecord.szy','incompleteRecord.other'
	                         ,'incompleteRecord.xl'];

		
	for (var i = 0; i < fieldsNameObserve.length; i++) {
		(function(num){
			console.log(num);
			console.log(fieldsNameObserve[num]);
			console.log(typeof jzjlForm.elements[fieldsNameObserve[num]]);
			
			if(jzjlForm.elements[fieldsNameObserve[num]].addEventListener){
				jzjlForm.elements[fieldsNameObserve[num]].addEventListener("change", 
						DKDH.fieldChangeHandler(fieldsNameObserve[num]),false);
			} else if(jzjlForm.elements[fieldsNameObserve[num]].attachEvent){
				jzjlForm.elements[fieldsNameObserve[num]].attachEvent("onchange",
						DKDH.fieldChangeHandler(fieldsNameObserve[num]));
			} else {
				jzjlForm.elements[fieldsNameObserve[num]].onchange = DKDH.fieldChangeHandler(fieldsNameObserve[num]);
			}
			//DKDH.EventUtil.addHandler(jzjlForm.elements[fieldsNameObserve[num]], "change",
					//DKDH.fieldChangeHandler(fieldsNameObserve[num]));
			//DKDH.EventUtil.addHandler(jzjlForm.elements[fieldsNameObserve[num]], "change",
				//	sgHandler);
			//$(jzjlForm.elements[fieldsNameObserve[num]]).on("change",fieldChangeHandler(fieldsNameObserve[num]));
		})(i);
		
	}
	
};
//字段内容变化  处理函数
DKDH.fieldChangeHandler=function(fieldName){
	return function (){
		var gxyForm = document.getElementById("registerformGxy");
		var tnbForm = document.getElementById("registerformTnb");
		var jzjlForm = document.getElementById("registerform");
		var fieldValue = jzjlForm.elements[fieldName].value;
		switch(fieldName){
			case 'incompleteRecord.sg':
			   gxyForm.elements['signGxy.height'].value = fieldValue;
			   tnbForm.elements['signTnb.height'].value = fieldValue;
			   break;
			case 'incompleteRecord.tz':
				gxyForm.elements['signGxy.wight'].value = fieldValue;
				   tnbForm.elements['signTnb.wight'].value = fieldValue;
				   break;
			case 'incompleteRecord.tizhi':
				gxyForm.elements['signGxy.bmi'].value = fieldValue;
				   tnbForm.elements['signTnb.bmi'].value = fieldValue;
				   break;
			case 'incompleteRecord.ssy':
				gxyForm.elements['signGxy.bloodPressureL'].value = fieldValue;
				   tnbForm.elements['signTnb.bloodPressureL'].value = fieldValue;
				   break;
			case 'incompleteRecord.szy':
				gxyForm.elements['signGxy.bloodPressureH'].value = fieldValue;
				   tnbForm.elements['signTnb.bloodPressureH'].value = fieldValue;
				   break;
			case 'incompleteRecord.other':
				gxyForm.elements['signGxy.others'].value = fieldValue;
				   tnbForm.elements['signTnb.others'].value = fieldValue;
				   break;
			case 'incompleteRecord.xl':
				gxyForm.elements['signGxy.heartRate'].value = fieldValue;
				   break;
			default:
				break;
		
		}
	};
	
	
}

//检查iframe是否存在
DKDH.checkeExistence = function (iframeName){
	var src = document.iframes[iframeName].src;
	return src == ""?false:true;
	
}

//添加、移除事件类公用函数
DKDH.EventUtil = {
	addHandler:function(element,type, handler){
		if(element.addEventListener){
			element.addEventListener(type, handler, false);
		} else if(element.attachEvent){
			element.attachEvent('on'+type, handler);
		} else {
			element['on'+type] = handler;
		}
	},
	removeHandler:function(element,type,handler){
		if(element.removeEventListener){
			element.removeEventListener(type, handler, false);
		} else if (element.dettachEvent){
			element.detachEvent('on'+type, handler);
		} else {
			element['on'+type] = null;
		}
	}
}