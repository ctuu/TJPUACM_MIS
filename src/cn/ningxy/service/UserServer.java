package cn.ningxy.service;

import cn.ningxy.bean.User;
import cn.ningxy.dao.UserDaoServer;

/**
 * @Author: ningxy
 * @Description:
 * @Date: 2018-04-18 13:00
 **/
public class UserServer implements IUserService {

    @Override
    /**
     * @Author: ningxy
     * @Description: login
     * @params: [request]
     * @return: cn.ningxy.bean.User
     * @Date: 2018/4/19 上午11:20
     */
    public User login(String userName, String userPassword) throws Exception {

        User user = new UserDaoServer().validateUser(userName, userPassword);

        if (user != null) {
            System.out.println("用户[" + userName + "]登录成功");
        } else {
            System.out.println("登录失败");
        }

        return user;
    }

    /**
     * @Author: ningxy
     * @Description: 用户每日打卡
     * @params: [user]
     * @return: boolean
     * @Date: 2018/4/28 下午3:15
     */
    @Override
    public boolean checkin(String userName) throws Exception {

        boolean isCheckinSucces = false;

        try {
            isCheckinSucces = new UserDaoServer().checkin(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isCheckinSucces == true) {
            System.out.println("UserServer | 用户[" + userName + "]打卡成功");
        } else {
            System.out.println("UserDaoServer | 用户[" + userName + "]打卡失败");
        }

        return isCheckinSucces;
    }

    /**
     * @param userName
     * @Author: ningxy
     * @Description: 检查是否今日已经打过卡
     * @params: [userName]
     * @return: boolean
     * @Date: 2018/4/28 下午9:53
     */
    @Override
    public boolean isAlreadyCheckedin(String userName) throws Exception {

        boolean result = false;

        try {
            result = new UserDaoServer().isAlreadyCheckedin(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
