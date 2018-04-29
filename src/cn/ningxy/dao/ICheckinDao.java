package cn.ningxy.dao;

import java.util.List;

/**
 * @Author: ningxy
 * @Description:
 * @Date: 2018-04-29 11:29
 **/
public interface ICheckinDao {

    /**
    * @Author: ningxy
    * @Description:
    * @params: []
    * @return: java.util.List<java.lang.String>
    * @Date: 2018/4/29 下午12:18
    */
    public List<String> getCheckList() throws Exception;
}
