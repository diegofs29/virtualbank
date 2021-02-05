package com.bank.virtualbank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.virtualbank.entities.User;
import com.bank.virtualbank.repositories.UsersRepository;

@SpringBootTest
class VirtualbankApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private UsersRepository uR;

	@Test
	public void whenFindingCustomerById_thenCorrect() {
		uR.save(new User("John", "71904455X"));
		assertThat(uR.findById(1L)).isInstanceOf(Optional.class);
	}

}
