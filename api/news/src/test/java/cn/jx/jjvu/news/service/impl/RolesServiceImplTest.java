package cn.jx.jjvu.news.service.impl;

import cn.jx.jjvu.news.config.SpringConfig;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RolesServiceImplTest extends TestCase {
    @Autowired
    private RolesServiceImpl rolesService;
    @Test
    public void testFindAllRoles1() {
        System.out.println(rolesService.findAllRoles1(1,4));
    }
}