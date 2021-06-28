/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.domain.agregate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.meli.quasarfire.domain.exceptions.ArraysLengthMismatchException;
import com.meli.quasarfire.domain.exceptions.NotEnoughInformationException;
import com.meli.quasarfire.domain.exceptions.PointNotFoundException;
import com.meli.quasarfire.domain.model.Position;

/**
 * Test cases of EnemySpaceShipInformationFacade class
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
class EnemySpaceInformationFacadeTest {

	@Test
	void GivenFloatArrayOfSatelliteDistancesWhenGetEnemyShipPositionThenReturnsPosition() throws PointNotFoundException {
		// Given
		float[] distances = { 500, (float) 141.421356, (float) 583.095189 };
		Position.Builder positionBuilder = new Position.Builder();
		// When
		EnemySpaceInformationFacade enemySpaceInformationFacade = new EnemySpaceInformationFacade();
		Position actualPosition = enemySpaceInformationFacade.getLocation(distances[0], distances[1], distances[2]);
		// Then
		Assertions.assertEquals(actualPosition.getCoordinateX(), positionBuilder.setCoordinateX(0).build().getCoordinateX(), "The coordinate returned in X is not equals to expected");
		Assertions.assertEquals(actualPosition.getCoordinateY(),  positionBuilder.setCoordinateY(-200).build().getCoordinateY(), "The coordinate returned in Y is not equals to expected");
	}

	@Test
	void GivenFloatArrayOfSatelliteDistancesWithZeroDistancesValuesWhenGetEnemyShipPositionThenThrowsPointNotFoundException() throws PointNotFoundException {
		// Given
		float[] distances = { 10, 20, 30 };
		// When
		EnemySpaceInformationFacade enemySpaceInformationFacade = new EnemySpaceInformationFacade();
		// Then
		Assertions.assertThrows(PointNotFoundException.class, () -> enemySpaceInformationFacade.getLocation(distances[0], distances[1], distances[2]));
	}

	@Test
	void GivenStringsArraysOfSatellitesMessagesWhenGetMessageInterceptedThenReturnTheMessage() throws NotEnoughInformationException, ArraysLengthMismatchException {
		// Given
		String[] array1 = { "This", "is", "a", "", "" };
		String[] array2 = { "This", "", "", "secret", "message" };
		String[] array3 = { "This", "", "", "secret", "" };
		String messageExpected = "This is a secret message";
		// When
		EnemySpaceInformationFacade enemySpaceInformationFacade = new EnemySpaceInformationFacade();
		String message = enemySpaceInformationFacade.getMessage(array1, array2, array3);
		// Then
		Assertions.assertEquals(message, messageExpected, "The message returned is not expected");
	}

	@Test
	void GivenStringArraysOfSatellitesMessagesWithDifferentLengthWhenGetMessageInterceptedThenThrowsArraysLengthMismatchException() {
		// Given
		String[] array1 = { "This", "is", "a", "", "" };
		String[] array2 = { "This", "", "", "secret", "" };
		String[] array3 = { "This", "", "", "secret" };
		// When
		EnemySpaceInformationFacade enemySpaceInformationFacade = new EnemySpaceInformationFacade();
		// Then
		Assertions.assertThrows(ArraysLengthMismatchException.class, () -> enemySpaceInformationFacade.getMessage(array1, array2, array3));
	}

	@Test
	void GivenStringArraysOfSatellitesMessagesIncompleteWhenGetMessageInterceptedThenThrowsNotEnoughInformationException() {
		// Given
		String[] array1 = { "This", "is", "a", "", "" };
		String[] array2 = { "This", "", "", "secret", "" };
		String[] array3 = { "This", "", "", "secret", "" };
		// When
		EnemySpaceInformationFacade enemySpaceInformationFacade = new EnemySpaceInformationFacade();
		// Then
		Assertions.assertThrows(NotEnoughInformationException.class, () -> enemySpaceInformationFacade.getMessage(array1, array2, array3));
	}

}
