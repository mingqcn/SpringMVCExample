package spittr.view;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import spittr.entity.Spittle;
import spittr.service.SpittleService;

/**
 * Spittle控制器测试
 * @author mingqiu
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(SpittleController.class)
public class SpittleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SpittleService spittleService;

	@Test
	public void testSpittles() throws Exception {
		List<Spittle> spittles = new ArrayList<Spittle>();
		spittles.add(new Spittle("Hello", new Date()));
		given(spittleService.findSpittles(anyLong(), anyInt())).willReturn(spittles);

		this.mockMvc.perform(get("/spittles")).andDo(print()).andExpect(status().isOk())
				.andExpect(view().name("allSpittles"));
	}

	@Test
	public void testSpittle() throws Exception {

		given(spittleService.findOne(anyLong())).willReturn(new Spittle("Hello", new Date()));

		this.mockMvc.perform(get("/spittles/1")).andExpect(status().isOk()).andExpect(view().name("spittle"))
				.andExpect(model().attributeExists("spittle")).andDo(print());

	}

	
	@Test
	public void testSaveSpittle() throws Exception {


		this.mockMvc.perform(post("/spittles")).andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/spittles"))
				.andDo(print());
		
		then(spittleService).should(times(1)).save(any());

	}

}
