package com.meli.quasarfire.domain.enums;

/**
 * Used to set error constants.
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/22
 * @since 0.0.1 2021/06/22
 */
public enum MessageExceptions {
	ERROR_POINT_NOT_FOUND("Cartesian point was not found"),
	ERROR_LENGTH_ARRAYS_MISMATCHED("Array lengths are not equal"),
	ERROR_NOT_ENOUGH_INFORMATION("Distances or string messages arrays are not complete"),
	;
	
	private String message;

	/**
	 * @param message
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/26
	 * @since 0.0.1 2021/06/26
	 */
	private MessageExceptions(String message) {
		this.message = message;
	}

	/**
	 * @return Return value of field message
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/26
	 * @since 0.0.1 2021/06/26
	 */
	public String getMessage() {
		return message;
	}
}
