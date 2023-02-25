package com.real.vivek.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

//Include.NON_NULL Indicates that only non-null properties should be serialized.
//Include.NON_EMPTY Indicates that only non-null and non-empty properties should be serialized. This is actually the superset of Include.NON_NULL
@JsonInclude(value = Include.NON_NULL)
@XmlRootElement
public class Employee {
	
	private String name;
	private int age;
	private long salary;
	private String department;
	
	public Employee() {
		super();
	}

	public Employee(String name, int age, long salary, String department) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}
	
	//Set different key name while serializing in JSON
	@JsonProperty(value = "firstName")
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public long getSalary() {
		return salary;
	}
	
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", department=" + department + "]";
	}
	
}
