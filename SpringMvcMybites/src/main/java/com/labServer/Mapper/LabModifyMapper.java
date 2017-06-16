package com.labServer.Mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.ComponentScan;

import com.labServer.Model.LabModify;
@ComponentScan
@Mapper
public interface LabModifyMapper {

	/**
	 * 通过原探头名找到探头校正实例
	 * 
	 * @param inputProbreNumber
	 * @return
	 */
	@Select("select * from lab_modify where INPUTPROBENUMBER =#{inputProbeNumber} and STATUS = 'Y' ")
	List<LabModify> getLabModifyByInputProbNum(String inputProbeNumber);

	@Select("select * from lab_modify where STATUS = 'Y' ")
	List<LabModify> getSumLabModify();

}
