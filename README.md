# AmqMessage
这是一个通过ActiveMQ, Ajax 实现的一个简单的web即时通讯demo , 采用Spring Boot 实现。<br>
ActiveMQ支持Ajax，可以利用ActiveMQ的消息队列，来创建高度实时的web应用。<br>
Apache-activemq的目录下有一个官方的例子，webapps-demo . 官方的说明在这 http://activemq.apache.org/ajax.html <br>

<h3>启动</h3>
先启动ActiveMQ, 然后运行该项目, 打开网页 <br>
http://localhost:8081/send 发送方 <br>
http://localhost:8081/receive 接收方 <br>

<h3>原理</h3>
ActiveMQ 在版本发布包中包含了web sample的demo,其中就包含js与ActiveMQ交互的库文件amq.js. 
以5.8.0版本为例,该文件目录为 
apache-activemq-5.8.0\webapps-demo\demo\js\amq.js这个js文件还依赖一些基于公共JavaScript框架的 
适配器文件,比如依赖jQuery的适配器为amq_jquery_adapter.js. 因此,使用amq.js时,必须先引入 
jquery库文件和适配器库文件amq_jquery_adapter.js,然后在引入amq.js.

amq.js里面提供了sendMessage方法可以发送消息到代理,而addListener和removeListener方法可以给 
指定的的消息目的地添加或删除监听器,添加监听器后即可接收消息了.

在web页面使用sendMessage发送消息,其实是向后台的一个servlet发送请求,然后由该servlet发送消息给代理. 
这个servlet的类由ActiveMQ提供(后面配置web.xml时介绍)

页面调用addListener注册监听器,其实也是发送请求给servlet,由servlet创建一个目的地的消费者,当该目的地 
有消息时,servlet处理消息,并将消息处理响应发送给客户端.因为采用web的CS架构,servlet不能直接将响应发送 
给客户端. 这里amq.js中其实是采用了一种页面轮询的方式向服务器请求消息,以便监听代理上指定的目的地.

简而言之就是, 
发送消息: amq.js使用sendMessage发送消息给servlet,servlet在将消息发给代理. 
接收消息: amq.js使用addListener注册监听器接收并处理消息,其实也是发送请求给servlet,servlet产生消息消费者 
消费指定目的地的消息并产生客户端响应,amq.js使用一种特殊的轮询机制不断从服务器获取消息处理的响应.
