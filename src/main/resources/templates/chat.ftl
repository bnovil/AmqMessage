<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/amq_jquery_adapter.js"></script>
    <script type="text/javascript" src="js/amq.js"></script>
</head>
<body>
leon's chating room:
<hr>
<div style="height:400px;width:600px;border:block;overflow:auto" id="msg">
</div>
<br>
<script type="text/javascript">
    var amq = org.activemq.Amq;
    amq.init({
        uri: 'amq',
        logging: true,
        timeout: 20
    });
    var myHandler =
            {
                rcvMessage: function(message)
                {
                    //alert("received data:"+message.text);
                    document.getElementByIdx_x("msg").innerHTML += message.text + "<br>";
                }
            };
    amq.addListener("smeguangdong","topic://FirstTopic",myHandler.rcvMessage);
    function go()
    {
        var nickname = document.getElementByIdx_x("nickname").value;
        var content = document.getElementByIdx_x("keymsg").value;
        var ms = nickname + " : " +content;
        //alert("msg is "+ms);
        amq.sendMessage("topic://FirstTopic","<message>"+ms+"</message>","amq-msg-type=>'text'");
    }
</script>
昵称：
<input type="text" id="nickname">
内容：
<input type="text" id="keymsg">
<button onclick="go()">submit</button>
</body>
</html>