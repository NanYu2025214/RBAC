package cn.jx.jjvu.news.web.controller;

import cn.jx.jjvu.news.domain.ResponseResult;
import cn.jx.jjvu.news.domain.Sys_Permission;
import cn.jx.jjvu.news.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:81")
@RequestMapping("/permissioncontroller")
public class PermissionController {
    @Autowired
    private PermissionService  permissionService;
    @RequestMapping("/findAllPermission")
    public ResponseResult findAllPermission(@RequestParam(defaultValue = "1") int currentpage, @RequestParam(defaultValue = "5") int pagesize){
        ResponseResult result = new ResponseResult();
        PageInfo<Sys_Permission> permissions = permissionService.findAllPermission(currentpage,pagesize);
        result.setCode(200);
        result.setMsg("加载成功");
        result.setCount(permissions.getTotal());  //总记录数
        result.setData(permissions.getList());  //每一页的记录
        return result;
    }
    @RequestMapping("/addPermission")
    public ResponseResult addPermission(@RequestBody Sys_Permission permission){
        ResponseResult result = new ResponseResult();
        permissionService.addPermission(permission);
        result.setCode(200);
        return result;
    }
    @RequestMapping("/updatePermission")
    public ResponseResult updatePermission(@RequestBody Sys_Permission permission){
        ResponseResult result = new ResponseResult();
        permissionService.updatePermission(permission);
        result.setCode(200);
        System.out.println("修改成功");
        return result;
    }
    @RequestMapping("/deletePermission")
    public ResponseResult deletePermission(@RequestBody int id){
        ResponseResult result = new ResponseResult();
        permissionService.deletePermission(id);
        result.setCode(200);
        return result;
    }
}
