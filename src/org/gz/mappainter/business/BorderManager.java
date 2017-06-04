package org.gz.mappainter.business;

import java.util.HashSet;

import org.gz.mappainter.model.Border;

/**
 * Responsible to generate and store Border objects.
 */
public class BorderManager {
	HashSet<Border> borders;
	int[][] map;
	
	/**
	 * Constructor with matrix that represents the normalized map.
	 * @param map
	 */
	public BorderManager(int[][] map) {
		this.map = map;
		borders = new HashSet<Border>();
	}
	
	private void addBorder(Border b) {
		if (!borders.contains(b)) {
			borders.add(b);
		}
	}
	
	/**
	 * Creates the proper borders for the coordinate used as parameter.
	 * @param v is the vertical coordinate
	 * @param h is the horizontal coordinate
	 * @return the set of known borders
	 */
	public HashSet<Border> createBorders(int v, int h) {
		int current = map[v][h];
		if (v == 0) {
			Border b = new Border(v, h, v, h + 1);
			addBorder(b);
		} else if ((v > 0) && (map[v - 1][h]) != current) {
			Border b = new Border(v, h, v, h + 1);
			addBorder(b);
		}
		
		if (v == map.length - 1) {
			Border b = new Border(v + 1, h, v + 1, h + 1);
			addBorder(b);
		} else if ((v < map.length - 1) && (map[v + 1][h] != current)) {
			Border b = new Border(v + 1, h, v + 1, h + 1);
			addBorder(b);
		}
		
		if (h == 0) {
			Border b = new Border(v, h, v + 1, h);
			addBorder(b);
		} else if ((h > 0) && (map[v][h - 1] != current)) {
			Border b = new Border(v, h, v + 1, h);
			addBorder(b);
		}
		
		if (h == map[v].length - 1) {
			Border b = new Border(v, h + 1, v + 1, h + 1);
			addBorder(b);
		} else if ((h < map[v].length - 1) && (map[v][h + 1] != current)) {
			Border b = new Border(v, h + 1, v + 1, h + 1);
			addBorder(b);
		}
		
		return borders;
	}
}
