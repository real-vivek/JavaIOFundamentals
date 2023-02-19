package com.real.vivek.character.fundamental;

import java.io.File;
import java.io.FileWriter;

public class FileWriterExample {

	public static void main(String[] args) {

		File file = new File("src/demo.txt");
		//When we write to output resource we usually don't route char or bytes to resource , we write to buffer
		//This buffer must be then flushed to o/p resource
		//The close operation will also trigger flush
		//If we pass a 2nd parameter as true to FileWriter it will append to the file unlike in this example where is erases all content and then writes
		try(FileWriter fileWriter = new FileWriter(file);) {
			fileWriter.append("Hey there hello from File Writer!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
