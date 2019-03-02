package com.example.task.task1.dal;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.task.task1.model.Employee;
import com.mongodb.client.MongoDatabase;

@Component
public class EmployeeDALImpl implements EmployeeDAL {

	private MongoTemplate mongoTemplate;

	/**
	 * @param templ
	 */
	public EmployeeDALImpl(MongoTemplate templ) {
		this.mongoTemplate = templ;
	}

	/* (non-Javadoc)
	 * @see com.example.task.task1.dal.EmployeeDAL#saveEmployee(com.example.task.task1.model.Employee)
	 */
	public Employee saveEmployee(Employee emp) {
		return mongoTemplate.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.example.task.task1.dal.EmployeeDAL#getAllEmployees()
	 */
	public List<Employee> getAllEmployees() {
		return mongoTemplate.findAll(Employee.class);
	}

	/* (non-Javadoc)
	 * @see com.example.task.task1.dal.EmployeeDAL#findByName(java.lang.String)
	 */
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.task.task1.dal.EmployeeDAL#findByAge(int)
	 */
	public List<Employee> findByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.task.task1.dal.EmployeeDAL#updateOneEmployee(com.example.task.task1.model.Employee)
	 */
	public void updateOneEmployee(Employee emp) {
	}

	/* (non-Javadoc)
	 * @see com.example.task.task1.dal.EmployeeDAL#deleteEmployee(com.example.task.task1.model.Employee)
	 */
	public void deleteEmployee(Employee emp) {
		mongoTemplate.remove(emp);
	}

	/* (non-Javadoc)
	 * @see com.example.task.task1.dal.EmployeeDAL#updateAllEmployee(org.springframework.data.mongodb.core.query.Update)
	 */
	@Override
	public void updateAllEmployee(Update update) {

		mongoTemplate.updateMulti(new Query(), update, "employee");

	}

}
