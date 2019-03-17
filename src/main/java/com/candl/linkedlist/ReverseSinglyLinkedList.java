package com.candl.linkedlist;

/**
 * Program to reverse a singly linked list
 * For example purpose, data is stored in String format
 * in Linked list with N nodes
 *
 * @author sumit.ambhore
 */
public class ReverseSinglyLinkedList {

    static int counter = 1;
    static final String data = "data";
    static final int N = 10;

    // create a SinglyLinkedList
    private static SinglyLinkedList buildLinkedList() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.head = buildNode(new SinglyLinkedList.Node());
        return linkedList;
    }

    // create a Node
    private static SinglyLinkedList.Node buildNode(SinglyLinkedList.Node node) {
        if (counter > N) {
            return null;
        }
        node.data = data + counter++;
        node.next = buildNode(new SinglyLinkedList.Node());
        return node;
    }

    /**
     * Method to reverse linked list,
     * starting point of recursion
     *
     * @param linkedList
     * @return
     */
    private static SinglyLinkedList reverseList(SinglyLinkedList linkedList) {
        SinglyLinkedList.Node node = reverseNode(linkedList.head, linkedList);
        node.next = null; // pointing the last node to null
        return linkedList;
    }

    /**
     * recursive method to reverse a Node
     *
     * @param node
     * @param linkedList
     * @return
     */
    private static SinglyLinkedList.Node reverseNode(SinglyLinkedList.Node node,
                                                     SinglyLinkedList linkedList) {
        SinglyLinkedList.Node currentNode = node;
        if (node.next == null) {
            linkedList.head = node;
        } else {
            node = reverseNode(node.next, linkedList);
            node.next = currentNode;
        }
        return currentNode;
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = buildLinkedList();
        if (linkedList.head == null) {
            System.out.println("No nodes are present in the linked list.");
        } else {
            System.out.println("Linked List Before Reversal: ");
            System.out.println(linkedList);
            System.out.println("\nLinked List After Reversal: ");
            System.out.println(reverseList(linkedList));
        }
    }
}