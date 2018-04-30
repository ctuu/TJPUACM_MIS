package cn.ningxy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @Author: ningxy
 * @Description: 用户退出登录
 * @Date: 2018-04-30 18:41
 **/
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //    获取当前用户
        String userNow = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("username")) {
                    System.out.println("cookies = " + cookies[i].getValue());
                    userNow = cookies[i].getValue();
                }
            }
        }
        System.out.println("CheckoutServlet | " + userNow);

        PrintWriter out = response.getWriter();

        if (userNow != null) {
            Cookie cookie = new Cookie("username", userNow);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            out.print("logoutSucceed");
        } else {
            out.print("logoutFailed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
