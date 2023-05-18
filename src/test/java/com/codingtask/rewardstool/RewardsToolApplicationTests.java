package com.codingtask.rewardstool;

import com.codingtask.rewardstool.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RewardsToolApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TransactionRepository transactionRepository;
//	@BeforeEach
//	public void deleteAllBeforeTests() throws Exception {
//		transactionRepository.deleteAll();
//	}
	@Test
	void shouldCreateEntity() throws Exception {

		mockMvc.perform(post("/transactions").content(
				"{\"customerId\": \"Frodo\", \"purchaseAmount\":20}")).andExpect(
				status().isCreated()).andExpect(
				header().string("Location", containsString("transactions/")));
	}

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.transactions").exists());
	}

}
