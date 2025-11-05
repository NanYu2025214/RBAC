package cn.jx.jjvu.news.service;

import cn.jx.jjvu.news.domain.Sys_Permission;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PermissionService {
    PageInfo<Sys_Permission> findAllPermission(int currentpage, int pagesize);

    void addPermission(Sys_Permission permission);

    void updatePermission(Sys_Permission permission);

    void deletePermission(int id);
}
