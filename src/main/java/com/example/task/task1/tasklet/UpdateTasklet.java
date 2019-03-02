package com.example.task.task1.tasklet;

import java.util.Date;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.task.task1.service.EmployeeService;

/**
 * @author Divya
 *
 */
public class UpdateTasklet implements Tasklet {

	@Autowired
	EmployeeService service;

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		service.updateAllEmployee(new Date());
		return RepeatStatus.FINISHED;
	}

}
