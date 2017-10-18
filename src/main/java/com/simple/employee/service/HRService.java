package com.simple.employee.service;

import java.util.List;

import com.simple.employee.vo.Criteria;
import com.simple.employee.vo.Employee;

public interface HRService {

	 List<Employee> getSelectiveEmployees(Criteria criteria);
}
