    // Solution - main idea node data we search is always between v1 and v2
	public static Node lca(Node root, int v1, int v2) {
      	if (root == null) {
            return null;
        }
          
        // If data is smaller than both v1 and v2
        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        }
        // If data is bigger than both v1 and v2
        if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        }
        
        // Else we found our node
        return root;
    }
