/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.adapters.restapi.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.meli.quasarfire.domain.model.Satellite;

/**
 * Model of request top secret service rest
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
public class TopSecretRequestDto {
	@NotBlank
	private List<Satellite> satellites;

	/**
	 * @return Return value of field satellites
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	public List<Satellite> getSatellites() {
		return satellites;
	}

	/**
	 * @param satellites Set new value for field satellites
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TopSecretRequestDto [satellites=" + satellites + "]";
	}
}
