  // Solution
	public static int height(Node root) {
        int lH = 0;
        int rH = 0;
        // Count left nodes height
        if (root.left != null) {
            lH = height(root.left) + 1;
        }
        // Count right nodes height
        if (root.right != null) {
            rH = height(root.right) + 1;
        }
        // Compare and return biggest
        return lH > rH ? lH : rH;
    }
