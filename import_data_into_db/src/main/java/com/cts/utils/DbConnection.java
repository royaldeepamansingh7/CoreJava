package com.cts.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class DbConnection {

	private static final Logger LOGGER = Logger.getLogger(DbConnection.class);

	public Connection getConnection(String url, String username, String password) throws SQLException {
		LOGGER.info("getConnection method start");
		Connection connection = DriverManager.getConnection(url, username, password);
		if (connection != null) {
			LOGGER.info("Connected to Postgres database successfully");
		}
		LOGGER.info("getConnection method end");
		return connection;
	}// getConnection()

	@SuppressWarnings("unused")
	public void insertTextFileData(List<String> list, Connection con) throws SQLException {
		LOGGER.info("insertTextFileData method start");
		// System.exit(1);
		String insertQuery = null;
		Statement stmt = null;
		for (String element : list) { // element = 631231482,David,Smith,77,tester
			String[] elementSplit = element.split(",");
			if (elementSplit.length == 5) {
				insertQuery = "INSERT INTO public.generic_parser(id, emp_first_name, emp_last_name, age, dept)VALUES "
						+ "(" + elementSplit[0] + ",'" + elementSplit[1] + "','" + elementSplit[2] + "','"
						+ elementSplit[3] + "','" + elementSplit[4] + "')";
				stmt = con.createStatement();
				stmt.executeUpdate(insertQuery);
			} else {
				LOGGER.error("Rows having error : " + element);
			}
		} // for loop end
		LOGGER.info("insertTextFileData method end");

	}// insertTextFileData()
}
