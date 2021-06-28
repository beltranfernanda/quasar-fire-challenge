package com.meli.quasarfire.domain.utils;

import com.meli.quasarfire.domain.enums.MessageExceptions;
import com.meli.quasarfire.domain.exceptions.ArraysLengthMismatchException;
import com.meli.quasarfire.domain.exceptions.NotEnoughInformationException;

/**
 * Used to common operations with arrays.
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/22
 * @since 0.0.1 2021/06/22
 */
public class UtilArrays {
	
	private static final float TOLERANCE = (float) 0.2;

	private UtilArrays() {
	}

	/**
	 * Used to determine if two float arrays are equal.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/22
	 * @since 0.0.1 2021/06/22
	 * @param arrayOne
	 * @param arraytwo
	 * @return boolean result of comparison.
	 */
	public static boolean equalsTwoArrays(float[] arrayOne, float[] arraytwo) {
		if (arrayOne.length != arraytwo.length)
			return false;
		for (int i = 0; i < arrayOne.length; i++) {
			if (Math.abs(Math.abs(arrayOne[i]) - Math.abs(arraytwo[i])) > TOLERANCE)
				return false;
		}
		return true;
	}
	
	/**
	 * Used to determine if string array has blank spaces.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/23
	 * @since 0.0.1 2021/06/23
	 * @param arrayString
	 * @return boolean result of search.
	 */
	public static boolean arrayStringIsComplete(String[] arrayString) {
		for(String value : arrayString) {
			if(value.equals("")) return false;
		}
		return true;
	}
	
	/**
	 * Combine two string arrays and return a new one.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/23
	 * @since 0.0.1 2021/06/23
	 * @param firstArray
	 * @param secondArray
	 * @return string combined array.
	 * @throws ArraysLengthMismatchException
	 * @throws NotEnoughInformationException 
	 */
	public static String[] combineStringArrays(String[] firstArray, String[] secondArray) throws ArraysLengthMismatchException, NotEnoughInformationException {
		if(firstArray.length != secondArray.length) {
			throw new ArraysLengthMismatchException(MessageExceptions.ERROR_LENGTH_ARRAYS_MISMATCHED.getMessage());
		}
		String[] combinedArray = new String[firstArray.length];
		for(int i = 0; i < firstArray.length; i++) {
			if(firstArray[i].equals("")) {
				combinedArray[i] = secondArray[i];
			}else if(secondArray[i].equals("")) {
				combinedArray[i] = firstArray[i];
			}else if(!firstArray[i].equals(secondArray[i])) {
				throw new NotEnoughInformationException(MessageExceptions.ERROR_NOT_ENOUGH_INFORMATION.getMessage());
			}else {
				combinedArray[i] = firstArray[i];
			}
		}
		return combinedArray;
	}
	
	/**
	 * Convert string array to a string message
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/23
	 * @since 0.0.1 2021/06/23
	 * @param message
	 * @return string message
	 */
	public static String getStringMessage(String[] message) {
		StringBuilder convertedMessage = new StringBuilder();
		for(String value : message) {
			convertedMessage = convertedMessage.append(value + " ");
		}
		return convertedMessage.toString().trim();
	}

}
