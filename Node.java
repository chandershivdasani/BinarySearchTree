/**
 * This Class Represents a Node in a Tree
 * 
 * @author cshivdasani
 *
 */
public class Node {

	public Node leftChild;
	public Node rightChild;
	public int data;


	public Node(Node leftChild, Node rightChild, int data) {

		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.data = data;
	}

	public Node(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public Node getLeftChild() {
		return this.leftChild;
	}

	public Node getRightChild() {
		return this.rightChild;
	}

	public int getData() {
		return this.data;
	}

}
