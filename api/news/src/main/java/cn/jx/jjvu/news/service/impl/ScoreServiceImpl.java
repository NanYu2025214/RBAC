package cn.jx.jjvu.news.service.impl;

import cn.jx.jjvu.news.dao.RolesDao;
import cn.jx.jjvu.news.dao.ScoreDao;
import cn.jx.jjvu.news.dao.UserDao;
import cn.jx.jjvu.news.domain.Score;
import cn.jx.jjvu.news.domain.Sys_Role;
import cn.jx.jjvu.news.domain.Sys_User;
import cn.jx.jjvu.news.domain.Sys_User_Roles;
import cn.jx.jjvu.news.service.ScoreService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreDao scoreDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RolesDao roleDao;

//    添加初始成绩
    @Override
    public void addInitScore(List<Sys_User> users) {
//        循环遍历所有用户
        for (Sys_User user : users) {
//            获取用户角色
            List<Sys_Role> roles =user.getRoles();
            for (Sys_Role role : roles) {
//                如果角色为学生就添加初始成绩
                if (role.getRole_id() == 2) {
                    if (scoreDao.countBySid(user.getId())==0){
                        scoreDao.addInitScore(user);
                    }
                    break;
                }
            }

        }
    }

    @Override
    public PageInfo<Score> findAllScore(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage, pagesize);
        List<Score> scores = scoreDao.findAllScore();
        return new PageInfo<>(scores);
    }

    @Override
    public void updateScore(Score score) {
        userDao.updateUser1(score);
        scoreDao.updateScore(score);
    }

    @Override
    public void delScore(int id) {
        scoreDao.delScore(id);
        userDao.delUser(id);
        roleDao.delUserAndRoles(id);
    }

    @Override
    public void addScore(Score score) {
        Sys_User user = new Sys_User();
        user.setUsername(score.getName());
        user.setPassword("123456");
        user.setStatus("1");
        List<Sys_Role> roles = new ArrayList<>();
        Sys_User_Roles  sys_user_roles = new Sys_User_Roles();
        roles.add(score.getRole());
        user.setRoles(roles);
        userDao.addUser1(user);
        sys_user_roles.setUid(user.getId());
        sys_user_roles.setRid(score.getRole().getRole_id());
        roleDao.addUserAndRoles(sys_user_roles);
        scoreDao.addScore(user);
    }
}
