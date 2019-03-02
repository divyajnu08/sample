package com.example.task.task1.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.task.task1.dal.EmployeeDAL;
import com.example.task.task1.model.Employee;
import com.mongodb.client.MongoDatabase;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeDAL employeeDAL;

	/**
	 * Inserts an employee into the collection
	 * @param name
	 * @param age
	 */
	public void insertEmployee(String name, int age) {
		Employee emp = new Employee();
		emp.setAge(age);
		emp.setName(name);
		employeeDAL.saveEmployee(emp);
	}

	/**
	 * Updates all employees modified date with the specified date
	 * @param date
	 */
	public void updateAllEmployee(Date date) {
		Update update = new Update();
		update.set("modifiedDate", date);
		employeeDAL.updateAllEmployee(update);

	}

}
