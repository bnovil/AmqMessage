<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>amq</title>
</head>
<body>
<div>
    <input type = "text" id = "inputText">
    <button onclick="SendFunction()">send message</button>
</div>
<div id="show"></div>

<#--ActiveMQ ajax -->
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/amq_jquery_adapter.js"></script>
<script type="text/javascript" src="js/amq.js"></script>

<script>

    function showInfo(str) {
        var t = document.getElementById("show");
        var d = new Date();
        var dt = d + " : "
        t.innerHTML += dt + "<br>" + str + "<br>";
    }
    showInfo("start");


    var amq = org.activemq.Amq;
    amq.init({
        uri: 'amq',
        logging: true,
        timeout: 20
    });

    /**
     * Be aware that, by default, messages published via Stomp which include a content-length header will be
     * converted by ActiveMQ to binary messages, and will not be visible to your web clients
     * Beginning with ActiveMQ 5.4.0, you can resolve this problem by always setting the amq-msg-type header
     * to text in messages which will may be consumed by web clients.
     *
     * refactor sendMessage in amq.js from
     * 	sendMessage : function(destination, message) {
			sendJmsMessage(destination, message, 'send');
		}
      to
     * 	sendMessage : function(destination, message, headers) {
			sendJmsMessage(destination, message, 'send', headers);
		}
     */
    function SendFunction( ) {
        var destination = "channel://amq.test";
        var msgCon = document.getElementById("inputText").value;
        amq.sendMessage(destination,msgCon,"amq-msg-type='text'");
        showInfo("send message to queue: " + msgCon);

    }

</script>


</body>
</html>