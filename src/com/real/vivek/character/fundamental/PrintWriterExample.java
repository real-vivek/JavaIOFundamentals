package com.real.vivek.character.fundamental;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PrintWriterExample {
	
	public static void main(String[] args) {
		Path path = Paths.get("src/demo.txt");
		//We can pass OpenOption as 2nd parameter like we can have CREATE,CREATE_NEW,WRITE,APPEND,DELETE_ON_CLOSE
		try(BufferedWriter bufferedWriter=Files.newBufferedWriter(path, StandardOpenOption.APPEND);) {
		PrintWriter printWriter = new PrintWriter(bufferedWriter);
		printWriter.println("Hello from PrintWriter");
		//To write number in octal
		printWriter.printf("%o \n", 12);
		//To write number in hexadecimal with 4 chars and add 0 if chars are less also add 0x in front of it
		printWriter.printf("0x%04x \n", 12);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
