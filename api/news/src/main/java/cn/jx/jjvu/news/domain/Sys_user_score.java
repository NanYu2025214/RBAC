package cn.jx.jjvu.news.domain;

public class Sys_user_score {
    private int uid;
    private int sid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Sys_user_score{" +
                "uid=" + uid +
                ", sid=" + sid +
                '}';
    }
}
