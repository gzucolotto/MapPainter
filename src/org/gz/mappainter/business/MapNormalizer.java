package org.gz.mappainter.business;

/**
 * Normalizes a matrix representing a map.
 */
public class MapNormalizer {
	public static final int OCEAN = 0;
	public static final int MARK = -1;
	int[][] map;
	int[][] indexMap;
	int currentId = 1;
	
	/**
	 * Constructor with the unnormalized representation of the map.
	 * @param map the unnormalized representation of a map.
	 */
	public MapNormalizer(int[][] map) {
		this.map = cloneMap(map);
		initIndexMap();
	}
	
	/**
	 * Returns the indexed matrix, i.e. the normalized representation of a map.
	 * @return the normalized matrix
	 */
	public int[][] getIndexMap() {
		return indexMap;
	}
	
	private void initIndexMap() {
		indexMap = new int[map.length][map[0].length];
		
		for (int i = 0; i < indexMap.length; i++) {
			for (int j = 0; j < indexMap[i].length; j++) {
				indexMap[i][j] = MARK;
			}
		}
	}
	
	/**
	 * Executes the matrix normalization. This method will generate a unique index for each
	 * distinct region identified.
	 */
	public void indexRegions() {
		for (int i = 0; i < indexMap.length; i++) {
			for (int j = 0; j < indexMap[i].length; j++) {
				if (map[i][j] != MARK) {
					int currentVal = map[i][j];
					markRegion(i, j, currentVal, currentId);
					currentId++;
				}
			}
		}
	}

	private boolean checkLimits(int i, int j) {
		return (i >= 0) && (i < map.length) && (j >= 0) && (j < map[i].length);
	}
	
	private void markRegion(int i, int j, int currentVal, int currentId) {
		if (!checkLimits(i, j)) {
			return;
		}
		if (map[i][j] == currentVal) {
			map[i][j] = MARK;
			indexMap[i][j] = currentId;
			
			markRegion(i-1, j, currentVal, currentId);
			markRegion(i+1, j, currentVal, currentId);
			markRegion(i, j-1, currentVal, currentId);
			markRegion(i, j+1, currentVal, currentId);
		}
	}
	
	protected static int[][] cloneMap(int[][] orig) {
		int[][] cloned = new int[orig.length][];
		
		int i = 0;
		for (int[] arr: orig) {
			cloned[i++] = arr.clone();
		}
		
		return cloned;
	}
}
