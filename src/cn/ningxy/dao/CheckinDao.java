package cn.ningxy.dao;

import cn.ningxy.bean.CheckinData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author: ningxy
 * @Description:
 * @Date: 2018-04-29 12:18
 **/
public class CheckinDao implements ICheckinDao {
    /**
     * @Author: ningxy
     * @Description: 获取今日打卡列表
     * @params: []
     * @return: java.util.ArrayList<cn.ningxy.bean.CheckinData>
     * @Date: 2018/4/29 下午2:21
     */
    @Override
    public ArrayList<CheckinData> getCheckinList() throws Exception {

        String sql = "SELECT users.username, checkin.checkin_date, checkin.checkin_time " +
                "FROM users INNER JOIN checkin " +
                "ON checkin.user_id = users.user_id " +
                "WHERE checkin_date = CURRENT_DATE ;";

        Connection connection = new ConnectDB().getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = null;

        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<CheckinData> checkinList = new ArrayList<>();

        while (resultSet.next()) {
            String userName = resultSet.getString(1);
            String checkinDate = resultSet.getString(2);
            String checkinTime = resultSet.getString(3);
            checkinList.add(new CheckinData(userName, checkinDate, checkinTime));
        }
        try {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return checkinList;
    }

    /**
     * @Author: ningxy
     * @Description: 获取总打卡排名
     * @params: []
     * @return: java.util.ArrayList<cn.ningxy.bean.CheckinData>
     * @Date: 2018/4/30 下午12:28
     */
    @Override
    public ArrayList<CheckinData> getCheckinRank() throws Exception {

        String sql = "SELECT A.username, B.cnt \n" +
                "FROM users AS A \n" +
                "INNER JOIN (\n" +
                "  SELECT user_id, COUNT(*) cnt \n" +
                "  FROM checkin \n" +
                "  GROUP BY user_id \n" +
                ") AS B \n" +
                "ON A.user_id = B.user_id \n" +
                "ORDER BY B.cnt DESC;";

        Connection connection = new ConnectDB().getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = null;

        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<CheckinData> result = new ArrayList<>();

        while (resultSet.next()) {
            String userName = resultSet.getString(1);
            int frequency = Integer.valueOf(resultSet.getString(2));
//            System.out.println("CheckinDao | " + userName + ", " + frequency);
            result.add(new CheckinData(userName, frequency));
        }

        try {
            resultSet.close();
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
