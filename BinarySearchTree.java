/**
 * This class implements a simple Binary Search Tree
 * and all the common methods. A Binary Search Tree is 
 * a tree in which right child is greater than or equal to
 * the left child
 * 
 * @author cshivdasani
 *
 */
public class BinarySearchTree {

	Node root;

	/**
	 * Create an Empty Binary Tree
	 */
	public BinarySearchTree() {
		root = null;
	}


	/**
	 * Checks whether the given node is present 
	 * in a binary tree starting at the provided 
	 * node
	 * @param startNode start of a binary tree
	 * @param searchNode node to be searched
	 * @return true if present, false otherwise
	 */
	public boolean contains(Node startNode, Node searchNode) {
		return contains(startNode, searchNode.data);
	}
	/**
	 * Checks whether the given node is 
	 * present in a binary tree
	 * @param node node to be searched
	 * @return true if present, false otherwise
	 */

	public boolean contains(Node node) {
		return contains(node.data);
	}

	/**
	 * Checks whether the data is present in the 
	 * entire binary tree
	 * @param data data to be searched
	 * @return true if present, false otherwise
	 */
	public boolean contains(int data) {

		return contains(root, data);
	}

	/**
	 * Check whether the given data is present 
	 * in the binary tree starting at the given node
	 * @param searchNode Node from where to start the search 
	 * @param data data to be searched
	 * @return true if present, false otherwise
	 */
	public boolean contains(Node node, int data) {

		/** Terminating case */
		if(node == null) 
			return false;

		/** Traverse right subtree */
		if(data >= node.data) {
			return contains(node.rightChild, data);
		}
		else /** Traverse left subtree */
			return contains(node.leftChild, data);
	}


	/**
	 * Recurse down the tree and insert the data 
	 * at the correct position. It uses a helper
	 * function to recurse down
	 * @param data data to be added
	 */
	public void insert(int data) {
		root = insert(root, data);
	}

	/**
	 * Given a node pointer, recurse down and insert
	 * the new node at the correct location
	 * @param node Given node pointer
	 * @param data New data to be added
	 * @return New node that is added
	 */
	public Node insert(Node node, int data) {
		if(node == null) {
			node = new Node(data);

		}
		else if(data < node.data) {
			node.leftChild = insert(node.leftChild, data);
		}else 
			node.rightChild = insert(node.rightChild, data);

		return node;

	}
	/**
	 * Recurse down the binary tree and delete the specified 
	 * node
	 * @param node Start Node
	 * @param data Node to be deleted
	 * @return 
	 */
	public Node delete(Node node, int data) {
		/**
		 * A Node can be one of the following types:
		 * 1. Leaf Node
		 * 2. With one child
		 * 3. With two child
		 */
		if(data < node.data) {
			node.leftChild = delete(node.leftChild, data);

		}else if(data > node.data) {

			node.rightChild = delete(node.rightChild, data);

		}else {
			/** Leaf Node */
			if(node.rightChild == null && node.leftChild == null) 
				node =  null;

			/**Node with one child*/
			else if(node.leftChild == null)
				node =  node.rightChild;

			else if(node.rightChild == null) 
				node = node.rightChild;

			else {
				/**
				 * Node with 2 child. Replace the node
				 * with any of its sibling and then delete
				 * the sibling
				 */

				node.data = node.leftChild.data;
				node.leftChild = null;
			}
		}
		return node; 
	}


	/**
	 * Inorder traversal of this binary search tree 
	 */
	public void inOrder() {
		inOrder(root);		

	}


	/**
	 * PreOrder traversal of this binary search tree 
	 * 
	 */
	public void preOrder() {
		preOrder(root);

	}


	/**
	 * Postorder traversal of this binary search tree 
	 *  
	 */
	public void postOrder() {
		postOrder(root);
	}

	/**
	 * Inorder traversal of the binary search tree 
	 * represented by the node
	 * @param node node to start the traversal from
	 */
	public void inOrder(Node node) {

		if(node != null) {
			inOrder(node.leftChild);
			System.out.println("Data: " + node.data);
			inOrder(node.rightChild);

		}

	}


	/**
	 * PreOrder traversal of the binary search tree 
	 * represented by the node
	 * @param node node to start the traversal from
	 */
	public void preOrder(Node node) {
		if(node != null) {
			System.out.println("Data: " + node.data);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}

	}


	/**
	 * Postorder traversal of the binary search tree 
	 * represented by the node
	 * @param node node to start the traversal from
	 */
	public void postOrder(Node node) {
		if(node != null) {
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			System.out.println("Data: " + node.data);
		}
	}
	/**
	 * Find the size of this binary search tree
	 * @return number of nodes in the tree
	 */
	public int size() {
		return size(this.root);
	}

	/**
	 * Find the size of the tree represented by 
	 * the given node
	 * @param node tree
	 * @return number of nodes
	 */
	public int size(Node node) {
		return size(node.leftChild) + 1 + size(node.rightChild);

	}

	/**
	 * Returns the max depth of a tree
	 * @return max depth of the tree
	 */
	public int maxDepth() {
		return maxDepth(this.root);
	}

	/**
	 * Compute the max  node-to leaf depth of tree
	 * @param node Input tree
	 * @return max depth 
	 */
	public int maxDepth(Node node) {
		if(node == null)
			return 0;

		int left = maxDepth(node.leftChild);
		int right = maxDepth(node.rightChild);

		return (Math.max(left, right) + 1);
	}
	/**
	 * Return the minimum value in this binary search tree
	 * @return minimum value
	 */
	public int minValue() {
		return minValue(this.root);
	}

