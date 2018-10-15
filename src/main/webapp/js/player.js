function myAlert(msg){
    //alert(msg);
}

function execCmd(cmd){
    $.get("/mediaControl?cmd=" + cmd,function(data, status){
        myAlert("数据: " + data + "\n状态: " + status);
    });
}

$(document).ready(function(){
    $(".btn_big_prev").click(function(){
        $.get("/mediaControl?cmd=prevSong",function(data, status){
            myAlert("数据: " + data + "\n状态: " + status);
        });
    });

    $(".btn_big_play").click(function(){
        $.get("/mediaControl?cmd=playOrPause",function(data, status){
            myAlert("数据: " + data + "\n状态: " + status);
        });
    });

    $(".btn_big_next").click(function(){
        $.get("/mediaControl?cmd=nextSong",function(data, status){
            myAlert("数据: " + data + "\n状态: " + status);
        });
    });

    $("#increaseVolume").click(function(){
        $.get("/mediaControl?cmd=volumeUp",function(data, status){
            myAlert("数据: " + data + "\n状态: " + status);
        });
    });

    $("#decreaseVolume").click(function(){
        $.get("/mediaControl?cmd=volumeDown",function(data, status){
            myAlert("数据: " + data + "\n状态: " + status);
        });
    });

    $("#muteVolume").click(function(){
        $.get("/mediaControl?cmd=volumeMute",function(data, status){
            myAlert("数据: " + data + "\n状态: " + status);
        });
    });

    $(".btn_volume_mute").click(function(){
        $.get("/mediaControl?cmd=volumeMute",function(data, status){
            myAlert("数据: " + data + "\n状态: " + status);
        });
    });

    $(".btn_stop").click(function(){
        $.get("/mediaControl?cmd=stop",function(data, status){
            myAlert("数据: " + data + "\n状态: " + status);
        });
    });

    $(".btn_shutdown").click(function(){
        $.get("/systemControl?cmd=shutdown",function(data, status){
            myAlert("数据: " + data + "\n状态: " + status);
        });
    });

    $(".btn_cancel").click(function(){
        $.get("/systemControl?cmd=cancel",function(data, status){
            myAlert("数据: " + data + "\n状态: " + status);
        });
    });
});

