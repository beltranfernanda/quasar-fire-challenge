package com.meli.quasarfire.domain.exceptions;


/**
 * Used to customize exception when Cartesian point is not found.
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/22
 * @since 0.0.1 2021/06/22
 */
public class PointNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PointNotFoundException(String message) {
		super(message);
	}

}
