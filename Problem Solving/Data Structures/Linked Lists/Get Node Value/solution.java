    // Solution
    public static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode currentNode = head;
        SinglyLinkedListNode runner = head;
        
        // Special case
        if (positionFromTail == 0) {
            return head.data;
        }
        
        // Move runner pointer first
        for (int i = 0; i < positionFromTail; i++) {
            runner = runner.next;
        }
        
        // Move both pointers at the same time
        while (runner.next != null) {
            runner = runner.next;
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }
