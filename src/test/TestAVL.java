package test;

import gui.JFrameTree;
import models.Node;
import models.Tree;

public class TestAVL {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.add(new Node(1));
		tree.add(new Node(2));
		tree.add(new Node(3));
		tree.add(new Node(4));
		tree.add(new Node(5));
		tree.add(new Node(6));
		tree.add(new Node(7));
		tree.add(new Node(8));
		
		JFrameTree frameTree = new JFrameTree(tree.getRoot());
		frameTree.setVisible(true);
	}
}
