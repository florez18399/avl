package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.Controller;
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
		addJMenuBar();
		add(drawTree, BorderLayout.CENTER);
	}

	private void addJMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Árbol");
		menu.add(createJITem("Agregar", "ADD", KeyEvent.VK_A));
		menu.add(createJITem("Balancear", "BALANCE", KeyEvent.VK_B));
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	
	private JMenuItem createJITem(String name , String command, int keyEvent) {
		JMenuItem item1 = new JMenuItem(name);
		item1.setActionCommand(command);
		item1.addActionListener(Controller.getInstance());
		item1.setAccelerator(KeyStroke.getKeyStroke(keyEvent, ActionEvent.ALT_MASK));
		return item1;
	}
	
	public void repaintTree(Node root) {
		drawTree.setRoot(root);
		drawTree.repaint();
	}
}
