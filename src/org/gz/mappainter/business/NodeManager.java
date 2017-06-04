package org.gz.mappainter.business;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.gz.mappainter.model.Node;

/**
 * Generates and stores the instances of Node and its relationship.
 */
public class NodeManager {
	HashMap<Integer, Node> indexedNodes;
	
	/**
	 * Constructor.
	 */
	public NodeManager() {
		indexedNodes = new HashMap<Integer, Node>();
	}
	
	/**
	 * Creates and include a new Node with specified UID. If there is a Node with same UID 
	 * already stored then no new Node will be created.
	 * @param uid the node UID
	 */
	public void addNode(int uid) {
		Node n = new Node(uid);
		
		addIfNewNode(n);
	}
	
	/**
	 * Include the Node n if it is new. If the Node n is already stored, the 
	 * collection of nodes contains another node with same UID, n will be ignored.
	 * @param n instance of Node to be included
	 * @return instance of Node stored
	 */
	public Node addIfNewNode(Node n) {
		if (!indexedNodes.containsKey(n.getUid())) {
			indexedNodes.put(n.getUid(), n);
		}
		return indexedNodes.get(n.getUid());
	}
	
	private void setIndex(Node n) {
		if (n.isIndexed()) {
			return ;
		}
		
		int currentIndex = 1;
		
		Iterator<Node> it = n.getSortedNeighbours().iterator();
		while (it.hasNext()) {
			Node m = it.next();
			System.out.println("...found neighbor " + m);
			if (m.isIndexed()) {
				if (currentIndex == m.getIndex()) {
					currentIndex++;
				} else if (currentIndex > m.getIndex()) {
					break;
				}
			}
		}
		n.setIndex(currentIndex);
		System.out.println(n + " got index " + currentIndex);
	}
	
	private void doIndex(Node n) {
		System.out.println("indexing uid=" + n.getUid());
		if (n.getIndex() == Node.NOT_INDEXED) {
			setIndex(n);
			
			Iterator<Node> it = n.getSortedNeighbours().iterator();
			while (it.hasNext()) {
				Node m = it.next();
				doIndex(m);
			}
		}
	}
	
	/**
	 * Iterates through all stored Nodes to define its indexes. The index of each node must be unique
	 * among its neighbors.
	 */
	public void doIndex() {
		Iterator<Node> it = indexedNodes.values().iterator();
		while (it.hasNext()) {
			doIndex(it.next());
		}
	}
	
	@Override
	public String toString() {
		return indexedNodes.values().toString();
	}
}
