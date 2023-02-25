package com.real.vivek.json.fundamentals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.real.vivek.dto.Employee;

public class JSONMarhallingExample {

	public static void main(String[] args) {
		Employee employee1 = new Employee("emp1", 21, 150000, "Workflow");
		ObjectMapper mapper = new ObjectMapper();
		try {
			String employeeJSONString = mapper.writeValueAsString(employee1);
			System.out.println(employeeJSONString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
