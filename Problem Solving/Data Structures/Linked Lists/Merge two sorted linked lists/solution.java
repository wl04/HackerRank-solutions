    // Solution
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode list1, SinglyLinkedListNode list2) {
        // If empty
        if (list1 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }
        
        // Initial comparison - searching new head
        SinglyLinkedListNode head = null; 
        if (list1.data < list2.data) {
            head = list1;
            list1 = list1.next;
        } 
        else {
            head = list2;
            list2 = list2.next;
        }
        
        // Making most of list
        SinglyLinkedListNode tmp = head;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tmp.next = list1; 
                list1 = list1.next;   
            }
            else {
                tmp.next = list2; 
                list2 = list2.next;    
            }
            tmp = tmp.next;
        }
        
        // Making remaining part
        if (list1 == null) {
            tmp.next = list2;
        } 
        else {
            tmp.next = list1;
        }
        
        return head; 
    }
         
