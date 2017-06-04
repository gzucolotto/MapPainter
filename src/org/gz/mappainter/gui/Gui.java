package org.gz.mappainter.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.gz.mappainter.business.MapNormalizer;
import org.gz.mappainter.business.MapOrchestrator;
import org.gz.mappainter.business.RegionDelimiter;
import org.gz.mappainter.business.utils.MatrixFactory;
import org.gz.mappainter.business.utils.Utils;
import org.gz.mappainter.model.Border;
import org.gz.mappainter.model.Node;

/**
 * Generates a visual representation of maps.
 */
public class Gui extends JPanel {
	public static final int UNIT = 20;
	private static final int OCEAN = 0;
	HashMap<Integer, Color> colorMap;
	MapOrchestrator mo;
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		RegionDelimiter rd = mo.getRedionDelimiter();
		int[][] normalized = mo.getNormalized();
		
		for (int v = 0; v < normalized.length; v++) {
			for (int h = 0; h < normalized[v].length; h++) {
				int index = normalized[v][h];
				
				Node n = rd.getIndexedNodes().get(index);
				g2.setColor(colorMap.get(n.getIndex()));
				g2.fillRect(h * UNIT, v * UNIT, UNIT, UNIT);
				
				g2.setColor(Color.BLACK);
				g2.drawString(String.valueOf(index), h * UNIT, v * UNIT + UNIT);
			}
		}
		
		g2.setColor(Color.BLACK);
		Iterator<Border> it = rd.getBorders().iterator();
		while(it.hasNext()) {
			Border b = it.next();
			
			g2.drawLine(b.getA().getH() * UNIT, b.getA().getV() * UNIT, b.getB().getH() * UNIT, b.getB().getV() * UNIT);
		}

	}
	
	public static void paintMapGui(int[][] map) {
		Gui gui = new Gui();
		
		gui.mo = new MapOrchestrator(map);
		
		MapOrchestrator mo = gui.mo;
		
		gui.colorMap = new HashMap<Integer, Color>();
		Iterator<Node> it = mo.getRedionDelimiter().getNodes().iterator();
		Random rn = new Random();
		while(it.hasNext()) {
			Node n = it.next();
			if (n.getIndex() == OCEAN) {
				gui.colorMap.put(n.getIndex(), Color.BLUE);
			} else {
				int c = rn.nextInt();
				System.out.println("index=" + n.getIndex() + " is color "+ c);
				gui.colorMap.put(n.getIndex(), new Color(c));
			}
		}


		JFrame f = new JFrame();
		f.getContentPane().add(gui);
		f.setSize(400, 300);
		f.setVisible(true);
		
		System.out.println("Nodes: " + Utils.toString(mo.getRedionDelimiter().getNodes()));
	}
	
	public static void main(String[] args) {
		int[][] map = MatrixFactory.getMatrix(10, 10);
		paintMapGui(map);
	}

}
