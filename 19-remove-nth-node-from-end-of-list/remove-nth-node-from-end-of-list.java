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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size =  getSize(head);
        
        int num = size - n + 1;

        if(num == 1){
            return head.next;
        }
        int count = 1;
        ListNode resultHead = head;
        ListNode prevHead = new ListNode(0);
        prevHead.next = head;
        while(count < num  ){
            head = head.next;
            prevHead = prevHead.next;
            count++;
        }
        prevHead.next = head.next;
        return resultHead;
    }
    private int getSize(ListNode head){

        int count =0;
        while(head != null){
            count++;
            head = head.next;
        }

        return count;
    }
}