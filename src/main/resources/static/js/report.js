$(function(){
    var taskId = getQueryString("taskid");
    var url = "http://spark3:5601/app/kibana#/dashboard/4522b9c0-42ce-11e8-9c4e-33472f948452?_g=(refreshInterval:(display:Off,pause:!f,value:0),time:(from:now%2Fy,mode:quick,to:now%2Fy))&amp;_a=(description:'',filters:!(),fullScreenMode:!t,options:(darkTheme:!f,hidePanelTitles:!f,useMargins:!t),panels:!((gridData:(h:3,i:'1',w:12,x:0,y:0),id:'28d6e300-443f-11e8-9c4e-33472f948452',panelIndex:'1',type:visualization,version:'6.1.2'),(gridData:(h:3,i:'2',w:12,x:0,y:3),id:'1e65cb60-4445-11e8-9c4e-33472f948452',panelIndex:'2',type:visualization,version:'6.1.2')),query:(language:lucene,query:'taskid:"+taskId+"'),timeRestore:!f,title:demo--45,uiState:(),viewMode:view)";
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