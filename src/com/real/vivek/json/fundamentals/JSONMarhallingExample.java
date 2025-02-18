package com.real.vivek.json.fundamentals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.real.vivek.dto.Employee;

public class JSONMarhallingExample {

	public static void main(String[] args) {
		Employee employee1 = new Employee("emp1", 21, 150000, null);
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("json/employeeJSON.txt");
		try (PrintWriter printWriter = new PrintWriter(file);){
			String employeeJSONString = mapper.writeValueAsString(employee1);
			printWriter.write(employeeJSONString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
