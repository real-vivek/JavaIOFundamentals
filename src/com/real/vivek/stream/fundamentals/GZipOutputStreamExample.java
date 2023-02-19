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
import java.util.zip.GZIPOutputStream;

public class GZipOutputStreamExample {

	public static void main(String[] args) {

		File file = new File("src/initRangeCompressed.gz");
		try (OutputStream outputStream = new FileOutputStream(file);
				//Here we decorate OutputStream with GZIPOutputStream and decorate DataOutputStream with GZipOutputStream
				//This GZIPOutputStream doesn't add any method to class
				//It just changes the way stream is written and implements GZIP algo
				//Internal buffers of GZIPOutputStream have to be flushed to disk hence we have it in try with resource block
				//Limitations for GZIPStream: it can compress 1 file at a time and there may be limit on file size
				GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
				DataOutputStream dataOutputStream = new DataOutputStream(gzipOutputStream);) {
			IntStream.range(0, 100).forEach(i -> {
				try {
					dataOutputStream.writeInt(i);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		Path path = Paths.get("src/initRangeCompressed.gz");
		long size=0;
		try {
			size = Files.size(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//The file of compressed file will be lesser that the non-compressed file because the bytes have been written using GZip algo
		//However if we unzip this file then its size will be same as original file size(4000 bytes in our case because int is 4 bytes)
		System.out.println("Size of file "+path+" is:"+size);
	}

}
