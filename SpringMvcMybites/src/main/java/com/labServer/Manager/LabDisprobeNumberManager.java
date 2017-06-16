package com.labServer.Manager;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.labServer.Model.LabDisprobeNumber;
@ComponentScan
public interface LabDisprobeNumberManager {

  List<LabDisprobeNumber> findAllLabDisprobeNumber();
  
}
