package com.example.task;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



/**
 * @author Divya
 *
 */
@Component
public class CRUDScheduler {

	@Autowired
	JobLauncher launcher;

	@Autowired
	Job job;

	private JobExecution execution;

	/**
	 * Runs update job
	 * @throws Exception
	 */
	@Scheduled(cron = "${task.update.cron}")
	public void update() throws Exception {
		execution = launcher.run(job, new JobParameters());
		System.out.println("Execution status: " + execution.getStatus());
	}

}
