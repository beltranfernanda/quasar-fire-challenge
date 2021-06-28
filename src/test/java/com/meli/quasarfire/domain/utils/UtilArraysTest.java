package com.meli.quasarfire.domain.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.meli.quasarfire.domain.exceptions.ArraysLengthMismatchException;
import com.meli.quasarfire.domain.exceptions.NotEnoughInformationException;

/**
 * Test cases of UtilArrays class
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */
class UtilArraysTest {

	@Test
	void GivenTwoFloatEqualArraysWhenComparesThenReturnTrue() {
		//Given
		float[] arrayOne = { -2, 1 };
		float[] arrayTwo = { -2, 1 };
		//When-Then
		Assertions.assertTrue(UtilArrays.equalsTwoArrays(arrayOne, arrayTwo), "Value returned is not expected.");
	}

	@Test
	void GivenTwoFloatNotEqualArraysWhenComparesThenReturnFalse() {
		//Given
		float[] arrayOne = { 1, 1 };
		float[] arrayTwo = { -2, 1 };
		//When-Then
		Assertions.assertFalse(UtilArrays.equalsTwoArrays(arrayOne, arrayTwo), "Value returned is not expected.");
	}

	@Test
	void GivenTwoFloatNotEqualLengthArraysWhenComparesThenReturnFalse() {
		//Given
		float[] arrayOne = { -2, 1, 1 };
		float[] arrayTwo = { -2, 1 };
		//When-Then
		Assertions.assertFalse(UtilArrays.equalsTwoArrays(arrayOne, arrayTwo), "Length is equal.");
	}
	
	@Test
	void GivenStringArrayWithBlankSpaceValueWhenValidateArrayStringIsCompleteThenReturnFalse() {
		//Given
		String[] message = {"This","","a","secret","message"};
		//When-Then
		Assertions.assertFalse(UtilArrays.arrayStringIsComplete(message), "Value returned is no expected (expected false)");
	}
	
	@Test
	void GivenStringArrayWithoutBlankSpaceValueWhenValidateArrayStringIsCompleteThenReturnTrue() {
		//Given
		String[] message = {"This","is","a","secret","message"};
		//When-Then
		Assertions.assertTrue(UtilArrays.arrayStringIsComplete(message), "Value returned is no expected (expected true)");
	}
	
	@Test
	void GivenTwoStringArraysWithDifferentLengthWhenCombineTwoArraysThenThrowsArrayLengthMismatchException() {
		//Given
		String[] array1 = {"This","is","a","secret","message"};
		String[] array2 = {"This","is","","secret"};
		//When-Then
		Assertions.assertThrows(ArraysLengthMismatchException.class, () -> UtilArrays.combineStringArrays(array1, array2));
	}
	
	@Test
	void GivenTwoStringArraysWhenCombineTwoArraysThenReturnThirdOneCombined() throws ArraysLengthMismatchException, NotEnoughInformationException {
		//Given
		String[] array1 = {"This","is","a","secret",""};
		String[] array2 = {"This","is","","","message"};
		String[] expected = {"This","is","a","secret","message"};
		//When
		String[] actual = UtilArrays.combineStringArrays(array1, array2);
		//Then
		Assertions.assertArrayEquals(expected, actual, "Array returned is not expected");
	}
	
	@Test
	void GivenOneStringArrayWhenGetOneMessageThenReturnTheMessage() throws ArraysLengthMismatchException {
		//Given
		String[] message = {"This","is","a","secret","message"};
		String expected = "This is a secret message";
		//When
		String actual = UtilArrays.getStringMessage(message);
		//Then
		Assertions.assertEquals(expected, actual, "Message returned is not expected");
	}
}
