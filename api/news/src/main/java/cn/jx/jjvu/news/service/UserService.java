package cn.jx.jjvu.news.service;

import cn.jx.jjvu.news.domain.Sys_User;
import cn.jx.jjvu.news.domain.UserPojo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {


    String findUserByUserName(Sys_User user);

    PageInfo<Sys_User> findAllUser(int currentpage, int pagesize);
    List<Sys_User> findAllUser1();
    void addUser(UserPojo user);

    void delUser(int id);

    void updateUser(UserPojo user);
}
