package cn.jx.jjvu.news.web.controller;

import cn.jx.jjvu.news.domain.ResponseResult;
import cn.jx.jjvu.news.domain.Rolepojo;
import cn.jx.jjvu.news.domain.Sys_Role;
import cn.jx.jjvu.news.service.RolesService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rolescontroller")
@CrossOrigin(origins = "http://localhost:81")
public class RolesController {
    @Autowired
    RolesService rolesService;
    @RequestMapping("/findAllRoles")
    public ResponseResult findAllRoles(){
        ResponseResult result = new ResponseResult();
        List<Sys_Role> roles =rolesService.findAllRoles();
        result.setCode(200);
        result.setMsg("加载成功");
        result.setData(roles);
        return result;
    }
    @RequestMapping("/findAllRoles1")
    public ResponseResult findAllRoles1(@RequestParam(defaultValue = "1") int currentpage, @RequestParam(defaultValue = "5") int pagesize){
        ResponseResult result = new ResponseResult();
        PageInfo<Rolepojo> roles =rolesService.findAllRoles1(currentpage,pagesize);
        result.setCode(200);
        result.setCount(roles.getTotal());  //记录总数
        result.setData(roles.getList()); //每一页的记录
        result.setMsg("加载成功");
        return result;
    }
    @RequestMapping("/addRole")
    public ResponseResult addRole(@RequestBody Rolepojo role){
        ResponseResult result = new ResponseResult();
        rolesService.addRole(role);
            result.setCode(200);
            result.setMsg("添加成功");
        return result;
    }
    @RequestMapping("/updateRole")
    public ResponseResult updateRole(@RequestBody Rolepojo role){
        ResponseResult result = new ResponseResult();
        rolesService.updateRole(role);
        result.setCode(200);
        result.setMsg("修改成功");
        return result;
    }
    @RequestMapping("/delRole")
    public ResponseResult delRole(@RequestBody int roleId){
        ResponseResult result = new ResponseResult();
        rolesService.delRole(roleId);
        result.setCode(200);
        result.setMsg("修改成功");
        return result;
    }
}
