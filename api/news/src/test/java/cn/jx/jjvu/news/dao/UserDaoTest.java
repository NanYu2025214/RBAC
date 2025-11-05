package cn.jx.jjvu.news.dao;

import cn.jx.jjvu.news.config.SpringConfig;
import cn.jx.jjvu.news.domain.Sys_User;
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
public class UserDaoTest extends TestCase {
    @Autowired
    private UserDao userDao;
    @Test
    public void testFindAllUser() {
        List<Sys_User> sys_users = userDao.findAllUser();
        System.out.println(sys_users);
    }
     @Test
    public void testAddUser (){
       UserPojo user = new UserPojo();
       user.setUsername("admin");
       user.setPassword("123456");
        user.setStatus("1");
         user.setRoles(Arrays.asList(1,2));
          userDao.addUser(user);
           System.out.println("addUser is ok");
     }
}