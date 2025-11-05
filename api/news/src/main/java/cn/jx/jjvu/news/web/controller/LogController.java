package cn.jx.jjvu.news.web.controller;

import cn.jx.jjvu.news.domain.ResponseResult;
import cn.jx.jjvu.news.domain.Sys_User;
import cn.jx.jjvu.news.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@CrossOrigin(origins = "http://localhost:81")
@RestController
@RequestMapping("/logcontroller")
public class LogController {

    @Autowired
    private UserService  userService;
    @RequestMapping ("/login")
    public ResponseResult login(@RequestBody Sys_User user) {
        ResponseResult result = new ResponseResult();
        String message = userService.findUserByUserName(user);
        if (message==null){
           String token= Jwts.builder()
                    .setSubject(user.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime()+1000*60*60*24))
                    .signWith(SignatureAlgorithm.HS256,"asfecvdicgvanldfiesaldkjfjeisasdfkesadfesadfesadfas")
                    .compact();
           result.setData(token);
            result.setCode(200);
            result.setMsg("登录成功！");
        }
        return result;
    }

}
