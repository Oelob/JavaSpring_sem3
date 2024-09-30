package com.example.demo;

import com.example.demo.models.Project;
import com.example.demo.models.Timesheet;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.Timesheetrepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		Timesheetrepository repoTimesheet = ctx.getBean(Timesheetrepository.class);
		ProjectRepository repoProjects = ctx.getBean(ProjectRepository.class);
		String [] projectNames = {"mysql","spring","exceptions","collections"};
//
		LocalDate createAt = LocalDate.now();
		for (int i = 1; i < 5 ; i++) {
			Project project = new Project();
			project.setId((long) i);
			project.setName(projectNames[i-1]);
			repoProjects.create(project);
		}

		for (int i = 1; i < 10 ; i++) {
			createAt = createAt.plusDays(1);
			Timesheet timesheet = new Timesheet();
			timesheet.setId((long) i);
			timesheet.setProjectName(repoProjects.getById((long)ThreadLocalRandom.current().nextInt(1,4)).get().getName());
			timesheet.setCreateAt(createAt);
			timesheet.setMinutes(ThreadLocalRandom.current().nextInt(100, 1000));

			repoTimesheet.create(timesheet);
		}
	}

}
