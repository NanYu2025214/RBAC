package cn.jx.jjvu.news.web.controller;

import cn.jx.jjvu.news.domain.Dashboard;
import cn.jx.jjvu.news.domain.ResponseResult;
import cn.jx.jjvu.news.service.DashService;
import cn.jx.jjvu.news.utils.JwtUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:81")
@RequestMapping("/dashcontroller")
public class DashController {
    @Autowired
    private DashService dashService;
    @RequestMapping("/findAll")
    public ResponseResult findAll(){
        ResponseResult  result = new ResponseResult();
        Dashboard dashboard = dashService.findAll();
        result.setCode(200);
        result.setMsg("加载成功");
        result.setData(dashboard);
        return result;
    }
    @RequestMapping("/getUser")
    public ResponseResult getUser(@RequestHeader("Authorization") String token){
        ResponseResult  result = new ResponseResult();
//        存储token
        String tokenValue = token.replace("Bearer ", "");
        result.setCode(200);
        result.setMsg("加载成功");
        result.setData(tokenValue);
        return result;
    }

}
