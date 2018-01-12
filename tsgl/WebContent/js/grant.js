

 window.onload = function(){

  var parent = document.getElementsByTagName("td");
          for(var i=0; i<parent.length; i++){
            parent[i].id = i;
                          //给td元素菜单赋属性id
                        }

  var input = document.getElementsByTagName('input');
    for(var i=0; i<input.length; i++){
      input[i].id=i;
    }
}

//纵向选中

function TdSelect(obj){
  
  var click = obj.id;
  var newNum1 = parseInt(click) + 7;
  var newNum2 = parseInt(click) + 14;
  var AllInput = document.getElementsByTagName('input');
    if(obj.checked == true){
        AllInput[newNum1].checked = true;
        AllInput[newNum2].checked = true;
      }
      else{
        AllInput[newNum1].checked= false;
        AllInput[newNum2].checked= false;
      }
}
// 单行全选
// function TrSelect(obj){
//   var TrBrother = this.
// }


// 全选函数
function selectAll(obj){
  var Sall = document.getElementsByTagName('input');
  for(i=0; i<Sall.length; i++){
    Sall[i].checked= true;

  }
}




function gparent(obj){
          var son = document.getElementsByClassName("grant-son");
          
          var son1 = son[0];
          var son2 = son[1];  //档案管理
          var son3 = son[2];
          var son4 = son[3];
          var son5 = son[4];
          var son6 = son[5];
          var son7 = son[6];
          var son8 = son[7];  //健康管理
          var son9 = son[8];
          var son10 = son[9];
          var son11 = son[10];  //健康理疗  
          var son12 = son[11];
          var son13 = son[12];
          var son14 = son[13];
          var son15 = son[14];  //健康关怀
          var son16 = son[15];
          var son17 = son[16];
          var son18 = son[17];
          var son19 = son[18];
          var son20 = son[19];
          var son21 = son[20];
          var son22 = son[21];  //门诊记录
          var son23 = son[22];
          var son24 = son[23];
          var son25 = son[24];  
          var son26 = son[25];  //员工管理
          var son27 = son[26];
          var son28 = son[27];
          var son29 = son[28];	//统计分析
          var son30 = son[29];
          var son31 = son[30]; 
          var son32 = son[31];
          var son33 = son[32];  //系统管理
          var img = document.getElementsByClassName('head-img');
          var img1 = img[0];
          var img2 = img[1];
          var img3 = img[3];
          var img4 = img[4];
          var img5 = img[5];
          var img6 = img[6];
          var img7 = img[9];
          //获取display属性
          function getStyle(obj,attr){

            if(obj.currentStyle){
              return obj.currentStyle[attr];
            }
            else{
              return document.defaultView.getComputedStyle(obj,false)[attr];
            }
          }

        var tdId = obj.id;
        var IdNum = parseInt(tdId);
        switch(IdNum){
        	case 0: 
                var dis = getStyle(son1,'display');
                if(dis=='none'){
                  son1.style.display = "table-row";
                  son2.style.display = "table-row";
                  img1.style.transform = 'rotate(90deg)'
                }
                else{
                  son1.style.display = "none";
                  son2.style.display = "none";
                  img1.style.transform = 'rotate(0deg)'
                }

        	break;
        	case 24:
                  var dis = getStyle(son3,'display');
                  if(dis=='none'){
                    son3.style.display = "table-row";
                    son4.style.display = "table-row";
                    son5.style.display = "table-row";
                    son6.style.display = "table-row";  
                    son7.style.display = "table-row";
                    son8.style.display = "table-row";
                    img2.style.transform = 'rotate(90deg)'
                  }
                  else{
                   son3.style.display = "none";
                   son4.style.display = "none";
                   son5.style.display = "none";
                   son6.style.display = "none";  
                   son7.style.display = "none";
                   son8.style.display = "none";
                   img2.style.transform = 'rotate(0deg)'
                  }
                   
        	break;
        	case 88: 
                   var dis = getStyle(son9,'display');
                   if(dis=='none'){
                   son9.style.display = "table-row";
                   son10.style.display = "table-row";
                   son11.style.display = "table-row";
                   img3.style.transform = 'rotate(90deg)'
                  }
                  else{
                   son9.style.display = "none";
                   son10.style.display = "none";
                   son11.style.display = "none";
                   img3.style.transform = 'rotate(0deg)'
                  }
        	break;
        	case 120:
                  var dis = getStyle(son12,'display'); 
                  if(dis=='none'){
                   son12.style.display = "table-row";
                   son13.style.display = "table-row";
                   son14.style.display = "table-row";  
                   son15.style.display = "table-row";
                   img4.style.transform = 'rotate(90deg)'
                 }
                 else{
                   son12.style.display = "none";
                   son13.style.display = "none";
                   son14.style.display = "none";  
                   son15.style.display = "none";
                   img4.style.transform = 'rotate(0deg)'
                 }
        	break;
        	case 160: 
                  var dis = getStyle(son16,'display');
                  if(dis=='none'){
                   son16.style.display = "table-row";
                   son17.style.display = "table-row";
                   son18.style.display = "table-row";
                   son19.style.display = "table-row";  
                   son20.style.display = "table-row";
                   son21.style.display = "table-row";
                   son22.style.display = "table-row";
                   img5.style.transform = 'rotate(90deg)'
                 }
                 else{
                   son16.style.display = "none";
                   son17.style.display = "none";
                   son18.style.display = "none";
                   son19.style.display = "none";  
                   son20.style.display = "none";
                   son21.style.display = "none";
                   son22.style.display = "none";
                   img5.style.transform = 'rotate(0deg)'
                 }

        	break;
        	case 224:
                  var dis = getStyle(son23,'display');
                  if(dis=='none'){
                   son23.style.display = "table-row";
                   son24.style.display = "table-row";
                   son25.style.display = "table-row";
                   img6.style.transform = 'rotate(90deg)'
                 }
                 else{
                   son23.style.display = "none";
                   son24.style.display = "none";
                   son25.style.display = "none";
                   img6.style.transform = 'rotate(0deg)'
                 }

        	break;
        	case 272: 
                  var dis = getStyle(son26,'display');
                  if(dis=='none'){
                    son26.style.display = "table-row";
                    son27.style.display = "table-row";
                    son28.style.display = "table-row";
                    son29.style.display = "table-row";
                    son30.style.display = "table-row";
                    son31.style.display = "table-row";
                    img7.style.transform = 'rotate(90deg)'
                  }
                  else{
                    son26.style.display = "none";
                    son27.style.display = "none";
                    son28.style.display = "none";
                    son29.style.display = "none";
                    son30.style.display = "none";
                    son31.style.display = "none";
                    img7.style.transform = 'rotate(0deg)'
                  }
        	break;
          
        }

         
	}



