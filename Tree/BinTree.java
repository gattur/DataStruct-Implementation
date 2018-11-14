package tree;

import java.util.ArrayList;

class check {
	int a;
	int level;
	boolean found;
	int data;
	boolean b;
}

public class BinTree {
	TNode root;
	int size;
	boolean bo;

	// wrapper
	void binInsert(int data) {
		TNode t = new TNode(data);
		if (root == null) {
			root = t;
			return;
		}
		binInsert(root, data);
	}

	void print() {
		print(root);
	}

	void printadd() {
		printadd(root);
	}

	void printadd(TNode root) {
		TNode temp = root;
		if (root == null)
			return;
		System.out.println(root);
		printadd(root.getLeft());
		printadd(root.getRight());
	}

	TNode binInsert(TNode roo, int data) {

		if (roo == null) {
			TNode n = new TNode(data);
			return n;
		}
		if (roo.getData() < data) {

			TNode r = binInsert(roo.getRight(), data);
			roo.setRight(r);
			return roo;
		}

		else {

			TNode l = binInsert(roo.getLeft(), data);
			roo.setLeft(l);
			return roo;
		}

	}

	// wrapper
	boolean found = false;

	boolean find(int data) {
		find(root, data);
		return found;
	}

	boolean finder(int data) {

		return finder(root, data);
	}

	boolean finder(TNode root, int data) {

		boolean found = false;
		while (root != null && !found) {
			if (root.getData() == data) {
				// found =true;
				return true;
			} else if (root.getData() < data) {
				root = root.getRight();
			} else {
				root = root.getLeft();
			}
		}
		return false;
	}

	boolean find(TNode root, int data) {

		if (root == null) {
			System.out.println("empty");
			return false;
		}
		if (root.getData() == data) {
			System.out.println(root.getData());
			found = true;
			System.out.println("found");
			return true;
		}

		find(root.getLeft(), data);

		find(root.getRight(), data);

		return found;
	}
	
	//real delete
	void delete1(int data) {

		TNode r = delete1(root, data);
		root.setData(r.getData());
	}

	TNode delete1(TNode root, int data) {
		if (root == null) {
			return null;
		}
		if (root.getData() < data) {
			TNode r = delete1(root.getRight(), data);
			if (r != null)
				root.getRight().setData(r.getData());
			else
				root.setRight(null);
			return root;
		} else if (root.getData() > data) {
			TNode l = delete1(root.getLeft(), data);
			if (l != null)
				root.getLeft().setData(l.getData());
			else
				root.setLeft(null);
			return root;
		} else {
			if (root.getLeft() == null) {
				TNode temp = root.getRight();
				root.setRight(null);
				System.out.println(temp);
				return temp;
			} else if (root.getRight() == null) {
				TNode temp = root.getLeft();
				root.setLeft(null);
				return temp;
			} else {
				int succ = treeMax(root.getLeft());
				delete1(root.getLeft(), succ);
				root.setData(succ);
				return root;
			}
		}
	}
	
	//lousy delete
	void delete(int data) {
		TNode current = root;
		TNode prev = null;
		boolean isLeft = false;
		while (current.getData() != data) {
			if (current.getData() < data) {
				isLeft = false;
				prev = current;
				current = current.getRight();
			} else {
				isLeft = true;
				prev = current;
				current = current.getLeft();
			}
		}
		if (current.getLeft() == null && current.getRight() == null) {
			if (root == current)
				root = null;
			else if (isLeft)
				prev.setLeft(null);
			else
				prev.setRight(null);
			current = null;
		} else if (current.getRight() == null) {
			if (root == current)
				root = current.getLeft();
			else {
				if (isLeft)
					prev.setLeft(current.getLeft());
				else
					prev.setRight(current.getLeft());
			}
			current = null;
		} else if (current.getLeft() == null) {
			if (root == current)
				root = current.getRight();
			else if (isLeft) {
				prev.setLeft(current.getRight());
			} else {
				prev.setRight(current.getRight());
			}
			prev = null;
		} else {
			TNode sucessor = findSucssor(current.getRight());
			System.out.println("sucess" + sucessor.getData());
			if (root == current) {
				System.out.println("in root");
				sucessor.setRight(current.getRight());
				sucessor.setLeft(current.getLeft());
				this.root = sucessor;
				System.out.println(
						"root" + root.getData() + " " + root.getLeft().getData() + " " + root.getRight().getData());
			} else {
				if (isLeft) {
					prev.setLeft(sucessor);
					sucessor.setLeft(current.getLeft());
				} else
					prev.setRight(sucessor);
				sucessor.setLeft(current.getLeft());
			}
		}
		current = null;
		System.out.println("end");
	}

