package com.example.task.task1.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.task.CRUDScheduler;
import com.example.task.task1.tasklet.UpdateTasklet;

/**
 * @author Divya
 *
 */
@EnableScheduling
@EnableBatchProcessing
@Configuration
public class EmployeeBatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Bean
	protected Job addRecords(@Qualifier("step1") Step step1) {
		return jobs.get("myJob").start(step1).build();

	}

	@Bean
	protected Step step1() {
		return steps.get("step1").tasklet(tasklet()).build();
	}

	@Bean
	protected Tasklet tasklet() {
		return new UpdateTasklet();
	}

	@Bean
	protected CRUDScheduler scheduler() {
		return new CRUDScheduler();
	}

}
