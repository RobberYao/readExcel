package com.labServer.Manager;

import java.util.List;

import com.labServer.Model.User;


public interface UserManager {

  public List<User> queryUserByName(String name);

  public void addUser(String name, int age);

  public void delUser(String name);
  
  public void updateUser(String name,int age);

}
