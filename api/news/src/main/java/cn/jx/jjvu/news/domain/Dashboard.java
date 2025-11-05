package cn.jx.jjvu.news.domain;

public class Dashboard {
    private int todayVisitors;
    private int totalUsers;
    private int totalRoles;
    private int totalPermissions;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTodayVisitors() {
        return todayVisitors;
    }

    public void setTodayVisitors(int todayVisitors) {
        this.todayVisitors = todayVisitors;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public int getTotalRoles() {
        return totalRoles;
    }

    public void setTotalRoles(int totalRoles) {
        this.totalRoles = totalRoles;
    }

    public int getTotalPermissions() {
        return totalPermissions;
    }

    public void setTotalPermissions(int totalPermissions) {
        this.totalPermissions = totalPermissions;
    }

    @Override
    public String toString() {
        return "Dashboard{" +
                "todayVisitors=" + todayVisitors +
                ", totalUsers=" + totalUsers +
                ", totalRoles=" + totalRoles +
                ", totalPermissions=" + totalPermissions +
                ", username='" + username + '\'' +
                '}';
    }
}
