package cn.jx.jjvu.news.dao;

import cn.jx.jjvu.news.domain.Score;
import cn.jx.jjvu.news.domain.Sys_User;
import cn.jx.jjvu.news.domain.UserPojo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ScoreDao {
    @Insert( "insert into scores(sid,name,chinese,math,english,total) values(#{id},#{username},0,0,0,0)")
    void addInitScore(Sys_User user);
    @Select("select * from scores")
    List<Score> findAllScore();
    @Select("SELECT COUNT(*) FROM scores WHERE sid = #{sid}")
    int countBySid(int sid);
    @Update("update scores set name=#{name},chinese=#{chinese},math=#{math},english=#{english},total=#{total} where sid=#{sid}")
    void updateScore(Score score);
    @Delete("delete from scores where sid=#{id}")
    void delScore(int id);
    @Insert("insert into scores(sid,name,chinese,math,english,total) values(#{id},#{username},0,0,0,0)")
    void addScore(Sys_User user);
    @Update("update scores set name= #{username} where sid= #{id}")
    void updateScore1(UserPojo user);
}
