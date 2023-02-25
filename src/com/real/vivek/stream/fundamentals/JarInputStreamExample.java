package com.real.vivek.stream.fundamentals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class JarInputStreamExample {

	public static void main(String[] args) throws Exception {
		File file = new File("jar/jackson-core-2.14.2.jar");

		Path path = Paths.get("jar/jackson-core-2.14.2.jar");
		long size = Files.size(path);
		System.out.println("Size of file " + path + " is:" + size);

		try (InputStream inputStream = new FileInputStream(file);
				JarInputStream jarInputStream = new JarInputStream(inputStream);) {
			JarEntry jarEntry = jarInputStream.getNextJarEntry();
			while (jarEntry != null) {
				if (jarEntry.isDirectory()) {
					System.out.println("Reading directory: " + jarEntry);
				} else if (jarEntry.getName().contains(".class")) {
					System.out.println("Following .class file is present: " + jarEntry);
				}
				jarEntry = jarInputStream.getNextJarEntry();
			}
		}
	}

}
