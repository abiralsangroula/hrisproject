package com.springboot;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import com.springboot.model.User;
import com.springboot.repository.UserRespository;

@SpringBootApplication
@Controller
//@ComponentScan(basePackages="com.springboot")
public class Application implements CommandLineRunner {
	@Autowired
	private UserRespository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		openHomePage();
	}

	@Override
	public void run(String... args) throws Exception {
		List<User> userList = userRepository.findAll();
		if (userList.size() < 1) {
			User user = new User();
			user.setUsername("abiral");
			user.setPassword(bcrypt.encode("abiral"));
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
	
//	 private static void openHomePage() {
//	        try {
//	            URI homepage = new URI("http://localhost:9090/index");
//	            Desktop.getDesktop().browse(homepage);
//	        } catch (URISyntaxException | IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
}
