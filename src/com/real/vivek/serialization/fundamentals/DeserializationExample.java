package com.real.vivek.serialization.fundamentals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DeserializationExample {

	public static void main(String[] args) {
		File file = new File("ser/person-serialization.ser");
		//If we try to add any other method in Person class and let compiler generate serialVersionUID then we get following exception:
		//InvalidClassException: local class incompatible: stream classdesc serialVersionUID = -196410440475012755, local class serialVersionUID = -6675950253085108747
		try (InputStream inputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);) {
			Person person1 = (Person) objectInputStream.readObject();
			Person person2 = (Person) objectInputStream.readObject();
			System.out.println("Deserialized object1: " + person1);
			System.out.println("Deserialized object2: " + person2);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
