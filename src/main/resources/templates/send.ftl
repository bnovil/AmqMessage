<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>amq</title>
</head>
<body>
<div id="show"></div>
<script>
    "use strict";
    //    var t1 = new Date().getTime();
    function showInfo(str) {
        var t = document.getElementById("show");
        var d = new Date();
        var dt = d + " : "
        t.innerHTML += dt + "<br>" + str + "<br>";
    }
    showInfo("开始加载");
    console.log("loading");
</script>

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/amq_jquery_adapter.js"></script>
<script type="text/javascript" src="js/amq.js"></script>

<script type="text/javascript">
    var amq = org.activemq.Amq;
    amq.init({
        uri: 'amq',
        logging: true,
        timeout: 20
    });

    var toReceiver = "hello";

    amq.sendMessage("channel://amq.test",toReceiver);
    amq.sendMessage("channel://amq.test","hello world");
    showInfo("send message");

//    var myHandler =
//        {
//            rcvMessage: function(message)
//            {
//                alert("received "+message.content);
//                showInfo("received " + message.toString());
//            }
//        };
//
//    amq.addListener("my","channel://amq.test",myHandler.rcvMessage);
</script>


</body>
</html>