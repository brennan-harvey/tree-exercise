
public class TreeExercise {

	public static void main(String[] args) {

		// Create leaf nodes
		Node e1 = new Node("E1");
		Node target = new Node("FindMe");
		Node c1 = new Node("C1");

		// Create level 2 nodes and set children
		Node d1 = new Node("D1");
		Node b1 = new Node("B1");
		Node b2 = new Node("B2");
		d1.setChildren(e1, null);
		b1.setChildren(target, null);
		b2.setChildren(c1, null);

		// Create level 1 nodes and set children
		Node a1 = new Node("A1");
		Node a2 = new Node("A2");
		a1.setChildren(d1, null);
		a2.setChildren(b1, b2);

		// Create root node and set children
		Node root = new Node("Start");
		root.setChildren(a1, a2);

		Boolean success = findTarget(root, "FindMe");

		if (!success) {
			System.out.println("\nSearched entire tree.  Did not find target node.");
		}
	}

	/*
	 * Given the root node of a binary tree and the String name of a target node,
	 * this method searches the tree for the target node. This is accomplished using
	 * an unconventional right-left post-order search.
	 */
	public static Boolean findTarget(Node root, String target) {

		// Assuming left child is at index 0, and right child is at index 1
		Node left = root.getChildren().get(0);
		Node right = root.getChildren().get(1);

		// Recursion terminator
		Boolean success = false;

		// First, go down the right sub-tree
		if (right != null) {
			success = findTarget(right, target);
		}

		// If target was found, terminate recursion.
		if (success == true) {
			return true;
		}

		// Next, go down the left sub-tree.
		if (left != null) {
			success = findTarget(left, target);
		}

		// If target was found, terminate recursion.
		if (success == true) {
			return true;
		}

		/*
		 * If execution reaches here, the current node has no un-reached children, so
		 * compare the node to the target. If this is the target node, return true to
		 * terminate recursion. Else, return false and continue the search.
		 * Regardless, print the node to show we've been here.
		 */

		if (root.getName().compareTo(target) == 0) {
			System.out.print(root.getName());
			System.out.println(" <----- Found it!");
			return true;
		} else {
			System.out.println(root.getName());
			return false;
		}
	}
}
