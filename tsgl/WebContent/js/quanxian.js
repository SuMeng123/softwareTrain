$(document).ready(function(){

	var curTr = $('.qx-ul > li');

	var curparInput = curTr.find('div > input');
	//子元素的长度
	var sonInputLength = curTr.find('ul li').length;
	console.log('子元素的行数为:'+sonInputLength);

	//点击父元素时 - 全选子元素
	curparInput.click(function () {
			var curIndex = $(this).index();
			var cursonInput = $(this).parent().next().find('input');
			console.log(cursonInput.length);
			if($(this).is(':checked') == true){
				for(var i = 0; (i*6) < cursonInput.length; i++){
					$(cursonInput[curIndex-1+i + 6*i]).prop('checked',true);
				}
			}else{
				for(var i = 0; (i*6) < cursonInput.length; i++){
					$(cursonInput[curIndex-1+i + 6*i]).prop('checked',false);
				}
			}
		});
		//全选   有bug！！！
		$('.all-check').click(function(){
			if($(this).is(':checked') == true){
				$(this).parent().find('input').prop('checked',true);
				if($(this).parent().is('div')){
					//checkAllCheck();
					$(this).parent().parent().find('input').prop('checked',true);
				}
			}else{
				$(this).parent().find('input').prop('checked',false);
				if($(this).parent().is('div')){
					//checkAllCheck();
					$(this).parent().parent().find('input').prop('checked',false);
				}
			}
		});
		//检测子元素右边全选选中 然后左侧选中
		function checkAllCheck (){
			var $allCheck = $('.all-check');
			console.log($allCheck);
			$allCheck.each(function (i) {
				if($($allCheck[i]).is(':checked') == true){
					$(this).parent().find('input').prop('checked',true);
				}else{
					$(this).parent().find('input').prop('checked',false);
				}
			});
		};
	//检测子元素都被选中时 - 父元素也选中

	//检测子元素选中个数 如果都选中即将父元素选中
	
	//给子元素赋value 从左到右为：1 2 4 8 16 32
	/*var sonLi = curTr.find('ul li');
	for(var i = 0; i < sonLi.length; i++){
		var curLi = $(sonLi[i]);
		curLi.find('input').each(function(i){
			$(this).val(Math.pow(2,i)); //2的i次方
		});
	}*/

	

});