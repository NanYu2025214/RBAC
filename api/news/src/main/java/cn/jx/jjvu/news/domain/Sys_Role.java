package cn.jx.jjvu.news.domain;

import java.util.List;

public class Sys_Role {
    private int role_id;
    private String role_name;
    private String remark;
    private List<Sys_Permission> permissions;

    public List<Sys_Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Sys_Permission> permissions) {
        this.permissions = permissions;
    }

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

    @Override
    public String toString() {
        return "Sys_Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", remark='" + remark + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
