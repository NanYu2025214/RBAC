package cn.jx.jjvu.news.dao;

import cn.jx.jjvu.news.domain.Rolepojo;
import cn.jx.jjvu.news.domain.Sys_Role;
import cn.jx.jjvu.news.domain.Sys_User_Roles;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RolesDao {
    @Select("select * from roles where role_id in (select rid from sys_user_role where uid=#{uid})")
     List<Sys_Role> findRolesById(int uid);
    @Select("select * from roles")
    List<Sys_Role> findAllRoles();
    @Select("select * from roles")
    @Results({
            @Result(id = true, property = "role_id", column = "role_id"),
            @Result(property = "permissions", column = "role_id", many = @Many(select = "cn.jx.jjvu.news.dao.PermissionDao.findPermissionByRoleId"))
    })
    List<Rolepojo> findAllRoles1();
    @Insert( "insert into sys_user_role(uid,rid) values(#{uid},#{rid})")
    void addUserAndRoles(Sys_User_Roles sysUserRoles);
    @Delete( "delete from sys_user_role where uid=#{id}")
    void delUserAndRoles(int id);
    @Insert(  "insert into roles(remark,role_name) values(#{remark},#{role_name})")
    @Options(useGeneratedKeys = true,keyProperty = "role_id",keyColumn = "role_id")
    void addRole(Rolepojo role);
    @Update(  "update roles set remark=#{remark},role_name=#{role_name} where role_id=#{role_id}")
    @Options(useGeneratedKeys = true,keyProperty = "role_id",keyColumn = "role_id")
    void updateRole(Rolepojo role);
    @Delete(  "delete from roles where role_id= #{roleId}")
    void delRole(int roleId);
    @Select("select count(*) from roles")
    int findCount();
}
