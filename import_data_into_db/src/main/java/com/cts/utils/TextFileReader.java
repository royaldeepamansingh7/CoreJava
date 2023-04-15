package com.cts.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cts.main.AppTest;

public class TextFileReader {
	private static final Logger LOGGER = Logger.getLogger(TextFileReader.class);

	public List<String> readTextFile(String inputPath) {
		System.out.println("TestFileReader readTextFile method start");
		System.out.println("Input Path : " + inputPath);
		List<String> list = new ArrayList<>();
		try {
			File file = new File(inputPath); // creates a new file instance
			FileReader fr = new FileReader(file); // reads the file
			BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
			StringBuffer sb = new StringBuffer(); // constructs a string buffer with no characters
			String line;
			while ((line = br.readLine()) != null) {
//				sb.append(line); // appends line to string buffer
//				sb.append("\n"); // line feed
				
				list.add(line);
			}
			fr.close(); // closes the stream and release the resources
			list.remove(0);
			for (String val : list)
				LOGGER.info("List data : " + val);
		} catch (IOException e) {
			e.printStackTrace();
		} // catch
		LOGGER.info("TestFileReader readTextFile method end");
		return list;
	}// readTextFile method end

}// class
