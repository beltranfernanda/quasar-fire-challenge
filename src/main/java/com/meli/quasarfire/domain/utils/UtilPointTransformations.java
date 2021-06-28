package com.meli.quasarfire.domain.utils;

/**
 * Used to make operations over a Cartesian point.
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/21
 * @since 0.0.1 2021/06/21
 */
public class UtilPointTransformations {

	private UtilPointTransformations() {

	}

	/**
	 * Used to rotate Cartesian given point .
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/21
	 * @since 0.0.1 2021/06/21
	 * @param cartesian
	 * @param theta
	 * @return float vector rotated point contained.
	 */
	protected static float[] rotate(float[] cartesian, float theta) {
		float[] polar = cartesianToPolar(cartesian);
		float[] rotatedPoint = new float[2];
		rotatedPoint[0] = (float) Math.round((polar[0] * Math.cos(polar[1] - theta)) * 10) / 10;
		rotatedPoint[1] = (float) Math.round((polar[0] * Math.sin(polar[1] - theta)) * 10) / 10;
		return rotatedPoint;
	}

	/**
	 * Used to translate Cartesian point given point and translation.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/21
	 * @since 0.0.1 2021/06/21
	 * @param cartesian
	 * @param translation
	 * @return float vector translated point contained.
	 */
	protected static float[] translate(float[] cartesian, float[] translation) {
		float[] translatedPoint = new float[2];
		translatedPoint[0] = cartesian[0] + translation[0];
		translatedPoint[1] = cartesian[1] + translation[1];
		return translatedPoint;
	}

	/**
	 * Changes Cartesian point symbol.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/21
	 * @since 0.0.1 2021/06/21
	 * @param cartesian
	 * @param translation
	 * @return float vector symbol point changed.
	 */
	protected static float[] negativePoint(float[] point) {
		float[] negative = new float[2];
		negative[0] = point[0] * -1;
		negative[1] = point[1] * -1;
		return negative;
	}

	/**
	 * Used to obtain an angle given Cartesian coordinate.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/21
	 * @since 0.0.1 2021/06/21
	 * @param cartesian
	 * @param translation
	 * @return float angle.
	 */
	protected static float getAngle(float[] cartesian) {
		if (cartesian[0] == 0 && cartesian[1] == 0)
			return 0;
		if (cartesian[0] == 0) {
			return (cartesian[1] > 0) ? (float) Math.PI / 2 : (float) (Math.PI / 2) * -1;
		}
		if (cartesian[0] > 0)
			return (float) Math.atan(cartesian[1] / cartesian[0]);
		return (cartesian[1] >= 0) ? (float) (Math.PI - Math.atan(cartesian[1] / cartesian[0])) : (float) (Math.atan(cartesian[1] / cartesian[0]) + Math.PI);
	}

	/**
	 * Used to convert Cartesian coordinates to polar.
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/21
	 * @since 0.0.1 2021/06/21
	 * @param cartesian
	 * @return float vector polar coordinates contained.
	 */
	protected static float[] cartesianToPolar(float[] cartesian) {
		float[] polar = new float[2];
		polar[0] = (float) Math.sqrt(Math.pow(cartesian[0], 2) + Math.pow(cartesian[1], 2));
		polar[1] = getAngle(cartesian);
		return polar;
	}

}
