package com.example.demo;

import com.example.demo.models.Employee;
import com.example.demo.models.Project;
import com.example.demo.models.Timesheet;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TimesheetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		TimesheetRepository repoTimesheet = ctx.getBean(TimesheetRepository.class);
		ProjectRepository repoProjects = ctx.getBean(ProjectRepository.class);
		EmployeeRepository repoEmployees = ctx.getBean(EmployeeRepository.class);
		String [] projectNames = {"mysql","spring","exceptions","collections"};
		String[] eployeeLastNames = {"Черных", "Белых", "Красных", "Зеленых", "Швец", "Бекк"};
		String[] eployeeNames = {"Иван", "София", "Владимир", "Игорь", "Арнольд", "Федор"};
 //
		LocalDate createAt = LocalDate.now();
		for (int i = 1; i < 5 ; i++) {
			Project project = new Project();
//			project.setId((long) i);
			project.setName(projectNames[i-1]);
			repoProjects.save(project);
		}

		for (int i = 1; i < 10; i++) {
			Employee employee = new Employee();
			employee.setFirstName(eployeeNames[ThreadLocalRandom.current().nextInt(0, 6)]);
			employee.setLastName(eployeeNames[ThreadLocalRandom.current().nextInt(0, 6)]);
			repoEmployees.save(employee);

		}
		for (int i = 1; i < 10 ; i++) {
			createAt = createAt.plusDays(1);
			Timesheet timesheet = new Timesheet();
			timesheet.setId((long) i);
			timesheet.setProjectName(repoProjects.findById((long)ThreadLocalRandom.current().nextInt(1,4)).get().getName());
			timesheet.setCreateAt(createAt);
			timesheet.setMinutes(ThreadLocalRandom.current().nextInt(100, 1000));
			timesheet.setEmployeeId(repoEmployees.findById((long)ThreadLocalRandom.current().nextInt(1,10)).get().getId());

			repoTimesheet.save(timesheet);
		}


	}

}
