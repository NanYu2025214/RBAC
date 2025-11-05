package cn.jx.jjvu.news.service.impl;

import cn.jx.jjvu.news.dao.RolesDao;
import cn.jx.jjvu.news.dao.ScoreDao;
import cn.jx.jjvu.news.dao.UserDao;
import cn.jx.jjvu.news.domain.Sys_User;
import cn.jx.jjvu.news.domain.Sys_User_Roles;
import cn.jx.jjvu.news.domain.UserPojo;
import cn.jx.jjvu.news.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
     @Autowired
      private RolesDao rolesDao;
     @Autowired
      private ScoreDao scoreDao;



    @Override
    public String findUserByUserName(Sys_User user) {
       Sys_User sys_user=userDao.findUserByUserName(user.getUsername());
       String message = null;
       if(sys_user==null){
           message="账号错误！";
       }else {
           if (user.getPassword().equals(sys_user.getPassword())){
               if (sys_user.getStatus().equals("0")){
                   message="账号已禁用！";
               }
           }else{
               message="密码错误！";
           }
       }
        return message;
    }

    @Override
    public PageInfo<Sys_User> findAllUser(int currentpage,int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        List<Sys_User> users = userDao.findAllUser();
        return new PageInfo<>(users);
    }
    public List<Sys_User> findAllUser1() {
        List<Sys_User> users = userDao.findAllUser();
        return users;
    }

    @Override
    @Transactional
    public void addUser(UserPojo user) {
        userDao.addUser(user);
        List  roles = user.getRoles();
        for (int i = 0; i <roles.size() ; i++) {
            Sys_User_Roles sys_user_roles = new Sys_User_Roles();
            sys_user_roles.setUid(user.getId());
             sys_user_roles.setRid(Integer.parseInt(roles.get(i).toString()));
             rolesDao.addUserAndRoles (sys_user_roles);
        }

    }

    @Override
    public void delUser(int id) {
        userDao.delUser(id);
         rolesDao.delUserAndRoles(id);
         scoreDao.delScore(id);
    }

    @Override
    public void updateUser(UserPojo user) {
        userDao.updateUser(user);
        scoreDao.updateScore1(user);
         rolesDao.delUserAndRoles(user.getId());
         List <Integer> roles = user.getRoles();
          for (int i = 0; i < roles.size(); i++) {
               Sys_User_Roles sys_user_roles = new Sys_User_Roles();
                sys_user_roles.setUid(user.getId());
                sys_user_roles.setRid(roles.get(i));
                 rolesDao.addUserAndRoles(sys_user_roles);
          }
    }
}
