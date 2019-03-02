package com.example.task.task1.dal;

import java.util.List;

import org.springframework.data.mongodb.core.query.Update;

import com.example.task.task1.model.Employee;
import com.mongodb.client.MongoDatabase;

/**
 * @author Divya
 *
 */
/**
 * @author Divya
 *
 */
public interface EmployeeDAL {

	/**
	 * Updates employee with emp
	 * @param emp
	 * @return
	 */
	Employee saveEmployee(Employee emp);

	/**
	 * Returns all employees from the collection
	 * @return
	 */
	List<Employee> getAllEmployees();

	/**
	 * Searches the employee with the given name
	 * @param name
	 * @return
	 */
	List<Employee> findByName(String name);

	/**
	 * Searches employee with the given age
	 * @param age
	 * @return
	 */
	List<Employee> findByAge(int age);

	/**
	 * Updates one employee with the new value
	 * @param emp
	 */
	void updateOneEmployee(Employee emp);

	/**
	 * Deletes employee specified by emp
	 * @param emp
	 */
	void deleteEmployee(Employee emp);

	/**
	 * Updates all employees with the update criteria
	 * @param update
	 */
	void updateAllEmployee(Update update);

}
