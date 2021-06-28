/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.adapters.restapi.enums;

/**
 * Enum with description of exceptions
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
public enum MessagesRestExceptions {
	ERROR_NOT_POSSIBLE_INTERCEPT_ENEMY_SPACESHIP_INFORMATION("Not possible to intercept enemy information"),
	ERROR_INCORRECT_INFORMATION_EXCEPTION("Parameter in request is incorrect"),
	ERROR_GENERAL("Error general"),
	;
	
	private String message;

	/**
	 * @param message
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	private MessagesRestExceptions(String message) {
		this.message = message;
	}

	/**
	 * @return Return value of field message
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message Set new value for field message
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
