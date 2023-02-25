package com.real.vivek.stream.fundamentals;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamExample {

	public static void main(String[] args) {

		File file = new File("files/archive.zip");
		try (OutputStream outputStream = new FileOutputStream(file);
				// Advantage of using ZIP format is we can create directories and files also we can add content on the fly
				ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
				DataOutputStream dataOutputStream = new DataOutputStream(zipOutputStream);) {

			ZipEntry zipEntry = new ZipEntry("bin/");
			zipOutputStream.putNextEntry(zipEntry);

			ZipEntry binZipEntry = new ZipEntry("bin/inits.bin");
			zipOutputStream.putNextEntry(binZipEntry);

			IntStream.range(0, 100).forEach(i -> {
				try {
					// If we have only writeInt then each byte is 4 byte as size of int is 4 byte
					dataOutputStream.writeInt(i);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			ZipEntry textZipEntry = new ZipEntry("text/");
			zipOutputStream.putNextEntry(textZipEntry);

			ZipEntry textFileEntry = new ZipEntry("text/file.txt");
			zipOutputStream.putNextEntry(textFileEntry);

			dataOutputStream.writeUTF("Hello from Zip file!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
