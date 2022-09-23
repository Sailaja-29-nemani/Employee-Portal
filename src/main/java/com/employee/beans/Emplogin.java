package com.employee.beans;

public class Emplogin
{
private int empId;
private String empName;
private String empEmail;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmpEmail() {
	return empEmail;
}
public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
}
public Emplogin(int empId, String empName, String empEmail) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empEmail = empEmail;
}
public Emplogin()
{
	super();
}
@Override
public String toString() {
	return "Emplogin [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + "]";
}

}
