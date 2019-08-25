package com.candl.linkedlist;

public class ReverseSubList {
    /**
     * Method to reverse SubList from a LinkedList in between
     * positions startPos and endPos.
     * @param head
     * @param startPos
     * @param endPos
     * @return
     */
    public Node reverseSubList(Node head, int startPos, int endPos) {
        if(head == null || head.next == null){
            return head;
        }
        if(startPos >= endPos){
            return head;
        }
        Node curr = head;
        Node prev = null;
        while(startPos > 1){
            prev = curr;
            curr = curr.next;
            startPos--;
            endPos--;
        }
        Node start = prev;
        Node end = curr;
        Node temp;
        while(endPos > 0){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            endPos--;
        }
        if(start == null){
            head = prev;
        } else {
            start.next = prev;
        }
        end.next = curr;
        return head;
    }

    private static void printList(Node head){
        while (head != null){
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.print(null+""+"\n");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        System.out.println("Linked List Before Reversal:");
        printList(head);
        head = new ReverseSubList().reverseSubList(head, 2, 5);
        System.out.println("Linked List After Reversal:");
        printList(head);
    }
}

