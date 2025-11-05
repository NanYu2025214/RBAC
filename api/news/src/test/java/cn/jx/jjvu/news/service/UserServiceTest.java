package cn.jx.jjvu.news.service;

import cn.jx.jjvu.news.config.SpringConfig;
import cn.jx.jjvu.news.dao.RolesDao;
import cn.jx.jjvu.news.domain.Sys_User;
import cn.jx.jjvu.news.domain.Sys_User_Roles;
import cn.jx.jjvu.news.domain.UserPojo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest extends TestCase {
    @Autowired
    private UserService userService;
     @Autowired
      private RolesDao rolesDao;
//    @Test
//    public void testFindAllUser() {
//        List<Sys_User> sys_users = userService.findAllUser();
//        System.out.println("ok");
//    }
    @Test
    public void addUser() {
        UserPojo user = new UserPojo();
         user.setUsername("admin");
          user.setPassword("123");
          user.setStatus("1");
          user.setId(1);
           user.setRoles(Arrays.asList(1,2));
        userService.addUser(user);
        System.out.println("添加用户 is ok");
        List  roles = user.getRoles();
        for (int i = 0; i <roles.size() ; i++) {
            Sys_User_Roles sys_user_roles = new Sys_User_Roles();
            sys_user_roles.setUid(user.getId());
            sys_user_roles.setRid(user.getRoles().get(i));
            rolesDao.addUserAndRoles (sys_user_roles);
            System.out.println( "添加用户角色 is ok");

        }

    }
}