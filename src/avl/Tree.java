package avl;

public class Tree {
	private Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public Tree() {
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
