/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */

package com.meli.quasarfire.adapters.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meli.quasarfire.adapters.restapi.api.TopSecretSplitServiceApi;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretResponseDto;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretSplitRequestDto;
import com.meli.quasarfire.adapters.restapi.enums.MessagesRestExceptions;
import com.meli.quasarfire.adapters.restapi.exceptions.IncorrectInformationException;
import com.meli.quasarfire.adapters.restapi.exceptions.NotPossibleInterceptShipInformationException;
import com.meli.quasarfire.domain.exceptions.ArraysLengthMismatchException;
import com.meli.quasarfire.domain.exceptions.NotEnoughInformationException;
import com.meli.quasarfire.domain.exceptions.PointNotFoundException;
import com.meli.quasarfire.domain.model.Position;
import com.meli.quasarfire.domain.model.Satellite;
import com.meli.quasarfire.domain.services.EnemySpaceShipSplitService;

/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */
@Service
public class TopSecretSplitServiceImpl implements TopSecretSplitServiceApi{
	
	@Autowired
	EnemySpaceShipSplitService domainEnemySpaceShipSplitService;

	/* (non-Javadoc)
	 * @see com.meli.quasarfire.adapters.restapi.api.TopSecretSplitServiceApi#saveSatellitesInformation(com.meli.quasarfire.domain.model.Satellite)
	 */
	@Override
	public void saveSatellitesInformation(TopSecretSplitRequestDto topSecretSplitRequestDto, String nameSatellite) {
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		domainEnemySpaceShipSplitService.storeSatellite(satelliteBuilder.setName(nameSatellite)
				.setdistance(topSecretSplitRequestDto.getDistance())
				.setMessage(topSecretSplitRequestDto.getMessage()).build());
	}

	/* (non-Javadoc)
	 * @see com.meli.quasarfire.adapters.restapi.api.TopSecretSplitServiceApi#getSpacialEnemyShipInformationService()
	 */
	@Override
	public TopSecretResponseDto getSpacialEnemyShipInformationService() throws NotPossibleInterceptShipInformationException, IncorrectInformationException {
		try {
			String message = domainEnemySpaceShipSplitService.getEnemySpaceShipMessage();
			Position position = domainEnemySpaceShipSplitService.getEnemySpaceShipPosition();
			return new TopSecretResponseDto(position, message);
		} catch (NotEnoughInformationException | PointNotFoundException e) {
			throw new NotPossibleInterceptShipInformationException(MessagesRestExceptions.ERROR_NOT_POSSIBLE_INTERCEPT_ENEMY_SPACESHIP_INFORMATION.getMessage());
		} catch (ArraysLengthMismatchException e) {
			throw new IncorrectInformationException(MessagesRestExceptions.ERROR_INCORRECT_INFORMATION_EXCEPTION.getMessage());		
		}
	}

}
