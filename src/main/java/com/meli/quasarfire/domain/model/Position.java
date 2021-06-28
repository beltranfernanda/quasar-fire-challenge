package com.meli.quasarfire.domain.model;


/**
 * Defines model of position object use to calculate position of enemy spaceship
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */
public class Position {
	private float coordinateX;	
	private float coordinateY;
	
	/**
	 * @param coordinateX
	 * @param coordinateY
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	private Position(float coordinateX, float coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	/**
	 * @return Return value of field coordinateX
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/26
	 * @since 0.0.1 2021/06/26
	 */
	public float getCoordinateX() {
		return coordinateX;
	}

	/**
	 * @return Return value of field coordinateY
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/26
	 * @since 0.0.1 2021/06/26
	 */
	public float getCoordinateY() {
		return coordinateY;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(coordinateX);
		result = prime * result + Float.floatToIntBits(coordinateY);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (Float.floatToIntBits(coordinateX) != Float.floatToIntBits(other.coordinateX))
			return false;
		if (Float.floatToIntBits(coordinateY) != Float.floatToIntBits(other.coordinateY))
			return false;
		return true;
	}


	/**
	 * Class builder pattern to asign new values
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	public static class Builder{
		private float coordinateX;	
		private float coordinateY;
		
		
		/**
		 * @param coordinateX Set new value for field coordinateX
		 * @author Maria Fernanda Velandia
		 * @version 0.0.1 2021/06/27
		 * @since 0.0.1 2021/06/27
		 */
		public Builder setCoordinateX(float coordinateX) {
			this.coordinateX = coordinateX;
			return this;
		}

		/**
		 * @param coordinateY Set new value for field coordinateY
		 * @author Maria Fernanda Velandia
		 * @version 0.0.1 2021/06/27
		 * @since 0.0.1 2021/06/27
		 */
		public Builder setCoordinateY(float coordinateY) {
			this.coordinateY = coordinateY;
			return this;
		}

		/**
		 * Used to set new values to position
		 * @author Maria Fernanda Velandia
		 * @version 0.0.1 2021/06/27
		 * @since 0.0.1 2021/06/27
		 * @return
		 */
		public Position build() {
			return new Position(coordinateX,coordinateY);
		}
	}
}
