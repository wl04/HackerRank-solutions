    // Solution
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null) {
            return null;
        }
        
        SinglyLinkedListNode currentNode = head;
        SinglyLinkedListNode nextNode = head.next;
        SinglyLinkedListNode previousNode = null;
        
        while (currentNode != null) {
            nextNode = currentNode.next;        // store next
            currentNode.next = previousNode;    // change next of current
            previousNode = currentNode;         // set previous as current 
            currentNode = nextNode;             // set current as previous
        }
        return previousNode;                    // previous = head
    }
