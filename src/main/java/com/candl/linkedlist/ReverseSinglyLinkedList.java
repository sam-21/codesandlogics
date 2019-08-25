package com.candl.linkedlist;

/**
 * Program to reverse a singly linked list
 * For example purpose, data is stored in String format
 * in Linked list with N nodes
 *
 * @author sumit.ambhore
 */
public class ReverseSinglyLinkedList {

    private static int counter = 1;
    private static final int N = 10;

    // create a SinglyLinkedList
    private static SinglyLinkedList buildLinkedList() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.head = buildNode(new Node(counter++));
        return linkedList;
    }

    // create a Node
    private static Node buildNode(Node node) {
        if (counter > N) {
            return null;
        }
        node.next = buildNode(new Node(counter++));
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
        Node node = reverseNode(linkedList.head, linkedList);
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
    private static Node reverseNode(Node node,
                                    SinglyLinkedList linkedList) {
        Node currentNode = node;
        if (node.next == null) {
            linkedList.head = node;
        } else {
            node = reverseNode(node.next, linkedList);
            node.next = currentNode;
        }
        return currentNode;
    }

    private static void printList(Node head){
        while (head != null){
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.print(null+""+"\n");
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = buildLinkedList();
        if (linkedList.head == null) {
            System.out.println("No nodes are present in the linked list.");
        } else {
            System.out.println("Linked List Before Reversal: ");
            printList(linkedList.head);
            reverseList(linkedList);
            System.out.println("\nLinked List After Reversal: ");
            printList(linkedList.head);
        }
    }
}

