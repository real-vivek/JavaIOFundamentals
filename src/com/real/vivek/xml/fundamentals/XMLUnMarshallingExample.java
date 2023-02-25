package com.real.vivek.xml.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.real.vivek.dto.Employee;

public class XMLUnMarshallingExample {

	public static void main(String[] args) {
		Path path = Paths.get("xml/employeeXML.txt");
		try (BufferedReader bufferedReader =Files.newBufferedReader(path);){
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Employee employee = (Employee)unmarshaller.unmarshal(bufferedReader);
			System.out.println("Unmarshalled Employee Object: "+employee);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
