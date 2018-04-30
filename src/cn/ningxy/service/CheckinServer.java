package cn.ningxy.service;

import cn.ningxy.bean.CheckinData;
import cn.ningxy.dao.CheckinDao;

import java.util.ArrayList;

/**
 * @Author: ningxy
 * @Description:
 * @Date: 2018-04-29 14:03
 **/
public class CheckinServer implements ICheckinService{

    /**
     * @Author: ningxy
     * @Description: 获取今日打卡列表
     * @params: []
     * @return: java.util.ArrayList<cn.ningxy.bean.CheckinData>
     * @Date: 2018/4/29 下午2:20
     */
    @Override
    public ArrayList<CheckinData> getCheckinList() throws Exception {
        return new CheckinDao().getCheckinList();
    }

    /**
     * @Author: ningxy
     * @Description: 获取总打卡排名
     * @params: []
     * @return: java.util.ArrayList<cn.ningxy.bean.CheckinData>
     * @Date: 2018/4/30 下午12:41
     */
    @Override
    public ArrayList<CheckinData> getCheckinRank() throws Exception {
        return new CheckinDao().getCheckinRank();
    }
}
