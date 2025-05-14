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
    public ListNode deleteMiddle(ListNode head) {
        int len = length(head);
        if(len == 1){
            return head.next;
        }

        int mid = len%2 == 0 ? len/2 : len/2 ;
        ListNode prevHead = new ListNode();
        prevHead.next = head;

        ListNode current = head;
        ListNode prev = prevHead;
        int count = 0;
        while(count != mid){
            prev = current;
            current = current.next;
            count++;
            
        } 
        prev.next = current.next;

        return prevHead.next;

    }
    public int length(ListNode head){
        int len = 0;
        while(head!=null){
            head =head.next;
            len++;
        }
        return len;
    }
}