// Solution
    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.data == curNode.next.data) {
                if (curNode.next.next == null) {
                    curNode.next = null;
                    break;    
                } else {
                    curNode.next = curNode.next.next; 
                }  
            } else {
                curNode = curNode.next;    
            }
            
        } 
        return head;   
    }
