package cn.jx.jjvu.news.dao;

import cn.jx.jjvu.news.config.SpringConfig;
import cn.jx.jjvu.news.domain.Sys_Role;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(classes = SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RolesDaoTest extends TestCase {

    @Autowired
    private RolesDao rolesDao;
    @Test
    public void testFindRolesById() {
        List<Sys_Role> roles = rolesDao.findRolesById(1);
        System.out.println(roles);
    }

    @Test
    public void findAllRoles() {
        System.out.println(rolesDao.findAllRoles());
    }
}