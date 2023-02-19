package com.real.vivek.character.fundamental;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderExample {

	public static void main(String[] args) {

		Path path = Paths.get("src/demo.txt");
		// Using try with resources will automatically close the resources declared in it
		try (
				// New Java7 approach to build bufferedReader
				BufferedReader bufferedReaderUsingJava7 = Files.newBufferedReader(path);
			) {
			// Iterating over file using Stream api introduced in Java 8
			// bufferedReader.lines().forEach(System.out::print);
			String line = bufferedReaderUsingJava7.readLine();
			while (line != null) {
				System.out.println(line);
				line = bufferedReaderUsingJava7.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
