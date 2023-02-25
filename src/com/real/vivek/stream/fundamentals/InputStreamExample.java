package com.real.vivek.stream.fundamentals;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputStreamExample {

	public static void main(String[] args) throws Exception {
		File file = new File("src/inits.bin");

		Path path = Paths.get("src/inits.bin");
		long size = Files.size(path);
		System.out.println("Size of file " + path + " is:" + size);

		try (InputStream inputStream = new FileInputStream(file);
				DataInputStream dataInputStream = new DataInputStream(inputStream);) {
			List<Double> doubles = new ArrayList<>();
			try {
				while (true) {
					// We know the type of input that we had given when writing binary to file so we are using readDouble here
					// By reading the documentation we came to know that EOFException will be thrown oncw we finish reading data
					doubles.add((double) dataInputStream.readDouble());
				}
			} catch (EOFException e) {
			}

			System.out.println("The number of double binary element/s present in file " + path + " are: " + doubles.size()
					+ " element/s written are: " + doubles);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
