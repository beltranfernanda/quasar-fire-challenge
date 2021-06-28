package com.meli.quasarfire.domain.exceptions;


/**
 * Used to customize exception when two arrays length is different.
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/23
 * @since 0.0.1 2021/06/23
 */
public class ArraysLengthMismatchException extends Exception{

	private static final long serialVersionUID = 1L;


	public ArraysLengthMismatchException(String message) {
		super(message);
	}

}
