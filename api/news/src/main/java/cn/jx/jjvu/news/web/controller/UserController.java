package cn.jx.jjvu.news.web.controller;

import cn.jx.jjvu.news.domain.ResponseResult;
import cn.jx.jjvu.news.domain.Sys_User;
import cn.jx.jjvu.news.domain.UserPojo;
import cn.jx.jjvu.news.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:81")
@RestController
@RequestMapping("/usercontroller")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/findAllUser")
    public ResponseResult findAllUser(@RequestParam(defaultValue = "1") int currentpage,@RequestParam(defaultValue = "10") int pagesize){
        ResponseResult result = new ResponseResult();
        PageInfo<Sys_User> users = userService.findAllUser(currentpage,pagesize);
        result.setCount(users.getTotal());  //记录总数
        result.setCode(200);
        result.setData(users.getList());  //每一页的记录
        return result;
    }
    @PostMapping("/addUser")
     public ResponseResult addUser(@RequestBody UserPojo user){
        ResponseResult result = new ResponseResult();
         userService.addUser(user);
            result.setCode(200);
            result.setMsg("添加成功");
        return result;
    }
    @PostMapping("/delUser")
    public ResponseResult delUser(@RequestBody int id){
        ResponseResult result = new ResponseResult();
        userService.delUser(id);
        result.setCode(200);
        result.setMsg("删除成功");
        return result;
    }
    @PostMapping("/updateUser")
     public ResponseResult updateUser(@RequestBody UserPojo user){
        ResponseResult result = new ResponseResult();
        userService.updateUser(user);
        result.setCode(200);
        result.setMsg("修改成功");
        return result;
    }
}
