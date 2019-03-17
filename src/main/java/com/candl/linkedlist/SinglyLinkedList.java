package com.candl.linkedlist;

/**
 * Created by sumit.ambhore
 */
public class SinglyLinkedList {

    public Node head;

    @Override
    public String toString() {
        return getString(head);
    }

    private static String getString(Node node) {
        String string = "";
        while (node != null) {
            string += node.data + "->";
            node = node.next;
        }
        string += null;
        return string;
    }

    public static class Node {

        public String data;
        public Node next;

        @Override
        public String toString() {
            return data;
        }
    }
}
