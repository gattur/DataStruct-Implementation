package doubleLinkedList;

public class DLL {
	public Node head;
	int size;
	Node tail;

	/*
	 * adding data to double linked list
	 */
	public void append(int data) {
		Node n = new Node();
		if (head == null) {
			n.setData(data);
			head = n;
			size = size + 1;
			return;
		}
		Node temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		n.setData(data);
		temp.setNext(n);
		n.setPrev(temp);
		size = size + 1;
	}

	void Append(int data) {
		Node n = new Node();
		if (head == null) {
			n.setData(data);
			head = n;
			size = size + 1;
			tail = head;
			return;
		}
		n.setData(data);
		tail.setNext(n);
		n.setPrev(tail);
		tail = n;
		size = size + 1;
	}

	public void circAppend(int data) {
		Node n = new Node();
		if (head == null) {
			n.setData(data);
			head = n;
			size = size + 1;
			tail = head;
			return;
		}
		n.setData(data);
		tail.setNext(n);
		n.setPrev(tail);
		tail = n;
		size = size + 1;
		head.setPrev(tail);
		tail.setNext(head);
	}

	/*
	 * removing data
	 */
	
	void remove(int data) {
		Node temp = head;
		if (temp.getData() == data) {
			System.out.println("foun" + data);
			head = head.getNext();
			System.out.println(head);
			if (head != null) {
				head.setPrev(null);
				temp.setNext(null);
				size = size - 1;
				return;
			}
			temp.setNext(null);
			size = size - 1;
			tail = head;
			return;
		}
		while (temp != null) {
			if (temp.getData() == data) {
				size = size - 1;
				System.out.println("found");
				if (temp.getNext() == null) {
					tail = tail.getPrev();
					temp.getPrev().setNext(null);
					temp.setPrev(null);
					return;
				}
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
				temp.setNext(null);
				temp.setPrev(null);
				return;
			}
			temp = temp.getNext();
		}
		System.out.println("nt found");
	}

	void printrev() {
		Node temp = tail;
		System.out.println("size" + size + " " + head + tail);
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getPrev();
		}
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		System.out.println("size" + size);
	}
}
