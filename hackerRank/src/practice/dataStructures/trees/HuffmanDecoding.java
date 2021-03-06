package practice.dataStructures.trees;

public class HuffmanDecoding {
	// you only have to complete the function given below.  
	// Node is defined as  

	class Node {
		public  int frequency; // the frequency of this tree
		public  char data;
		public  Node left, right;
	}

	void decode(String S ,Node root) {
		Node myNode = root;
		for (int i=0; i<S.length(); i++) {
			myNode = nextNode(myNode, S.charAt(i));
			if (myNode.left == null && myNode.right == null) {
				System.out.print(myNode.data);
				myNode = root;
			}
		}
	}
	
	private Node nextNode(Node root, char direction) {
		if (direction == '0') return root.left;
		if (direction == '1') return root.right;
		return null;
	}
}
