    // Solution
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        // If empty list create new node
        if (head == null) {
            return new SinglyLinkedListNode(data);
        } 
        // If not empty iterate till the tail and add new node
        else {
            SinglyLinkedListNode node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new SinglyLinkedListNode(data);
            return head;        
        }  
    }
