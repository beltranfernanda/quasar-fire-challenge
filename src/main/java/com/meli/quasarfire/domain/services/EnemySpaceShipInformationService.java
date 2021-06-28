/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
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


/**
 * Used as port to gives information about an enemy spaceship
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */
@Component
public class EnemySpaceShipInformationService {

	private EnemySpaceInformationFacade enemyShipInformation;
	private static final int DISTANCE_LENGTH = 3;
	private static final int MESSAGE_LENGTH = 3;
	
	@Autowired
	public EnemySpaceShipInformationService(EnemySpaceInformationFacade enemyShipInformation) {
		this.enemyShipInformation = enemyShipInformation;	
	}
	
	/**
	 * Used to order satellites and returns position of enemy spaceship.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 * @param satelliteList list of satellites (must be 3)
	 * @return position object with enemy coordinates
	 * @throws NotEnoughInformationException thrown if length list are not equals to 3
	 * @throws PointNotFoundException thrown if not point of intersection is found
	 */
	public Position getEnemySpaceShipPosition(List<Satellite> satelliteList) throws NotEnoughInformationException, PointNotFoundException {
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
	 * @param satelliteList list of satellites (must be 3)
	 * @return string message intercepted
	 * @throws NotEnoughInformationException thrown if length list are not equals to 3
	 * @throws ArraysLengthMismatchException thrown if not point of intersection is found
	 */
	public String getEnemySpaceShipMessage(List<Satellite> satelliteList) throws NotEnoughInformationException, ArraysLengthMismatchException {
		if(satelliteList.size() < MESSAGE_LENGTH) {
			throw new NotEnoughInformationException(MessageExceptions.ERROR_NOT_ENOUGH_INFORMATION.getMessage());
		}
		List<Satellite> orderedList = enemyShipInformation.orderSatellitesList(satelliteList);
		return enemyShipInformation.getMessage(orderedList.get(0).getMessage(),
				orderedList.get(1).getMessage(),
				orderedList.get(2).getMessage());
	}
	
	
	
}
