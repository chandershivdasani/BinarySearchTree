/**
 * Main class that will make use of 
 * Binary Search Tree
 * @author Chander
 *
 */
public class BinarySearchTreeManipulation {

	BinarySearchTree bst;
	
	public BinarySearchTreeManipulation() {
		bst = new BinarySearchTree();		
	}
	
	public static void main(String[] args) {
		BinarySearchTreeManipulation bstm = new BinarySearchTreeManipulation();
		bstm.build123a();
		bstm.build123b();
		bstm.build123c();
		
	}
	
	/**
	 * Build 1, 2 and 3 using 3 pointer variables
	 */
	public void build123a() {
		System.out.println("Using 3 pointer variable");
		this.bst.root = new Node(1);
		this.bst.insert(this.bst.root, 2);
		this.bst.insert(this.bst.root, 3);
		this.bst.inOrder();
		
	}
	
	/** 
	 Build 123 using only one pointer variable. 
	*/ 
	public void build123b() { 
		System.out.println("Using 1 pointer variables");
		this.bst.root = new Node(2);
		this.bst.root.leftChild = new Node(1);
		this.bst.root.rightChild = new Node(3);
		this.bst.inOrder();
	}
	
	/** 
	 Build 123 by calling insert() three times. 
	 Note that the '2' must be inserted first. 
	*/ 
	public void build123c() { 
		System.out.println("Calling insert 3 times");
		this.bst.root = null;
		this.bst.root = this.bst.insert(this.bst.root, 2);
		this.bst.root = this.bst.insert(this.bst.root, 1);
		this.bst.root = this.bst.insert(this.bst.root, 3);
		this.bst.inOrder(this.bst.root);
	}
}
