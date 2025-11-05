package cn.jx.jjvu.news.dao;

import cn.jx.jjvu.news.domain.Score;
import cn.jx.jjvu.news.domain.Sys_User;
import cn.jx.jjvu.news.domain.UserPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("select * from sys_user where username=#{username}")
    Sys_User findUserByUserName(String username);
    @Select("select * from sys_user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
           @Result(property = "roles", column = "id", many = @Many(select = "cn.jx.jjvu.news.dao.RolesDao.findRolesById"))
    })
    List<Sys_User> findAllUser();
    @Insert("insert into sys_user(username,password,status) values(#{username},#{password},#{status})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void addUser(UserPojo user);
    @Delete("delete from sys_user where id=#{id}")
    void delUser(int id);
    @Update("update sys_user set username=#{username},password=#{password},status=#{status} where id=#{id}")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void updateUser(UserPojo user);
    @Insert("insert into sys_user(username,password,status) values(#{username},#{password},#{status})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void addUser1(Sys_User user);
    @Update("update sys_user set username=#{name} where id=#{sid}")
    void updateUser1(Score score);
//    查找所有用户数量
    @Select("select count(*) from sys_user")
    int findCount();
}
