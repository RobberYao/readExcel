package com.labServer.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.ComponentScan;

import com.labServer.Model.User;
@ComponentScan
@Mapper
public interface UserMapper {

  @Select("select * from user where name = #{name}")
  List<User> findUserByName(@Param("name") String name);

  @Select("select * from user")
  User findAllUser();

  @Insert("insert into user (name ,age) values(#{name},#{age}) ")
  void addUser(User user);

  @Delete("delete from user where name =#{name} ")
  void delUser(String name);

  @Update("Update user set name =#{name} ,age=#{age} where name=#{name}")
  void updateUser(User user);



}
