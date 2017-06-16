package com.labServer.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.ComponentScan;

import com.labServer.Model.LabDisprobeNumber;
@ComponentScan
@Mapper
public interface LabDisprobeNumberMapper {

  // http://blog.csdn.net/a352193394/article/details/39940259
  /**
   * 通过原探头号查找对应探头映射表实力
   * 
   * @param inputProbeNumber
   * @return
   */
  @Select("select * from lab_disprobenumber where INPUTPROBENUMBER = #{inputProbeNumber}")
  LabDisprobeNumber getDisprobeNumberByInputProbNum(String inputProbeNumber);

  /**
   * 通过原探头号查找对应探头映射表实力
   * 
   * @param inputProbeNumber
   * @return
   */
  @Select("select * from lab_disprobenumber")
  List<LabDisprobeNumber> getSumDisprobeNumber();

}
