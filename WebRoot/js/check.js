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
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });
}
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return (r[2]);
}