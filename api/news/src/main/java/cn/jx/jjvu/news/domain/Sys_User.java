package cn.jx.jjvu.news.domain;

import java.util.List;

public class Sys_User {
    private int id;
    private String password;
    private String username;
    private String status;
    private List<Sys_Role> roles;

    public List<Sys_Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Sys_Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Sys_User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", status='" + status + '\'' +
                ", roles=" + roles +
                '}';
    }
}
