package com.labServer.Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labServer.Mapper.LabModifyMapper;
import com.labServer.Model.LabModify;

@Service
public class LabModifyManagerImpl implements LabModifyManager {
  @Autowired
  LabModifyMapper labModifyMapper;

  @Override
  public List<LabModify> findAllLabModify() {


    return labModifyMapper.getSumLabModify();
  }

}
