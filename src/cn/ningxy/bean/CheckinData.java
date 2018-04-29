package cn.ningxy.bean;

/**
 * @Author: ningxy
 * @Description:
 * @Date: 2018-04-29 14:11
 **/
public class CheckinData {
    private String userName;
    private String checkinDate;
    private String checkinTime;

    public CheckinData(String userName, String checkinDate, String checkinTime) {
        this.userName = userName;
        this.checkinDate = checkinDate;
        this.checkinTime = checkinTime;
    }

    public CheckinData() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    @Override
    public String toString() {
        return "CheckinData{" +
                "userName='" + userName + '\'' +
                ", checkinDate='" + checkinDate + '\'' +
                ", checkinTime='" + checkinTime + '\'' +
                '}';
    }
}
