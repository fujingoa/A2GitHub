package com.fja.dao;

import com.fja.po.User;
import org.apache.ibatis.annotations.*;

import javax.naming.Name;
import java.util.List;

/**
 * @author ${fujingao}
 * @create 2020-10-01-8:52
 */
public interface UserDao {

    //查询全部
    @Select("select * from user")
    @Results(id="userResult",value = {
            @Result(id = true,property = "idd",column = "id"),
            @Result(property = "name",column = "name")
    })
    List<User> selectAll();
    //根据id查询
    @Select("select * from user where id=#{id}")
    @ResultMap("userResult")
    User selectOne(int id);

    @Insert("insert into user(name) values(#{name})")
    int insert(User user);
    @Update("update user set name=#{name} where id=#{id}")
    int update(User user);
    @Delete("delete from user where id=#{id}")
    int delete(int id);
}
