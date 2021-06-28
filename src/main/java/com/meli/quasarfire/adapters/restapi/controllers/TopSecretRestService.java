/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.adapters.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meli.quasarfire.adapters.restapi.api.TopSecretServiceApi;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretRequestDto;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretResponseDto;
import com.meli.quasarfire.adapters.restapi.exceptions.ExceptionResponseModel;
import com.meli.quasarfire.adapters.restapi.exceptions.IncorrectInformationException;
import com.meli.quasarfire.adapters.restapi.exceptions.NotPossibleInterceptShipInformationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
@RestController
@RequestMapping("/topsecret")
public class TopSecretRestService {
	
	@Autowired
	private TopSecretServiceApi topSecretServiceApi;
	
	/**
	 * This method returns enemy spaceship position and message intercepted
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 * @param topSecretRequestDto request object required
	 * @return TopSecretResponseDto response object with position and message
	 * @throws NotPossibleInterceptShipInformationException
	 * @throws IncorrectInformationException
	 */
	@Operation(summary = "Get enemy spaceship position and intercepted message")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Message and position found", 
				content = { @Content(mediaType = "application/json", 
				schema = @Schema(implementation = TopSecretResponseDto.class))}), 
			@ApiResponse(responseCode = "400", description = "Request is not correct", 
			content = { @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ExceptionResponseModel.class))}), 
			@ApiResponse(responseCode = "404", description = "Position or message can't be revealed", 
			content = { @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ExceptionResponseModel.class))}), 
			@ApiResponse(responseCode = "500", description = "Internal server error", 
			content = { @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ExceptionResponseModel.class))}), 
			})
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TopSecretResponseDto> getEnemyInformation(@Valid @RequestBody TopSecretRequestDto topSecretRequestDto)
			throws NotPossibleInterceptShipInformationException, IncorrectInformationException {
		return new ResponseEntity<>(topSecretServiceApi.getSpacialEnemyShipInformationService(topSecretRequestDto), HttpStatus.OK);
	}

}
