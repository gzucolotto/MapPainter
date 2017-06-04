package org.gz.mappainter.model;

/**
 * Representation of 2D coordinate.
 */
public class Coordinate {
	int v;
	int h;
	
	public Coordinate(int v, int h) {
		this.v = v;
		this.h = h;
	}

	public int getV() {
		return v;
	}


	public int getH() {
		return h;
	}


	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		if (o instanceof Coordinate) {
			Coordinate c = (Coordinate) o;
			
			return (v == c.v) && (h == c.h);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return ((Integer)v).hashCode() + ((Integer)h).hashCode();
	}
	
	@Override
	public String toString() {
		return "(" + v + ", " + h + ")";
	}
}
