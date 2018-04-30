package cn.ningxy.servlet;

import cn.ningxy.dao.UserDaoServer;
import cn.ningxy.service.CheckinServer;
import cn.ningxy.service.UserServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: ningxy
 * @Description: 用户每日打卡
 * @Date: 2018-04-28 15:20
 **/
@WebServlet(name = "CheckinServlet")
public class CheckinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String userName = request.getParameter("username");

        boolean isCheckinSuccess = false;
        boolean isAlreadyCheckedin = false;
        boolean isIPLegal = false;



        PrintWriter out = response.getWriter();

        try {
            isAlreadyCheckedin = new UserServer().isAlreadyCheckedin(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isAlreadyCheckedin == true) {
            out.print("checkedin");
        } else {

            isIPLegal = new CheckinServer().CheckIPAddr(request);

            if (isIPLegal == false) {
                out.print("IPIllegal");
            } else {
                try {
                    isCheckinSuccess = new UserServer().checkin(userName);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (isCheckinSuccess == true) {
                    out.print("success");
                } else {
                    out.print("error");
                }

                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
