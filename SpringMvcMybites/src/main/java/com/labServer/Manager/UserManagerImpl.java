package com.labServer.Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labServer.Mapper.UserMapper;
import com.labServer.Model.User;

@Service
public class UserManagerImpl implements UserManager {
  @Autowired
  UserMapper userMapper;

  @Override
  public List<User> queryUserByName(String name) {
    return userMapper.findUserByName(name);
  }

  @Override
  public void addUser(String name, int age) {
    User user = new User();
    user.setName(name);
    user.setAge(age);
    userMapper.addUser(user);
    System.out.println("add");
  }

  @Override
  public void delUser(String name) {
    userMapper.delUser(name);
  }

  @Override
  public void updateUser(String name, int age) {
    User user=new User();
    user.setName(name);
    user.setAge(age);
    userMapper.updateUser(user);
    
    
    
  }



}
