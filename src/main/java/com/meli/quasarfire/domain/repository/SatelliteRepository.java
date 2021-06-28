/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */

package com.meli.quasarfire.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.meli.quasarfire.domain.model.Satellite;

/**
 * Used as port to store information about a Satellite
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */
@Repository
public interface SatelliteRepository {
	
	public void saveSatellite(Satellite satellite);
	
	public List<Satellite> getSatellites();
}
