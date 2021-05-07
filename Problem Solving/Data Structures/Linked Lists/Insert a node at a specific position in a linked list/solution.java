// Solution
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        
        // Inserting to head
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        }
        else {
            // Finding position to insert
            SinglyLinkedListNode prevNode = head;
            for (int i = 0; i < position - 1; i++) {
                prevNode = prevNode.next;
            }
            // Keeping link to the next node
            SinglyLinkedListNode nextNode = prevNode.next;
            
            // Inserting new node
            prevNode.next = newNode;
            newNode.next = nextNode;   
        }
        return head;    
    }
