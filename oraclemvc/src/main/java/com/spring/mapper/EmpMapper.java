package com.spring.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.domain.EmpDTO;

@Mapper
public interface EmpMapper {
	
	public int totalCount(HashMap<String, Object> o);
	public List<EmpDTO> emplist(HashMap<String, Object> o);
	public EmpDTO empinfo(int empno);

}
