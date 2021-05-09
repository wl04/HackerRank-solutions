    // Solution
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        } 
        // We assume that tree is binary search tree, if test cases change that might not work   
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
