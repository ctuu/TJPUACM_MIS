<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.ningxy.bean.CheckinData" %>
<%@ page import="cn.ningxy.service.CheckinServer" %>
<%@ page import="cn.ningxy.service.UserServer" %><%--
  Created by IntelliJ IDEA.
  User: ningxy
  Date: 2018/4/28
  Time: 下午10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link href="https://cdn.bootcss.com/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/toastr.js/latest/toastr.min.js"></script>

    <title>TJPUACM Board</title>

    <script>

        function sendRequestByPost() {

            toastr.options.timeOut = '5000'; //展现时间
            toastr.options.extendedTimeOut = '10000';
            toastr.options.positionClass = 'toast-top-full-width'; //弹出窗的位置
            toastr.options.showMethod = 'slideDown';
            toastr.options.progressBar = true;

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
                    var result = xmlReq.responseText.toString();
                    //后续操作

                    if (result == "checkedin") {
                        toastr.info("今天已经打过卡了哦~");
                    } else if (result == "success") {
                        toastr.success("今日打卡成功！！！");
                    } else if (result == "notLogin") {
                        toastr.warning("登录信息过期，请刷新页面重新登录哟~");
                    } else if (result == "IPIllegal") {
                        toastr.warning("请连接实验室网络进行打卡哦~");
                    } else {
                        toastr.error("抱歉，我们遇到了错误。请联系管理员。");
                    }
                }
            }

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
                toastr.warning("别着急嘛~ 先登录好嘛~");
            }
        }

        function sendRequestByPost2() {

            toastr.options.timeOut = '2000'; //展现时间
            toastr.options.extendedTimeOut = '1000';
            toastr.options.positionClass = 'toast-top-full-width'; //弹出窗的位置
            toastr.options.showMethod = 'slideDown';
            toastr.options.progressBar = false;

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
                    var result = xmlReq.responseText.toString();
                    //后续操作

                    if (result == "logoutSucceed") {
                        var url = "home.jsp";
                        var timeDelay = 1010;
                        toastr.info("退出成功");
                        setTimeout("top.location.href = '" + url + "'",timeDelay);
                    } else {
                        toastr.error("抱歉，我们遇到了错误。请联系管理员。");
                    }
                }
            };

            //创建异步Post请求
            var url = "LogoutServlet";
            // var url="LoginServlet";
            xmlReq.open("POST", url, true);
            xmlReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            //发送请求
            xmlReq.send(null);
        }
    </script>

</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-light bg-white sticky-top">
        <div class="container">
            <a class="navbar-brand" href="#">TJPU ACM Borad</a>
            <a href="profile.jsp"><button>set profile</button> </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <div class="navbar-nav mr-auto">
                    <a class=" nav-item active nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                    <a class="nav-item nav-link" href="rank.jsp">Rank</a>
                    <a class="nav-item nav-link" href="about.jsp">About
                    </a>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-link dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false" id="navbardrop">
                        Null
                    </button>
                    <div class="dropdown-menu dropdown-menu-right" id="dropdown-menu">
                        <%--<a class="dropdown-item" href="#">账户设置</a>--%>
                        <%--<a class="dropdown-item" href="#">后台管理</a>--%>
                        <a class="dropdown-item" href="profile.jsp">设置</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" onclick="sendRequestByPost2()">登出</a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
<%--<div class="alert alert-success" role="alert">--%>
    <%--签到成功，你是今日第--%>
    <%--<b>19</b>个签到的人 ~^ ^~--%>
<%--</div>--%>
<%--<div class="alert alert-warning" role="alert">--%>
    <%--请不要重复签到 = =。--%>
<%--</div>--%>
<main class="container mt-4">
    <div class="row">
        <div class="col-md-9">
            <div class="row">
                <div class="col-md-6">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">每日打卡</h5>
                            <h6 class="card-subtitle mb-2 text-muted">
                                <%
                                    Date date = new Date();
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                    TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
                                    dateFormat.setTimeZone(timeZone);
                                    out.print(dateFormat.format(date));
                                %>
                            </h6>
                            <p class="card-text">
                                大佬别签啦我都跟不上啦
                            </p>
                            <a onclick="sendRequestByPost()" class="btn btn-primary text-light">点击签到</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col">
                    <div class="card">
                        <div class="card-header">
                            通知
                        </div>
                        <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <div class="row">
                                        <a href="#" class="mr-auto">TJPU首个ACM个人系统上线啦</a>
                                        <time>2018-04-26</time>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="row">
                                        <a href="#" class="mr-auto">这还是一条通知</a>
                                        <time>2018-04-25</time>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="row">
                                        <a href="#" class="mr-auto">这又是一条通知</a>
                                        <time>2018-04-24</time>
                                    </div>
                                </li>
                                <li class="list-group-item">
                                    <div class="row">
                                        <a href="#" class="mr-auto">这是一条通知</a>
                                        <time>2018-04-23</time>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="card" style="width: 18rem;">
                <div class="card-header">
                    统计
                </div>
                <div class="card-body">
                    <!-- <h5 class="card-title">签到次数：</h5> -->
                    <!-- <h6 class="card-subtitle mb-2 text-muted">2018-04-25</h6> -->
                    <p class="card-text">
                        今日Top3：<br>
                        <%
                            String[] color = new String[3];
                            color[0] = "#FF230F";
                            color[1] = "#ff3c97";
                            color[2] = "D559FF";

                            ArrayList<CheckinData> checkinDataArrayList = new CheckinServer().getCheckinList();

                            if(checkinDataArrayList != null) {
                                for(int i = 0; i < checkinDataArrayList.size() && i < 3; i++) {

                                    String checkinTop3 = null;
                                    String checkinListUserName = checkinDataArrayList.get(i).getUserName();
                                    String checkinListTime = checkinDataArrayList.get(i).getCheckinTime();

                                    checkinTop3 = String.format("No.%d %s    -> %s ", i+1, checkinListUserName, checkinListTime);
                                    out.print("<p style=\"color: " + color[i] + "\">" + checkinTop3 + "</p>");
                                }
                            }
                        %>
                        <%--<span style="color: #d559ff;"></span>--%>
                        <%--<a href="#" style="color: xxx">xiaowuga</a>--%>
                        <%--于--%>
                        <%--<time>08:17</time>--%>
                    </p>
                </div>
            </div>
        </div>
    </div>
</main>
<%@include file="footer.jsp"%>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<%
    //    获取当前用户
    String userNow = new UserServer().getUserNow(request);
    System.out.println("home | " + userNow);
    out.print("<script>userNow = '" + userNow + "';</script>");
//    out.print("userNow = '"+ userNow +"';");

    if (userNow != null) {
        out.println("<script>document.getElementById(\"navbardrop\").innerHTML=\"" + userNow + "\";</script>");
//        out.println("<script>document.getElementById(\"dropdown-menu\").innerHTML = \"<a class=\\\"dropdown-item\\\" href=\\\"#\\\">设置</a>\";</script>");
//        out.println("<script>document.getElementById(\"dropdown-menu\").innerHTML = \"<a class=\\\"dropdown-item\\\" onclick=\\\"sendRequestByPost2()\\\">登出</a>\";</script>");
    } else {
        out.println("<script>document.getElementById(\"navbardrop\").innerHTML=\"未登录\";</script>");
        out.println("<script>document.getElementById(\"dropdown-menu\").innerHTML = \"<a class=\\\"dropdown-item\\\" href=\\\"login.jsp\\\">登录</a><a class=\\\"dropdown-item\\\" href=\\\"register.jsp\\\">注册</a>\"</script>\n");
    }
%>

</body>



</html>
