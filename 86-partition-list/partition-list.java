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
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        if(x >100){
            return head;
        }
        ListNode firstNode = new ListNode(0);
        ListNode ansFirstNode = firstNode;
        ListNode secondNode = new ListNode(0);
        ListNode ansSecondNode = secondNode;

        while(head!=null){
            if(head.val < x){
                firstNode.next = head;
                head = head.next;
                firstNode = firstNode.next;
                firstNode.next = null;
            }else{
                secondNode.next = head;
                head = head.next;
                secondNode = secondNode.next;
                secondNode.next = null;
            }
        }
        firstNode.next = ansSecondNode.next;
        return ansFirstNode.next;
    }
}