package com.meli.quasarfire.domain.utils;

import com.meli.quasarfire.domain.enums.MessageExceptions;
import com.meli.quasarfire.domain.exceptions.PointNotFoundException;

/**
 * Used to determine position using three circles intercept them
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/21
 * @since 0.0.1 2021/06/21
 */
public class Trilateration {

	private Trilateration() {
	}

	/**
	 * Used to find two intersection points given two points and radius.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/21
	 * @since 0.0.1 2021/06/21
	 * @param center
	 * @param radius
	 * @return float 2-dimensional vector 
	 * @throws PointNotFoundException 
	 */
	protected static float[][] locationWithTwoPoints(float center1[], float radius1, float center2[], float radius2) throws PointNotFoundException {
		float[] center2Translated = UtilPointTransformations.translate(center2, UtilPointTransformations.negativePoint(center1));
		float[] center2Rotated = UtilPointTransformations.rotate(center2Translated, UtilPointTransformations.getAngle(center2Translated));
		float coordinateX = (float) (Math.pow(center2Rotated[0], 2) - Math.pow(radius2, 2) + Math.pow(radius1, 2)) / (2 * center2Rotated[0]);
		float coordinateY = (float) Math.sqrt(Math.pow(radius1, 2) - Math.pow(coordinateX, 2));
		if(Float.isNaN(coordinateX) || Float.isNaN(coordinateY)) 
			throw new PointNotFoundException(MessageExceptions.ERROR_POINT_NOT_FOUND.getMessage());
		float[] point1 = { coordinateX, coordinateY };
		float[] point2 = { coordinateX, coordinateY * -1 };
		point1 = UtilPointTransformations.rotate(point1, -1 * UtilPointTransformations.getAngle(center2Translated));
		point1 = UtilPointTransformations.translate(point1, center1);
		point2 = UtilPointTransformations.rotate(point2, -1 * UtilPointTransformations.getAngle(center2Translated));
		point2 = UtilPointTransformations.translate(point2, center1);
		return new float[][] { point1, point2 };
	}

	/**
	 * Used to find one position given three points and radius.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/21
	 * @since 0.0.1 2021/06/21
	 * @param center
	 * @param radius
	 * @return float vector with coordinates X and Y
	 * @throws PointNotFoundException 
	 */
	public static float[] locationWithThreePoints(float[] center1, float radius1, float[] center2, float radius2, float[] center3, float radius3) throws PointNotFoundException {
		float[][] pointsComparationResultP1P2 = locationWithTwoPoints(center1, radius1, center2, radius2);
		float[][] pointsComparationResultP1P3 = locationWithTwoPoints(center1, radius1, center3, radius3);
		for (int i = 0; i < pointsComparationResultP1P2.length; i++) {
			for (int j = 0; j < pointsComparationResultP1P3.length; j++) {
				if (UtilArrays.equalsTwoArrays(pointsComparationResultP1P2[i], pointsComparationResultP1P3[j]))
					return pointsComparationResultP1P2[i];
			}
		}
		throw new PointNotFoundException(MessageExceptions.ERROR_POINT_NOT_FOUND.getMessage());
	}

}
