package cn.ningxy.bean;

/**
 * @Author: ningxy
 * @Description: 打卡数据实体类
 * @Date: 2018-04-29 14:11
 **/
public class CheckinData {
    private String userName;
    private String checkinDate;
    private String checkinTime;
    private int checkinFrequency;

    public CheckinData(String userName, String checkinDate, String checkinTime, int checkinFrequency) {
        this.userName = userName;
        this.checkinDate = checkinDate;
        this.checkinTime = checkinTime;
        this.checkinFrequency = checkinFrequency;
    }

    public CheckinData(String userName, String checkinDate, String checkinTime) {
        this.userName = userName;
        this.checkinDate = checkinDate;
        this.checkinTime = checkinTime;
    }

    public CheckinData(String userName, int checkinFrequency) {
        this.userName = userName;
        this.checkinFrequency = checkinFrequency;
    }

    public CheckinData() {
        this.setUserName("");
        this.setCheckinDate("");
        this.setCheckinTime("");
        this.setCheckinFrequency(0);
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

    public int getCheckinFrequency() {
        return checkinFrequency;
    }

    public void setCheckinFrequency(int checkinFrequency) {
        this.checkinFrequency = checkinFrequency;
    }

    @Override
    public String toString() {
        return "CheckinData{" +
                "userName='" + userName + '\'' +
                ", checkinDate='" + checkinDate + '\'' +
                ", checkinTime='" + checkinTime + '\'' +
                ", checkinFrequency=" + checkinFrequency +
                '}';
    }
}
