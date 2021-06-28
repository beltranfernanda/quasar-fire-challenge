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
import com.meli.quasarfire.adapters.restapi.api.TopSecretSplitServiceApi;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretResponseDto;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretSplitRequestDto;
import com.meli.quasarfire.adapters.restapi.exceptions.IncorrectInformationException;
import com.meli.quasarfire.adapters.restapi.exceptions.NotPossibleInterceptShipInformationException;
import com.meli.quasarfire.domain.model.Position;


/**
 * Unit test cases of TopSecretSplitRestService
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */
@WebMvcTest(controllers = TopSecretSplitRestService.class)
class TopSecretSplitRestServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TopSecretSplitServiceApi topSecretSplitServiceApi;
	
	@Autowired
    private ObjectMapper objectMapper;
		
	@Test
	void GivenTopSecretSplitRequestDtoWhenSaveSatelliteInformationThenReturnCreated() throws Exception {
		//Given
		TopSecretSplitRequestDto topSecretSplitRequestDto = new TopSecretSplitRequestDto();
		Mockito.doNothing().when(this.topSecretSplitServiceApi).saveSatellitesInformation(topSecretSplitRequestDto,"Sato");
		//When
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/topsecret_split/Sato");
		requestBuilder.contentType(MediaType.APPLICATION_JSON);
		requestBuilder.content(objectMapper.writeValueAsBytes(topSecretSplitRequestDto));
		//Then
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
		resultActions.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	void GivenRequestWhenGetEnemySpaceShipInformationThenReturnEnemySpaceshipInformation() throws Exception {
		//Given
		Position.Builder positionBuilder = new Position.Builder();
		TopSecretResponseDto topSecretResponseDto = new TopSecretResponseDto(positionBuilder.build(),"");
		Mockito.doReturn(topSecretResponseDto).when(this.topSecretSplitServiceApi).getSpacialEnemyShipInformationService();
		//When
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/topsecret_split/");
		//Then
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
		resultActions.andExpect(MockMvcResultMatchers.content().string(this.objectMapper.writeValueAsString(topSecretResponseDto)));
	}
	
	@Test
	void GivenAnUnexpectedErrorWhenGetEnemySpaceShipInformationThenReturnInternalServerError() throws Exception {
		//Given
		Mockito.doThrow(new NullPointerException()).when(this.topSecretSplitServiceApi).getSpacialEnemyShipInformationService();
		//When
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/topsecret_split/");
		//Then
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
		resultActions.andExpect(MockMvcResultMatchers.status().isInternalServerError());
	}
	
	@Test
	void GivenAnIncorrectRequestErrorWhenGetEnemySpaceShipInformationThenReturnBadRequest() throws Exception {
		//Given
		Mockito.doThrow(new IncorrectInformationException("bad request")).when(this.topSecretSplitServiceApi).getSpacialEnemyShipInformationService();
		//When
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/topsecret_split/");
		//Then
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
		resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	void GivenNotPossibleInterceptionErrorWhenGetEnemySpaceShipInformationThenReturnNotFound() throws Exception {
		//Given
		Mockito.doThrow(new NotPossibleInterceptShipInformationException("not interception point")).when(this.topSecretSplitServiceApi).getSpacialEnemyShipInformationService();
		//When
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/topsecret_split/");
		//Then
		ResultActions resultActions = this.mockMvc.perform(requestBuilder);
		resultActions.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
