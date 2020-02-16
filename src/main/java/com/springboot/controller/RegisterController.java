package com.springboot.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.ConfirmationToken;
import com.springboot.model.User;
import com.springboot.repository.ConfirmationTokenRepository;
import com.springboot.repository.UserRespository;
import com.springboot.services.EmailSenderService;

import lombok.Getter;
import lombok.Setter;

@Controller
// @RequestMapping("/register")
@Getter
@Setter
@PropertySource("classpath:application.properties")
public class RegisterController {

	@Value("${spring.mail.username}")
	private String sentFrom;

	@Autowired
	private UserRespository userRepository;

	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	private EmailSenderService emailSenderService;

	@Autowired
	BCryptPasswordEncoder bcrypt;

	@GetMapping("/register")
	public ModelAndView displayRegistraion(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@PostMapping("/register")
	public ModelAndView registerUser(ModelAndView modelAndView, User user) {
		Random random = new Random();
		String confirm = String.format("%04d", random.nextInt(10000));
		User existingUser = userRepository.findByEmailIdIgnoreCase(user.getEmailId());
		if (existingUser != null) {
			modelAndView.addObject("message", "This email already exists!");
			modelAndView.setViewName("error");
		} else {
			user.setEnabled(false);
			user.setCreatedDate(new Date());
			user.setIsAdmin(false);
			user.setPassword(bcrypt.encode(user.getPassword()));
			userRepository.save(user);

			ConfirmationToken confirmationToken = new ConfirmationToken(user);

			confirmationTokenRepository.save(confirmationToken);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmailId());
			mailMessage.setSubject("Complete Registration!");
			mailMessage.setFrom(sentFrom);
			mailMessage.setText("Use this number to activate \t \t" + confirm
					+ "\n \n To confirm your account, please click here : "
					+ "http://localhost:9090/confirm-account?token=" + confirmationToken.getConfirmationToken());

			emailSenderService.sendMail(mailMessage);

			modelAndView.addObject("emailId", user.getEmailId());

			modelAndView.setViewName("successfulRegistration");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/confirm-account", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			User user = userRepository.findByEmailIdIgnoreCase(token.getUser().getEmailId());
			Date date = token.getExpiryDate();
			Calendar cal = Calendar.getInstance();
			if ((date.getTime() - cal.getTime().getTime()) <= 0) {
				modelAndView.setViewName("tokenExpired");
				System.out.println();
			}else {
				user.setEnabled(true);
				userRepository.save(user);
				modelAndView.setViewName("accountVerified");
			}
			
		} else {
			modelAndView.addObject("message", "The link is invalid or broken!");
			modelAndView.setViewName("error");
		}

		return modelAndView;
	}
	
	@GetMapping("/generateNew")
	public ModelAndView generateNewToken(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("generateNewRegToken");
		return modelAndView;
	}
	
	@PostMapping("/generateNew")
	public ModelAndView generateNewTokenSelected(ModelAndView modelAndView , User user) {
		User existingUser= userRepository.findByEmailIgnoreCase(user.getEmailId(), false);
		if(existingUser != null) {
			List<ConfirmationToken> userTokenList= confirmationTokenRepository.findByUserId(existingUser.getId());
			ConfirmationToken deltoken=userTokenList.get(userTokenList.size()-1);
			deltoken.setDelFlg(true);
			confirmationTokenRepository.save(deltoken);
			modelAndView.setViewName("redirect:/generateNewRegToken");
		}
		return modelAndView;
	}
}
