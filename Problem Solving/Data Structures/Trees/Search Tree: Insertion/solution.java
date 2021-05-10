  // Solution
	public static Node insert(Node root,int data) {
        // If the tree is empty return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }
        // Otherwise, recur down the tree 
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }	
        // Return unchanged node pointer
        return root;
    }
