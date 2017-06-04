package org.gz.mappainter.business;

import org.gz.mappainter.business.utils.Utils;

/**
 * Orchestrates the operations required to have a map representation with:
 * i- unique regions;
 * ii- minimum set of colors;
 *
 */
public class MapOrchestrator {
	MapNormalizer mn;
	RegionDelimiter rd;
	int[][] normalized;

	/**
	 * Constructor with unnormalized representation of a map.
	 * @param map unnormalized matrix
	 */
	public MapOrchestrator(int[][] map) {
		mn = new MapNormalizer(map);
		mn.indexRegions();
		normalized = mn.getIndexMap();
		System.out.println("Normalized:" + Utils.toString(normalized));

		rd = new RegionDelimiter(normalized);
		rd.generateRegions();
		rd.doIndexNodes();
	}

	/**
	 * Return instance of MapNormalizer.
	 * @return instance of MapNormalizer
	 */
	public MapNormalizer getMapNormalizer() {
		return mn;
	}

	/**
	 * Return instance of RegionDelimiter.
	 * @return instance of RegionDelimiter
	 */
	public RegionDelimiter getRedionDelimiter() {
		return rd;
	}

	/**
	 * Normalized matrix.
	 * @return the normalized matrix
	 */
	public int[][] getNormalized() {
		return normalized;
	}
	
	
}
