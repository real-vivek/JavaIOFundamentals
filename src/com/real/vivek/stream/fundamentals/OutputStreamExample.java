package com.real.vivek.stream.fundamentals;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OutputStreamExample {

	public static void main(String[] args) throws IOException {
		File file = new File("src/inits.bin");

		//DataOutputStream is class dedicated to writing primitive types and String which follows decorative pattern
		try (
				OutputStream outputStream = new FileOutputStream(file);
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			) {
			dataOutputStream.writeDouble(10);
			//For below eg size of file is 7 because there are 2 technical bytes as header(which tell that encoding is UTF-8) and 1 byte for each character in UTF encoding
			//dataOutputStream.writeUTF("Hello");
			//If we try to add non std ASCII char then it will require 1 byte as header and 1 for the byte itself
			//Thus ó byte is encoded using 2 bytes
			//Thus chars can be written using 1/2/4 bytes using UTF
			//dataOutputStream.writeUTF("Helló");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Path path = Paths.get("src/inits.bin");
		//This size will depend on type of data we are adding to file 
		//For eg if we try to have writeInt(8) the size will increase by 4
		//We have written this code outside try catch so that the binary data will be flushed and we get correct output
		long size = Files.size(path);
		System.out.println("Size of file "+path+" is:"+size);

	}

}
