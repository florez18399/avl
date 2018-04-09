package models;

public class Tree {
	private Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public Tree() {
	}
	
	/**
	 * Calcula la altura de un árbol o de una rama
	 * @param rootTree Raíz del árbol
	 * @param count Contador necesario para recursividad
	 * @return
	 */
	public int calculateHeightTree(Node rootTree, int count) {
		count ++;
		int heightLeft = 0;
		int heightRight = 0;
		if(rootTree.getLeft() != null) {
			heightLeft = calculateHeightTree(rootTree.getLeft(), count);
		}
		if(rootTree.getRight() != null) {
			heightLeft = calculateHeightTree(rootTree.getLeft(), count);
		}
		return heightLeft > heightRight ? heightLeft : heightRight;
	}

	/**
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

}
