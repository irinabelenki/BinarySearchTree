
public class Main {

	public static void main(String[] args) {
		//testBinarySearchTree();
		testBinarySearchTreeP();
	}
	
	public static void testBinarySearchTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(10);
		tree.insert(8);
		tree.insert(6);
		tree.insert(4);
		tree.insert(2);
		tree.insert(5);
		tree.insert(7);
		tree.insert(9);
		tree.insert(11);
		tree.insert(13);
		tree.insert(12);
		tree.insert(14);
		tree.printInorder();
		
		try {
			System.out.println("Min: " + tree.getMin());
			System.out.println("Max: " + tree.getMax());
			System.out.println("Depth: " + tree.depth());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		tree.traverseNonRec();		
		System.out.println("Is balanced: " + tree.isBalanced());
	}
	
	public static void testBinarySearchTreeP() {
		BinarySearchTreeP<Integer> tree = new BinarySearchTreeP<Integer>();
		tree.insert(10);
		tree.insert(9);
		tree.insert(4);
		tree.insert(2);
		tree.insert(5);
		tree.insert(7);
		tree.insert(11);
		tree.insert(13);
		tree.insert(12);
		tree.insert(14);
		tree.insert(8);
		tree.insert(6);
		tree.printInorder();
		
		try {
			System.out.println("Min: " + tree.getMin());
			System.out.println("Max: " + tree.getMax());
			System.out.println("Depth: " + tree.depth());
			System.out.println("Is balanced: " + tree.isBalanced());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tree.traverseNonRec();		
	}
}
