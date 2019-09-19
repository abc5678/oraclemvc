package com.spring.service;

import java.util.List;

import com.spring.domain.EmpDTO;

public interface EmpService {
	
	public List<EmpDTO> list(String search, String searchtxt, int startRow, int endRow);
	public EmpDTO empinfo(int empno);
	public int totalCount(String search, String searchtxt);

}
