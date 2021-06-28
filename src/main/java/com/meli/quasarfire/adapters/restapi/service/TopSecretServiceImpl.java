/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.adapters.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.quasarfire.adapters.restapi.api.TopSecretServiceApi;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretRequestDto;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretResponseDto;
import com.meli.quasarfire.adapters.restapi.enums.MessagesRestExceptions;
import com.meli.quasarfire.adapters.restapi.exceptions.IncorrectInformationException;
import com.meli.quasarfire.adapters.restapi.exceptions.NotPossibleInterceptShipInformationException;
import com.meli.quasarfire.domain.exceptions.ArraysLengthMismatchException;
import com.meli.quasarfire.domain.exceptions.NotEnoughInformationException;
import com.meli.quasarfire.domain.exceptions.PointNotFoundException;
import com.meli.quasarfire.domain.model.Position;
import com.meli.quasarfire.domain.services.EnemySpaceShipInformationService;

/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
@Service
public class TopSecretServiceImpl implements TopSecretServiceApi {

	@Autowired
	EnemySpaceShipInformationService domainEnemySpaceShipInformationService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.meli.quasarfire.adapters.restapi.api.TopSecretServiceApi#
	 * getSpacialEnemyShipInformationService(com.meli.quasarfire.adapters.restapi.
	 * dtos.TopSecretRequestDto)
	 */
	@Override
	public TopSecretResponseDto getSpacialEnemyShipInformationService(TopSecretRequestDto topSecretRequestDto) throws NotPossibleInterceptShipInformationException, IncorrectInformationException {
		try {
			String message = domainEnemySpaceShipInformationService.getEnemySpaceShipMessage(topSecretRequestDto.getSatellites());
			Position position = domainEnemySpaceShipInformationService.getEnemySpaceShipPosition(topSecretRequestDto.getSatellites());
			return new TopSecretResponseDto(position, message);
		} catch (NotEnoughInformationException | PointNotFoundException e) {
			throw new NotPossibleInterceptShipInformationException(MessagesRestExceptions.ERROR_NOT_POSSIBLE_INTERCEPT_ENEMY_SPACESHIP_INFORMATION.getMessage());
		} catch (ArraysLengthMismatchException e) {
			throw new IncorrectInformationException(MessagesRestExceptions.ERROR_INCORRECT_INFORMATION_EXCEPTION.getMessage());		
		}
	}

}
