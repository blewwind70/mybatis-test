package com.simple.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.employee.dao.EmployeeDao;
import com.simple.employee.vo.Criteria;
import com.simple.employee.vo.Employee;

@Service
public class HRServiceImpl implements HRService {

	@Autowired
	private EmployeeDao empDao;
	
	public List<Employee> getSelectiveEmployees(Criteria criteria) {
		if(criteria == null) {
			throw new IllegalArgumentException("Criteria는 null값이 들어갈 수 없습니다.");
		}
		
		String opt = criteria.getOpt();
		List<Integer> depts = criteria.getDepts();
		List<String> jobs = criteria.getJobs();
		Double minSalary = criteria.getMinSalary();
		Double maxSalary = criteria.getMaxSalary();
		String beginDate = criteria.getBeginDate();
		String endDate = criteria.getEndDate();
		
		if(opt == null && (depts != null || jobs != null || minSalary != null || 
						minSalary != null || maxSalary != null || beginDate != null || 
						endDate != null)) {
				throw new IllegalArgumentException("Option값 없이 다른 검색은 할 수 없습니다.");
		}
		
		return empDao.getEmployees(criteria);
	}

}
