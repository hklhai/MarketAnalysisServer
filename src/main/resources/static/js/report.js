$(function(){
    var taskId = getQueryString("taskid");
    var url = "http://119.90.53.151:5601/app/kibana#/dashboard/47bddfe0-63b0-11e8-91a6-8dc4e1d30ce2?_g=(refreshInterval:(display:Off,pause:!f,value:0),time:(from:now%2Fd,mode:quick,to:now%2Fd))&amp;_a=(description:%E4%BA%A4%E4%BA%92%E5%BC%8F%E6%9F%A5%E8%AF%A2dashboard%E5%B1%95%E7%A4%BA,filters:!(),fullScreenMode:!f,options:(darkTheme:!f,hidePanelTitles:!f,useMargins:!t),panels:!((gridData:(h:3,i:'1',w:12,x:0,y:0),id:'32e53970-63af-11e8-91a6-8dc4e1d30ce2',panelIndex:'1',type:visualization,version:'6.1.2'),(gridData:(h:3,i:'2',w:12,x:0,y:3),id:e70e97c0-63af-11e8-91a6-8dc4e1d30ce2,panelIndex:'2',type:visualization,version:'6.1.2')),query:(language:lucene,query:'taskid:"+taskId+"'),timeRestore:!f,title:%E4%BA%A4%E4%BA%92%E5%BC%8F%E6%9F%A5%E8%AF%A2,uiState:(),viewMode:view)";
    $("#dataShow").attr("src",url);
    $.ajax({
        type: "post",
        url: "/system/showData",
        data: {
            taskid: taskId
        },
        dataType: "json",
        success: function(data){
            if(data.baiduInfo&&data.baiduInfo.otherInfo){
                var info = data.baiduInfo.otherInfo.replace(/\"/g,"").replace("{","").replace("}","");
                var infoArray = info.split(",");
                var str = "";
                var tdInfo1 = [];
                var tdInfo2 = [];
                $(".contener h4").text(infoArray[0].split(":")[1]+"----分析报告");
                for(var i=0,len=parseInt(infoArray.length/2);i<len;i=i+2){
                    console.log(i);
                    tdInfo1 = infoArray[i].split(":");
                    tdInfo2 = infoArray[i+1].split(":");
                    str+="<tr><td>"+tdInfo1[0]+"</td><td>"+tdInfo1[1]+"</td><"
                        +"<td>"+tdInfo2[0]+"</td><td>"+tdInfo2[1]+"</td></tr>";
                }
                $("table tbody").html(str);
                $(".info").css("top","30px");
                var iframeTop = $(".table").height()-168+90+"px";
                $(".iframe-div").css("top",iframeTop);
            }else{
                $(".contener h4").text(data.title+"----分析报告");
                var iframeTop = -90+"px";
                $(".iframe-div").css("top",iframeTop);
            }

        }
    });

    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
});