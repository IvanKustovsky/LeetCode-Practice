package dataStructures;

import java.util.Objects;

public class LinkedList { // SinglyLinkedList
    private ListNode head;

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public void reverse() { // 5(h) -> 4 -> 3 -> null  ==> 3(h) -> 4 -> 5 -> null
        if (head != null && head.next != null) {
            // 5(h) -> 4 -> 3 -> null
            ListNode next;
            ListNode previous = null;

            while (head != null) {
                next = head.next;
                head.next = previous;
                previous = head;
                head = next;
            }
            head = previous;
        }
    }

    public void add(int index, ListNode element) {
        Objects.checkIndex(index, size() + 1);
        if(index == 0) {
            element.next = head;
            head = element;
            return;
        }
        ListNode pointer = head;
        for (int i = 0; i < index - 1; i++) {
            pointer = pointer.next;
        }
        element.next = pointer.next;
        pointer.next = element;
    }

    public int size(){
        int size = 0;
        ListNode pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            size++;
        }
        return size;
    }

    public void printListNode() {
        ListNode headNode = head;
        while (headNode != null) {
            System.out.print(headNode.val + "->");
            headNode = headNode.next;
        }
        System.out.println("null");
    }
}
