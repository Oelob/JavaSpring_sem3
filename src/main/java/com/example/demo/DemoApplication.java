package com.example.demo;

import com.example.demo.models.*;
import com.example.demo.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		TimesheetRepository repoTimesheet = ctx.getBean(TimesheetRepository.class);
		ProjectRepository repoProjects = ctx.getBean(ProjectRepository.class);
		EmployeeRepository repoEmployees = ctx.getBean(EmployeeRepository.class);
		RolesRepository repoRoles = ctx.getBean(RolesRepository.class);
		UsersRepository repoUsers = ctx.getBean(UsersRepository.class);
		UsersRoleRepository repoUsersRoles = ctx.getBean(UsersRoleRepository.class);

		String [] projectNames = {"mysql","spring","exceptions","collections"};
		String[] eployeeLastNames = {"Черных", "Белых", "Красных", "Зеленых", "Швец", "Бекк"};
		String[] eployeeNames = {"Иван", "София", "Владимир", "Игорь", "Арнольд", "Федор"};

		Role roleAdmin = new Role();
		roleAdmin.setId(1L);
		roleAdmin.setName("admin");
		repoRoles.save(roleAdmin);

		Role roleUser = new Role();
		roleUser.setId(2L);
		roleUser.setName("user");
		repoRoles.save(roleUser);

		Role roleRest = new Role();
		roleRest.setId(3L);
		roleRest.setName("rest");
		repoRoles.save(roleRest);


		User admin = new User();
		admin.setId(1L);
		admin.setLogin("admin");
		admin.setPassword("hashed_admin");

		User user = new User();
		user.setId(2L);
		user.setLogin("user");
		user.setPassword("hashed_user");


		User anonimous = new User();
		anonimous.setId(3L);
		anonimous.setLogin("anon");
		anonimous.setPassword("hashed_anon");
		repoUsers.save(admin);
		repoUsers.save(user);
		repoUsers.save(anonimous);

		UserRole adminAdminRole = new UserRole();
		adminAdminRole.setUserId(String.valueOf(admin.getId()));
		adminAdminRole.setRoleId(String.valueOf(repoRoles.findByName("admin").get().getId()));
		adminAdminRole.setRoleName(repoRoles.findByName("admin").get().getName());
		repoUsersRoles.save(adminAdminRole);

		UserRole adminUserRole = new UserRole();
		adminUserRole.setUserId(String.valueOf(admin.getId()));
		adminUserRole.setRoleId(String.valueOf(repoRoles.findByName("user").get().getId()));
		adminAdminRole.setRoleName(repoRoles.findByName("user").get().getName());
		repoUsersRoles.save(adminUserRole);


		UserRole userUserRole = new UserRole();
		userUserRole.setUserId(String.valueOf(user.getId()));
		userUserRole.setRoleId(String.valueOf(repoRoles.findByName("user").get().getId()));
		adminAdminRole.setRoleName(repoRoles.findByName("user").get().getName());
		repoUsersRoles.save(userUserRole);

		UserRole userRestRole = new UserRole();
		userUserRole.setUserId(String.valueOf(user.getId()));
		userUserRole.setRoleId(String.valueOf(repoRoles.findByName("rest").get().getId()));
		adminAdminRole.setRoleName(repoRoles.findByName("rest").get().getName());
		repoUsersRoles.save(userRestRole);

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
