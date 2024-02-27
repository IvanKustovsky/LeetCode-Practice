
import dataStructures.LinkedList;
import dataStructures.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class LinkedListTest {

    @Test
    public void testAdd() {
        // Arrange
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;

        ListNode newNode = new ListNode(4);

        // Act
        LinkedList utility = new LinkedList(head);
        utility.add(1, newNode); // Add newNode at index 1

        // Assert
        assertEquals(1, utility.getHead().val); // First node should remain the same
        assertEquals(4, utility.getHead().next.val); // newNode should be at index 1
        assertEquals(2, utility.getHead().next.next.val); // Second node should be after newNode
        assertEquals(3, utility.getHead().next.next.next.val); // Third node should be after second node
    }

    @Test
    public void testAddToEnd() {
        // Arrange
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;

        ListNode newNode = new ListNode(4);

        // Act
        LinkedList utility = new LinkedList(head);
        utility.add(3, newNode); // Add newNode at the end (index 3)

        // Assert
        assertEquals(1, utility.getHead().val); // First node should remain the same
        assertEquals(2, utility.getHead().next.val); // Second node should remain the same
        assertEquals(3, utility.getHead().next.next.val); // Third node should remain the same
        assertEquals(4, utility.getHead().next.next.next.val); // newNode should be added at the end
        assertNull(utility.getHead().next.next.next.next); // There should be no more nodes after newNode
    }

    @Test
    public void testAddToBeginning() {
        // Arrange
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;

        ListNode newNode = new ListNode(4);

        // Act
        LinkedList utility = new LinkedList(head);
        utility.add(0, newNode); // Add newNode at the beginning (index 0)

        // Assert
        assertEquals(4, utility.getHead().val); // newNode should be added at the beginning
        assertEquals(1, utility.getHead().next.val); // First node should come after newNode
        assertEquals(2, utility.getHead().next.next.val); // Second node should come after first node
        assertEquals(3, utility.getHead().next.next.next.val); // Third node should come after second node
    }

    @Test
    public void testAddToEmptyList() {
        // Arrange
        ListNode head = null; // Empty list

        ListNode newNode = new ListNode(1);

        // Act
        LinkedList utility = new LinkedList(head);
        utility.add(0, newNode); // Add newNode at the beginning (index 0)

        // Assert
        assertEquals(1, utility.getHead().val); // newNode should be added as the head of the list
        assertNull(utility.getHead().next); // There should be no more nodes after newNode
    }

    @Test
    public void testReverse() {
       /* // Arrange
        ListNode head = new ListNode(5);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(3);
        head.next = second;
        second.next = third;

        // Act
        LinkedList utility = new LinkedList(head);
        utility.reverse(); // Reverse the linked list

        // Assert
        assertEquals(3, head.val); // Third node should be the new head
        assertEquals(4, head.next.val); // Second node should come after the third
        assertEquals(5, head.next.next.val); // First node should come after the second
        assertEquals(null, head.next.next.next); // There should be no more nodes after the first node*/
    }
}
