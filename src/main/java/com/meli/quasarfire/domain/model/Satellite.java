/**
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */

package com.meli.quasarfire.domain.model;

import java.util.Arrays;

/**
 * Defines model object Satellite use to intercept messages.
 * @author Maria Fernanda Velandia
 * @version 0.0.1 2021/06/26
 * @since 0.0.1 2021/06/26
 */
public class Satellite {
	private String name;
	private float distance;
	private String[] message;
	
	/**
	 * @param name
	 * @param distance
	 * @param message
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	private Satellite(String name, float distance, String[] message) {
		super();
		this.name = name;
		this.distance = distance;
		this.message = message;
	}
	
	/**
	 * @return Return value of field name
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Return value of field distance
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	public float getDistance() {
		return distance;
	}

	/**
	 * @return Return value of field message
	 * @author Maria Fernanda Velandia
	 * @version 0.0.1 2021/06/27
	 * @since 0.0.1 2021/06/27
	 */
	public String[] getMessage() {
		return message;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(distance);
		result = prime * result + Arrays.hashCode(message);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Satellite other = (Satellite) obj;
		if (Float.floatToIntBits(distance) != Float.floatToIntBits(other.distance))
			return false;
		if (!Arrays.equals(message, other.message))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		private String name;
		private float distance;
		private String[] message;
		
		/**
		 * @param name Set new value for field name
		 * @author Maria Fernanda Velandia
		 * @version 0.0.1 2021/06/27
		 * @since 0.0.1 2021/06/27
		 */
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		/**
		 * @param distance Set new value for field distance
		 * @author Maria Fernanda Velandia
		 * @version 0.0.1 2021/06/27
		 * @since 0.0.1 2021/06/27
		 */
		public Builder setdistance(float distance) {
			this.distance = distance;
			return this;
		}
		
		/**
		 * @param message Set new value for field message
		 * @author Maria Fernanda Velandia
		 * @version 0.0.1 2021/06/27
		 * @since 0.0.1 2021/06/27
		 */
		public Builder setMessage(String[] message) {
			this.message = message;
			return this;
		}
		
		public Satellite build() {
			return new Satellite(name, distance, message);
		}
	}
}
