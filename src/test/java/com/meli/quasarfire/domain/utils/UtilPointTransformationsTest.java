package com.meli.quasarfire.domain.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test cases of UtilPointTransformations class
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/21
 * @since 0.0.1 2021/06/21
 */
class UtilPointTransformationsTest {


	@Test
	void GivenOnePointAndRotationAngleWhenRotatePointThenReturnRotatedPoint() {
		//Given
		float[] cartesian = { 2, 2 };
		float[] expected = { 2, -2 };
		float theta = (float) (Math.PI / 2);
		//When
		float[] actual = UtilPointTransformations.rotate(cartesian, theta);
		float delta = (float) 0.1;
		//Then
		Assertions.assertArrayEquals(expected, actual, delta, "Value returned must be expected when rotate point");
	}


	@Test
	void GivenOnePointAndTranslationCoordinatesWhenTranslatePointThenReturnTranslatedPoint() {
		//Given
		float[] cartesian = new float[] { 2, 2 };
		float[] translation = new float[] { 3, -4 };
		float[] expected = new float[] { 5, -2 };
		//When
		float[] actual = UtilPointTransformations.translate(cartesian, translation);
		float delta = (float) 0.1;
		//Then
		Assertions.assertArrayEquals(expected, actual, delta, "Value returned must be expected when translate point");
	}


	@Test
	void GivenOnePointWithXValueZeroWhenGetAngleThenReturnValidValue() {
		//Given
		float[] cartesian = { 0, -2 };
		float expected = (float) (-1 * Math.PI / 2);
		//When
		float actual = UtilPointTransformations.getAngle(cartesian);
		float delta = (float) 0.1;
		//Then
		Assertions.assertEquals(expected, actual, delta, "Value returned must be -pi/2");
	}


	@Test
	void GivenOnePointWithYValueZeroWhenGetAngleThenReturnValidValue() {
		//Given
		float[] cartesian = { -2, 0 };
		float expected = (float) (Math.PI);
		//When
		float actual = UtilPointTransformations.getAngle(cartesian);
		float delta = (float) 0.1;
		//Then
		Assertions.assertEquals(expected, actual, delta, "Value returned must be pi");
	}


	@Test
	void GivenOnePointWithYAndXValuesZeroWhenGetAngleThenReturnValidValue() {
		//Given
		float[] cartesian = { 0, 0 };
		//When
		float actual = UtilPointTransformations.getAngle(cartesian);
		float delta = (float) 0.1;
		//Then
		Assertions.assertEquals(0, actual, delta, "Value returned must be expected zero");
	}
}
