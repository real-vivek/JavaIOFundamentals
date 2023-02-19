package com.real.vivek.character.fundamental;

import java.io.CharArrayReader;
import java.io.StringReader;

public class CharArrayReaderAndStringReaderExample {

	public static void main(String[] args) throws Exception {
		char[] chArray = new char[5];
		chArray[1]='a';
		CharArrayReader charArrayReader = new CharArrayReader(chArray);
		int ch = charArrayReader.read();
		//Default value for char is /u0000 i.e. space(' ') so those elements will be present and printed from chArray by default
		while (ch != -1) {
			System.out.print((char) ch);
			ch = charArrayReader.read();
		}
		//We can also create StringReader using following code
		StringReader stringReader = new StringReader(new String("Hello from String Reader!"));
		int strChar=stringReader.read();
		while (strChar != -1) {
			System.out.print((char) strChar);
			strChar = stringReader.read();
		}
	}
}
