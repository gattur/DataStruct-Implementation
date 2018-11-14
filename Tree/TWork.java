package tree;

import java.util.Scanner;
import java.util.Stack;

public class TWork {

	public static void main(String[] args) {
		BinTree b = new BinTree();

		b.root = new TNode(1);
		b.root.setRight(new TNode(3));
		b.root.setLeft(new TNode(2));
		b.root.getLeft().setLeft(new TNode(4));
		b.root.getLeft().setRight(new TNode(5));
		b.root.getRight().setRight(new TNode(6));
		// b.root.get
		b.sideTrav(b.root);

		System.out.println();
		b.printlevel();

	}
}