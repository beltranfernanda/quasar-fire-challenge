package com.meli.quasarfire.domain.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.meli.quasarfire.domain.exceptions.PointNotFoundException;

/**
 * Test cases of Trilateration class
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/21
 * @since 0.0.1 2021/06/21
 */
class TrilaterationTest {

	@Test
	void GivenThreePointsAndDistanceWhenFindLocationWithThreePointsThenReturnIntersectionPoint() throws PointNotFoundException {
		//Given
		float[] center1 = new float[] { 0, 0 };
		float[] center2 = new float[] { 2, 0 };
		float[] center3 = new float[] { 1, 1 };
		float radius = 1;
		//When
		float[] actual = Trilateration.locationWithThreePoints(center1, radius, center2, radius, center3, radius);
		float[] expected = new float[] { 1, 0 };
		float delta = (float) 0.1;
		//Then
		Assertions.assertArrayEquals(expected, actual, delta, "Returned value is not expected.");
	}

	@Test
	void GivenThreePointsNotIntersectedAndDistanceWhenFindLocationWithThreePointsThenReturnNotPointFoundException() throws PointNotFoundException {
		//Given
		float[] center1 = new float[] { 0, 0 };
		float[] center2 = new float[] { 2, 0 };
		float[] center3 = new float[] { 10, 10 };
		float radius = 1;
		//When-Then
		Assertions.assertThrows(PointNotFoundException.class, () -> Trilateration.locationWithThreePoints(center1, radius, center2, radius, center3, radius));
	}

	@Test
	void GivenTwoPointsAndDistanceWhenFindLocationWithTwoPointsThenReturnPoints() throws PointNotFoundException {
		//Given
		float[] center1 = new float[] { 0, 0 };
		float[] center2 = new float[] { 2, 0 };
		float radius = 1;
		//When
		float[][] actual = Trilateration.locationWithTwoPoints(center1, radius, center2, radius);
		float[] actualPoint1 = actual[0];
		float[] actualPoint2 = actual[1];
		float[] expectedPoint = { 1, 0 };
		float delta = (float) 0.1;
		//Then
		Assertions.assertArrayEquals(expectedPoint, actualPoint1, delta, "Returned value is not expected in first point.");
		Assertions.assertArrayEquals(expectedPoint, actualPoint2, delta, "Returned value is not expected in second point.");
	}
	
	@Test
	void GivenThreePointsPartialIntersectedAndDistanceWhenFindLocationWithThreePointsThenReturnNotPointFoundException() throws PointNotFoundException {
		//Given
		float[] center1 = new float[] { -500, -200 };
		float[] center2 = new float[] { 100, -100 };
		float[] center3 = new float[] { 500, 100 };
		float radius1 = 500;
		float radius2 = 150;
		float radius3 = 600;
		//When-Then
		Assertions.assertThrows(PointNotFoundException.class, () -> Trilateration.locationWithThreePoints(center1, radius1, center2, radius2, center3, radius3));
	}

}
