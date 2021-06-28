/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */

package com.meli.quasarfire.domain.agregate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.meli.quasarfire.domain.enums.MessageExceptions;
import com.meli.quasarfire.domain.enums.SatelliteInformation;
import com.meli.quasarfire.domain.exceptions.ArraysLengthMismatchException;
import com.meli.quasarfire.domain.exceptions.NotEnoughInformationException;
import com.meli.quasarfire.domain.exceptions.PointNotFoundException;
import com.meli.quasarfire.domain.model.Position;
import com.meli.quasarfire.domain.model.Satellite;
import com.meli.quasarfire.domain.utils.Trilateration;
import com.meli.quasarfire.domain.utils.UtilArrays;

/**
 * Used to implement logic about enemy spaceship information
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */
@Component
public class EnemySpaceInformationFacade {

	/**
	 * Used to calculate the position of an enemy spaceship
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/26
	 * @since 0.0.1 2021/06/26
	 * @param distances array with distances intercepted by satellites
	 * @return float position vector (X and Y coordinates)
	 * @throws PointNotFoundException if point of trilateration is not found
	 */
	public Position getLocation(float... distances) throws PointNotFoundException {
		float[] position = Trilateration.locationWithThreePoints(SatelliteInformation.KENOBI.getPosition(), distances[0], SatelliteInformation.SKYWALKER.getPosition(), distances[1],
				SatelliteInformation.SATO.getPosition(), distances[2]);
		Position.Builder positionFoundBuilder = new Position.Builder();
		return positionFoundBuilder.setCoordinateX(position[0]).setCoordinateY(position[1]).build();
	}

	/**
	 * Used to obtain the message intercepted by satellites
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/26
	 * @since 0.0.1 2021/06/26
	 * @param messages arrays of messages intercepted
	 * @return string message intercepted and converted
	 * @throws NotEnoughInformationException thrown if final array is not complete
	 * @throws ArraysLengthMismatchException thrown if messages arrays length are
	 *not equals
	 */
	public String getMessage(String[]... messages) throws NotEnoughInformationException, ArraysLengthMismatchException {
		String[] firstCombination = UtilArrays.combineStringArrays(messages[0], messages[1]);
		String[] finalCombination = UtilArrays.combineStringArrays(firstCombination, messages[2]);
		if (!UtilArrays.arrayStringIsComplete(finalCombination))
			throw new NotEnoughInformationException(MessageExceptions.ERROR_NOT_ENOUGH_INFORMATION.getMessage());
		return UtilArrays.getStringMessage(finalCombination);
	}
	
	public List<Satellite> orderSatellitesList(List<Satellite> listSatellites){
		List<Satellite> orderedList =  new ArrayList<>();
		int[] pivot = new int[3];
		for(int i = 0; i< listSatellites.size(); i++) {
			if(listSatellites.get(i).getName().equalsIgnoreCase(SatelliteInformation.KENOBI.getName())) {
				pivot[0] = i;
			} 
			if(listSatellites.get(i).getName().equalsIgnoreCase(SatelliteInformation.SKYWALKER.getName())) {
				pivot[1] = i;
			}
			if(listSatellites.get(i).getName().equalsIgnoreCase(SatelliteInformation.SATO.getName())) {
				pivot[2] = i;
			}
		}
		orderedList.add(listSatellites.get(pivot[0]));
		orderedList.add(listSatellites.get(pivot[1]));
		orderedList.add(listSatellites.get(pivot[2]));
		return orderedList;
	}

}
