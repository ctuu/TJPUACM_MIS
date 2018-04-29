package cn.ningxy.dao;

import java.sql.Connection;
import java.util.List;

/**
 * @Author: ningxy
 * @Description:
 * @Date: 2018-04-29 12:18
 **/
public class CheckinDao implements ICheckinDao {
    /**
     * @Author: ningxy
     * @Description:
     * @params: []
     * @return: java.util.List<java.lang.String>
     * @Date: 2018/4/29 下午12:18
     */
    @Override
    public List<String> getCheckList() throws Exception {

        String sql = "";

        Connection connection = new ConnectDB().getConnection();

        return null;
    }
}
