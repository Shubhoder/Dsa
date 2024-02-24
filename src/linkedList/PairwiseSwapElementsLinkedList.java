package linkedList;
import java.util.*;
/*
Given a singly linked list of size N. The task is to swap elements in the linked list pairwise.
For example, if the input list is 1 2 3 4, the resulting list after swaps will be 2 1 4 3.
Note: You need to swap the nodes, not only the data. If only data is swapped then driver will print -1.

Example 1:

Input:
LinkedList: 1->2->2->4->5->6->7->8
Output:
2 1 4 2 6 5 8 7
Explanation:
After swapping each pair considering (1,2), (2, 4), (5, 6).. so on as pairs, we get 2, 1, 4, 2, 6, 5, 8, 7 as a new linked list.
Example 2:

Input:
LinkedList: 1->3->4->7->9->10->1
Output:
3 1 7 4 10 9 1
Explanation:
After swapping each pair considering (1,3), (4, 7), (9, 10).. so on as pairs, we get 3, 1, 7, 4, 10, 9, 1 as a new linked list.
 */
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
public class PairwiseSwapElementsLinkedList {
    public Node pairwiseSwap(Node head)
    {
        // code here
        Node dummy = new Node(-1); // Create a dummy node
        dummy.next = head;
        Node point = dummy;

        while (point.next != null && point.next.next != null) {
            Node swap1 = point.next;
            Node swap2 = point.next.next;

            swap1.next = swap2.next;
            swap2.next = swap1;

            point.next = swap2;
            point = swap1;
        }
        return dummy.next;
    }
}
