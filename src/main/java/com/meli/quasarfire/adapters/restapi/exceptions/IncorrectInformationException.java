/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */

package com.meli.quasarfire.adapters.restapi.exceptions;

/**
 * Exception throws if data in request is wrong
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/27
 * @since 0.0.1 2021/06/27
 */
public class IncorrectInformationException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public IncorrectInformationException(String message) {
		super(message);
	}
	

}
