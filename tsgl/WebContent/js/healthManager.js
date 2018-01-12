/*
 * @auther 张晓光
 */

//弹框显示对接系统返回的信息
  function alertMessage(message){
       if(message ==="" || message ===null){
       			return ;
       }
       var myType = "" ;
       if(message.indexOf("成功")!=-1){
           myType="success";
       }else{
       		myType="error";
       }
  swal({  
            title: message,   
            type: myType,   
            showCancelButton: false,  
            showConfirmButton:true,  
            animation: "slide-from-top",  
            }
  );}