package cn.ningxy.dao;

import cn.ningxy.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ningxy
 * @Description: 定义各种数据交互函数原型
 * @Date: 2018-04-17 21:52
 **/
public interface IUserDaoService {

    /**
    * @Author: ningxy
    * @Description:
    * @params: [userName, passWord]
    * @return: cn.ningxy.bean.User
    * @Date: 2018/4/18 上午11:52
    */
    public List<User> getAllUser() throws Exception;

    /**
    * @Author: ningxy
    * @Description: 检查用户是否已存在
    * @params: [userName, userPassword]
    * @return: cn.ningxy.bean.User
    * @Date: 2018/4/18 下午9:31
    */
    public boolean isUserExist(String userName) throws Exception;

    /**
    * @Author: ningxy
    * @Description: 注册用户
    * @params: [userName, userPassword]
    * @return: cn.ningxy.bean.User
    * @Date: 2018/4/18 下午9:42
    */
    public User registerUser(String userName, String userPassword) throws Exception;

    /**
    * @Author: ningxy
    * @Description: 注册用户
    * @params: [user] 传入封装好的User
    * @return: cn.ningxy.bean.User
    * @Date: 2018/4/25 下午8:27
    */
    public User registerUser(User user) throws Exception;

    /**
    * @Author: ningxy
    * @Description: 检测用户名、密码是否匹配
    * @params: [userName, userPassword]
    * @return: cn.ningxy.bean.User
    * @Date: 2018/4/19 上午11:24
    */
    public User validateUser(String userName, String userPassword) throws Exception;

    /**
    * @Author: ningxy
    * @Description: 用户每日打卡
    * @params: [userName]
    * @return: boolean
    * @Date: 2018/4/28 下午1:52
    */
    public boolean checkin(String userName) throws Exception;

    /**
    * @Author: ningxy
    * @Description: 检查用户今日是否已经打过卡
    * @params: [userName]
    * @return: boolean
    * @Date: 2018/4/28 下午8:35
    */
    public boolean isAlreadyCheckedin(String userName) throws Exception;

    /**
    * @Author: ningxy
    * @Description:
    * @params: [userName]
    * @return: java.util.ArrayList<cn.ningxy.bean.User>
    * @Date: 2018/5/3 下午9:18
    */
    public ArrayList<User> getUserInfo(String userName) throws Exception;
}
