
public class BinarySearchTreeP<E extends Comparable<E>> {

	class NodeP<T extends Comparable<T>> {
		public T data;
		public NodeP<T> parent = null;
		public NodeP<T> left = null;
		public NodeP<T> right = null;

		public NodeP(T data) {
			this.data = data;
		}
	}

	public NodeP<E> root;

	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	private void printInOrderRec(NodeP<E> node) {
		if (node == null) {
			return;
		}
		printInOrderRec(node.left);
		System.out.print(node.data + " ");
		printInOrderRec(node.right);
	}

	public  void printTreeRec(NodeP<E> entry, int n) {
		if (entry == null)
			return;
		for (int i = 0; i < n; i++)
			System.out.print(" ");
		System.out.println(entry.data);
		printTreeRec(entry.left, n + 2);
		for (int i = 0; i < n; i++)
			System.out.print(" ");
		System.out.println("--");
		printTreeRec(entry.right, n + 2);
	}

	public void insert(E value) {
		NodeP<E> node = new NodeP<E>(value);
		if (root == null) {
			root = node;
			return;
		}
		insertRec(root, node);
	}

	private void insertRec(NodeP<E> latestRoot, NodeP<E> node) {
		if (latestRoot.data.compareTo(node.data) > 0) {
			if (latestRoot.left == null) {
				latestRoot.left = node;
				node.parent = latestRoot;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				node.parent = latestRoot;
				return;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

	public E getMin() throws Exception {
		if (root == null) {
			throw new Exception("Empty tree");
		} else {
			NodeP<E> curr = root;
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
			NodeP<E> curr = root;
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

	private int depthRec(NodeP<E> node, int d) {
		int leftDepth = d;
		int rightDepth = d;

		if (node == null) {
			return d;
		}
		//System.out.println("Depth node: " + node.data + ", d: " + d);

		if (node.left != null) {
			leftDepth = depthRec(node.left, d + 1);
		}
		if (node.right != null) {
			rightDepth = depthRec(node.right, d + 1);
		}
		return leftDepth > rightDepth ? leftDepth : rightDepth;
	}
	
	public void traverseNonRec1() {
		NodeP<E> curr = root;
		NodeP<E> prev = null;
		while (curr.left != null) {
			curr = curr.left;
		}
		System.out.println("curr: " + curr.data);
		
		while (curr != null) {
			if (prev == null || prev == curr.left) {
				prev = curr;
				curr = curr.parent;
				System.out.println("curr: " + curr.data);
				
				if (curr.right != null) {
					prev = curr;
					curr = curr.right;
					System.out.println("curr: " + curr.data);
					while (curr.left != null) {
						prev = curr;
						curr = curr.left;
					}
				}				
				
			} else if (prev == curr.right) {
				prev = curr;
				curr = curr.parent;
				System.out.println("curr: " + curr.data);
				
			} else if (prev == curr.parent) {
				prev = curr;
				curr = curr.parent.right;
				System.out.println("curr: " + curr.data);
			}
		}
	}
	

	public void traverseNonRecOld() {
		NodeP<E> node = root;
		NodeP<E> lastNode = null;
		while (node != null) {
			System.out.println("WHILE BEGIN node " + node.data);
			if (lastNode == node.parent) {
				System.out.println("lastnode is node.parent ");
				if (node.left != null) {
					lastNode = node;
					node = node.left;
					continue;
				} else {
					System.out.println("lastnode null, node.left null ");
					lastNode = null;
				}
			}
			if (lastNode == node.left) {
				System.out.println("lastnode is node.left " + node.data + " ");

				if (node.right != null) {
					lastNode = node;
					node = node.right;
					continue;
				} else {
					System.out.println("lastnode null, node.right null");
					lastNode = null;
				}
			}
			if (lastNode == node.right) {
				System.out.println("lastnode is node.right ");
				lastNode = node;
				node = node.parent;
			}
		}
		System.out.println();
	}

	public boolean isBalanced() {
		System.out.println("Is balanced");
		return isBalancedRec(root);
	}

	private boolean isBalancedRec(NodeP<E> node) {
		if (node == null) {
			return true;
		}
		int ld = depthRec(node.left, 0);
		int rd = depthRec(node.right, 0);
		//System.out.println("Is balanced: " + node.data + ", ld: " + ld	+ ", rd: " + rd);

		if ((Math.abs(ld - rd) <= 1) && isBalancedRec(node.left)
				&& isBalancedRec(node.right)) {
			return true;
		}
		return false;
	}
	
	public void traverseNonRec() {
		NodeP<E> loop = root;		
		System.out.print(loop.data + " ");

		while (loop.left != null) {
			loop = loop.left;
			System.out.print(loop.data + " ");
		}

		do {
			NodeP<E>  rightSibling = loop.parent.right;
			if (rightSibling != null && rightSibling != loop) {
				loop = rightSibling;
				System.out.print(loop.data + " ");
				if (loop.left == null && loop.right != null) {
					loop = loop.right;
					System.out.print(loop.data + " ");
				}
				while (loop.left != null) {
					loop = loop.left;
					System.out.print(loop.data + " ");
				}
			} else {
				loop = loop.parent;
			}
			
		} while (loop != root);
		
	}

}
