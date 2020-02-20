package com.heidelsoft.attendance.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name ="ForeignKeyAssoEntity")
@Table(name = "EMPLOYEE_MASTER")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "emp_first_name")
	private String empFirstName;

	@Column(name = "emp_last_name")
	private String empLastName;

	@Column(name = "emp_addr")
	private String empAddr;

	
	  @OneToMany(cascade=CascadeType.ALL,mappedBy="employee")
	 // @JoinColumn(name="emp_id") 
	  private Set<EmpPunchLog>empPunchLogs;
	 
	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the id to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the empFirstName
	 */
	public String getEmpFirstName() {
		return empFirstName;
	}

	/**
	 * @param empFirstName the empFirstName to set
	 */
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	/**
	 * @return the empLastName
	 */
	public String getEmpLastName() {
		return empLastName;
	}

	/**
	 * @param empLastName the empLastName to set
	 */
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	/**
	 * @return the empAddr
	 */
	public String getEmpAddr() {
		return empAddr;
	}

	/**
	 * @param empAddr the empAddr to set
	 */
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	/**
	 * @return the empPunchLogs
	 */
	  public Set<EmpPunchLog> getEmpPunchLogs() { 
		  return empPunchLogs; 
	  }
		 

	/**
	 * @param empPunchLogs the empPunchLogs to set
	 */
	
	  public void setEmpPunchLogs(Set<EmpPunchLog> empPunchLogs) {
		  this.empPunchLogs = empPunchLogs; 
	  }
	 

	@Override
	public String toString() {
		return "EmployeeMasterEntity [id=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empAddr=" + empAddr  + ", empPunchLogs=" + empPunchLogs + "]";
	}

}