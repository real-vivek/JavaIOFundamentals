package com.real.vivek.json.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.real.vivek.dto.Employee;

public class JSONUnMarhallingExample {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		Path path = Paths.get("json/employeeJSON.txt");
		try (BufferedReader bufferedReader = Files.newBufferedReader(path);) {
			String line = bufferedReader.readLine();
			Employee readValue = mapper.readValue(line, Employee.class);
			System.out.println(readValue);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
