function myAlert(msg){
    //alert(msg);
}

$(".btn_big_prev").click(function(){
    $.get("/qqmusicControl?cmd=prevSong",function(data, status){
        myAlert("数据: " + data + "\n状态: " + status);
    });
});

$(".btn_big_play").click(function(){
    $.get("/qqmusicControl?cmd=startOrStop",function(data, status){
        myAlert("数据: " + data + "\n状态: " + status);
    });
});

$(".btn_big_next").click(function(){
    $.get("/qqmusicControl?cmd=nextSong",function(data, status){
        myAlert("数据: " + data + "\n状态: " + status);
    });
});

$("#increaseVolume").click(function(){
    $.get("/qqmusicControl?cmd=increaseVolume",function(data, status){
        myAlert("数据: " + data + "\n状态: " + status);
    });
});

$("#decreaseVolume").click(function(){
    $.get("/qqmusicControl?cmd=decreaseVolume",function(data, status){
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