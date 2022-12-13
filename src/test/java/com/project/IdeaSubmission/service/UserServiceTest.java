package com.project.IdeaSubmission.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.IncorrectUpdateSemanticsDataAccessException;

import com.jayway.jsonpath.Option;
import com.mysql.cj.xdevapi.Result;
import com.project.IdeaSubmission.AbstractTest;
import com.project.IdeaSubmission.dto.User;
import com.project.IdeaSubmission.repository.UserRepository;

import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest extends AbstractTest{
	
	@MockBean
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	private User user;
	
	@BeforeEach
    public void setup(){
        user = User.builder()
                .id(100)
                .fname("Jack")
                .lname("Fadatare")
                .email("ramesh@gmail.com")
                .password("123")
                .role("admin")
				.username("haaanaa")
                .build();
    }
	@Test
	void testAddUser() {
//		given(userRepository.findById(user.getId())).willReturn(Option.empty())
//		given(userRepository.save(user)).willReturn(user);
//		System.out.println(userRepository);
//		System.out.println(userService);
		
//		assertThat(savedUser).isNotNull();
//		User user = new User();
//		user.setFname("Amma");
//		user.setLname("Janson");
//		user.setEmail("amman@gmail.com");
//		user.setPassword("123");
//		user.setUsername(null);
//		user.setRole("admin");
		userRepository.save(user);
		Assertions.assertThat(user.getId()).isGreaterThan(0);
		User savedUser = userService.addUser(user); 
//		User found = userRepository.findById(user.getId()).get();
	      assertThat(user.getId()).isNotNull();	
	}

	@Test
	void testUpdateUser() {
		user = userRepository.save(user);
		user.setEmail("jack@gmail.com");
		User user2 = userRepository.save(user);
		
		User updatedUser = userService.updateUser(user2,100);
		
		assertThat(updatedUser.getEmail()).isEqualTo("jack@gmail.com");
	}

	@Test
	void testDeleteUser() {
		int id = 100;
		userRepository.deleteById(id);
		userService.deleteUser(id);
		userRepository.existsById(id);
		assertThat(user.getId()).isNotNull();
		
	}

	
	@Test
	void testGetUsers() {
		userService.getUsers();
		verify(userRepository).findAll();
		}

}
