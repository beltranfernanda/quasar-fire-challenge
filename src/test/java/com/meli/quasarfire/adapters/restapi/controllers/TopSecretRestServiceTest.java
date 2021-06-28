/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */

package com.meli.quasarfire.adapters.restapi.controllers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.quasarfire.adapters.restapi.api.TopSecretServiceApi;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretRequestDto;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretResponseDto;
import com.meli.quasarfire.adapters.restapi.exceptions.IncorrectInformationException;
import com.meli.quasarfire.adapters.restapi.exceptions.NotPossibleInterceptShipInformationException;
import com.meli.quasarfire.domain.model.Position;

/**
 * Unit test cases of TopSecretRestService
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */
@WebMvcTest(controllers = TopSecretRestService.class)
class TopSecretRestServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TopSecretServiceApi topSecretServiceApi;
	
	@Autowired
    private ObjectMapper objectMapper;
		
	@Test
	void GivenTopSecretRequestDtoWhenGetEnemySpaceShipInformationThenReturnTopSecretResponseDtoObject() throws Exception {
		//Given
		Position.Builder positionBuilder = new Position.Builder();
		TopSecretResponseDto topSecretResponseDto = new TopSecretResponseDto(positionBuilder.build(),"");
		TopSecretRequestDto topSecretRequestDto = new TopSecretRequestDto();
		Mockito.doReturn(topSecretResponseDto).when(this.topSecretServiceApi).getSpacialEnemyShipInformationService(topSecretRequestDto);
		//When
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/topsecret/");
		requestBuilder.contentType(MediaType.APPLICATION_JSON);
		requestBuilder.content(objectMapper.writeValueAsBytes(topSecretRequestDto));
		//Then
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.content().string(objectMapper.writeValueAsString(topSecretResponseDto)));
	}
	
	@Test
	void GivenAnUnexpectedErrorWhenGetEnemySpaceShipInformationThenReturnInternalServerError() throws Exception {
		//Given
		TopSecretRequestDto topSecretRequestDto = new TopSecretRequestDto();
		Mockito.doThrow(new NullPointerException()).when(this.topSecretServiceApi).getSpacialEnemyShipInformationService(topSecretRequestDto);
		//When
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/topsecret/");
		requestBuilder.contentType(MediaType.APPLICATION_JSON);
		requestBuilder.content(objectMapper.writeValueAsBytes(topSecretRequestDto));
		//Then
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
		resultActions.andExpect(MockMvcResultMatchers.status().isInternalServerError());
	}
	
	@Test
	void GivenAnIncorrectRequestErrorWhenGetEnemySpaceShipInformationThenReturnBadRequest() throws Exception {
		//Given
		TopSecretRequestDto topSecretRequestDto = new TopSecretRequestDto();
		Mockito.doThrow(new IncorrectInformationException("bad request")).when(this.topSecretServiceApi).getSpacialEnemyShipInformationService(topSecretRequestDto);
		//When
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/topsecret/");
		requestBuilder.contentType(MediaType.APPLICATION_JSON);
		requestBuilder.content(objectMapper.writeValueAsBytes(topSecretRequestDto));
		//Then
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
		resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	void GivenNotPossibleInterceptionErrorWhenGetEnemySpaceShipInformationThenReturnNotFound() throws Exception {
		//Given
		TopSecretRequestDto topSecretRequestDto = new TopSecretRequestDto();
		Mockito.doThrow(new NotPossibleInterceptShipInformationException("not interception point")).when(this.topSecretServiceApi).getSpacialEnemyShipInformationService(topSecretRequestDto);
		//When
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/topsecret/");
		requestBuilder.contentType(MediaType.APPLICATION_JSON);
		requestBuilder.content(objectMapper.writeValueAsBytes(topSecretRequestDto));
		//Then
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
		resultActions.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
