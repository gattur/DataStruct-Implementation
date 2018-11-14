 package Tree;

public class TreeSt {
  TNode root;
  int size;	

    
    //wrapper
  void print(){
	  print(root);
  }
  void printleft(){
	  printleft(root);
  }
  void printright(){
	  printright(root.getRight());
  }
  
  public  boolean isLeaf(TNode root){
    	if(root.getLeft()==null && root.getRight()==null){
    	  return true;	
    	}
    	return false;
    }
	void print(TNode root){
		if(root==null){
			return;
		}
		print(root.getLeft());
		System.out.println(root.getData());
		print(root.getRight());
	}
	void printleft(TNode root){
		if(root==null || isLeaf(root)){
			return;
		}
		System.out.println(root.getData());
		if(root.getLeft()==null){
			printleft(root.getRight());
		}
		else{
			printleft(root.getLeft());
		}
		
	}
	//wrapper
	void printnoleaves(){
		printnoleaves(root);
	}
	void printright(TNode root){
		if(root==null && isLeaf(root)){
			return;
		}
		if(root.getRight()==null){
			printleft(root.getLeft());
		}
		else{
			printleft(root.getRight());
		}
		System.out.println(root.getData());
	}
	
	void printnoleaves(TNode root){
		if(root==null || (root.getLeft()==null && root.getRight()==null)){
			return;
		}
		System.out.println(root.getData());
		printnoleaves(root.getLeft());
		printnoleaves(root.getRight());		
	}
	//wrapper
		void printleaves(){
			printleaves(root);
		}
		
		void printleaves(TNode root){
			if(root==null){
				return;
			}
			printleaves(root.getLeft());
			if(root.getLeft()==null &&root.getRight()==null){
				System.out.println(root.getData());				
			}
			printleaves(root.getRight());
		}
		void levelorde(TNode root){
			Bintre b=new Bintre();
			int h=b.height(root);
		
			for (int i = 0; i <=h; i++) {
				
				printlevel(root,i,0);
				
			}
		}
		void printlevel(TNode root,int level,int cur){
 	
			if(root==null)
		      return;
			/*System.out.println("lev"+lev+"  " +level);*/
			if(cur==level){
				
				System.out.println(root.getData());
				return;
			}
			else{
				
				printlevel(root.getLeft(),level,cur+1);
				printlevel(root.getRight(),level,cur+1);
			}
				
		
		}
		
}
