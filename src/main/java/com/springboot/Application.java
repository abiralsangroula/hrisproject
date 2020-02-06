package com.springboot;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.model.User;
import com.springboot.repository.UserRespository;

@SpringBootApplication
@Controller
public class Application implements CommandLineRunner {
	@Autowired
	private UserRespository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<User> userList = userRepository.findAll();
		if (userList.size() < 1) {
			User user = new User();
			user.setUsername("abiral");
			user.setPassword("abiral");
			user.setIsAdmin(true);
			user.setCreatedDate(new Date());
			user.setDelFlg(false);
			userRepository.save(user);
			Optional<User> findUser = userRepository.findById(user.getId());
			if (findUser.isPresent()) {
				User existingUser = findUser.get();
				existingUser.setCreatedBy(user);
			}
		}
	}

}
