package com.labServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.labServer.Manager.UserManager;
import com.labServer.Mapper.UserMapper;
import com.labServer.Model.User;
import com.mysql.fabric.xmlrpc.base.Array;
@ComponentScan
@Controller
@RequestMapping({"/user"})
public class UserController {

  private static final Logger log = LoggerFactory.getLogger(UserController.class);

  @Autowired
  UserManager userManager;

  /**
   * 总入口
   * 
   * @return
   */
  @RequestMapping
  public String addUserGET() {
    return "user";
  }

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello(Model model) {
    model.addAttribute("name", "Dear");
    return "hello";
  }

  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public ModelAndView addUser(String name, int age) {
    userManager.addUser(name, age);
    User user = new User();
    user.setName(name);
    user.setAge(age);
    ModelAndView mv = new ModelAndView();
    mv.addObject("MSG", user.toString());
    mv.setViewName("user");
    return mv;
  }

  @RequestMapping(value = "delUser", method = RequestMethod.POST)
  public ModelAndView delUser(String name) {
    userManager.delUser(name);
    ModelAndView mv = new ModelAndView();
    mv.addObject("MSG", name);
    mv.setViewName("user");
    return mv;

  }

  @RequestMapping(value = "updateUser", method = RequestMethod.POST)
  public ModelAndView updateUser(String name, int age) {
    userManager.updateUser(name, age);
    User user = new User();
    user.setName(name);
    user.setAge(age);
    ModelAndView mv = new ModelAndView();
    mv.addObject("MSG", user.toString());
    mv.setViewName("user");
    return mv;
  }

  @RequestMapping(value = "queryUser", method = RequestMethod.POST)
  public ModelAndView queryUser(String name) {
    List<User> userList = userManager.queryUserByName(name);
    System.out.println("UserListSize  :" + userList.size());
    ModelAndView mv = new ModelAndView();
    mv.addObject("userList", userList);
    mv.setViewName("user");
    return mv;
  }



}
