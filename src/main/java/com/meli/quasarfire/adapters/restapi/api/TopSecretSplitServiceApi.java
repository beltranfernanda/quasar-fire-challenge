/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */

package com.meli.quasarfire.adapters.restapi.api;


import com.meli.quasarfire.adapters.restapi.dtos.TopSecretResponseDto;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretSplitRequestDto;
import com.meli.quasarfire.adapters.restapi.exceptions.IncorrectInformationException;
import com.meli.quasarfire.adapters.restapi.exceptions.NotPossibleInterceptShipInformationException;

/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */
public interface TopSecretSplitServiceApi {
	
	/**
	 * Used to save satellite information through domain layer
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/28
	 * @since 0.0.1 2021/06/28
	 * @param satellite object
	 */
	void saveSatellitesInformation(TopSecretSplitRequestDto topSecretSplitRequestDto, String nameSatellite);
	
	
	/**
	 * Used to get enemy spaceship information through domain layer
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/28
	 * @since 0.0.1 2021/06/28
	 * @return topSecretResponseDto with enemy spaceship message and position
	 */
	TopSecretResponseDto getSpacialEnemyShipInformationService() throws NotPossibleInterceptShipInformationException, IncorrectInformationException;
}
