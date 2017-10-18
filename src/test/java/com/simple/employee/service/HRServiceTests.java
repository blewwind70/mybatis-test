package com.simple.employee.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.employee.vo.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/app-context.xml")
public class HRServiceTests {

	@Autowired
	HRService hrService;
	
	@Test
	public void testGetEmployees() {
		String opt1 = "name";
		String keyword1 = "H";
		String opt2 = "phone";
		String keyword2 = "515";
		
		List<Integer> depts = Arrays.asList(10, 30, 50);
		List<String> jobs = Arrays.asList("AD_PRES", "SA_REP", "IT_PROG");
		Double minSalary = Double.parseDouble("3000");
		Double maxSalary = Double.parseDouble("10000");
		String beginDate = "2006-02-07";
		String endDate = "2007-03-07";
		
		Criteria criteria = new Criteria();
		criteria.setOpt(opt2);
		criteria.setKeyword(keyword2);
		criteria.setDepts(depts);
		//criteria.setJobs(jobs);
		criteria.setMinSalary(minSalary);
		criteria.setMaxSalary(maxSalary);
		criteria.setBeginDate(beginDate);
		criteria.setEndDate(endDate);
		
		Assert.assertEquals(1, hrService.getSelectiveEmployees(criteria).size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalException() {
		Criteria criteria = new Criteria();
		criteria.setMaxSalary(Double.parseDouble("3000"));
		
		hrService.getSelectiveEmployees(criteria);
	}
}
