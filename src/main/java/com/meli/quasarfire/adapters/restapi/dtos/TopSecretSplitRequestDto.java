/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */

package com.meli.quasarfire.adapters.restapi.dtos;

import java.util.Arrays;

/**
 * Model of top secret split service response
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */
public class TopSecretSplitRequestDto {
	private float distance;
	private String[] message;
	
	/**
	 * @return Return value of field distance
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/28
	 * @since 0.0.1 2021/06/28
	 */
	public float getDistance() {
		return distance;
	}
	/**
	 * @param distance Set new value for field distance
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/28
	 * @since 0.0.1 2021/06/28
	 */
	public void setDistance(float distance) {
		this.distance = distance;
	}
	/**
	 * @return Return value of field message
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/28
	 * @since 0.0.1 2021/06/28
	 */
	public String[] getMessage() {
		return message;
	}
	/**
	 * @param message Set new value for field message
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/28
	 * @since 0.0.1 2021/06/28
	 */
	public void setMessage(String[] message) {
		this.message = message;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(distance);
		result = prime * result + Arrays.hashCode(message);
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopSecretSplitRequestDto other = (TopSecretSplitRequestDto) obj;
		if (Float.floatToIntBits(distance) != Float.floatToIntBits(other.distance))
			return false;
		if (!Arrays.equals(message, other.message))
			return false;
		return true;
	}
}
