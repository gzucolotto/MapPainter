package org.gz.mappainter.model;

import java.util.TreeSet;

/**
 * Abstraction of a region on a map. Holds the neighborhood relationship of other nodes.
 */
public class Node implements Comparable<Node> {
	TreeSet<Node> neighbours;
	int index;
	int uid;
	public static final int NOT_INDEXED = -1;
	static long lastId = 1;
	
	/**
	 * Constructor with node UID. 
	 * @param uid
	 */
	public Node(int uid) {
		neighbours = new TreeSet<Node>();
		index = NOT_INDEXED;
		this.uid = uid;
	}
	
	/**
	 * Return the TreeSet of neighboring nodes sorted by its Indexes.
	 * @return
	 */
	public TreeSet<Node> getSortedNeighbours() {
		TreeSet<Node> newTree = new TreeSet<Node>(new NodeValueComparator());
		newTree.addAll(neighbours);
		return newTree;
	}
	
	/**
	 * Returns de node UID.
	 * @return
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * Set node's index.
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Return node's index.
	 * @return
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Include n in the list of node's neighbors. Also this node will become n's neighbor.
	 * @param n
	 */
	public void addNeighbor(Node n) {
		if (n != null) {
			if (!neighbours.contains(n)) {
				neighbours.add(n);
				n.addNeighbor(this);
			}
		}
		
	}
	
	/**
	 * Returns true if the node hase been indexed.
	 * @return
	 */
	public boolean isIndexed() {
		return NOT_INDEXED != index;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		
		if (!(o instanceof Node)) {
			return false;
		}
		
		Node n = (Node) o;
		return uid == n.uid;
	}
	
	@Override
	public int hashCode() {
		return ((Integer)uid).hashCode();
	}

	@Override
	public int compareTo(Node o) {
		if (index == o.index) {
			if (uid > o.uid) {
				return 1;
			}
			
			if (uid < o.uid) {
				return -1;
			}
			
			return 0;
		}
		
		if (index > o.index) {
			return 1;
		}
		
		if (index < o.index) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(");
		sb.append(uid);
		sb.append(",");
		sb.append(index);
		sb.append(")");
		
		return sb.toString();
	}

}
