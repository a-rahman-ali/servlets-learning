package com.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeBO {
	static final String url = "jdbc:mysql://localhost:3306/jdbc";
	static final String username = "root";
	static final String password = "admin";

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	static final String INSERT_QUERY = "INSERT INTO `employees` (`id`,`name`,`email`,`department`,`salary`) values(?,?,?,?,?)";

	public EmployeeBO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public int save(Employee e) {
		System.out.println(e);

		try {

			preparedStatement = connection.prepareStatement(INSERT_QUERY);

			preparedStatement.setInt(1, e.getId());
			preparedStatement.setString(2, e.getName());
			preparedStatement.setString(3, e.getEmail());
			preparedStatement.setString(4, e.getDepartment());
			preparedStatement.setInt(5, e.getSalary());

			int i = preparedStatement.executeUpdate();

			return i;

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return 0;
	}
}
