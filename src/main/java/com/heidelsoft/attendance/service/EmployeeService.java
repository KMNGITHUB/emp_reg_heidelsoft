package com.heidelsoft.attendance.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heidelsoft.attendance.exception.RecordNotFoundException;
import com.heidelsoft.attendance.model.EmpPunchLog;
import com.heidelsoft.attendance.model.EmployeeEntity;
import com.heidelsoft.attendance.repository.EmployeePunchRepository;
import com.heidelsoft.attendance.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empMasterRepository;
	
	public List<EmployeeEntity> getAllEmployees()
	{
		List<EmployeeEntity> result = (List<EmployeeEntity>) empMasterRepository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}
	
	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException 
	{
		Optional<EmployeeEntity> employee = empMasterRepository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
	
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) 
	{
		if(entity.getEmpId()  == null) 
		{
			entity = empMasterRepository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<EmployeeEntity> employee = empMasterRepository.findById(entity.getEmpId());
			
			if(employee.isPresent()) 
			{
				EmployeeEntity newEntity = employee.get();
				newEntity.setEmpFirstName(entity.getEmpFirstName());
				newEntity.setEmpLastName(entity.getEmpLastName());
				newEntity.setEmpAddr(entity.getEmpAddr());

				newEntity = empMasterRepository.save(newEntity);
				
				return newEntity;
			} else {
				entity = empMasterRepository.save(entity);
				
				return entity;
			}
		}
	} 
	
	public void deleteEmployeeById(Long id) throws RecordNotFoundException 
	{
		Optional<EmployeeEntity> employee = empMasterRepository.findById(id);
		
		if(employee.isPresent()) 
		{
			empMasterRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	} 
	
	public void puchEmployee(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity>employee = empMasterRepository.findById(id);
		if(employee.isPresent()) {
			String status ="IN";
			Set<EmpPunchLog>punchList = employee.get().getEmpPunchLogs();
			Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
			status = punchList.size()%2==0?status:"OUT";
			EmpPunchLog punchRecord = new EmpPunchLog();
			punchRecord.setEmployee(employee.get());
			punchRecord.setEmpPunchStatus(status);
			punchRecord.setEmpPunchTimestamp(timestamp);
			punchList.add(punchRecord);
			EmployeeEntity employeeEntity = employee.get();
			employeeEntity.setEmpPunchLogs(punchList);
			empMasterRepository.save(employeeEntity);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
}