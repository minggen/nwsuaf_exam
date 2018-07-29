$(function(){
	$("#ad_form_login").bootstrapValidator({  
        message: '通用的验证失败消息',//好像从来没出现过  
        feedbackIcons: {//根据验证结果显示的各种图标  
            valid: 'glyphicon glyphicon-ok',  
            invalid: 'glyphicon glyphicon-remove',  
            validating: 'glyphicon glyphicon-refresh'  
        },  
        fields: {  
        	username: {
                 message: '用户名验证失败',
                 validators: {
                     notEmpty: {
                         message: '用户名不能为空'
                     },
                     stringLength: {//检测长度  
                         min: 10,  
                         max: 10,  
                         message: '长度应为10位'  
                     }
                 }
             },
             password: {
                 message: '密码验证失败',
                 validators: {
                     notEmpty: {
                         message: '密码不能为空'
                     }
          
                 }
             }/*,
             examid:{
            	 message: '考试ID有误',
                 validators: {
                     notEmpty: {
                         message: '考试ID不能为空'
                     }
          
                 }
             }*/
             
        }  
    });  
	
});