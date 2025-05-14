/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null){
            return null;
        }
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        ListNode even = head.next;
        ListNode prev = head;
        while(oddPtr != null && evenPtr != null){
            oddPtr.next = evenPtr.next;
            oddPtr = oddPtr.next;
            if (oddPtr != null){
                prev = oddPtr;
                evenPtr.next = oddPtr.next;
                evenPtr = evenPtr.next;
            }
        }
        prev.next = even;
        return head;
        
        //this solution is basd on value not indices
        // if(head == null){
        //     return null;
        // }

        // ListNode odd = null;
        // ListNode even = null;
        // ListNode ansHead = null;
        // ListNode evenHead = null;

        // while(head != null){
        //     //even
        //     if(head.val%2 == 0){
        //         if(even != null){
        //             even.next = head;
        //             even = even.next;
        //         }else{
        //             even = head;
        //             evenHead = head;
        //         }
        //     }else{
        //         if(odd != null){
        //             odd.next = head;
        //             odd = odd.next;
        //         }else{
        //             odd = head;
        //             ansHead = head;
        //         }
        //     }
        //     head = head.next;
        // }
        // odd.next = evenHead;
        // even.next = null;
        // return ansHead;
    }
}