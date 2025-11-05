package cn.jx.jjvu.news.service.impl;



import cn.jx.jjvu.news.dao.PermissionDao;
import cn.jx.jjvu.news.dao.RolesDao;
import cn.jx.jjvu.news.dao.UserDao;
import cn.jx.jjvu.news.domain.Dashboard;
import cn.jx.jjvu.news.service.DashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashServiceImpl implements DashService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RolesDao rolesDao;
    @Override
    public Dashboard findAll() {
        Dashboard dashboard = new Dashboard();
        dashboard.setTotalUsers(userDao.findCount());
        dashboard.setTotalRoles(rolesDao.findCount());
        dashboard.setTotalPermissions(permissionDao.findCount());
        return dashboard;
    }
}
