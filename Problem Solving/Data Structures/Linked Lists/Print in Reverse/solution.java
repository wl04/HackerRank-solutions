    // Solution
    public static void reversePrint(SinglyLinkedListNode head) {      
        SinglyLinkedListNode node = head;
        
        // Recursive call until end of list reached
        if (node.next != null) {
            node = node.next; 
            reversePrint(node);
        }
        System.out.println(head.data); 
    }
