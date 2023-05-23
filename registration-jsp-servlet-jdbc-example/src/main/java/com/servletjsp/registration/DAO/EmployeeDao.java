package com.servletjsp.registration.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.servletjsp.registration.model.Employee;

public class EmployeeDao {
	
	public int employeeRegister(Employee employee) throws ClassNotFoundException {
		String Insert_SQl="INSERT INTO employees"+" (id, first_name, last_name,username, passwrd,address) "+ "values (?,?,?,?,?,?);";
		int result=0;
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useSSL=false", "root", "sumanil99");
				PreparedStatement preparedStatement = connection.prepareStatement(Insert_SQl)){
				preparedStatement.setInt(1, 1);
				preparedStatement.setString(2, employee.getFirstName());
				preparedStatement.setString(2, employee.getLastName());
				preparedStatement.setString(2, employee.getUserName());
				preparedStatement.setString(2, employee.getPassword());
				preparedStatement.setString(2, employee.getAddress());
				
				System.out.println(preparedStatement);
				
				result=preparedStatement.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		}
}