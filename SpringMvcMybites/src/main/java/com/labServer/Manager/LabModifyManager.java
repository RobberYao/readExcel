package com.labServer.Manager;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.labServer.Model.LabDisprobeNumber;
import com.labServer.Model.LabModify;

@ComponentScan
public interface LabModifyManager {
  
  List<LabModify> findAllLabModify();
}
