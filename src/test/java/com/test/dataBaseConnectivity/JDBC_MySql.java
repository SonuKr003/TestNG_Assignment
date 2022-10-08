package com.test.dataBaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_MySql {

	public static void main(String[] args) throws SQLException {

		// ----- Step 1---------- : load/register jdbc driver (mysql database)
		Driver driverref = new Driver();// this will take care of registrations
		DriverManager.registerDriver(driverref); // this method will registered the driver

		// Step 2:------- Connect to database------------------- localhost and name of
		// the Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");

		// Step 3 :-------- Create database Statement/Query
		Statement stat = conn.createStatement();

		String query = "select * from student_info";

		// step : 4-------- execute query

		ResultSet result = stat.executeQuery(query);

		while (result.next()) {

			System.out.println(result.getInt(1) + "\t" + result.getString(2) +"\t"+result.getString(2));
		}

		// step 5: =-- closed the connections.................

		conn.close();
		System.out.println("closing dataBase connectivity................");

	}
}
