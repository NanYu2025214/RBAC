package cn.jx.jjvu.news.service.impl;

import cn.jx.jjvu.news.dao.PermissionDao;
import cn.jx.jjvu.news.dao.RolesDao;
import cn.jx.jjvu.news.domain.*;
import cn.jx.jjvu.news.service.RolesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("rolesService")
public class RolesServiceImpl implements RolesService {
    @Autowired
    RolesDao rolesDao;
    @Autowired
    PermissionDao permissionDao;
    @Override
    public List<Sys_Role> findAllRoles() {
        List<Sys_Role> roles = rolesDao.findAllRoles();
        return roles;
    }

    @Override
    public PageInfo<Rolepojo> findAllRoles1(int currentpage, int pagesize) {
        PageHelper.startPage(currentpage,pagesize);
        List<Rolepojo> roles = rolesDao.findAllRoles1();
        for (Rolepojo role : roles) {
            if (role.getPermissions() instanceof List<?>) {  //检查当前角色的 permissions 是否是 List 类型，防止空指针或者类型不匹配
                //创建一个新的 List 来存储权限的 ID
                List<Integer> permissionIds = new ArrayList<>();
                // 遍历 permissions，将每个权限的 ID 添加到新的 List 中
                for (Object obj : (List<?>) role.getPermissions()) {
                    // 检查 obj 是否是 Sys_Permission 类型，如果是，则将权限的 ID 添加到新的 List 中
                    //如果是 Sys_Permission 对象，就调用它的 getPermissionId() 方法获取 ID；
                    if (obj instanceof Sys_Permission) {
                        permissionIds.add(((Sys_Permission) obj).getPermission_id());
                    } else if (obj instanceof Integer) { //如果已经是 Integer 类型，就直接加入新列表；
                        permissionIds.add((Integer) obj);
                    }
                }
                //把原来的 List<Sys_Permission> 替换成 List<Integer>；
                role.setPermissions(permissionIds);
            }
        }

        return new PageInfo<>(roles);
    }

    @Override
    public void addRole(Rolepojo role) {
       rolesDao.addRole(role);
       List<Integer> permissions = role.getPermissions();
       for (int i = 0; i < permissions.size(); i++){
           Sys_Role_Permission sys_role_permission = new Sys_Role_Permission();
           sys_role_permission.setRid(role.getRole_id());
           sys_role_permission.setPid((Integer) permissions.get(i));
           permissionDao.addRoleAndPermission(sys_role_permission);
       }
    }

    @Override
    public void updateRole(Rolepojo role) {
       rolesDao.updateRole(role);
       permissionDao.delRoleAndPermission(role.getRole_id());
       List<Integer> permissions = role.getPermissions();
       for (int i = 0; i < permissions.size(); i++){
           Sys_Role_Permission sys_role_permission = new Sys_Role_Permission();
           sys_role_permission.setRid(role.getRole_id());
           sys_role_permission.setPid(permissions.get(i));
           permissionDao.addRoleAndPermission(sys_role_permission);
       }
    }

    @Override
    public void delRole(int roleId) {
        permissionDao.delRoleAndPermission(roleId);
        rolesDao.delRole(roleId);
    }
}
