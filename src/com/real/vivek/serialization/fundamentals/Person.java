package com.real.vivek.serialization.fundamentals;

import java.io.Serializable;

//It's highly recommended that you explicitly declare and initialize the static, final field of type long and named 'serialVersionUID' in all your classes you want to make Serializable instead of relying on the default computation of the value for this field. 
//This computation is extremely sensitive and may vary from one compiler implementation to another and hence you may turn up getting the InvalidClassException even for the same class just because you used different compiler implementations on the sender and the receiver ends of the serialization process.
public class Person  implements Serializable{
	
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
