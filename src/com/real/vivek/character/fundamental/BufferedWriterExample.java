package com.real.vivek.character.fundamental;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BufferedWriterExample {

	public static void main(String[] args) {

		Path path = Paths.get("src/demo.txt");
		//We can pass OpenOption as 2nd parameter like we can have CREATE,CREATE_NEW,WRITE,APPEND,DELETE_ON_CLOSE
		try(BufferedWriter bufferedWriter=Files.newBufferedWriter(path, StandardOpenOption.CREATE);) {
			//The disadvantage of using BufferedWriter or FileWriter is we can append only CharSequence or Character
			bufferedWriter.append("Hello from BufferedWriter!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
