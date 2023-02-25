package com.real.vivek.xml.fundamentals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.real.vivek.dto.Employee;

public class XMLMarshallingExample {

	public static void main(String[] args) {
		Employee employee1 = new Employee("emp1", 21, 150000, "Workflow");
		File file = new File("xml/employeeXML.txt");
		try (PrintWriter printWriter = new PrintWriter(file);){
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(employee1, printWriter);
			marshaller.marshal(employee1, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
