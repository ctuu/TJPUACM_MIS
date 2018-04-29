<%--
  Created by IntelliJ IDEA.
  User: ningxy
  Date: 2018/4/25
  Time: 上午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script>
        // 设置当前登录用户的用户名全局变量
        var userNow = null;
    </script>
</head>
<body>
<h4 style="color: red">USER : <%=session.getAttribute("userName")%>
</h4>
<h4 style="color: red">STATUS : <%=session.getAttribute("loginRes")%>
</h4>
<a href="login.jsp">
    <button class="button">Login</button>
</a>
<a href="register.jsp">
    <button class="button">Register</button>
</a>
<br>
签到结果<span id="checkinResSpan"></span>
<button id="checkin" onclick="sendRequestByPost()">Checkin</button>
<%--<h2><%=request.getAttribute("checkinRes")%></h2>--%>

</body>

<script>

    function sendRequestByPost() {

        <%
            //    获取当前用户
            String userNow = null;
            Cookie cookie = null;
            Cookie[] cookies = null;
            cookies = request.getCookies();
            if(cookies != null) {
                for(int i = 0 ; i < cookies.length; i++) {
                    if(cookies[i].getName().equals("username")) {
                        System.out.println("cookies = " + cookies[i].getValue());
                        userNow = cookies[i].getValue();
                    }
                }
            }
            System.out.println("home | " + userNow);
//            out.print("<script>userNow = '"+ userNow +"';</script>");
            out.print("userNow = '"+ userNow +"';");
        %>

        //定义异步请求对象
        var xmlReq;
        //检测浏览器是否直接支持ajax
        if (window.XMLHttpRequest) {//直接支持ajax
            xmlReq = new XMLHttpRequest();
        } else {//不直接支持ajax
            xmlReq = new ActiveObject('Microsoft.XMLHTTP');
        }

        //设置回调函数
        xmlReq.onreadystatechange = function () {
            if (xmlReq.readyState == 4 && xmlReq.status == 200) {
                //获取服务器的响应值
                var result = xmlReq.responseText;
                //后续操作
                alert(result);
            }
        };

        //创建异步Post请求
        var url = "CheckinServlet";
        // var url="LoginServlet";
        xmlReq.open("POST", url, true);
        xmlReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        //发送请求
        if (userNow != "null") {
            var data = "username=" + userNow;
            xmlReq.send(data);
        } else {
            alert("当前未登录！");
        }
    }
</script>

</html>
