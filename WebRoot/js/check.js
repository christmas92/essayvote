/**
 * Created by Administrator on 2015/10/21.
 */
function checkSubscribed(){
	$.ajax({
        type:'post',
        url:'checkSubscribed',//'?openid='+GetQueryString("openid")+'&id='+num',     
        data:{
            openid:GetQueryString("openid")
            //openid:"<%= openid%>",
        },
        dataType:'json',
        cache:false,
        async:true,
        success: function(data) {
        	if(data.state=="1"){ //�Ѿ���ע

        	}
        	if(data.state=="0"){
                ShowDiv('MyDiv','fade');
        	}
        }/*,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }*/
    });
}
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return (r[2]);
}

function hasIdentity(){
    $.ajax({
        type:'post',
        url:'hasIdentity',//'?openid='+GetQueryString("openid")+'&id='+num',
        data:{
            openid:GetQueryString("openid")
            //openid:"<%= openid%>",
        },
        dataType:'json',
        cache:false,
        async:true,
        success: function(data) {
            if(data.state=="-1"){ //�Ѿ���ע
                ShowDiv('IdentityDiv','fade');
            }
        }/*,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }*/
    });
}
function other(){
    $.ajax({
        type:'post',
        url:'other',//'?openid='+GetQueryString("openid")+'&id='+num',
        data:{
            openid:GetQueryString("openid")
            //openid:"<%= openid%>",
        },
        dataType:'json',
        cache:false,
        async:true,
        success:CloseDiv('IdentityDiv','fade')
        /*,
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }*/
    });
}

function senddiv(){
    CloseDiv('IdentityDiv','fade');
    ShowDiv('SendDiv','fade');
}

function lawyer(){
    $.ajax({
        type:'post',
        url:'lawyer',//'?openid='+GetQueryString("openid")+'&id='+num',
        data:{
            openid:GetQueryString("openid")
            //openid:"<%= openid%>",
        },
        dataType:'json',
        cache:false,
        async:true,
        success: function(data) {

        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}

function turnRegular(){
    var re = "#regular_1";
    var display = $(re).css('display');
    if(display=="none"){
        $(re).css('display','block');
    }else{
        $(re).css('display','none');
    }
}