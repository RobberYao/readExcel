package com.labServer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.labServer.Mapper.LabModifyMapper;
import com.labServer.Model.LabModify;
@ComponentScan
@Controller
@RequestMapping({"/modify"})
public class LabModifyController {

  @Autowired
  LabModifyMapper labModifyMapper;





}
