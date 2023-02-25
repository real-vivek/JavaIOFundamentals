package com.real.vivek.serialization.fundamentals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializationExample {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("name1");
		p1.setAge(26);
		Person p2 = new Person();
		p2.setName("name2");
		p2.setAge(27);
		File file = new File("ser/person-serialization.ser");

		try (OutputStream outputStream = new FileOutputStream(file);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);) {
			objectOutputStream.writeObject(p1);
			objectOutputStream.writeObject(p2);	
			System.out.println("Serialization Successful!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
