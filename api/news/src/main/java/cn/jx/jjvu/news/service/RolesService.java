package cn.jx.jjvu.news.service;

import cn.jx.jjvu.news.domain.Rolepojo;
import cn.jx.jjvu.news.domain.Sys_Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RolesService {
    List<Sys_Role> findAllRoles();

    PageInfo<Rolepojo> findAllRoles1(int currentpage, int pagesize);

    void addRole(Rolepojo role);

    void updateRole(Rolepojo role);

    void delRole(int roleId);
}
