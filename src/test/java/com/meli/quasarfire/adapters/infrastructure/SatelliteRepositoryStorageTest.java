/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.adapters.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.meli.quasarfire.domain.model.Satellite;

/**
 * Test cases of SatelliteRepositoryStorage
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
class SatelliteRepositoryStorageTest {
	
	@Test
	void GivenTwoSatellitesWhenSaveSatelliteThenGetListOfTwoSatellites() {
		//Given
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		List<Satellite> satelliteListExpected = new ArrayList<>();
		satelliteListExpected.add(satelliteBuilder.setName("Sato").setdistance(200).setMessage(new String[] { "Hello", "", "world" }).build());
		satelliteListExpected.add(satelliteBuilder.setName("Kenobi").setdistance(200).setMessage(new String[] { "Hello", "beautiful", "" }).build());
		//When
		SatelliteRepositoryStorage satelliteRepositoryStorage = new SatelliteRepositoryStorage();
		satelliteRepositoryStorage.saveSatellite(satelliteBuilder.setName("Sato").setdistance(200).setMessage(new String[] { "Hello", "", "world" }).build());
		satelliteRepositoryStorage.saveSatellite(satelliteBuilder.setName("Kenobi").setdistance(200).setMessage(new String[] { "Hello", "beautiful", "" }).build());
		//Then
		Assertions.assertEquals(satelliteListExpected, satelliteRepositoryStorage.getSatellites(), "List returned is not expected");
	}

	@Test
	void GivenTwoEqualsSatellitesWhenSaveSatelliteThenGetListOfOneSatellite() {
		//Given
		Satellite.Builder satelliteBuilder = new Satellite.Builder();
		List<Satellite> satelliteListExpected = new ArrayList<>();
		satelliteListExpected.add(satelliteBuilder.setName("Sato").setdistance(200).setMessage(new String[] { "Hello", "world", "" }).build());
		//When
		SatelliteRepositoryStorage satelliteRepositoryStorage = new SatelliteRepositoryStorage();
		satelliteRepositoryStorage.saveSatellite(satelliteBuilder.setName("Sato").setdistance(200).setMessage(new String[] { "Hello", "beautiful", "" }).build());
		satelliteRepositoryStorage.saveSatellite(satelliteBuilder.setName("Sato").setdistance(200).setMessage(new String[] { "Hello", "world", "" }).build());
		//Then
		Assertions.assertEquals(satelliteListExpected, satelliteRepositoryStorage.getSatellites(), "List returned is not expected");
	}

}
