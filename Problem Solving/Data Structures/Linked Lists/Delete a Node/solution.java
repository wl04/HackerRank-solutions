// Solution
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        // If list is empty
        if (head == null) {
            return null;
        }
        
        SinglyLinkedListNode tmp = head;
        // If need to delete 1st node
        if (position == 0) {
            head = tmp.next;
        }
        // If any other, first need to find it
        else {
            for (int i = 0; i < position - 1; i++) {
                tmp = tmp.next;    
            }
            tmp.next = tmp.next.next;
        }
        return head;
    }
