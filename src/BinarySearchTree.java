import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {

	class Node<T extends Comparable<T>> {
		public T data;
		public Node<T> left;
		public Node<T> right;

		public Node(T data) {
			this.data = data;
		}
	}

	public Node<E> root;

	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	private void printInOrderRec(Node<E> node) {
		if (node == null) {
			return;
		}
		printInOrderRec(node.left);
		System.out.print(node.data + " ");
		printInOrderRec(node.right);
	}

	public void insert(E value) {
		Node<E> node = new Node<E>(value);
		if (root == null) {
			root = node;
			return;
		}
		insertRec(root, node);
	}
	
	private void insertRec(Node<E> latestRoot, Node<E> node) {
		if (latestRoot.data.compareTo(node.data) > 0) {
			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		}
		else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			}
			else {
				insertRec(latestRoot.right, node);
			}
		}
	}
	
	public E getMin() throws Exception {
		if (root == null) {
			throw new Exception("Empty tree");
		} else {
			Node<E> curr = root;
			while (curr.left != null) {
				curr = curr.left;
			}
			return curr.data;
		}
	}
	
	public E getMax() throws Exception {
		if (root == null) {
			throw new Exception("Empty tree");
		} else {
			Node<E> curr = root;
			while (curr.right != null) {
				curr = curr.right;
			}
			return curr.data;
		}
	}
	
	public int depth() {
		int depth = 0;
		return depthRec(root, depth);
	}
	
	private int depthRec(Node<E> node, int d) {
	    int leftDepth = d;
	    int rightDepth = d;
	    
	    if (node == null) {
	    	return d;
	    }
	    //System.out.println("Depth node: " + node.data + ", d: " + d);
	     
	    if (node.left != null){
	        leftDepth = depthRec(node.left, d+1);
	    }
	    if (node.right != null){
	        rightDepth = depthRec(node.right, d+1);
	    }
	    return leftDepth > rightDepth ? 
	    		leftDepth : 
	    		rightDepth;
	}
	
	public void traverseNonRec() {
		Stack<Node<E>> stack = new Stack<Node<E>>(); 
		Node<E> node = root;
		while (node != null) {
			stack.push(node);
			System.out.println("Push node: " + node.data + ", go left");
		    node = node.left;
		}

		while (stack.size() > 0) {
		    node = stack.pop();
		    System.out.println("Pop node: " + node.data + ", go right");
		    if (node.right != null) {
		        node = node.right;
		        while (node != null) {
		        	stack.push(node);
		        	System.out.println("Push node: " + node.data + ", go left");
		            node = node.left;
		        }
		    }
		}
	}
	
	public boolean isBalanced() {
		System.out.println("Is balanced");
		return isBalancedRec(root);
	}
	
	private boolean isBalancedRec(Node<E> node) {
		if (node == null) {
			return true;
		}
		int ld = depthRec(node.left, 0);
		int rd = depthRec(node.right, 0);
		System.out.println("Is balanced: " + node.data + ", ld: " + ld + ", rd: " + rd);
		
		if ((Math.abs(ld - rd) <= 1)
                && isBalancedRec(node.left)
                && isBalancedRec(node.right)) {
            return true;
        }
		return false;
	}
	
}
