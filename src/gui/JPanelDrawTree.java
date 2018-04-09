package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import models.Node;

public class JPanelDrawTree extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Node root;

	public JPanelDrawTree(Node root) {
		this.root = root;
	}

	/**
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(root != null) {
			paintTree(root, getWidth()/2, 50, getWidth()/2, g);
		}
	}

	private void paintTree(Node actual, int x, int y, int total, Graphics g) {
		total /= 2;
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, 30, 30);
		g.setColor(Color.WHITE);
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf(actual.getBalanceFactor()), x + 5, y - 5);
		g.drawString(String.valueOf(actual.getInfo()), x + 5, y + 20);
		g.setColor(Color.RED);
		if(actual.getLeft() != null) {
			g.drawLine(x + 15, y + 30, x - total + 15 , y + 75);
			paintTree(actual.getLeft(), x - total, y + 75, total, g);
		}
		if (actual.getRight() != null) {
			g.drawLine(x + 15, y + 30, x + total + 15 , y + 75);
			paintTree(actual.getRight(), x + total, y + 75, total, g);
		}
	}
	
}
