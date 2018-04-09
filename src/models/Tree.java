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
	
	public void balanceTree() {
		if(root.getBalanceFactor() < -1) {
			balanceLL(root);
		}else if(root.getBalanceFactor() > 1) {
			balanceRR(root);
		}
	}
	
	public void balanceRR(Node nodeToBalance) {
		changeRightRR(nodeToBalance);
		changeLeftRR(nodeToBalance);
	}
	
	private void changeLeftRR(Node nodeToBalance) {
		while(nodeToBalance.getLeft().getLeft() != null) {
			nodeToBalance.setInfo(nodeToBalance.getLeft().getInfo());
			nodeToBalance = nodeToBalance.getLeft();
		}
		nodeToBalance.setInfo(nodeToBalance.getLeft().getInfo());
		nodeToBalance.setLeft(null);
	}
	
	private void changeRightRR(Node nodeToBalance) {
		int infoAux = nodeToBalance.getInfo();
		while(nodeToBalance.getRight() != null) {
			infoAux = nodeToBalance.getRight().getInfo();
			nodeToBalance.getRight().setInfo(nodeToBalance.getInfo());
			if(nodeToBalance.getRight().getRight() != null)
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
		while(nodeToBalance.getLeft() != null) {
			infoAux = nodeToBalance.getLeft().getInfo();
			nodeToBalance.getLeft().setInfo(nodeToBalance.getInfo());
			if(nodeToBalance.getLeft().getLeft() != null)
				nodeToBalance.getLeft().getLeft().setInfo(infoAux);
			nodeToBalance = nodeToBalance.getLeft();
		}
		nodeToBalance.setLeft(new Node(infoAux));
	}

	private void changeRightLL(Node nodeToBalance) {
		while(nodeToBalance.getRight().getRight() != null) {
			nodeToBalance.setInfo(nodeToBalance.getRight().getInfo());
			nodeToBalance = nodeToBalance.getRight();
		}
		nodeToBalance.setInfo(nodeToBalance.getRight().getInfo());
		nodeToBalance.setRight(null);
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
