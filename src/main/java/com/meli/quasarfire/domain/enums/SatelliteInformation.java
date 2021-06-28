/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */

package com.meli.quasarfire.domain.enums;

/**
 * Used to define Satellite atributes constants
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */
public enum SatelliteInformation {
	KENOBI("Kenobi",new float[] {-500,-200}),
	SKYWALKER("Skywalker", new float[] {100,-100}),
	SATO("Sato",new float[] {500,100});	
	
	private String name;
	private float [] position;
	/**
	 * @param name
	 * @param position
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/26
	 * @since 0.0.1 2021/06/26
	 */
	private SatelliteInformation(String name, float[] position) {
		this.name = name;
		this.position = position;
	}
	/**
	 * @return Return value of field name
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/26
	 * @since 0.0.1 2021/06/26
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return Return value of field position
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/26
	 * @since 0.0.1 2021/06/26
	 */
	public float[] getPosition() {
		return position;
	}
}
