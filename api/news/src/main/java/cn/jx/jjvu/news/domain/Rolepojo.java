package cn.jx.jjvu.news.domain;

import java.util.List;

public class Rolepojo {
    private int role_id;
    private String role_name;
    private String remark;
    private List<Integer> permissions;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Integer> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Integer> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Rolepojo{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", remark='" + remark + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
