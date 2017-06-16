package com.labServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class SpringMvcMybitesApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringMvcMybitesApplication.class, args);
  }

  /**
   * 主页
   * 
   * @return
   */
  @RequestMapping("/")
  public String getWelcomePage() {
    
    return "welcome";

  }


}

