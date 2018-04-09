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
