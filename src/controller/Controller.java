package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.JFrameTree;
import models.Node;
import models.Tree;

public class Controller implements ActionListener{
	private static Controller controller;
	private JFrameTree frameTree;
	private Tree tree;
	
	private Controller() {
	}
	
	public static Controller getInstance() {
		if(controller == null)
			controller = new Controller();
		return controller;
	}
	
	public void initComponents() {
		tree = new Tree();
		frameTree = new JFrameTree(tree.getRoot());
		frameTree.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "BALANCE":
			tree.balanceTree();
			frameTree.repaintTree(tree.getRoot());
			break;
		case "ADD":
			int number = Integer.parseInt(JOptionPane.showInputDialog(frameTree, "Ingresa el número"));
			tree.add(new Node(number));
			frameTree.repaintTree(tree.getRoot());
			break;
			
		case "REMOVE":
			int number2 = Integer.parseInt(JOptionPane.showInputDialog(frameTree, "Ingresa el número"));
			tree.delete(number2);
			frameTree.repaintTree(tree.getRoot());
			break;

		default:
			break;
		}
		
	}
	
	
}
