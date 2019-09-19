package com.spring.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.EmpDTO;
import com.spring.domain.MakePage;
import com.spring.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@RequestMapping("/list")
	public String list(@RequestParam(required=false, defaultValue="1") int currPage, @RequestParam(required=false, defaultValue="") String search, @RequestParam(required=false, defaultValue="") String searchtxt, Model model) {
		
		Pattern p=Pattern.compile("([0-9]*$)");
		
		if(search=="employee_id"|| search.equals("employee_id")||search=="department_id"||search.equals("department_id")) {
			Matcher m=p.matcher(searchtxt);
			if(!m.find()) {
				model.addAttribute("searchtxt",searchtxt);
			}else {
				searchtxt="";
				model.addAttribute("searchtxt","");
				
			}
		}
		
		int totalCount=service.totalCount(search, searchtxt);
		int pageSize=10;
		int blockSize=5;
		
		MakePage page=new MakePage(currPage, totalCount, pageSize, blockSize);
		List<EmpDTO> emplist=service.list(search, searchtxt, page.getStartRow(), page.getEndRow());
		
		model.addAttribute("list", emplist);
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("searchtxt", searchtxt);
		
		return "list";
	}
	
	@RequestMapping("/{empno}")
	public String info(int empno) {
		
		service.empinfo(empno);
		
		return "info";
	}

}
