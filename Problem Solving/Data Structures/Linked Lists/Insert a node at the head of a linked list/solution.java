    //Solution
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        // If list is empty creating new node
        if (llist == null) {
            return new SinglyLinkedListNode(data);
        }
        // If list not empty insert before head
        else {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            node.next = llist;
            return node;
        }
    }
