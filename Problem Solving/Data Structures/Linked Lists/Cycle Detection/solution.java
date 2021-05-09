    // Solution
    static boolean hasCycle(SinglyLinkedListNode head) {
        HashSet<SinglyLinkedListNode> set = new HashSet<SinglyLinkedListNode>();
        SinglyLinkedListNode currentNode = head;
        while (currentNode.next != null) {
            if (!set.add(currentNode)) {
                return true;
            }
            currentNode = currentNode.next; 
        }    
        return false;
    }
