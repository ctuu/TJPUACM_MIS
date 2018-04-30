package cn.ningxy.service;

import cn.ningxy.bean.CheckinData;

import java.util.ArrayList;

/**
 * @Author: ningxy
 * @Description:
 * @Date: 2018-04-29 11:26
 **/
public interface ICheckinService {

    /**
     * @Author: ningxy
     * @Description: 获取今日打卡列表
     * @params: []
     * @return: java.util.ArrayList<cn.ningxy.bean.CheckinData>
     * @Date: 2018/4/29 下午2:20
     */
    public ArrayList<CheckinData> getCheckinList() throws Exception;

    /**
    * @Author: ningxy
    * @Description: 获取总打卡排名
    * @params: []
    * @return: java.util.ArrayList<cn.ningxy.bean.CheckinData>
    * @Date: 2018/4/30 下午12:41
    */
    public ArrayList<CheckinData> getCheckinRank() throws Exception;
}
