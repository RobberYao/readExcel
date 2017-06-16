package com.labServer.Controller;

import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@ComponentScan
@RequestMapping
public class WelcomeController {

  @RequestMapping
  public String welcomePage(Map<String, Object> map) {
    return "user";
  }
  
  
  
  
  

}
