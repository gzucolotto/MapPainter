package org.gz.mappainter.model;

/**
 * Represents a border of two neighboring regions in a map.
 */
public class Border {
	private Coordinate a;
	private Coordinate b;
	
	/**
	 * Constructor with 2D coordinates required to draw a minimum line border.
	 * @param a
	 * @param b
	 */
	public Border(Coordinate a, Coordinate b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * Constructor with 2D coordinates required to draw a minimum line border.
	 * @param v1
	 * @param h1
	 * @param v2
	 * @param h2
	 */
	public Border(int v1, int h1, int v2, int h2) {
		this(new Coordinate(v1, h1), new Coordinate(v2, h2));
	}
	
	/**
	 * Returns the coordinate A of the border.
	 * @return
	 */
	public Coordinate getA() {
		return a;
	}

	/**
	 * Returns the coordinate B of the border.
	 * @return
	 */
	public Coordinate getB() {
		return b;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		if (o instanceof Border) {
			Border b = (Border)o;
			
			if ((this.a.equals(b.a) && this.b.equals(b.b))
					|| (this.a.equals(b.b) && this.b.equals(b.a))) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return a.hashCode() * 3 + b.hashCode() * 7 +
				b.hashCode() * 3 + a.hashCode() * 7;
	}
	
	@Override
	public String toString() {
		return "[" + a + ", " + b + "]";
	}
}
