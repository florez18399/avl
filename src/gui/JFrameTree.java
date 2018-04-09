package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import models.Node;

public class JFrameTree extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelDrawTree drawTree;

	public JFrameTree(Node root) {
		init(root);
	}

	private void init(Node root) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBackground(Color.decode("#FFF8E7"));
		setLayout(new BorderLayout());
		drawTree = new JPanelDrawTree(root);
		add(drawTree, BorderLayout.CENTER);
	}
}
