package com.heidelsoft.attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.heidelsoft.attendance.model.EmpPunchLog;

@Repository
public interface EmployeePunchRepository 
			extends CrudRepository<EmpPunchLog, Long> {

}
