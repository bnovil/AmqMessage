<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>receive</title>
</head>
<body>
<div id="show"></div>

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

    var myHandler =
        {
            rcvMessage: function(message)
            {
                console.log(message);
                //chrome
                showInfo("received " + message.textContent);

            }
        };

    var destination = "channel://amq.test";
    amq.addListener(1,destination,myHandler.rcvMessage);
    showInfo("listening");


</script>
</body>
</html>