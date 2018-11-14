package tree;

public class BST {

	TNode root;
	int size;

	boolean isLeaf(TNode root) {
		if (root == null || (root.getLeft() == null && root.getLeft() == null))
			return true;
		return false;
	}

	void insert(int data) {
		root = insert(root, data);
	}

	TNode insert(TNode root, int data) {
		if (root == null) {
			TNode n = new TNode(data);
			size = size + 1;
			return n;
		} else {
			if (root.getData() > data)
				root.setLeft(insert(root.getLeft(), data));

			else {
				root.setRight(insert(root.getRight(), data));
			}
			return root;
		}
	}

	boolean isPerfectBinary() {
		return isPerfectBinary(root);
	}

	boolean isPerfectBinary(TNode root) {
		if (root == null)
			return true;

		if (isLeaf(root))
			return true;
		if (!isLeaf(root.getLeft()) || !isLeaf(root.getRight()))
			if (root.getRight() == null || root.getLeft() == null)
				return false;
		return isPerfectBinary(root.getLeft()) && isPerfectBinary(root.getRight());
	}

	void print() {
		print(root);
	}

	void print(TNode root) {
		if (root == null)
			return;
		print(root.getLeft());
		System.out.println(root.getData());
		print(root.getRight());

	}

}
