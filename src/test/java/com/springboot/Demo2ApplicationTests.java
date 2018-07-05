package com.springboot;

import com.springboot.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Demo2ApplicationTests {

	@MockBean
	private UserController userController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("1","1");
		Assert.isNull(map,"empty"); //isNull 等于 Assert.notNull()
		//调用getUserMap 方法的时候会返回 map
		Mockito.when(userController.getUserMap()).thenReturn(map);

	}

	@Test
	public void controllerTest() throws  Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
