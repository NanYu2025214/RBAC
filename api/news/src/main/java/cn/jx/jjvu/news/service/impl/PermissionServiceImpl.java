package cn.jx.jjvu.news.service.impl;

import cn.jx.jjvu.news.dao.PermissionDao;
import cn.jx.jjvu.news.domain.Sys_Permission;
import cn.jx.jjvu.news.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao  permissionDao;
    @Override
    public PageInfo<Sys_Permission> findAllPermission(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        List<Sys_Permission> permissions =permissionDao.findAllPermission();
        return new PageInfo<>(permissions);
    }

    @Override
    public void addPermission(Sys_Permission permission) {
        permissionDao.addPermission(permission);
    }

    @Override
    public void updatePermission(Sys_Permission permission) {
        permissionDao.updatePermission(permission);
    }

    @Override
    public void deletePermission(int id) {
        permissionDao.deletePermission(id);
    }
}
