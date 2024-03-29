/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.domain.services;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.meli.quasarfire.domain.agregate.EnemySpaceInformationFacade;
import com.meli.quasarfire.domain.exceptions.ArraysLengthMismatchException;
import com.meli.quasarfire.domain.exceptions.NotEnoughInformationException;
import com.meli.quasarfire.domain.exceptions.PointNotFoundException;
import com.meli.quasarfire.domain.model.Position;
import com.meli.quasarfire.domain.model.Satellite;
import com.meli.quasarfire.domain.repository.SatelliteRepository;

/**
 * Test cases for EnemySpaceShipSplitService
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
class EnemySpaceShipSplitServiceTest {
	private static SatelliteRepository satelliteRepository;
	private static EnemySpaceShipSplitService enemySpaceShipSplitService;
	private static EnemySpaceInformationFacade enemyShipInformation;
	
	@BeforeAll
    public static void setUp() {
		satelliteRepository = Mockito.mock(SatelliteRepository.class);
		enemyShipInformation = new EnemySpaceInformationFacade();
		enemySpaceShipSplitService = new EnemySpaceShipSplitService(enemyShipInformation,satelliteRepository);
	}
	
	@Test
	void GivenThreeSatellitesWhenStoreSatellitesAndGetEnemySpaceShipPositionThenReturnPosition() throws NotEnoughInformationException, PointNotFoundException {
		//Given
		List<Satellite> satelliteList = new ArrayList<>();
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		satelliteList.add(satelliteBuilder.setName("Sato").setdistance((float) 583.095189).build());
		satelliteList.add(satelliteBuilder.setName("Kenobi").setdistance(500).build());
		satelliteList.add(satelliteBuilder.setName("Skywalker").setdistance((float) 141.421356).build());
		Mockito.doNothing().when(satelliteRepository).saveSatellite(satelliteBuilder.build());
		Mockito.doReturn(satelliteList).when(satelliteRepository).getSatellites();
		Position.Builder positionBuilder = new Position.Builder();
		//When
		enemySpaceShipSplitService.storeSatellite(satelliteList.get(0));
		enemySpaceShipSplitService.storeSatellite(satelliteList.get(1));
		enemySpaceShipSplitService.storeSatellite(satelliteList.get(2));
		Position positionActual = enemySpaceShipSplitService.getEnemySpaceShipPosition();
		// Then
		Assertions.assertEquals(positionActual.getCoordinateX(), positionBuilder.setCoordinateX(0).build().getCoordinateX(), "The coordinate returned in X is not equals to expected");
		Assertions.assertEquals(positionActual.getCoordinateY(),  positionBuilder.setCoordinateY(-200).build().getCoordinateY(), "The coordinate returned in Y is not equals to expected");
	}
	
	@Test
	void GivenThreeSatellitesWhenStoreSatellitesAndGetEnemySpaceShipMessageThenReturnMessage() throws NotEnoughInformationException, PointNotFoundException, ArraysLengthMismatchException {
		//Given
		List<Satellite> satelliteList = new ArrayList<>();
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		satelliteList.add(satelliteBuilder.setName("Sato").setMessage(new String[] {"Hello","",""}).build());
		satelliteList.add(satelliteBuilder.setName("Kenobi").setMessage(new String[] {"","world",""}).build());
		satelliteList.add(satelliteBuilder.setName("Skywalker").setMessage(new String[] {"","","forever"}).build());
		Mockito.doNothing().when(satelliteRepository).saveSatellite(satelliteBuilder.build());
		Mockito.doReturn(satelliteList).when(satelliteRepository).getSatellites();
		//When
		enemySpaceShipSplitService.storeSatellite(satelliteList.get(0));
		enemySpaceShipSplitService.storeSatellite(satelliteList.get(1));
		enemySpaceShipSplitService.storeSatellite(satelliteList.get(2));
		String messageExpected = "Hello world forever";
		String message = enemySpaceShipSplitService.getEnemySpaceShipMessage();
		// Then
		Assertions.assertEquals(message, messageExpected, "The message returned is not expected");
	}
	
	@Test
	void GivenTwoSatellitesWhenStoreSatellitesAndGetEnemySpaceShipPositionThenThrowsNotEnoughInformationException() throws NotEnoughInformationException, PointNotFoundException {
		//Given
		List<Satellite> satelliteList = new ArrayList<>();
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		satelliteList.add(satelliteBuilder.setName("Sato").setdistance((float) 583.095189).build());
		satelliteList.add(satelliteBuilder.setName("Kenobi").setdistance(500).build());
		Mockito.doNothing().when(satelliteRepository).saveSatellite(satelliteBuilder.build());
		Mockito.doReturn(satelliteList).when(satelliteRepository).getSatellites();
		//When
		enemySpaceShipSplitService.storeSatellite(satelliteList.get(0));
		enemySpaceShipSplitService.storeSatellite(satelliteList.get(1));
		// Then
		Assertions.assertThrows(NotEnoughInformationException.class, () -> enemySpaceShipSplitService.getEnemySpaceShipPosition());
	}
	
	@Test
	void GivenTwoSatellitesWhenStoreSatellitesAndGetEnemySpaceShipMessageThenThrowsNotEnoughInformationException() throws NotEnoughInformationException, PointNotFoundException, ArraysLengthMismatchException{
		//Given
		List<Satellite> satelliteList = new ArrayList<>();
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		satelliteList.add(satelliteBuilder.setName("Kenobi").setMessage(new String[] {"","world",""}).build());
		satelliteList.add(satelliteBuilder.setName("Skywalker").setMessage(new String[] {"","","forever"}).build());
		Mockito.doNothing().when(satelliteRepository).saveSatellite(satelliteBuilder.build());
		Mockito.doReturn(satelliteList).when(satelliteRepository).getSatellites();
		//When
		enemySpaceShipSplitService.storeSatellite(satelliteList.get(0));
		enemySpaceShipSplitService.storeSatellite(satelliteList.get(1));
		// Then
		Assertions.assertThrows(NotEnoughInformationException.class, () -> enemySpaceShipSplitService.getEnemySpaceShipMessage());
	}

	

}
