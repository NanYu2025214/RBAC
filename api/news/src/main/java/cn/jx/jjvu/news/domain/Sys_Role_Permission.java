package cn.jx.jjvu.news.domain;

public class Sys_Role_Permission {
    private int rid;
    private int pid;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Sys_Role_Permission{" +
                "rid=" + rid +
                ", pid=" + pid +
                '}';
    }
}
