package com.real.vivek.character.fundamental;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderExample {

	public static void main(String[] args) {

		//File is model of file or directory on the disk
		File file = new File("src/demo.txt");
		Reader fileReader = null;
		try {
			// The line below throws FileNotFoundException
			fileReader = new FileReader(file);
			// The line below throws IOException
			int c = fileReader.read();
			while (c != -1) {
				System.out.print((char) c);
				c = fileReader.read();
			}
		} catch (IOException e) {
			if(fileReader==null) {
				throw new NullPointerException("The FileReader object is null!");
			}
			e.printStackTrace();
		} finally {
			try {
				// Below code has to be in finally block but it also throws IOException
				fileReader.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

	}

}
