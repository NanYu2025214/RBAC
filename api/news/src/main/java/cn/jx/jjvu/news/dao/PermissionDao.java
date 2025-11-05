package cn.jx.jjvu.news.dao;

import cn.jx.jjvu.news.domain.Sys_Permission;
import cn.jx.jjvu.news.domain.Sys_Role_Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PermissionDao {
    @Select("select * from sys_permission where permission_id in (select pid from sys_role_permission where rid=#{role_id})")
    List<Sys_Permission> findPermissionByRoleId(Integer role_id);
    @Select("select * from sys_permission")
    List<Sys_Permission> findAllPermission();
    @Insert("insert into sys_role_permission(rid,pid) values(#{rid},#{pid})")
    void addRoleAndPermission(Sys_Role_Permission sysRolePermission);
    @Delete("delete from sys_role_permission where rid=#{roleId}")
    void delRoleAndPermission(int roleId);
    @Insert("insert into sys_permission(description,url,remark) values(#{description},#{url},#{remark})")
    void addPermission(Sys_Permission permission);
    @Update("update sys_permission set description=#{description},url=#{url},remark=#{remark} where permission_id=#{permission_id}")
    void updatePermission(Sys_Permission permission);
    @Delete("delete from sys_permission where permission_id=#{id}")
    void deletePermission(int id);
    @Select("select count(*) from sys_permission")
    int findCount();
}
