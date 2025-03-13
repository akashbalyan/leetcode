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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(k == 0){
            return head;
        }
        int length = getLength(head);
        if(length == 1 ||  k % length == 0){
            return head;
        }
        int rotateBy = k % length;

        int stopAt = length - rotateBy;

        int count = 1;
        ListNode newHead;
        ListNode firstNode = head;
        while(count != stopAt){
            head = head.next;
            count++;

        }
        newHead = head.next;
        head.next = null;
        ListNode ansHead = newHead;
        while(newHead.next != null){
            newHead = newHead.next;
        }
        newHead.next = firstNode;

        return ansHead;
    }

    private int getLength(ListNode head){
        int count =0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}