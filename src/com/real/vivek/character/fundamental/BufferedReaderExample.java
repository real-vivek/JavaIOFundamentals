package com.real.vivek.character.fundamental;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferedReaderExample {

	public static void main(String[] args) throws Exception{

		File file = new File("src/demo.txt");
		// BufferedReader has composition relationship with FileReader or CharArrayReader
		// This is because BufferedReader needs a medium to read from
		//Java 1 approach to create BufferedReader
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = bufferedReader.readLine();
		while(line!=null) {
			System.out.println(line);
			line = bufferedReader.readLine();
		}
		//Closing the BufferedReader will automatically close the FileReader
		bufferedReader.close();
	}
}
