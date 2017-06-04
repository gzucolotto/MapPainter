package org.gz.mappainter.model;

import java.util.Comparator;

/**
 * Compares nodes by respective indexes.
 */
public class NodeValueComparator implements Comparator<Node> {

	@Override
	public int compare(Node n1, Node n2) {
		if (n1.index == n2.index) {
			if (n1.uid > n2.uid) {
				return 1;
			}
			
			if (n1.uid < n2.uid) {
				return -1;
			}
			
			return 0;
		}
		
		if (n1.index > n2.index) {
			return 1;
		}
		
		if (n1.index < n2.index) {
			return -1;
		}
		return 0;
	}

}
