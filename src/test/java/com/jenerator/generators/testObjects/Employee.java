package com.jenerator.generators.testObjects;

import java.util.Date;

public class Employee {
	private long employeeId;
	private String firstName;
	private String lastName;
	private int salary;
	private Date hiredDate;
	private double monthlyTargetPercent;
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getHiredDate() {
		return hiredDate;
	}
	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}
	public double getMonthlyTargetPercent() {
		return monthlyTargetPercent;
	}
	public void setMonthlyTargetPercent(double monthlyTargetPercent) {
		this.monthlyTargetPercent = monthlyTargetPercent;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + ", hiredDate=" + hiredDate + ", monthlyTargetPercent=" + monthlyTargetPercent
				+ "]";
	}
	
}
