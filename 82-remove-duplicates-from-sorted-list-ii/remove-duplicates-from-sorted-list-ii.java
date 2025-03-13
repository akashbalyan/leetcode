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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prevNode = new ListNode(0,head);
        ListNode resultPrev = prevNode;
        ListNode current = head;

        while(current!=null){
            int value = current.val;
            int count = 0;
            while(current.next != null && current.next.val == value){
                current = current.next;
                count++;

            }
            if(count > 0){
                //
                current = current.next;

                if(current == null){
                    prevNode.next = null;
                }
            }else{
                prevNode.next = current;
                prevNode = prevNode.next;
                current = current.next;
            }
            
            
            
        }

        return  resultPrev.next;
    }
}