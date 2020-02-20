/**
 * 
 */
package com.heidelsoft.attendance.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author lenovo
 *
 */
@Entity(name ="ForeignKeyAssoEmpPunchLog")
@Table(name="emp_punch_log")
public class EmpPunchLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_punch_log_id",unique=true,nullable=false)
	private Long empPunchLogId;
	
	@Column(name="emp_punch_status")
	private String empPunchStatus;
	
	@Column(name="emp_punch_timestamp")
	private Timestamp empPunchTimestamp;
	
	@ManyToOne
	@JoinColumn(name="emp_id", nullable=false)
	private EmployeeEntity employee;

	/**
	 * @return the empPunchLogId
	 */
	public Long getEmpPunchLogId() {
		return empPunchLogId;
	}

	/**
	 * @param empPunchLogId the empPunchLogId to set
	 */
	public void setEmpPunchLogId(Long empPunchLogId) {
		this.empPunchLogId = empPunchLogId;
	}

	/**
	 * @return the empPunchStatus
	 */
	public String getEmpPunchStatus() {
		return empPunchStatus;
	}

	/**
	 * @param empPunchStatus the empPunchStatus to set
	 */
	public void setEmpPunchStatus(String empPunchStatus) {
		this.empPunchStatus = empPunchStatus;
	}

	/**
	 * @return the empPunchTimestamp
	 */
	public Timestamp getEmpPunchTimestamp() {
		return empPunchTimestamp;
	}

	/**
	 * @param empPunchTimestamp the empPunchTimestamp to set
	 */
	public void setEmpPunchTimestamp(Timestamp empPunchTimestamp) {
		this.empPunchTimestamp = empPunchTimestamp;
	}

	/**
	 * @return the employee
	 */
	public EmployeeEntity getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmpPunchLog [empPunchLogId=" + empPunchLogId + ", empPunchStatus=" + empPunchStatus
				+ ", empPunchTimestamp=" + empPunchTimestamp + ", employee=" + employee + "]";
	}
	
	
}