	/**
	 * Given the binary search tree, find the minimum value
	 * @param node given binary search tree
	 * @return minimum value
	 */
	public int minValue(Node node) {

		while(node.leftChild != null) {
			node = node.leftChild;
		}
		return node.data;
	}

	/**
	 * Given a tree and a sum, return true if there is a path from the root
	 * down to a leaf, such that adding up all the values along the path
	 * equals the given sum.
	 * 
	 * Strategy: Subtract the node values as you down and check for 0 when 
	 * you run out of trees
	 * 
	 * @param sum sum to be found
	 * @return true if such sum exists, else false
	 */
	public boolean hasPathSum(int sum) {
		return hasPathSum(root, sum);


	}
	/**
	 * A Helper function which will recur down the tree and 
	 * subtract sum at each level
	 * @param node starting node 
	 * @param sum sum to be found
	 * @return true if such sum exists, false otherwise
	 */
	public boolean hasPathSum(Node node, int sum) {
		if(node == null) 
			return (sum == 0);
		else {
			int newsum = node.data - sum;
			return (hasPathSum(node.leftChild, newsum)
					|| hasPathSum(node.rightChild, newsum));
		}
	}

	/**
	 * For the given binary tree, print all its 
	 * root-leaf paths
	 * @param node : The starting node
	 */
	public void printAllPaths() {
		int[] paths = new int[1000];
		printAllPaths(root,paths,0);
	}

	/**
	 * A helper funtion- For the given Node, find all the 
	 * node-leaf paths present
	 * @param node the starting node
	 * @param paths array to hold visited paths 
	 * @param pathlen length of path
	 */
	public void printAllPaths(Node node, int[] paths, int pathlen) {
		//Terminating case
		if(node == null) 
			return;

		//Append this node to the path
		paths[pathlen++] = node.data;

		//Leaf node
		if(node.leftChild == null && node.rightChild ==null) {
			//Print the path
			System.out.println("Root - Leaf Path: ");

		}else {
			//Non leaf node
			printAllPaths(node.leftChild, paths, pathlen);
			printAllPaths(node.rightChild, paths, pathlen);
		}

	}

	/**
	 * Print the contents of the given array
	 * @param paths array storing the paths 
	 * @param pathlen length of the array
	 */
	public void printPath(int[] paths, int pathlen) {
		for(int data: paths) {
			System.out.println(data);
		}
	}
	/**
	 * For the given tree, print its mirror image
	 */
	public void mirror() {
		mirror(root);

	}

	/**
	 * Helper-function: For the given node, recurse through it and 
	 * swap left tree with right subtree
	 * @param node
	 */
	public void mirror(Node node) {
		//Terminating case
		if(node == null)	    
		mirror(node.leftChild);
		mirror(node.rightChild);

		Node temp = node.leftChild;
		node.leftChild = node.rightChild;
		node.rightChild = temp;
	}

	/**
	 * Changes the tree by inserting a duplicate 
	 * node on each node's left
	 */
	public void doubleTree() {
		doubleTree(root);
	}

	/**
	 * Helper-function: For the given node, recursively
	 * insert a duplicate node on each node's left
	 * @param node input node
	 */
	public void doubleTree(Node node) {
		if(node == null)
			return;
		doubleTree(node.leftChild);
		doubleTree(node.rightChild);

		Node newnode = new Node(node.data);
		newnode.leftChild = node.leftChild;
		node.leftChild = newnode;
	}

	/**
	 * Compare the given tree with this tree to see if they 
	 * are structurally the same
	 * @param otherTree the tree to compare
	 * @return true if they are same, false otherwise
	 */
	public boolean sameTree(BinarySearchTree otherTree) {
		return sameTree(this.root, otherTree.root);

	}


	/**
	 * Helper-function - Recursively check the structure of each node
	 * @param node1 first node
	 * @param node2 second node
	 * @return true if all the nodes are same, false otherwise
	 */
	public boolean sameTree(Node node1, Node node2) {
		//Both the node are null
		if(node1 == null && node2 == null)
			return true;
		else if(node1 !=null && node2 != null) {
			//Both the nodes are not null
			return (node1.data == node2.data && sameTree(node1.leftChild, node2.rightChild) 
					&& sameTree(node1.rightChild,node2.rightChild));
		}
		else //one node is null and other is not null
			return false;
	}

	/**
	 * Tests whether this tree is a binary search tree
	 * @return true if it is, false otherwise
	 */
	public boolean isBST() {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	/**
	 * Helper- function : Recurse down the node to verify if its a BST. The Logic is 
	 * to start with the maximum and minimum value and then narrowing it down, depending 
	 * upon the node. 
	 * 
	 * This is a very efficient approach as it takes on O(n) steps
	 * @param root given node
	 * @param minvalue minimum value of node
	 * @param maxvalue maximum value of node
	 * @return
	 */
	public boolean isBST(Node node, int minvalue, int maxvalue) {
		if(node == null) 
			return true;
		else {
			//Check whether this node is valid or not
			if(node.data <minvalue || node.data > maxvalue) 
				return false;
			//Check the left subtree
			boolean left = isBST(node.leftChild, minvalue, node.data);

			if(!left)
				return false;
			else {
				//Check right subtree only if left subtree is valid
				return isBST(node.rightChild, node.data+1, maxvalue);
			}
		}
	}
	
}