package com.simple.employee.dao;

import java.util.List;

import com.simple.employee.vo.Criteria;
import com.simple.employee.vo.Employee;

public interface EmployeeDao {

	List<Employee> getEmployees(Criteria criteria);
}
