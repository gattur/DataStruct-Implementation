package linkedList;

import linkedList.Node;

public class LL {

	Node nex;
	int size;
	public Node getnex() {
		return nex;
	}
	public void setnex(Node next) {
		this.nex = next;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	Node head;
	Node n = new Node();
	
	
	/*
	 * Adding nodes to list
	 */
	public void Append(int a){
		Node n = new Node();
		if(head==null){
			n.setData(a);			
	     head =n;
	     nex=n;
	     size=size+1;
		}
		else{
			n.setData(a);
			nex.setNext(n);
			nex=n;
			   size=size+1;
		}
		return;		
	}
	

	public void print(){
		Node pri=head;
		while(pri!=null){
			System.out.println(pri.getData());
			pri=pri.getNext();
		
		}
		System.out.println("size"+size);
		return;
	}
	
	/*
	 * deleting the required node by data
	 */
   void delete(int num){
	   Node forward=head.getNext();
	   Node back=head;
	   if(back.getData()==num){
		   head=head.getNext();
		   back.setNext(null);
		   size=size-1;
		   return;
	   }
	  while(forward!=null){
		  if (forward.getData()==(num)){
			  back.setNext(forward.getNext());
			  forward.setNext(null);
			  size=size-1;
			  return;
		  }
		  forward=forward.getNext();
		  back=back.getNext();
		  
	  }
	    }
   
   /*
    * adding required node at a particular position
    */
   void insertatpos(int data,int pos){
	   Node forward=head.getNext();
	   Node back=head;
	   Node n = new Node();
	   if(pos==1){
		   n.setData(data);
		   n.setNext(head);
		   head=n;
		   size=size+1;
	   return;
	   }
	   int count=2;
	   while(forward!=null){
		   if(count==pos){
			   n.setData(data);
		       n.setNext(back.getNext());
			   back.setNext(n);
			   size=size+1;
			   return;
		   }
		   count=count+1;
		   forward=forward.getNext();
		   back=back.getNext();
	   }
	   
   }
   void insertascend(int data){
	   Node n=new Node();
	   if(head==null){
		   n.setData(data);
		   head=n;
	     size=size+1;
	   return;
	   }
	   if(head.getNext()==null){
		   if(head.getData()>data){
			   n.setData(data);
			   n.setNext(head);
			   head=n;
			   size=size+1;
		      		      
		   }else{
			   n.setData(data);
			   head.setNext(n);
			   size=size+1;
		   }   return;
	   }
	   Node temp=head;
	   Node bac=head;
int i=0;	   
	   while(temp!=null){
		   if(temp.getData()>data){
			   if(temp.getData()==head.getData()){
				   System.out.println(temp.getData()+" "+data);
				   n.setData(data);
				   n.setNext(head);
				   head=n;
				   size=size+1;
				   return;
			   }
			   System.out.println(temp.getData());
			   n.setData(data);
			   n.setNext(bac.getNext());
			   bac.setNext(n);
			   size=size+1;
			   return;
		   }
		   temp=temp.getNext();
		   System.out.println(i);
		   if(i==1)
		   bac=bac.getNext();
		   i=1;
	   }
	   n.setData(data);
	   bac.setNext(n);
	   size=size+1;
	   return;
	   
   }
   
   /*
    * insterting the data in ascending order
    */
   void optiminsertascend(int data){
    Node n=new Node();
	   if (head==null){
	   n.setData(data);
	   head=n;
	   size=size+1;
	   return;
   }
	   if(data<head.getData()){
		   n.setData(data);
		   n.setNext(head);
		   head=n;
		   size=size+1;
		   return;
	   }
	 Node temp =head;
	 while(temp.getNext()!=null){
	 if (temp.getNext().getData()>data){
		 n.setData(data);
		 n.setNext(temp.getNext());
		 temp.setNext(n);
		 size=size+1;
		 return;
	 }
	 temp=temp.getNext();
	 }
	 n.setData(data);
	 temp.setNext(n);
	 size=size+1;
	   return;
   }

    void insertatstart(int data){
    	Node n=new Node();
    	if(head==null){
    		n.setData(data);
    		head=n;
    		size=size+1;
    	  return;
    	}
    n.setData(data);
    n.setNext(head);
    head=n;
    size=size+1;
    	
    }
    
    public void deleteatpos(int pos){
    	int size1=2;
    	Node temp1=null;
    	if(pos==1){
    		temp1=head;
    		head=temp1.getNext();
    		temp1.setNext(null);
    		size=size-1;
    		return;
    	}
    	Node temp=head;
    	while(pos!=size1){
    		temp=temp.getNext();
    		size1=size1+1;
    	}
    	 temp1=temp;
    	temp.setNext(temp1.getNext().getNext());
    	temp1.getNext().setNext(null);
    	size=size-1;
    }
   
    /*
     * Get the center of the list
     */
   void center(){
	   System.out.println("in");
	   Node forward =head;
	   Node back=head;
	   while(forward.getNext()!=null){
		   if(forward.getNext().getNext()!=null){
		   forward=forward.getNext().getNext();
		   back=back.getNext();
		   //System.out.println(back.getNext());
		   }
		   else{
			   System.out.println("two centers:"+back.getData()+" "+back.getNext().getData());
			   return;
		   }
		   }
	   System.out.println(back.getData());
	   
   }
   
   /*
    * reverse the list
    */
   void reverse(Node head1){
	   Node forward=head1.getNext();
	   Node back=head1;

	   if(forward.getNext()==null){
		   //System.out.println("in"+forward.getData());
           //System.out.println("in"+head.getData());
		   forward.setNext(back);
		   head.setNext(null);
		   head=forward;
		   System.out.println("head"+head.getData());
		   System.out.println("head"+head.getNext().getData());
		   return;
	   }
		   
		  // System.out.println(forward);
/*		   forward=forward.getNext();
		   back=back.getNext();*/
		   reverse(forward);
		   System.out.println("inf"+forward.getData());
		   forward.setNext(back);
	   
	    
   }
   
   public void pop(){
	   size=size-1;
	   nex=null;
   }
   
   /*
    * 
    * merging two lists
    */
   Node mergeLL(Node head1,Node head2){
	   if(head1==null && head2==null)
		   return null;
	   Node head;
	   if(head1==null)
    	   return head2;
       else if(head2==null)
    	   return head1;
       else{
    	  
    	   if(head1.getData()<head2.getData()){
    		   head=head1;
    		   System.out.println(head1.getData()+"   "+head2.getData() );
    		   System.out.println("firs"+head2.getData());
    		   head1=head1.getNext();    		   
    	   }
    	   else{
    		   head=head1;
    		   System.out.println("firs123"+head.getData());
    		   head2=head2.getNext();
    	   }    		   
       }
	   Node temp=head;
	   while(head1!=null && head2!=null){
		   if(head1.getData()<head2.getData()){
			   temp.setNext(head1);
			   temp=temp.getNext();
			   head1=head1.getNext();
		   }
		   else{
			   temp.setNext(head2);
			   temp=temp.getNext();
			   head2=head2.getNext();
		   }
	   }
	   if(head1==null)
		  temp.setNext(head2);
	   else
		   temp.setNext(head1);
	   
		return head;   	   	    	   
   }
   
 Node  recMerge(Node head1,Node head2){
	   if(head1==null && head2==null)
		   return null;
	   if(head1==null)
		   return head2;
	   else if(head2==null)
		   return head1;
	   else{
		   Node head=new Node();
		   if(head1.getData()>head2.getData()){
			   head=head2;
			   head2=head2.getNext();					  
		   }
		   else{
			   head=head1;
			   head1=head.getNext();
		   }return recMerge(head1,head2,head);
	   }	   
   }
   
 Node recMerge(Node head1,Node head2,Node head){
	 if(head1==null){
		 head.setNext(head2);
		 return head;
	 }
	 else if(head2==null){
		 head.setNext(head1);
	 return head;
	 }
	 if(head1.getData()>head2.getData()){
		 head.setNext(head2);
	recMerge(head1, head2.getNext(), head.getNext());	
	 }
	 else{
		 head.setNext(head1);
			recMerge(head1.getNext(), head2, head.getNext());
	 }
 return head;
 }
   
   
   void rev(int num){
	   if(num==0){
		   return;
	   }
	   rev(num-1);
	   System.out.println(num);
   }
}

