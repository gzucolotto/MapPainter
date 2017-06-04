package org.gz.mappainter.business.utils;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Class collecting a set of common utility methods.
 */
public class Utils {
	
	public static String toString(int[][] m) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int v = 0; v < m.length; v++) {
			sb.append("{" + m[v][0]);
			for (int h = 1; h < m[v].length; h++) {
				sb.append(", " + m[v][h]);
			}
			sb.append("}");
			if (v < (m.length -1)) {
				sb.append(",");
			}
		}
		sb.append("};");
		return sb.toString();
	}
	
	public static String toString(HashSet hs) {
		StringBuilder sb = new StringBuilder();
		
		Iterator it = hs.iterator();
		sb.append("[");
		if (it.hasNext()) {
			sb.append(it.next());
		}
		
		while (it.hasNext()) {
			sb.append("; " + it.next());
		}
		sb.append("]");
		
		return sb.toString();
	}
}
