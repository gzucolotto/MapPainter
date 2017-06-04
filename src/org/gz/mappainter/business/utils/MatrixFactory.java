package org.gz.mappainter.business.utils;

public class MatrixFactory {

	private static int[][] generateMap5x4() {
		int[][] map = {
				{1, 1, 1, 1},
				{1, 8, 8, 1},
				{1, 9, 9, 1},
				{1, 9, 9, 9},
				{1, 1, 1, 9}};
		return map;
	}
	
	private static int[][] generateMap2x2() {
		int[][] map = {{1, 2}, {3, 4}};
		return map;
	}
	
	private static int[][] generateMap10x10() {
		int[][] map = {
				{6, 6, 2, 3, 4, 5, 1, 7, 10, 10},
				{6, 2, 2, 3, 4, 5, 1, 7, 10, 10},
				{2, 2, 3, 3, 4, 5, 1, 7, 7, 7},
				{2, 3, 3, 4, 4, 5, 1, 7, 7, 7},
				{3, 3, 4, 4, 5, 5, 1, 1, 1, 1},
				{4, 4, 4, 5, 5, 1, 1, 1, 1, 1},
				{5, 5, 5, 5, 1, 1, 1, 8, 8, 1},
				{1, 1, 1, 1, 1, 1, 1, 9, 9, 1},
				{1, 1, 1, 1, 1, 1, 1, 9, 9, 9},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 9}};
		return map;
	}
	
	public static int[][] getMatrix(int v, int h) {
		int[][] mat;
		
		if ((v == 10) && (h == 10)) {
			mat = generateMap10x10();
		} else if ((v == 5) && (h == 4)) {
			mat = generateMap5x4();
		} else {
			mat = generateMap2x2();
		}
		
		
		return mat;
	}
}
