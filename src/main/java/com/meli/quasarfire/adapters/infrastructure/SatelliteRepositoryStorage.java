/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.adapters.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.meli.quasarfire.domain.model.Satellite;
import com.meli.quasarfire.domain.repository.SatelliteRepository;

/**
 * Permits store satellites in a list
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
@Component
public class SatelliteRepositoryStorage implements SatelliteRepository{
		
	private List<Satellite> satelliteList;
	
	public SatelliteRepositoryStorage(){
		this.satelliteList =  new ArrayList<>();
	}
	
	/**
	 * @return Return value of field satelliteList
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	private List<Satellite> getSatelliteList() {
		return satelliteList;
	}

	/* (non-Javadoc)
	 * @see com.meli.quasarfire.domain.repository.SatelliteRepository#saveSatellite(com.meli.quasarfire.domain.model.Satellite)
	 */
	@Override
	public void saveSatellite(Satellite satellite) {
		int indexSatellite = indexOfSatellite(satellite);
		if(indexSatellite != -1) satelliteList.remove(indexSatellite);
		satelliteList.add(satellite);
	}

	/* (non-Javadoc)
	 * @see com.meli.quasarfire.domain.repository.SatelliteRepository#getSatellites()
	 */
	@Override
	public List<Satellite> getSatellites() {
		return this.getSatelliteList();
	}
		
	/**
	 * Used to determine if satellite item already exist
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 * @param satellite
	 * @return position of satellite in list
	 */
	private int indexOfSatellite(Satellite satellite) {
		for(int i=0; i<satelliteList.size(); i++) {
		if(satelliteList.get(i).getName().equalsIgnoreCase(satellite.getName()))
			return i;
		}
		return -1;
	}
}
