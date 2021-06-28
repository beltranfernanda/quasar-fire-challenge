/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.adapters.restapi.api;

import com.meli.quasarfire.adapters.restapi.dtos.TopSecretRequestDto;
import com.meli.quasarfire.adapters.restapi.dtos.TopSecretResponseDto;
import com.meli.quasarfire.adapters.restapi.exceptions.IncorrectInformationException;
import com.meli.quasarfire.adapters.restapi.exceptions.NotPossibleInterceptShipInformationException;

public interface TopSecretServiceApi {
	
	/**
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 * @param topSecretRequestDto
	 * @return
	 */
	TopSecretResponseDto getSpacialEnemyShipInformationService(TopSecretRequestDto topSecretRequestDto) throws NotPossibleInterceptShipInformationException, IncorrectInformationException;

}
