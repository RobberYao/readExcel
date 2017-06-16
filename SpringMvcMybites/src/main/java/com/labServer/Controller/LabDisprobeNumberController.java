package com.labServer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.labServer.Manager.LabDisprobeNumberManager;
import com.labServer.Model.LabDisprobeNumber;
import com.labServer.Model.User;
@ComponentScan
@Controller
@RequestMapping("/disprobe")
public class LabDisprobeNumberController {
  @Autowired
  LabDisprobeNumberManager labDisprobeNumberManager;

  /**
   * 总入口
   * 
   * @return
   */
  @RequestMapping
  public String intoDisprobeNumber() {
    return "disprobeNumber";
  }


  @RequestMapping(value = "/query", method = RequestMethod.POST)
  public ModelAndView queryUser(String name) {
    List<LabDisprobeNumber> listOfProbe = labDisprobeNumberManager.findAllLabDisprobeNumber();

    ModelAndView mv = new ModelAndView();
    mv.addObject("labDisprobelist", listOfProbe);
    mv.setViewName("disprobeNumber");
    return mv;
  }



}
