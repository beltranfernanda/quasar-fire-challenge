/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meli.quasarfire.domain.agregate.EnemySpaceInformationFacade;
import com.meli.quasarfire.domain.enums.MessageExceptions;
import com.meli.quasarfire.domain.exceptions.ArraysLengthMismatchException;
import com.meli.quasarfire.domain.exceptions.NotEnoughInformationException;
import com.meli.quasarfire.domain.exceptions.PointNotFoundException;
import com.meli.quasarfire.domain.model.Position;
import com.meli.quasarfire.domain.model.Satellite;
import com.meli.quasarfire.domain.repository.SatelliteRepository;

/**
 * Used as port to gives information about an enemy spaceship to split service
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
@Component
public class EnemySpaceShipSplitService {
	
	private EnemySpaceInformationFacade enemyShipInformation;
	private SatelliteRepository satelliteRepository;
	private static final int DISTANCE_LENGTH = 3;
	private static final int MESSAGE_LENGTH = 3;
	
	@Autowired
	public EnemySpaceShipSplitService(EnemySpaceInformationFacade enemyShipInformation, SatelliteRepository satelliteRepository) {
		this.enemyShipInformation = enemyShipInformation;
		this.satelliteRepository = satelliteRepository;
	}
	
	/**
	 * Permits save Satellite object in a list
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 * @param satellite
	 */
	public void storeSatellite(Satellite satellite) {
		satelliteRepository.saveSatellite(satellite);
	}
	
	/**
	 * Used to order satellites and returns position of enemy spaceship.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 * @return position object with enemy coordinates
	 * @throws NotEnoughInformationException thrown if length list are not equals to 3
	 * @throws PointNotFoundException thrown if not point of intersection is found
	 */
	public Position getEnemySpaceShipPosition() throws NotEnoughInformationException, PointNotFoundException {
		List<Satellite> satelliteList = satelliteRepository.getSatellites();
		if (satelliteList.size() < DISTANCE_LENGTH) {
			throw new NotEnoughInformationException(MessageExceptions.ERROR_NOT_ENOUGH_INFORMATION.getMessage());
		}
		float[] distances = new float[DISTANCE_LENGTH];
		List<Satellite> orderedList = enemyShipInformation.orderSatellitesList(satelliteList);
		for(int i = 0; i < distances.length; i++) {
			distances[i] = orderedList.get(i).getDistance();
		}
		return enemyShipInformation.getLocation(distances);	
	}
	
	/**
	 * Used to obtain the message intercepted by the satellites
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 * @return string message intercepted
	 * @throws NotEnoughInformationException thrown if length list are not equals to 3
	 * @throws ArraysLengthMismatchException thrown if not point of intersection is found
	 */
	public String getEnemySpaceShipMessage() throws NotEnoughInformationException, ArraysLengthMismatchException {
		List<Satellite> satelliteList = satelliteRepository.getSatellites();
		if(satelliteList.size() < MESSAGE_LENGTH) {
			throw new NotEnoughInformationException(MessageExceptions.ERROR_NOT_ENOUGH_INFORMATION.getMessage());
		}
		List<Satellite> orderedList = enemyShipInformation.orderSatellitesList(satelliteList);
		return enemyShipInformation.getMessage(orderedList.get(0).getMessage(),
				orderedList.get(1).getMessage(),
				orderedList.get(2).getMessage());
	}

}
