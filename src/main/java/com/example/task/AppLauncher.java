package com.example.task;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.task.task1.config.EmployeeBatchConfig;
import com.example.task.task1.config.EmployeeConfig;

public class AppLauncher {
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		System.out.println("***************************Welcome to Job scheduling application**********************");
		System.out.println("This job will update the modified date of all employees");
		System.out.println("Option A: The job will be triggered after every 2 minutes");
		System.out.println(
				"You can configure the frequency of the job by modifying task.update.cron property in application.properties file");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeConfig.class,
				EmployeeBatchConfig.class);
		System.out.println("**************************************************************************************");

	}
}
