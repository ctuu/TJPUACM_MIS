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

        return checkinList;
    }
}
