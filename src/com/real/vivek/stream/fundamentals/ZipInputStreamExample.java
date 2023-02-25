package com.real.vivek.stream.fundamentals;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamExample {

	public static void main(String[] args) throws Exception {
		File file = new File("files/archive.zip");

		Path path = Paths.get("files/archive.zip");
		long size = Files.size(path);
		System.out.println("Size of file " + path + " is:" + size + " bytes");

		try (InputStream inputStream = new FileInputStream(file);
				ZipInputStream zipInputStream = new ZipInputStream(inputStream);
				DataInputStream dataInputStream = new DataInputStream(zipInputStream);) {
			ZipEntry zipEntry = zipInputStream.getNextEntry();
			while (zipEntry != null) {
				if (zipEntry.isDirectory()) {
					System.out.println("Reading from directory: " + zipEntry);
				} else {
					// We know that we have 1 text file and 1 bin file compressed in our zip file
					if (zipEntry.getName().contains(".txt")) {
						System.out
								.println("Content inside " + zipEntry.getName() + " is: " + dataInputStream.readUTF());
					} else {
						List<Integer> bytes = new ArrayList<>();
						int readInt = dataInputStream.readInt();
						try {
							while (true) {
								bytes.add(readInt);
								readInt = dataInputStream.readInt();
							}
						} catch (EOFException e) {
						}
						System.out.println("Content inside " + zipEntry.getName() + " is: " + bytes + " with size: "
								+ bytes.size());
					}
				}
				zipEntry = zipInputStream.getNextEntry();
			}
		}
	}

}
