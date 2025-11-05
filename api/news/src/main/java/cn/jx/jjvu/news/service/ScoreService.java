package cn.jx.jjvu.news.service;

import cn.jx.jjvu.news.domain.Score;
import cn.jx.jjvu.news.domain.Sys_User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ScoreService {
    void addInitScore(List<Sys_User> users);
    PageInfo<Score> findAllScore(int currentpage, int pagesize);

    void updateScore(Score score);

    void delScore(int id);

    void addScore(Score score);
}
