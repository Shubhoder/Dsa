package linkedList;
/*

Note that the linked lists must retain their original structure after the function returns.
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3

The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to
your program. If you correctly return the intersected node, then your solution will be accepted.
 */

/**
 * iss question ko 2 tareeke se solve kar skte hai
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getlength(headA);
        int lenB = getlength(headB);

        while(lenA>lenB){
            lenA--;
            headA= headA.next;
        }

        while(lenA<lenB){
            lenB--;
            headB= headB.next;
        }

        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private int getlength(ListNode head){
        int len = 0;
        ListNode curr = head;
        while(curr!=null){
            len++;
            curr = curr.next;
        }
        return len;
    }
}
