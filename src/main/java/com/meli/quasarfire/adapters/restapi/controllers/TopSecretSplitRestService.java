/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */

package com.meli.quasarfire.adapters.restapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meli.quasarfire.adapters.restapi.api.TopSecretSplitServiceApi;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretResponseDto;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretSplitRequestDto;
import com.meli.quasarfire.adapters.restapi.exceptions.ExceptionResponseModel;
import com.meli.quasarfire.adapters.restapi.exceptions.IncorrectInformationException;
import com.meli.quasarfire.adapters.restapi.exceptions.NotPossibleInterceptShipInformationException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


/**
 * Rest service to save and return information about enemy spaceship
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */
@RestController
@RequestMapping("/topsecret_split")
public class TopSecretSplitRestService {
	
	@Autowired
	private TopSecretSplitServiceApi topSecretSplitServiceApi;
	
	/**
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/28
	 * @since 0.0.1 2021/06/28
	 * @param nameSatellite
	 * @param topSecretSplitRequestDto
	 * @return
	 */
	@Operation(summary = "Save Satellite information")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Satellite Saved", 
				content = { @Content(mediaType = "application/json", 
				schema = @Schema(implementation = ResponseEntity.class))}), 
			@ApiResponse(responseCode = "500", description = "Internal server error", 
			content = { @Content(mediaType = "application/json", 
			schema = @Schema(implementation = ExceptionResponseModel.class))}), 
	})
	@PostMapping(value = "/{satellite_name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveSatelliteInformation(@PathVariable("satellite_name") String nameSatellite,@Valid @RequestBody TopSecretSplitRequestDto topSecretSplitRequestDto){
		topSecretSplitServiceApi.saveSatellitesInformation(topSecretSplitRequestDto, nameSatellite);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	/**
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/28
	 * @since 0.0.1 2021/06/28
	 * @return
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
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TopSecretResponseDto> getEnemyInformation()
			throws NotPossibleInterceptShipInformationException, IncorrectInformationException {
		return new ResponseEntity<>(topSecretSplitServiceApi.getSpacialEnemyShipInformationService(), HttpStatus.OK);
	}
	


}
