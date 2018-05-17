package linkedList;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		LL l=new LL();
		LL l1=new LL();
		l.head=new Node(1);
		l.head.setNext(new Node(3));
		l.head.getNext().setNext(new Node(5));
		l.head.getNext().getNext().setNext(new Node(7));
		l1.head=new Node(2);
		l1.head.setNext(new Node(4));
		l1.head.getNext().setNext(new Node(5));
		l1.head.getNext().getNext().setNext(new Node(8));
		l.head=l.recMerge(l.head, l1.head);
		l.print();
		System.out.println("Gattu"); 
		Scanner ne=new Scanner(System.in);
		
		while(true){
			int a1=ne.nextInt();
			if(a1==1 || a1==2 || a1==4 || a1==5)
			//System.out.println(a1);
			l.insertascend(a1);
				//l.insertatstart(a1);
			else if(a1==3)
			l.print();
			if(a1==9){
				l.deleteatpos(1);
				
			}
			if(a1==8){
				//Node head1=l.head;
				//l.reverse(head1);
			}
			if(a1==10){
				l.rev(10);
			}
						
			
			
		}
	}

}
