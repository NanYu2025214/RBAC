package cn.jx.jjvu.news.domain;

public class Sys_User_Roles {
     private int uid;
      private int rid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Sys_User_Roles{" +
                "uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}
