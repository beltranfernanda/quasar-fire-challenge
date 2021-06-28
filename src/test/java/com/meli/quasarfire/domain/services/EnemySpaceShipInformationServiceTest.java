/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.domain.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.meli.quasarfire.domain.agregate.EnemySpaceInformationFacade;
import com.meli.quasarfire.domain.exceptions.ArraysLengthMismatchException;
import com.meli.quasarfire.domain.exceptions.NotEnoughInformationException;
import com.meli.quasarfire.domain.exceptions.PointNotFoundException;
import com.meli.quasarfire.domain.model.Position;
import com.meli.quasarfire.domain.model.Satellite;


/**
 * Test cases of EnemySpaceShipInformationService class
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
class EnemySpaceShipInformationServiceTest {
	
	@Test
	void GivenSatelliteListWhenGetEnemyPositionThenReturnPosition() throws NotEnoughInformationException, PointNotFoundException {
		// Given
		List<Satellite> satelliteList = new ArrayList<>();
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		satelliteList.add(satelliteBuilder.setName("Sato").setdistance((float) 583.095189).build());
		satelliteList.add(satelliteBuilder.setName("Kenobi").setdistance(500).build());
		satelliteList.add(satelliteBuilder.setName("Skywalker").setdistance((float) 141.421356).build());
		Position.Builder positionBuilder = new Position.Builder();
		// When
		EnemySpaceShipInformationService enemySpaceShipInformationService = new EnemySpaceShipInformationService(new EnemySpaceInformationFacade());
		Position positionActual = enemySpaceShipInformationService.getEnemySpaceShipPosition(satelliteList);
		// Then
		Assertions.assertEquals(positionActual.getCoordinateX(), positionBuilder.setCoordinateX(0).build().getCoordinateX(), "The coordinate returned in X is not equals to expected");
		Assertions.assertEquals(positionActual.getCoordinateY(),  positionBuilder.setCoordinateY(-200).build().getCoordinateY(), "The coordinate returned in Y is not equals to expected");
	}
	
	@Test
	void GivenSatelliteListWithTwoItemsWhenGetEnemyPositionThenThrowsNotEnoughInformationException(){
		// Given
		List<Satellite> satelliteList = new ArrayList<>();
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		satelliteList.add(satelliteBuilder.setName("Sato").setdistance((float) 583.095189).build());
		satelliteList.add(satelliteBuilder.setName("Kenobi").setdistance(500).build());
		// When
		EnemySpaceShipInformationService enemySpaceShipInformationService = new EnemySpaceShipInformationService(new EnemySpaceInformationFacade());
		//Then
		Assertions.assertThrows(NotEnoughInformationException.class, () -> enemySpaceShipInformationService.getEnemySpaceShipPosition(satelliteList));
	}
	
	@Test
	void GivenSatelliteListWhenGetEnemyMessageThenReturnMessage() throws NotEnoughInformationException, ArraysLengthMismatchException{
		// Given
		List<Satellite> satelliteList = new ArrayList<>();
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		satelliteList.add(satelliteBuilder.setName("Sato").setMessage(new String[] {"Hello","",""}).build());
		satelliteList.add(satelliteBuilder.setName("Kenobi").setMessage(new String[] {"","world",""}).build());
		satelliteList.add(satelliteBuilder.setName("Skywalker").setMessage(new String[] {"","","forever"}).build());
		// When
		EnemySpaceShipInformationService enemySpaceShipInformationService = new EnemySpaceShipInformationService(new EnemySpaceInformationFacade());
		String messageExpected = "Hello world forever";
		String message = enemySpaceShipInformationService.getEnemySpaceShipMessage(satelliteList);
		// Then
		Assertions.assertEquals(message, messageExpected, "The message returned is not expected");
	}
	
	@Test
	void GivenSatelliteListWithTwoItemsWhenGetEnemyMessageThenThrowsNotEnoughInformationException(){
		// Given
		List<Satellite> satelliteList = new ArrayList<>();
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		satelliteList.add(satelliteBuilder.setName("Sato").setMessage(new String[] {"Hello","","forever"}).build());
		satelliteList.add(satelliteBuilder.setName("Kenobi").setMessage(new String[] {"Hello","world",""}).build());
		// When
		EnemySpaceShipInformationService enemySpaceShipInformationService = new EnemySpaceShipInformationService(new EnemySpaceInformationFacade());
		//Then
		Assertions.assertThrows(NotEnoughInformationException.class, () -> enemySpaceShipInformationService.getEnemySpaceShipMessage(satelliteList));
	}
}
