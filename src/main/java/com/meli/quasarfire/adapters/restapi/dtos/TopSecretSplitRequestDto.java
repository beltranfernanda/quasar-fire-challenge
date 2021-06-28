/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/28
 * @since 0.0.1 2021/06/28
 */

package com.meli.quasarfire.adapters.restapi.dtos;

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
}
