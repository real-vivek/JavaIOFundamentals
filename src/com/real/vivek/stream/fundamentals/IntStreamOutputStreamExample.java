package com.real.vivek.stream.fundamentals;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class IntStreamOutputStreamExample {

	public static void main(String[] args) {

		File file = new File("src/initRange.bin");
		//DataInputStream and DataOutputStream ad classes dedicated to reading and writing primitive types the both follow decorative pattern
		try (OutputStream outputStream = new FileOutputStream(file);
				DataOutputStream dataOutputStream = new DataOutputStream(outputStream);) {
			IntStream.range(0, 100).forEach(i -> {
				try {
//					dataOutputStream.writeInt(i);
					//If we have only write then each byte is 1 byte
					dataOutputStream.write(i);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		Path path = Paths.get("src/initRange.bin");
		long size=0;
		try {
			size = Files.size(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Size of file "+path+" is:"+size);

	}

}
