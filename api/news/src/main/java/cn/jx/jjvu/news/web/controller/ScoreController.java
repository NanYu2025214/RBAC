package cn.jx.jjvu.news.web.controller;

import cn.jx.jjvu.news.domain.ResponseResult;
import cn.jx.jjvu.news.domain.Score;
import cn.jx.jjvu.news.domain.Sys_User;
import cn.jx.jjvu.news.service.ScoreService;
import cn.jx.jjvu.news.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:81")
@RequestMapping("/scorecontroller")
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @Autowired
    UserService userService;
    @RequestMapping("/findAllScore")
    public ResponseResult findAllScore(@RequestParam(defaultValue = "1") int currentpage, @RequestParam(defaultValue = "5") int pagesize){
        List<Sys_User> users = userService.findAllUser1();
        scoreService.addInitScore(users);
        PageInfo<Score> scores = scoreService.findAllScore(currentpage,pagesize);
        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setMsg("加载成功");
        result.setCount(scores.getTotal());
        result.setData(scores.getList());
        return result;
    }
    @RequestMapping("/updateScore")
    public ResponseResult updateScore(@RequestBody Score score){
        scoreService.updateScore(score);
        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setMsg("修改成功");
        return result;
    }
    @RequestMapping("/delScore")
    public ResponseResult delScore(@RequestBody int id){
        ResponseResult result = new ResponseResult();
        scoreService.delScore(id);
        result.setCode(200);
        result.setMsg("删除成功");
        return result;
    }
    @RequestMapping("/addScore")
    public ResponseResult addScore(@RequestBody Score score){

        ResponseResult result = new ResponseResult();
        scoreService.addScore(score);
        result.setCode(200);
        result.setMsg("添加成功");
        return result;
    }
}
