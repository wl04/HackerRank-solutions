	// Solution without additional data structures
	public static void levelOrder(Node root) {
        int h = treeHeight(root);
        
        for (int i = 1; i <= h; i++) {
            printDesiredLevelRec(root, i);
        }
    }
    
    // Tree height
    public static int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int lh = treeHeight(root.left);
        int rh = treeHeight(root.right);
        
        return Math.max(lh, rh) + 1; 
    }
    
    // Print only desired level of tree
    public static void printDesiredLevelRec(Node root, int desired) {
        if (root == null) {
            return;
        }
        
        if (desired == 1) {
            System.out.print(root.data + " ");
        }
        printDesiredLevelRec(root.left, desired - 1);
        printDesiredLevelRec(root.right, desired - 1);
    }
