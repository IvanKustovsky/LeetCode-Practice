package dataStructures;

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

    public void printListNode() {
        ListNode headNode = head;
        while (headNode != null) {
            System.out.print(headNode.val + "->");
            headNode = headNode.next;
        }
        System.out.println("null");
    }
}
