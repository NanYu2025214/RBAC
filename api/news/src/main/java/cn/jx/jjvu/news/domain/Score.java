package cn.jx.jjvu.news.domain;

public class Score {
    private int sid;
    private String name;
    private float chinese;
    private float math;
    private float english;
    private float total;
    private Sys_Role role;

    public Sys_Role getRole() {
        return role;
    }

    public void setRole(Sys_Role role) {
        this.role = role;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getChinese() {
        return chinese;
    }

    public void setChinese(float chinese) {
        this.chinese = chinese;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = this.chinese+this.math+this.english;
    }

    @Override
    public String toString() {
        return "Score{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                ", total=" + total +
                ", role=" + role +
                '}';
    }

}