	TNode findSucssor(TNode current) {
		System.out.println(current.getData());
		TNode prev = null;
		TNode sucsprev = null;
		while (current != null) {
			sucsprev = prev;
			prev = current;
			current = current.getLeft();
		}
		if (sucsprev != null)
			sucsprev.setLeft(null);
		System.out.println(prev.getData());
		return prev;
	}



	// wrapper
	int height() {
		return height(root);
	}

	int height(TNode root) {
		if (root == null) {
			return -1;
		}
		// System.out.println("bef"+root.getData());
		int temp = 1 + Math.max(height(root.getLeft()), height(root.getRight()));
		// System.out.println("aft"+root.getData() );
		System.out.println("printing" + temp);
		return temp;
	}

	boolean contains(int data) {
		return contains(root, data);
	}

	boolean contains(TNode root, int data) {
		if (root == null) {
			return false;
		}
		if (root.getData() == data)
			return true;
		boolean tem = ((contains(root.getLeft(), data)) || contains(root.getRight(), data));
		System.out.println(root.getData());
		System.out.println(tem);
		return tem;

	}

	boolean same(TNode root1, TNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}

		if (root1.getData() != root2.getData()) {
			return false;
		}
		return (same(root1.getLeft(), root2.getLeft()) && same(root1.getRight(), root2.getRight()));
	}

	TNode root1;

	TNode replicate() {

		return replicate(root);

	}

	TNode replicate(TNode root) {
		if (root == null)
			return null;

		TNode t = new TNode(root.getData());
		t.setLeft(root.getLeft());
		t.setRight(root.getRight());
		replicate(root.getLeft());
		replicate(root.getRight());
		return t;
	}

	void mirror() {
		mirror(root);
	}

	void mirror(TNode root) {
		if (root == null) {
			return;
		}
		TNode temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
		mirror(root.getLeft());
		mirror(root.getRight());
	}

	void printGivenLevel() {
		printGivenLevel(root, 1);
	}

	void printGivenLevel(TNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.getData() + " ");
		else if (level > 1) {
			printGivenLevel(root.getLeft(), level - 1);
			printGivenLevel(root.getRight(), level - 1);
		}
	}

	void printpath() {
		// System.out.println("in");
		ArrayList head = new ArrayList();
		// if(root==null)return;
		printpath(root, head);
	}

	void printpath(TNode root, ArrayList head) {
		if (root == null)
			return;
		head.add(root.getData());
		if (isLeaf(root))
			System.out.println(head);

		printpath(root.getLeft(), new ArrayList(head));
		printpath(root.getRight(), new ArrayList(head));

		// System.out.println(root.getData());
		return;
	}

	boolean leafPathsum(TNode root, int data, int tot) {
		if (root == null)
			return false;

		int sum = tot + root.getData();
		if (sum == data)
			return true;
		return (leafPathsum(root.getLeft(), data, sum) || leafPathsum(root.getRight(), data, sum));

	}

	int childsun() {
		return childSum(root);
	}

	int childSum(TNode root) {
		System.out.println(root);
		if (root == null || isLeaf(root)) {
			System.out.println("in");
			return 0;
		}
		int lData = 0;
		int rData = 0;
		if (root.getLeft() != null)
			lData = root.getLeft().getData();
		if (root.getRight() != null)
			rData = root.getRight().getData();

		if (lData + rData == root.getData() && childSum(root.getRight()) != -1 && childSum(root.getLeft()) != -1)
			return 1;
		return -1;
	}

	void changeTosum() {
		changeTosum(root);
	}

	void changeTosum(TNode root) {
		if (root == null || isLeaf(root))
			return;
		changeTosum(root.getLeft());
		changeTosum(root.getRight());
		int r = 0;
		int l = 0;
		if (root.getRight() != null)
			r = root.getRight().getData();
		if (root.getLeft() != null)
			l = root.getLeft().getData();
		int s = root.getData() - r - l;
		if (s < 0)
			root.setData(root.getData() - s);
		else if (s > 0)
			increment(root, s);
	}

	void increment(TNode root, int ad) {

		if (root == null)
			return;

		int r = 0;
		int l = 0;
		if (root.getLeft() != null) {
			root.getLeft().setData(root.getLeft().getData() + ad);
			increment(root.getLeft(), ad);
		} else if (root.getRight() != null) {
			root.getRight().setData(root.getRight().getData() + ad);
			increment(root.getRight(), ad);
		}
	}

	int treeMax() {
		return treeMax(root);
	}

	int treeMax(TNode root) {
		if (root == null)
			return 0;

		// int max=0;
		int maxl = treeMax(root.getLeft());
		int maxr = treeMax(root.getRight());
		return Math.max(root.getData(), Math.max(maxl, maxr));
	}

	int findLevel(int a) {
		return findLevel(root, a, 0);
	}

	int findLevel(TNode root, int key, int level) {
		if (root == null)
			return 0;
		System.out.println(root.getData() + " " + key);
		if (root.getData() == key) {
			System.out.println("  f" + level);
			return level;
		}
		System.out.println("  f" + level);
		int l = findLevel(root.getLeft(), key, level + 1);
		if (l != 0)
			return l;
		int r = findLevel(root.getRight(), key, level + 1);
		if (r != 0)
			return r;
		return r;
	}

	check ifCousins(int key1, int key2) {
		return ifCousins(root, key1, key2, new check(), 0);
	}

	int level1 = 0;
	int level2 = 0;

	check ifCousins(TNode root, int key1, int key2, check level, int lev) {
		if (root == null) {
			return null;
		}
		if (root.getData() == key1) {
			level1 = lev;
			level.a = lev;
			level.data = root.getData();
			return level;
		}
		if (root.getData() == key2) {
			level2 = lev;
			level.a = lev;
			level.data = root.getData();
			return level;
		}

		check t = new check();
		t = ifCousins(root.getLeft(), key1, key2, level, lev + 1);

		check t1 = new check();
		t1 = ifCousins(root.getRight(), key1, key2, level, lev + 1);
		if (t1 != null)
			System.out.println("gattu right" + t1.a + "  " + t1.data + "root " + root.getData());
		// System.out.println("gattu left2 "+t.a+" "+t.data+"root "+root.getData());
		System.out.println("pinters" + t);
		System.out.println("pinters t" + t1);
		// if(t!=null && t1!=null && !isLeaf(root)){
		if (level1 != 0 && level2 != 0 && !isLeaf(root)) {
			System.out.println(level1);
			if (level1 == level2) {
				System.out.println("r" + root.getLeft());
				if ((root.getLeft().getData() == key1 && root.getRight().getData() == key2)
						|| (root.getLeft().getData() == key2 && root.getRight().getData() != key1)) {
					t.b = false;
					t.a = level1;
					return t;
				} else {
					t.b = true;
					return t;
				}
			}
		}
		if (t != null)
			System.out.println(t.a + "im" + "root  " + root.getData());
		if (t != null)
			return t;

		return t1;

	}

	check areTheycousins(TNode root, int key1, int key2, int level, check para) {
		if (root == null)
			return null;
		check c = new check();
		if (root.getData() == key1 || root.getData() == key2) {

			c.level = level;
			c.data = root.getData();
		}

		check leftl = areTheycousins(root.getLeft(), key1, key2, level + 1, para);
		if (leftl != null && leftl.found == false) {
			if (root.getRight() == null || root.getLeft() == null) {
				leftl.found = true;
			} else {
				if ((root.getLeft().getData() == key1 && root.getRight().getData() == key2)
						|| (root.getLeft().getData() == key1 && root.getRight().getData() == key2)) {
					leftl.found = false;
					leftl = null;
				} else
					leftl.found = true;
			}
		}
		check rightl = areTheycousins(root.getRight(), key1, key2, level + 1, para);
		if (rightl != null && rightl.found == false) {
			if (root.getRight() == null || root.getLeft() == null) {
				rightl.found = true;
			} else {
				if ((root.getLeft().getData() == key1 && root.getRight().getData() == key2)
						|| (root.getLeft().getData() == key1 && root.getRight().getData() == key2)) {
					rightl.found = false;
					rightl = null;
				} else
					rightl.found = true;
			}
		}
		if (rightl != null && leftl != null) {
			if (leftl.level == rightl.level)
				return leftl;
			else
				return null;
		} else {
			if (leftl != null)
				return leftl;
			return rightl;
		}
	}

	boolean isBinary() {
		return isBinary(root);
	}

	int val;

	boolean isBinary(TNode root) {
		if (root == null)
			return true;
		boolean l = isBinary(root.getLeft());
		// if(!l)return l;
		if (root.getData() < val)
			return false;
		else
			val = root.getData();
		boolean r = isBinary(root.getRight());
		return r;
	}



	void sideTrav(TNode root) {
		if (root == null)
			return;
		levTrav(root);
		if (root.getLeft() != null) {
			sideTrav(root.getLeft());
		} else
			sideTrav(root.getRight());

	}

	TNode levTrav(TNode root) {
		if (root == null)
			return null;
		TNode prev = null;
		while (root != null) {
			prev = attachlevel(root, prev);
			root = root.link;
		}
		return prev;

	}

	TNode attachlevel(TNode root, TNode prev) {
		System.out.println(root);
		if (root == null)
			return prev;
		System.out.println(root.getData());
		if (root.getLeft() == null && root.getRight() == null)
			return prev;
		if (prev == null) {
			if (root.getLeft() == null)
				return root.getRight();
			else if (root.getRight() == null)
				return root.getLeft();
			else {
				root.getLeft().link = root.getRight();
				System.out.println(root.getLeft().link.getData());
				return root.getRight();
			}
		} else if (root.getLeft() == null) {
			prev.link = root.getRight();
			return root.getRight();
		} else if (root.getRight() == null) {
			prev.link = root.getLeft();
			return root.getLeft();
		} else {
			prev.link = root.getLeft();
			root.getLeft().link = root.getRight();
			return root.getRight();
		}

	}

	void printlevel() {
		printlevel(root);
	}

	void printlevel(TNode root) {
		if (root == null)
			return;
		TNode temp = root;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.link;
		}
		System.out.println(" ");
		if (root.getLeft() != null)
			printlevel(root.getLeft());
		else
			printlevel(root.getRight());
	}

	void printleft() {
		printleft(root);
	}

	void printright() {
		printright(root.getRight());
	}

	public boolean isLeaf(TNode root) {
		if (root.getLeft() == null && root.getRight() == null) {
			return true;
		}
		return false;
	}

	void print(TNode root) {
		if (root == null) {
			return;
		}
		print(root.getLeft());
		System.out.println(root.getData());
		print(root.getRight());
	}

	void printleft(TNode root) {
		if (root == null || isLeaf(root)) {
			return;
		}
		System.out.println(root.getData());
		if (root.getLeft() == null) {
			printleft(root.getRight());
		} else {
			printleft(root.getLeft());
		}

	}

	// wrapper
	void printnoleaves() {
		printnoleaves(root);
	}

	void printright(TNode root) {
		if (root == null && isLeaf(root)) {
			return;
		}
		if (root.getRight() == null) {
			printleft(root.getLeft());
		} else {
			printleft(root.getRight());
		}
		System.out.println(root.getData());
	}

	void printnoleaves(TNode root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null)) {
			return;
		}
		System.out.println(root.getData());
		printnoleaves(root.getLeft());
		printnoleaves(root.getRight());
	}

	// wrapper
	void printleaves() {
		printleaves(root);
	}

	void printleaves(TNode root) {
		if (root == null) {
			return;
		}
		printleaves(root.getLeft());
		if (root.getLeft() == null && root.getRight() == null) {
			System.out.println(root.getData());
		}
		printleaves(root.getRight());
	}

	void levelorde(TNode root) {
		BinTree b = new BinTree();
		int h = b.height(root);

		for (int i = 0; i <= h; i++) {

			printlevel(root, i, 0);

		}
	}

	void printlevel(TNode root, int level, int cur) {

		if (root == null)
			return;
		/* System.out.println("lev"+lev+"  " +level); */
		if (cur == level) {

			System.out.println(root.getData());
			return;
		} else {

			printlevel(root.getLeft(), level, cur + 1);
			printlevel(root.getRight(), level, cur + 1);
		}

	}

}
