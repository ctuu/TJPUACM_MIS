package cn.ningxy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    //    private static final String URL = "jdbc:mysql://172.17.0.2:3333/mis";
    private static final String URL = "jdbc:mysql://localhost:3355/mis?useUnicode=true&characterEncoding=utf8&useSSL=false";
//    private static final String URL = "jdbc:mysql://localhost:3366/mis?useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String USER = "user";
    private static final String PASSWORD = "acmtjpu666";

    private Connection conn = null;

    //    加载驱动
    static {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("驱动加载失败：" + e.getMessage());
        }
    }

    /**
     * @Author: ningxy
     * @Description: 连接数据库
     * @params:
     * @return: Connection
     * @Date: 2018/4/17 下午8:27
     */
    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("数据库连接失败：" + e.getMessage());
        }
        return conn;
    }

}


