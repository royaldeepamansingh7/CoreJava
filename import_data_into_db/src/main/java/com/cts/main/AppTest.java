package com.cts.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cts.utils.DbConnection;
import com.cts.utils.TextFileReader;

/**
 * Hello world!
 *
 */
public class AppTest {
	
	private static final Logger LOGGER = Logger.getLogger(AppTest.class);
	
	public static void main(String[] args) {
		LOGGER.info("main method start");
		TextFileReader textFileReader = new TextFileReader();
		String inputPath = "C:/Users/ASUS/OneDrive/Desktop/work/input/generic_parser_data.txt";
		List<String> list = textFileReader.readTextFile(inputPath);
		//make db connection
		DbConnection dbConnection = new DbConnection();
		String dbURL = "jdbc:postgresql://localhost:5432/IDS";
		String username = "postgres";
		String password = "postgresql";
		try {
			Connection con = dbConnection.getConnection( dbURL, username, password);
			dbConnection.insertTextFileData(list, con);
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("main method end");
		}
		LOGGER.info("main method end");
	}
}
