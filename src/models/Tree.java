package models;

public class Tree {
	private Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public Tree() {
	}

	public void add(Node node) {
		if (root != null)
			add(root, node);
		else
			root = node;
	}

	private void add(Node actual, Node node) {
		if (actual.getInfo() < node.getInfo())
			if (actual.getRight() != null)
				add(actual.getRight(), node);
			else
				actual.setRight(node);
		else if (actual.getInfo() > node.getInfo())
			if (actual.getLeft() != null)
				add(actual.getLeft(), node);
			else
				actual.setLeft(node);
		else
			throw new NullPointerException("El nodo con la información especificada ya se encuentra");
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
