package models;

public class Node {
	private int info;
	private Node left;
	private Node right;

	public Node(int info) {
		this.info = info;
	}

	public Node(int info, Node left, Node right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}

	/**
	 * Calcula la altura de un árbol o de una rama
	 * 
	 * @return altura del nodo
	 */
	public int calculateHeightTree() {
		return calculateHeightTree(this, 0);
	}

	private int calculateHeightTree(Node rootTree, int count) {
		count++;
		int heightLeft = count;
		int heightRight = count;
		if (rootTree.getLeft() != null) {
			heightLeft = calculateHeightTree(rootTree.getLeft(), count);
		}
		if (rootTree.getRight() != null) {
			heightRight = calculateHeightTree(rootTree.getRight(), count);
		}
		return heightLeft > heightRight ? heightLeft : heightRight;
	}

	/**
	 * Calcula el factor de balanceo del nodo
	 * 
	 * @return factor de balanceo
	 */
	public int getBalanceFactor() {
		int heightLeft = 0;
		int heightRight = 0;
		if (left != null)
			heightLeft = left.calculateHeightTree();
		if (right != null)
			heightRight = right.calculateHeightTree();
		return heightLeft - heightRight;
	}

	/**
	 * @return the info
	 */
	public int getInfo() {
		return info;
	}

	/**
	 * @param info
	 *            the info to set
	 */
	public void setInfo(int info) {
		this.info = info;
	}

	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}

}
