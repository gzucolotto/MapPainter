package org.gz.mappainter.business;

import java.util.HashMap;
import java.util.HashSet;

import org.gz.mappainter.model.Border;
import org.gz.mappainter.model.Node;

/**
 * Determine the borders and neighborhood of the regions identified in a map.
 */
public class RegionDelimiter {
	NodeManager nodeManager;
	int[][] map;
	BorderManager borderManager;
	
	/**
	 * Constructor with the normalized representation of a map.
	 * @param normalizedMap normalized matrix representation of a map
	 */
	public RegionDelimiter(int[][] normalizedMap) {
		map = normalizedMap;
		borderManager = new BorderManager(map);
		nodeManager = new NodeManager();
	}

	/**
	 * Returns the indexed nodes. These nodes represents the abstraction of each region with
	 * its neighboring regions.
	 * @return HashMap with indexes and respective Node instance
	 */
	public HashMap<Integer, Node> getIndexedNodes() {
		return nodeManager.indexedNodes;
	}
	
	/**
	 * Returns all known nodes. These nodes represents the abstraction of each region with
	 * its neighboring regions.
	 * @return all known nodes
	 */
	public HashSet<Node> getNodes() {
		return new HashSet<Node>(nodeManager.indexedNodes.values());
	}
	
	/**
	 * Returns all the found borders of regions.
	 * @return all known borders
	 */
	public HashSet<Border> getBorders() {
		return borderManager.borders;
	}

	/**
	 * Index all known nodes setting a unique index for each node in a cluster of neighboring nodes.
	 */
	public void doIndexNodes() {
		nodeManager.doIndex();
	}
	
	private Node addKnownNode(Integer index) {
		Node n = new Node(index);
		return nodeManager.addIfNewNode(n);
	}
	
	/**
	 * Iterates through the map identifying region borders and neighbors relationship.
	 */
	public void generateRegions() {
		for (int v = 0; v < map.length; v++) {
			for (int h = 0; h < map[v].length; h++) {
				Node n = addKnownNode(map[v][h]);
				buildBorders(v, h, map[v][h], n);
			}
		}
	}

	private void buildBorders(int v, int h, int currentValue, Node currentNode) {
		borderManager.createBorders(v, h);
		if (v > 0) {
			if (map[v-1][h] != currentValue) {
				Node n = addKnownNode(map[v-1][h]);
				currentNode.addNeighbor(n);
			}
		}
		
		if (v < (map.length - 1)) {
			if (map[v+1][h] != currentValue) {
				Node n = addKnownNode(map[v+1][h]);
				currentNode.addNeighbor(n);
			}
		}
		
		if (h > 0) {
			if (map[v][h-1] != currentValue) {
				Node n = addKnownNode(map[v][h-1]);
				currentNode.addNeighbor(n);
			}
		}
		
		if (h < (map[v].length - 1)) {
			if (map[v][h+1] != currentValue) {
				Node n = addKnownNode(map[v][h+1]);
				currentNode.addNeighbor(n);
			}
		}
		
	}
}
