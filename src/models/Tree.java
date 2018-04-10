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
	 * Método que balancea un árbol
	 */
	public void balanceTree() {
		if (root.getBalanceFactor() < -1) {
			if (root.getRight().getLeft() != null)
				balanceRR(root.getRight());
			balanceLL(root);
		} else if (root.getBalanceFactor() > 1) {
			if (root.getLeft().getRight() != null)
				balanceLL(root.getLeft());
			balanceRR(root);
		}
	}

	public void balanceRR(Node nodeToBalance) {
		changeRightRR(nodeToBalance);
		changeLeftRR(nodeToBalance);
	}

	private void changeLeftRR(Node nodeToBalance) {
		while (nodeToBalance.getLeft().getLeft() != null) {
			nodeToBalance.setInfo(nodeToBalance.getLeft().getInfo());
			nodeToBalance = nodeToBalance.getLeft();
		}
		nodeToBalance.setInfo(nodeToBalance.getLeft().getInfo());
		nodeToBalance.setLeft(null);
	}

	private void changeRightRR(Node nodeToBalance) {
		int infoAux = nodeToBalance.getInfo();
		while (nodeToBalance.getRight() != null) {
			infoAux = nodeToBalance.getRight().getInfo();
			nodeToBalance.getRight().setInfo(nodeToBalance.getInfo());
			if (nodeToBalance.getRight().getRight() != null)
				nodeToBalance.getRight().getRight().setInfo(infoAux);
			nodeToBalance = nodeToBalance.getRight();
		}
		nodeToBalance.setRight(new Node(infoAux));
	}

	public void balanceLL(Node nodeToBalance) {
		changeLeftLL(nodeToBalance);
		changeRightLL(nodeToBalance);
	}

	private void changeLeftLL(Node nodeToBalance) {
		int infoAux = nodeToBalance.getInfo();
		while (nodeToBalance.getLeft() != null) {
			infoAux = nodeToBalance.getLeft().getInfo();
			nodeToBalance.getLeft().setInfo(nodeToBalance.getInfo());
			if (nodeToBalance.getLeft().getLeft() != null)
				nodeToBalance.getLeft().getLeft().setInfo(infoAux);
			nodeToBalance = nodeToBalance.getLeft();
		}
		nodeToBalance.setLeft(new Node(infoAux));
	}

	private void changeRightLL(Node nodeToBalance) {
		while (nodeToBalance.getRight().getRight() != null) {
			nodeToBalance.setInfo(nodeToBalance.getRight().getInfo());
			nodeToBalance = nodeToBalance.getRight();
		}
		nodeToBalance.setInfo(nodeToBalance.getRight().getInfo());
		nodeToBalance.setRight(null);
	}

	/**
	 * Eliminar nodo
	 * @param info
	 */
	public void delete(int info) {
		delete(null, root, info);
	}

	public void delete(Node father, Node actual, int info) {
		if (actual.getInfo() == info) {
			if (isComplete(actual)) {
				deleteComplete(actual);
			} else if (hasOneChildren(actual)) {
				deleteOneChild(father, actual);
			} else {
				deleteLeaf(father, actual);
			}
		} else {
			if (info < actual.getInfo()) {
				delete(actual, actual.getLeft(), info);
			} else {
				delete(actual, actual.getRight(), info);
			}
		}
	}

	private void deleteComplete(Node actual) {
		Node maxLeft = getMaxNode(actual.getLeft());
		Node minRight = getMinNode(actual.getRight());
		int data = (Math.abs(maxLeft.getInfo() - actual.getInfo()) < Math.abs(minRight.getInfo() - actual.getInfo()))
				? maxLeft.getInfo()
				: minRight.getInfo();
		delete(data);
		actual.setInfo(data);
	}

	public Node getMinNode(Node base) {
		Node actual = base;
		while (actual.getLeft() != null) {
			actual = actual.getLeft();
		}
		return actual;
	}

	public Node getMaxNode(Node base) {
		Node actual = base;
		while (actual.getRight() != null) {
			actual = actual.getRight();
		}
		return actual;
	}

	private void deleteOneChild(Node father, Node actual) {
		if (actual == root) {
			root = getOneChild(actual);
		} else if (father.getLeft().equals(actual)) {
			father.setLeft(getOneChild(actual));
		} else {
			father.setRight(getOneChild(actual));
		}
	}

	private void deleteLeaf(Node father, Node actual) {
		if (father == null) {
			root = null;
		} else if (father.getLeft() != null && father.getLeft().equals(actual)) {
			father.setLeft(null);
		} else {
			father.setRight(null);
		}
	}

	private Node getOneChild(Node actual) {
		return actual.getLeft() != null ? actual.getLeft() : actual.getRight();
	}

	private boolean hasOneChildren(Node actual) {
		return actual.getLeft() != null || actual.getRight() != null;
	}

	private boolean isComplete(Node actual) {
		return actual.getLeft() != null && actual.getRight() != null;
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
