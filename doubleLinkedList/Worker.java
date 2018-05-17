package doubleLinkedList;

import java.util.Scanner;

public class Worker {

	public static void main(String[] args) {
		System.out.println("inp");
		DLL dl = new DLL();
		Scanner s = new Scanner(System.in);
		while (true) {

			int a = s.nextInt();

			if (a == 1 || a == 2 || a == 4) {
				dl.Append(a);
			}
			if (a == 3)
				dl.printrev();
			if (a == 8)
				dl.remove(2);
		}
	}

}
