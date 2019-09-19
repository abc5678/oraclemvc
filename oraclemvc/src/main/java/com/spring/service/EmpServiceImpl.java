package com.spring.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.EmpDTO;
import com.spring.mapper.EmpMapper;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpMapper mapper;

	@Override
	public EmpDTO empinfo(int empno) {
		return mapper.empinfo(empno);
	}

	@Override
	public List<EmpDTO> list(String search, String searchtxt, int startRow, int endRow) {
		HashMap<String, Object> object=new HashMap<>();
		object.put("search", search);
		object.put("searchtxt", searchtxt);
		object.put("startRow", startRow);
		object.put("endRow", endRow);
		return mapper.emplist(object);
	}

	@Override
	public int totalCount(String search, String searchtxt) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("search", search);
		map.put("searchtxt", searchtxt);
		return mapper.totalCount(map); 
	}
	

}
