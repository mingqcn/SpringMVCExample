package spittr.view;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.mockito.BDDMockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import spittr.entity.Spitter;
import spittr.service.SpitterService;

/**
 * Spitter控制器测试
 * @author mingqiu
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SpitterController.class)
public class SpitterControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SpitterService spitterService;

	@Test
	public void testShowRegistrationForm() throws Exception {
		this.mockMvc.perform(get("/spitter/register")).andDo(print()).andExpect(status().isOk())
				.andExpect(view().name("registerForm"));
	}

	@Test
	public void testProcessRegistrationNull() throws Exception {

		given(spitterService.save(any())).willReturn(null);

		this.mockMvc
				.perform(post("/spitter/register"))
				.andExpect(status().isOk()).andExpect(view().name("registerForm")).andDo(print());

	}

	@Test
	public void testProcessRegistrationNotNull() throws Exception {

		given(spitterService.save(any())).willReturn(
				new Spitter("TestInputUserName", "TestInputPass", "TestInputFirst", "TestInputLast", "TestInputEmail"));

		this.mockMvc
				.perform(post("/spitter/register"))
				.andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/spitter/TestInputUserName")).andDo(print());

	}

	@Test
	public void testShowSpitterProfile() throws Exception {
		given(spitterService.findByUsername(anyString())).willReturn(new Spitter("TestUserName", "TestPass", "TestFirst", "TestLast", "TestEmail"));
		
		this.mockMvc.perform(get("/spitter/TestUserName")).andDo(print()).andExpect(status().isOk())
		.andExpect(view().name("profile"));
	}
}
