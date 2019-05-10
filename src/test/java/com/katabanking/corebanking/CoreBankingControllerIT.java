package com.katabanking.corebanking;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoreBankingControllerIT {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void should_make_deposit() throws Exception {

		//GIVEN

		String amountDeposit = "10";

		//WHEN-THEN
		this.mockMvc.perform(post("/deposit").contentType(MediaType.APPLICATION_JSON).content(amountDeposit)).andDo(print()).andExpect(status().isOk());
	}


	@Test
	public void should_make_withdrawal() throws Exception {

		//GIVEN

		String amountWithdrawal = "10";

		//WHEN-THEN
		this.mockMvc.perform(post("/withdraw").contentType(MediaType.APPLICATION_JSON).content(amountWithdrawal)).andDo(print()).andExpect(status().isOk());
	}



	@Test
	public void should_get_account_history() throws Exception {

		//GIVEN
        //Initial DevBootstrap data


		//WHEN-THEN
		this.mockMvc.perform(get("/history")).andDo(print()).andExpect(status().isOk());
	}

}
