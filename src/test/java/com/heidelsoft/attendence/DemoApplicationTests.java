package com.heidelsoft.attendence;
import java.util.List;

/**
 * Test class for the Employee Register API
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.heidelsoft.attendance.exception.RecordNotFoundException;
import com.heidelsoft.attendance.model.EmployeeEntity;
import com.heidelsoft.attendance.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	EmployeeService service;
	
	/**
	 * Test for creating a new employee. New employee will get the employee id after execution
	 */
	@Test
	public void addEmployee() {
		EmployeeEntity employee = new EmployeeEntity();
		employee.setEmpAddr("Addr1");
		employee.setEmpFirstName("FN");
		employee.setEmpLastName("LN");
		employee = service.createOrUpdateEmployee(employee);
		Assert.assertTrue(employee.getEmpId()!=null);
		
	}
	
	@Test
	public void updateEmployee() {
		EmployeeEntity employee = new EmployeeEntity();
		employee.setEmpAddr("Addr1");
		employee.setEmpFirstName("FN");
		employee.setEmpLastName("LN");
		employee = service.createOrUpdateEmployee(employee);
		employee.setEmpFirstName("FN1");
		employee = service.createOrUpdateEmployee(employee);
		Assert.assertTrue(employee.getEmpFirstName().equalsIgnoreCase("FN1"));
		
	}
	
	//Getting all employees test. Since we insert two employees at the starting the count will be 2
	@Test
	public void getAllEmployees() {
		List<EmployeeEntity>empList = service.getAllEmployees();
		Assert.assertTrue(empList.size()==2);
	}
	//Getting all employees test. Since we insert two employees at the starting the count will be 2
	@Test
	public void getEmployeeById() throws RecordNotFoundException {
		EmployeeEntity emp = service.getEmployeeById(1l);
		Assert.assertTrue(emp.getEmpFirstName().equalsIgnoreCase("Lokesh"));
	}
	//Getting all employees test. Since we insert two employees at the starting the count will be 2
	@Test
	public void puchEmployee() throws RecordNotFoundException {
		List<EmployeeEntity>empList = service.getAllEmployees();
		service.puchEmployee(empList.get(0).getEmpId());
		empList = service.getAllEmployees();
		Assert.assertTrue(empList.get(0).getEmpPunchLogs().size()==1);
	}

}
