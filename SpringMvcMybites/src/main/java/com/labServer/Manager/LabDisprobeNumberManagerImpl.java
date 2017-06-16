package com.labServer.Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.labServer.Mapper.LabDisprobeNumberMapper;
import com.labServer.Model.LabDisprobeNumber;
@ComponentScan
@Service
public class LabDisprobeNumberManagerImpl implements LabDisprobeNumberManager {

  @Autowired
  LabDisprobeNumberMapper labDisprobeNumberMapper;

  /**
   * 查询所有探头映射信息
   *
   * findAllLabDisprobeNumber
   * 
   * @see com.labServer.Manager.LabDisprobeNumberManager#findAllLabDisprobeNumber()
   *
   */
  @Override
  public List<LabDisprobeNumber> findAllLabDisprobeNumber() {
    return labDisprobeNumberMapper.getSumDisprobeNumber();
  }

}
